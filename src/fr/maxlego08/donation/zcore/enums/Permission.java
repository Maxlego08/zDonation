package fr.maxlego08.donation.zcore.enums;

public enum Permission {
	
	ZDONATION_USE,
	ZDONATION_OPEN,
	ZDONATION_SEND,
	ZDONATION_SEND_ALL,
	ZDONATION_RELOAD,

	;

	private String permission;

	private Permission() {
		this.permission = this.name().toLowerCase().replace("_", ".");
	}

	public String getPermission() {
		return permission;
	}

}
