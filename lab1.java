public class Television {

    private static final boolean POWER_ON_DEFAULT = false;
    private static final int VOLUME_DEFAULT = 20;
    private boolean powerOn;
    private int volume;
    private int channel;
    private String manufacturer;
    private int screenSize;

    public Television(String brand, int screenSize) {
        this.manufacturer = brand;
        this.screenSize = screenSize;
        this.powerOn = POWER_ON_DEFAULT;
        this.volume = VOLUME_DEFAULT;
        this.channel = 2;
    }
    public int getVolume() {
        return volume;
    }
    public int getChannel() {
        return channel;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public int getScreenSize() {
        return screenSize;
    }
    public void setChannel(int channel) {
        this.channel = channel;
    }
    public void power() {
        powerOn = !powerOn;
    }
    public void increaseVolume() {
        volume++;
    }
    public void decreaseVolume() {
        volume--;
    }
}
/***************************************************************************************/
/*Task #5 Creating another instance of a Television:*/
public class TelevisionDemo {
    public static void main(String[] args) {
        Television tv = new Television("Toshiba", 55);
        tv.power();
        System.out.println("A " + tv.getScreenSize() + " inch " + tv.getManufacturer() + " has been turned on.");
        System.out.print("What channel do you want? ");
        tv.setChannel(56);
        System.out.println("Channel: " + tv.getChannel() + " Volume: " + tv.getVolume());
        System.out.println("Too loud!! I am lowering the volume.");
        tv.decreaseVolume();
        System.out.println("Channel: " + tv.getChannel() + " Volume: " + tv.getVolume());

        Television portable = new Television("Sharp", 19);
        portable.power();
        System.out.println("The " + portable.getScreenSize() + " inch " + portable.getManufacturer() + " television has been turned on.");
        System.out.print("Enter your preferred channel: ");
        int preferredChannel = 68; // Example value, you can change it as per your preference
        portable.setChannel(preferredChannel);
        portable.decreaseVolume();
        portable.decreaseVolume();
        System.out.println("Channel: " + portable.getChannel() + " Volume: " + portable.getVolume());
    }
}



