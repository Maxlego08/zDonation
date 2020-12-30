package fr.maxlego08.donation;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bukkit.inventory.ItemStack;

import fr.maxlego08.donation.api.Donation;
import fr.maxlego08.donation.zcore.utils.ItemDecoder;

public class ZDonation implements Donation {

	private final UUID owner;
	private final UUID sender;
	private List<String> itemStacks;

	/**
	 * @param owner
	 * @param sender
	 * @param itemStacks
	 */
	public ZDonation(UUID owner, UUID sender, List<ItemStack> itemStacks) {
		super();
		this.owner = owner;
		this.sender = sender;
		this.itemStacks = itemStacks.stream().map(e -> ItemDecoder.serializeItemStack(e)).collect(Collectors.toList());
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
		return itemStacks.stream().map(e -> ItemDecoder.deserializeItemStack(e)).collect(Collectors.toList());
	}

}
