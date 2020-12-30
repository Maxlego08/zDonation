package fr.maxlego08.donation;

import java.util.Collection;
import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.omg.CORBA.PERSIST_STORE;

import fr.maxlego08.donation.api.Donation;
import fr.maxlego08.donation.api.DonationManager;
import fr.maxlego08.donation.zcore.utils.ZUtils;
import fr.maxlego08.donation.zcore.utils.storage.Persist;

public class ZDonationManager extends ZUtils implements DonationManager {

	private final ZDonationPlugin plugin;

	/**
	 * @param plugin
	 */
	public ZDonationManager(ZDonationPlugin plugin) {
		super();
		this.plugin = plugin;
	}

	@Override
	public void openDonationSend(Player player, OfflinePlayer target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendDonations(Player player, OfflinePlayer target, List<ItemStack> itemStacks) {
		// TODO Auto-generated method stub

	}

	@Override
	public void openDonations(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void openDonation(Player player, Donation donation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeDonation(Donation donation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasDonation(OfflinePlayer offlinePlayer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Donation> getDonations(OfflinePlayer offlinePlayer) {
		// TODO Auto-generated method stub
		return null;
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
