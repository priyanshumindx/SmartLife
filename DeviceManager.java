package SmartLife;

public class DeviceManager {
    public void checkDeviceCompatibility(int osVersion, int minimumVersion, int storageMB) throws UnsupportedOSException , InsufficientStorageException {

        System.out.println("Checking Device Compatibility...");

        if(osVersion < minimumVersion){
            throw new UnsupportedOSException("Your Operating System Version is not Supported");
        }

        if(storageMB < 500){
            throw new InsufficientStorageException("Insufficient device Storage.");
        }

        System.out.println("Device Comaptibility verified.");

    }
}
