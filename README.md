# zDonation

Allows players to give items to other players

## API

Java docs: https://docs.groupez.xyz/zdonation/

Get ItemManager:
```java
DonationManager donationManager = getProvider(DonationManager.class);

protected <T> T getProvider(Class<T> classz) {
    RegisteredServiceProvider<T> provider = getServer().getServicesManager().getRegistration(classz);
    if (provider == null) {
        log.log("Unable to retrieve the provider " + classz.toString(), LogType.WARNING);
        return null;
    }
    return provider.getProvider() != null ? (T) provider.getProvider() : null;
}
```
