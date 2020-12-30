package fr.maxlego08.donation.api.events;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import fr.maxlego08.donation.api.Donation;

public class DonationSendEvent extends CancelledDonationEvent {

	private final Player player;
	private final OfflinePlayer target;
	private final Donation donation;

	/**
	 * @param player
	 * @param target
	 * @param donation
	 */
	public DonationSendEvent(Player player, OfflinePlayer target, Donation donation) {
		super();
		this.player = player;
		this.target = target;
		this.donation = donation;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return the target
	 */
	public OfflinePlayer getTarget() {
		return target;
	}

	/**
	 * @return the donation
	 */
	public Donation getDonation() {
		return donation;
	}

}
