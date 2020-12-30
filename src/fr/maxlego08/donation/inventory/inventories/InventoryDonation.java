package fr.maxlego08.donation.inventory.inventories;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import fr.maxlego08.donation.ZDonationPlugin;
import fr.maxlego08.donation.api.Donation;
import fr.maxlego08.donation.exceptions.InventoryOpenException;
import fr.maxlego08.donation.inventory.VInventory;
import fr.maxlego08.donation.save.Config;
import fr.maxlego08.donation.zcore.utils.inventory.InventoryResult;

public class InventoryDonation extends VInventory {

	@Override
	public InventoryResult openInventory(ZDonationPlugin main, Player player, int page, Object... args)
			throws InventoryOpenException {

		Donation donation = (Donation) args[0];
		OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(donation.getSender());
		createInventory(Config.inventoryDonation.replace("%sender%", offlinePlayer.getName()), 54);

		return InventoryResult.SUCCESS;
	}

}
