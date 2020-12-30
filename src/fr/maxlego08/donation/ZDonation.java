package fr.maxlego08.donation;

import java.util.List;
import java.util.UUID;

import org.bukkit.inventory.ItemStack;

import fr.maxlego08.donation.api.Donation;

public class ZDonation implements Donation {

	private final UUID owner;
	private final UUID sender;
	private List<ItemStack> itemStacks;

	/**
	 * @param owner
	 * @param sender
	 * @param itemStacks
	 */
	public ZDonation(UUID owner, UUID sender, List<ItemStack> itemStacks) {
		super();
		this.owner = owner;
		this.sender = sender;
		this.itemStacks = itemStacks;
	}

	@Override
	public UUID getOwner() {
		return owner;
	}

	@Override
	public UUID getSender() {
		return sender;
	}

	@Override
	public List<ItemStack> getDonations() {
		return itemStacks;
	}

}
