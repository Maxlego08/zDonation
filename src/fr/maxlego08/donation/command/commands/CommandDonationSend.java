package fr.maxlego08.donation.command.commands;

import org.bukkit.OfflinePlayer;

import fr.maxlego08.donation.ZDonationPlugin;
import fr.maxlego08.donation.command.VCommand;
import fr.maxlego08.donation.zcore.enums.Permission;
import fr.maxlego08.donation.zcore.utils.commands.CommandType;

public class CommandDonationSend extends VCommand {

	public CommandDonationSend() {
		this.setPermission(Permission.ZDONATION_SEND);
		this.addRequireArg("player");
		this.setConsoleCanUse(false);
		this.addSubCommand("send");
		this.setDescription("Send a donation");
	}

	@Override
	protected CommandType perform(ZDonationPlugin main) {
		OfflinePlayer offlinePlayer = argAsOfflinePlayer(0);
		this.donationManager.openDonationSend(player, offlinePlayer);
		return CommandType.SUCCESS;
	}

}
