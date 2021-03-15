package fr.maxlego08.donation.command.commands;

import fr.maxlego08.donation.ZDonationPlugin;
import fr.maxlego08.donation.command.VCommand;
import fr.maxlego08.donation.zcore.utils.commands.CommandType;

public class CommandDonationVersion extends VCommand {

	public CommandDonationVersion() {
		this.setDescription("Show plugin version");
		this.addSubCommand("version", "v", "ver");
	}

	@Override
	protected CommandType perform(ZDonationPlugin plugin) {

		message(sender, "§aVersion du plugin§7: §2" + plugin.getDescription().getVersion());
		message(sender, "§aAuteur§7: §2Maxlego08");
		message(sender, "§aDiscord§7: §2http://discord.groupez.xyz/");
		message(sender, "§aDownload§7: §2https://groupez.xyz/resources/zdonation.16");

		return CommandType.SUCCESS;
	}

}
