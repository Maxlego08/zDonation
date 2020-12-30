package fr.maxlego08.donation.command.commands;

import fr.maxlego08.donation.ZDonationPlugin;
import fr.maxlego08.donation.command.VCommand;
import fr.maxlego08.donation.save.Config;
import fr.maxlego08.donation.zcore.enums.Permission;
import fr.maxlego08.donation.zcore.utils.commands.CommandType;

public class CommandDonationReload extends VCommand {

	public CommandDonationReload() {
		this.setPermission(Permission.ZDONATION_RELOAD);
		this.addSubCommand("reload", "rl");
		this.setDescription("Reload config file");
	}
	
	@Override
	protected CommandType perform(ZDonationPlugin main) {
		Config.getInstance().load(main.getPersist());
		message(sender, "§aReload !");
		return CommandType.SUCCESS;
	}

}
