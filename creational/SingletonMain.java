package Creational;

public class SingletonMain {
    private static SingletonMain instance;

    private SingletonMain() {
        // private constructor to prevent instantiation
    }

    public static SingletonMain getInstance() {
        synchronized (SingletonMain.class) {
        if (instance == null) {
            synchronized (SingletonMain.class) {
                    instance = new SingletonMain();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    public static void main(String[] args) {
        // Get the only instance of SingletonMain
        SingletonMain singleton = SingletonMain.getInstance();

        // Show a message
        singleton.showMessage();
    }
    
}
