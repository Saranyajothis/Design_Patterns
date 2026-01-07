package Creational;

class Computer{
    // Mandatory parameters
    private final String CPU;
    private final String RAM;

    // Optional parameters
    private final String GPU;
    private final String Storage;
    private final boolean isBluetoothEnabled;
    private final boolean isWiFiEnabled;

    private Computer(ComputerBuilder builder){
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.GPU = builder.GPU;
        this.Storage = builder.Storage;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isWiFiEnabled = builder.isWiFiEnabled;

    }

    //getters
    public String getCPU() {
        return CPU;
    }
    public String getRAM() {
        return RAM;
    }
    public String getGPU() {
        return GPU;
    }
    public String getStorage() {
        return Storage;
    }
    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }
    public boolean isWiFiEnabled() {
        return isWiFiEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", GPU='" + GPU + '\'' +
                ", Storage='" + Storage + '\'' +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                ", isWiFiEnabled=" + isWiFiEnabled +
                '}';
    }

    public static class ComputerBuilder {
        // Mandatory parameters
        private final String CPU;
        private final String RAM;

        // Optional parameters
        private String GPU;
        private String Storage;
        private boolean isBluetoothEnabled;
        private boolean isWiFiEnabled;

        public ComputerBuilder(String CPU, String RAM){
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public ComputerBuilder setGPU(String GPU){
            this.GPU = GPU;
            return this;
        }

        public ComputerBuilder setStorage(String Storage){
            this.Storage = Storage;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled){
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public ComputerBuilder setWiFiEnabled(boolean isWiFiEnabled){
            this.isWiFiEnabled = isWiFiEnabled;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }

    }

}

public class BuilderMain{
    public static void main(String[] args) {
        Computer gamingPC = new Computer.ComputerBuilder("Intel i9", "32GB")
                .setGPU("NVIDIA RTX 3080")
                .setStorage("1TB SSD")
                .setBluetoothEnabled(true)
                .setWiFiEnabled(true)
                .build();

        System.out.println(gamingPC);

        Computer officePC = new Computer.ComputerBuilder("Intel i5", "16GB")
                .setStorage("512GB SSD")
                .setWiFiEnabled(true)
                .build();

        System.out.println(officePC);
    }
}