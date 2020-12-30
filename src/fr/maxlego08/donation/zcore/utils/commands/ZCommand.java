package fr.maxlego08.donation.zcore.utils.commands;

import java.util.function.BiConsumer;

import fr.maxlego08.donation.ZDonationPlugin;
import fr.maxlego08.donation.command.VCommand;

public class ZCommand extends VCommand {

	private BiConsumer<VCommand, ZDonationPlugin> command;

	@Override
	public CommandType perform(ZDonationPlugin main) {
		
		if (command != null){
			command.accept(this, main);
		}

		return CommandType.SUCCESS;
	}

	public VCommand setCommand(BiConsumer<VCommand, ZDonationPlugin> command) {
		this.command = command;
		return this;
	}

	public VCommand sendHelp(String command) {
		this.command = (cmd, main) -> main.getCommandManager().sendHelp(command, cmd.getSender());
		return this;
	}

}
