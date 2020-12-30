package fr.maxlego08.donation.inventory.inventories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import fr.maxlego08.donation.ZDonationPlugin;
import fr.maxlego08.donation.exceptions.InventoryOpenException;
import fr.maxlego08.donation.inventory.VInventory;
import fr.maxlego08.donation.save.Config;
import fr.maxlego08.donation.zcore.utils.inventory.InventoryResult;

public class InventoryDonationCreate extends VInventory {

	private OfflinePlayer target;

	public InventoryDonationCreate() {
		this.disableClick = false;
	}
	
	@Override
	public InventoryResult openInventory(ZDonationPlugin main, Player player, int page, Object... args)
			throws InventoryOpenException {

		target = (OfflinePlayer) args[0];
		createInventory(Config.inventoryDonationSend.replace("%target%", target.getName()), 54);

		return InventoryResult.SUCCESS;
	}

	@Override
	protected void onClose(InventoryCloseEvent event, ZDonationPlugin plugin, Player player) {

		List<ItemStack> itemStacks = new ArrayList<ItemStack>();
		for (ItemStack itemStack : event.getInventory().getContents()) {
			if (itemStack != null)
				itemStacks.add(itemStack);
		}

		if (itemStacks.size() == 0)
			message(player, Config.sendCancel);
		else
			plugin.getDonationManager().sendDonations(player, target, itemStacks);
	}

}
