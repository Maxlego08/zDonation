package fr.maxlego08.donation.api.events;

import org.bukkit.event.Cancellable;

public class CancelledDonationEvent extends DonationEvent implements Cancellable {

	private boolean cancelled;

	/**
	 * @return the cancelled
	 */
	public boolean isCancelled() {
		return cancelled;
	}

	/**
	 * @param cancelled
	 *            the cancelled to set
	 */
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

}
