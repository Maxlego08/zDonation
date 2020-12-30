package fr.maxlego08.donation.command.commands;

import fr.maxlego08.donation.ZDonationPlugin;
import fr.maxlego08.donation.command.VCommand;
import fr.maxlego08.donation.zcore.enums.Permission;
import fr.maxlego08.donation.zcore.utils.commands.CommandType;

public class CommandDonationOpen extends VCommand {

	public CommandDonationOpen() {
		this.setPermission(Permission.ZDONATION_OPEN);
		this.setConsoleCanUse(false);
		this.addSubCommand("open");
		this.setDescription("See your donations.");
	}
	
	@Override
	protected CommandType perform(ZDonationPlugin main) {
		donationManager.openDonations(player);
		return CommandType.SUCCESS;
	}

}
