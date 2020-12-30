package fr.maxlego08.donation;

import org.bukkit.plugin.ServicePriority;

import fr.maxlego08.donation.api.DonationManager;
import fr.maxlego08.donation.command.CommandManager;
import fr.maxlego08.donation.command.commands.CommandDonation;
import fr.maxlego08.donation.inventory.InventoryManager;
import fr.maxlego08.donation.listener.AdapterListener;
import fr.maxlego08.donation.save.Config;
import fr.maxlego08.donation.zcore.ZPlugin;

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
		
		/* Add Listener */

		addListener(new AdapterListener(this));
		addListener(inventoryManager);

		/* Add Saver */
		addSave(Config.getInstance());
		addSave((ZDonationManager) donationManager);

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
