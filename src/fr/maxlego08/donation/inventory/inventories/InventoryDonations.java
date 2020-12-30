package fr.maxlego08.donation.inventory.inventories;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import fr.maxlego08.donation.ZDonationPlugin;
import fr.maxlego08.donation.api.Donation;
import fr.maxlego08.donation.api.DonationManager;
import fr.maxlego08.donation.exceptions.InventoryOpenException;
import fr.maxlego08.donation.inventory.VInventory;
import fr.maxlego08.donation.save.Config;
import fr.maxlego08.donation.zcore.utils.inventory.InventoryResult;
import fr.maxlego08.donation.zcore.utils.inventory.Pagination;

public class InventoryDonations extends VInventory {

	@SuppressWarnings("deprecation")
	@Override
	public InventoryResult openInventory(ZDonationPlugin main, Player player, int page, Object... args)
			throws InventoryOpenException {

		DonationManager manager = main.getDonationManager();
		createInventory(Config.inventoryDonations, 54);

		List<Donation> donations = manager.getDonations(player);
		Pagination<Donation> pagination = new Pagination<>();
		AtomicInteger atomicInteger = new AtomicInteger(0);
		pagination.paginate(donations, 45, page).forEach(donation -> {

			runAsync(() -> {
				String sender = Bukkit.getOfflinePlayer(donation.getSender()).getName();
				ItemStack itemStack = playerHead();
				SkullMeta itemMeta = (SkullMeta) itemStack.getItemMeta();
				itemMeta.setDisplayName(Config.displayName.replace("%sender%", sender));
				itemMeta.setLore(Config.displayLore.stream().map(e -> e.replace("%sender%", sender)).collect(Collectors.toList()));
				itemMeta.setOwner(sender);
				itemStack.setItemMeta(itemMeta);
				int slot = atomicInteger.getAndIncrement();
				addItem(slot, itemStack).setClick(e -> manager.openDonation(player, donation));
			});

		});

		return InventoryResult.SUCCESS;
	}

}
