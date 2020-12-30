package fr.maxlego08.donation.api;

import java.util.List;
import java.util.UUID;

import org.bukkit.inventory.ItemStack;

public interface Donation {

	/**
	 * 
	 * @return uuid of owner
	 */
	public UUID getOwner();
	
	/**
	 * 
	 * @return uuid of sender
	 */
	public UUID getSender();
	
	/**
	 * 
	 * @return list of {@link ItemStack}
	 */
	public List<ItemStack> getDonations();
	
}
