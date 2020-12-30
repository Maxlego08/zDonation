package fr.maxlego08.donation.inventory.inventories;

import org.bukkit.entity.Player;

import fr.maxlego08.donation.ZDonationPlugin;
import fr.maxlego08.donation.exceptions.InventoryOpenException;
import fr.maxlego08.donation.inventory.VInventory;
import fr.maxlego08.donation.save.Config;
import fr.maxlego08.donation.zcore.utils.inventory.InventoryResult;

public class InventoryDonations extends VInventory {

	@Override
	public InventoryResult openInventory(ZDonationPlugin main, Player player, int page, Object... args)
			throws InventoryOpenException {
		
		createInventory(Config.inventoryDonations, 54);
		
		return InventoryResult.SUCCESS;
	}

}
