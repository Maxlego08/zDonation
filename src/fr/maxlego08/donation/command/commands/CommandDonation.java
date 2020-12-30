package fr.maxlego08.donation.command.commands;

import fr.maxlego08.donation.ZDonationPlugin;
import fr.maxlego08.donation.command.VCommand;
import fr.maxlego08.donation.save.Config;
import fr.maxlego08.donation.zcore.enums.Permission;
import fr.maxlego08.donation.zcore.utils.commands.CommandType;

public class CommandDonation extends VCommand {

	public CommandDonation() {
		this.setPermission(Permission.ZDONATION_USE);
		this.addSubCommand(new CommandDonationOpen());
		this.addSubCommand(new CommandDonationSend());
	}

	@Override
	protected CommandType perform(ZDonationPlugin main) {
		Config.commandHelps.forEach(e -> message(sender, e));
		return CommandType.SUCCESS;
	}

}
