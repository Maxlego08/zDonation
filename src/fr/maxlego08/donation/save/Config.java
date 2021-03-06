package fr.maxlego08.donation.save;

import java.util.ArrayList;
import java.util.List;

import fr.maxlego08.donation.zcore.utils.storage.Persist;
import fr.maxlego08.donation.zcore.utils.storage.Saveable;

public class Config implements Saveable {

	public static boolean sendMessageWhenDonationIsReceive = true;

	public static String prefix = "�8(�fzDonation�8)";
	public static String sendError = "�cYou cannot send a donation to yourself.";
	public static String sendCancel = "�cYou did not put any item, the sending of the donation is cancelled.";
	public static String senderMessage = "�7You have just sent a donation to the player �f%target%�7.";
	public static String senderMessageAll = "�7You have just sent a donation to the player �fonline�7.";
	public static String senderMessageAllOffline = "�7You have just sent a donation to the player �foffline�7.";
	public static String receiverMessage = "�7You have just received a donation from the player �f%sender%�7.";
	public static List<String> commandHelps = new ArrayList<String>();

	private static volatile Config instance;

	public static String inventoryDonations = "�8Donations";
	public static String inventoryDonation = "�8Donation �o%sender%";
	public static String inventoryDonationSend = "�8Donation �o%target%";
	public static String inventoryDonationSendAll = "�8Donation �oOnline";
	public static String inventoryDonationSendAllOffline = "�8Donation �oOffline";

	public static String displayName = "�f�o%sender%";
	public static List<String> displayLore = new ArrayList<>();

	static {
		commandHelps.add("�f/don send <player> �7Send a donation to a player.");
		commandHelps.add("�f/don open �7Open the donation inventory.");
		
		displayLore.add("�fClick to open the donation of �7%sender%.");
	}

	/**
	 * Private constructor for singleton.
	 */
	private Config() {
	}

	/**
	 * Return a singleton instance of Config.
	 */
	public static Config getInstance() {
		// Double lock for thread safety.
		if (instance == null) {
			synchronized (Config.class) {
				if (instance == null) {
					instance = new Config();
				}
			}
		}
		return instance;
	}

	public void save(Persist persist) {
		persist.save(getInstance());
	}

	public void load(Persist persist) {
		persist.loadOrSaveDefault(getInstance(), Config.class);
	}

}
