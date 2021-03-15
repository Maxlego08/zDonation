package fr.maxlego08.donation.command.commands;

import fr.maxlego08.donation.ZDonationPlugin;
import fr.maxlego08.donation.command.VCommand;
import fr.maxlego08.donation.zcore.enums.Permission;
import fr.maxlego08.donation.zcore.utils.commands.CommandType;

public class CommandDonationSendAll extends VCommand {

	public CommandDonationSendAll() {
		this.setPermission(Permission.ZDONATION_SEND_ALL);
		this.setConsoleCanUse(false);
		this.addSubCommand("sendall");
		this.addOptionalArg("offline player");
		this.setDescription("Send a donation to online player");
	}

	@Override
	protected CommandType perform(ZDonationPlugin main) {
		boolean isonline = argAsBoolean(0, true);
		this.donationManager.openDonationSendAll(player, isonline);
		return CommandType.SUCCESS;
	}

}
