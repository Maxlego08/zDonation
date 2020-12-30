package fr.maxlego08.donation.inventory.inventories;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;

import fr.maxlego08.donation.ZDonationPlugin;
import fr.maxlego08.donation.exceptions.InventoryOpenException;
import fr.maxlego08.donation.inventory.VInventory;
import fr.maxlego08.donation.save.Config;
import fr.maxlego08.donation.zcore.utils.inventory.InventoryResult;

public class InventoryDonationCreate extends VInventory {

	@Override
	public InventoryResult openInventory(ZDonationPlugin main, Player player, int page, Object... args)
			throws InventoryOpenException {

		OfflinePlayer target = (OfflinePlayer) args[0];
		createInventory(Config.inventoryDonationSend.replace("%target%", target.getName()), 54);

		return InventoryResult.SUCCESS;
	}
	
	@Override
	protected void onClose(InventoryCloseEvent event, ZDonationPlugin plugin, Player player) {
		
		
		
	}

}
