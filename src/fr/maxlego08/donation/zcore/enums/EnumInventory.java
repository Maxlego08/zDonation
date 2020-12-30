package fr.maxlego08.donation.zcore.enums;

public enum EnumInventory {

	INVENTORY_DONATIONS(1),
	INVENTORY_DONATION(2),
	INVENTORY_DONATION_SEND(3),
	
	;
	
	private final int id;

	private EnumInventory(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
