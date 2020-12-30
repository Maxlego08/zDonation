package fr.maxlego08.donation.inventory.inventories;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import fr.maxlego08.donation.ZDonationPlugin;
import fr.maxlego08.donation.api.Donation;
import fr.maxlego08.donation.exceptions.InventoryOpenException;
import fr.maxlego08.donation.inventory.VInventory;
import fr.maxlego08.donation.save.Config;
import fr.maxlego08.donation.zcore.utils.inventory.InventoryResult;

public class InventoryDonation extends VInventory {

	private Donation donation;

	public InventoryDonation() {
		this.disableClick = false;
	}

	@Override
	public InventoryResult openInventory(ZDonationPlugin main, Player player, int page, Object... args)
			throws InventoryOpenException {

		donation = (Donation) args[0];
		OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(donation.getSender());
		createInventory(Config.inventoryDonation.replace("%sender%", offlinePlayer.getName()), 54);

		int slot = 0;
		for (ItemStack itemStack : donation.getDonations())
			addItem(slot++, itemStack);

		return InventoryResult.SUCCESS;
	}

	@Override
	protected void onClose(InventoryCloseEvent event, ZDonationPlugin plugin, Player player) {
		for (ItemStack itemStack : event.getInventory().getContents())
			if (itemStack != null)
				player.getWorld().dropItem(player.getLocation(), itemStack);
		plugin.getDonationManager().removeDonation(donation);
	}

}
