package fr.maxlego08.donation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.maxlego08.donation.api.Donation;
import fr.maxlego08.donation.api.DonationManager;
import fr.maxlego08.donation.api.events.CancelledDonationEvent;
import fr.maxlego08.donation.api.events.DonationSendEvent;
import fr.maxlego08.donation.save.Config;
import fr.maxlego08.donation.zcore.enums.EnumInventory;
import fr.maxlego08.donation.zcore.utils.ZUtils;
import fr.maxlego08.donation.zcore.utils.storage.Persist;

public class ZDonationManager extends ZUtils implements DonationManager {

	private static List<ZDonation> donations = new ArrayList<ZDonation>();

	/**
	 * @param plugin
	 */
	public ZDonationManager(ZDonationPlugin plugin) {
		super();
	}

	@Override
	public void openDonationSend(Player player, OfflinePlayer target) {

		if (target.getUniqueId().equals(player.getUniqueId())) {
			message(player, Config.sendError);
			return;
		}

		createInventory(player, EnumInventory.INVENTORY_DONATION_SEND, 1, target);
	}

	@Override
	public void sendDonations(Player player, OfflinePlayer target, List<ItemStack> itemStacks) {

		Donation donation = new ZDonation(target.getUniqueId(), player.getUniqueId(), itemStacks);

		CancelledDonationEvent event = new DonationSendEvent(player, target, donation);
		event.callEvent();

		if (event.isCancelled())
			return;

		donations.add((ZDonation) donation);

		if (target.isOnline() && Config.sendMessageWhenDonationIsReceive) {
			message(target.getPlayer(), Config.receiverMessage.replace("%sender%", player.getName()));
		}

		message(player, Config.senderMessage.replace("%target%", target.getName()));

	}

	@Override
	public void openDonations(Player player) {
		createInventory(player, EnumInventory.INVENTORY_DONATIONS);
	}

	@Override
	public void openDonation(Player player, Donation donation) {
		createInventory(player, EnumInventory.INVENTORY_DONATION, 1, donation);
	}

	@Override
	public void removeDonation(Donation donation) {
		donations.remove(donation);
	}

	@Override
	public boolean hasDonation(OfflinePlayer offlinePlayer) {
		return donations.stream().anyMatch(donation -> donation.getOwner().equals(offlinePlayer.getUniqueId()));
	}

	@Override
	public List<Donation> getDonations(OfflinePlayer offlinePlayer) {
		return donations.stream().filter(donation -> donation.getOwner().equals(offlinePlayer.getUniqueId()))
				.collect(Collectors.toList());
	}

	@Override
	public void save(Persist persist) {
		persist.save(this, "donations");
	}

	@Override
	public void load(Persist persist) {
		persist.loadOrSaveDefault(this, ZDonationManager.class, "donations");
	}

}
