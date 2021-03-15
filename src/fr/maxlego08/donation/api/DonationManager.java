package fr.maxlego08.donation.api;

import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.maxlego08.donation.zcore.utils.storage.Saveable;

public interface DonationManager extends Saveable{

	/**
	 * Allows you to open the menu to make a donation
	 * 
	 * @param player
	 * @param target
	 */
	public void openDonationSend(Player player, OfflinePlayer target);

	/**
	 * 
	 * @param player
	 * @param target
	 * @param itemStacks
	 */
	public void sendDonations(Player player, OfflinePlayer target, List<ItemStack> itemStacks);

	/**
	 * 
	 * @param player
	 */
	public void openDonations(Player player);

	/**
	 * 
	 * @param player
	 * @param donation
	 */
	public void openDonation(Player player, Donation donation);

	/**
	 * Remove donation
	 * @param donation
	 */
	public void removeDonation(Donation donation);

	/**
	 * 
	 * @param offlinePlayer
	 * @return true if player has donation
	 */
	public boolean hasDonation(OfflinePlayer offlinePlayer);

	/**
	 * 
	 * @param offlinePlayer
	 * @return donation list
	 */
	public List<Donation> getDonations(OfflinePlayer offlinePlayer);

	/**
	 * 
	 * @param player
	 */
	public void openDonationSendAll(Player player, boolean online);

	public void sendDonations(Player player, boolean online, List<ItemStack> itemStacks);

}
