package fr.maxlego08.donation;

import org.bukkit.plugin.ServicePriority;

import fr.maxlego08.donation.api.DonationManager;
import fr.maxlego08.donation.command.CommandManager;
import fr.maxlego08.donation.command.commands.CommandDonation;
import fr.maxlego08.donation.inventory.InventoryManager;
import fr.maxlego08.donation.inventory.inventories.InventoryDonation;
import fr.maxlego08.donation.inventory.inventories.InventoryDonationCreate;
import fr.maxlego08.donation.inventory.inventories.InventoryDonationCreateAll;
import fr.maxlego08.donation.inventory.inventories.InventoryDonations;
import fr.maxlego08.donation.listener.AdapterListener;
import fr.maxlego08.donation.save.Config;
import fr.maxlego08.donation.zcore.ZPlugin;
import fr.maxlego08.donation.zcore.enums.EnumInventory;
import fr.maxlego08.donation.zcore.utils.plugins.VersionChecker;

/**
 * System to create your plugins very simply Projet:
 * https://github.com/Maxlego08/TemplatePlugin
 * 
 * @author Maxlego08
 *
 */
public class ZDonationPlugin extends ZPlugin {

	private final DonationManager donationManager = new ZDonationManager(this);

	@Override
	public void onEnable() {

		preEnable();

		commandManager = new CommandManager(this);
		inventoryManager = InventoryManager.getInstance();

		/* Register service */
		this.getServer().getServicesManager().register(DonationManager.class, donationManager, this,
				ServicePriority.High);

		this.registerCommand("zdonation", new CommandDonation(), "don", "donation");
		this.registerInventory(EnumInventory.INVENTORY_DONATIONS, new InventoryDonations());
		this.registerInventory(EnumInventory.INVENTORY_DONATION, new InventoryDonation());
		this.registerInventory(EnumInventory.INVENTORY_DONATION_SEND, new InventoryDonationCreate());
		this.registerInventory(EnumInventory.INVENTORY_DONATION_SEND_ONLINE, new InventoryDonationCreateAll());
		/* Add Listener */

		addListener(new AdapterListener(this));
		addListener(inventoryManager);

		/* Add Saver */
		addSave(Config.getInstance());
		addSave((ZDonationManager) donationManager);

		VersionChecker checker = new VersionChecker(this, 16);
		checker.useLastVersion();

		getSavers().forEach(saver -> saver.load(getPersist()));

		postEnable();
	}

	@Override
	public void onDisable() {

		preDisable();

		getSavers().forEach(saver -> saver.save(getPersist()));

		postDisable();

	}

	public DonationManager getDonationManager() {
		return donationManager;
	}

}
