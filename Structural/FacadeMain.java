package Structural;

class Kitchen{
    public void cookFood(){
        System.out.println("Cooking Food");
    }
}

class PaymentSystem{
    public void processPayment(){
        System.out.println("Making Payment");
    }
}

class DeliveryService{
    public void assignDriver(String address) {
        System.out.println("Delivery: Assigning driver to " + address);
    }
    
    public void dispatch() {
        System.out.println("Delivery: Order dispatched!");
    }
}

class InventorySystem{
    public void checkStock(){
        System.out.println("Checking Inventory Stock");
    }

    public void updateStock(){
        System.out.println("Updating Inventory Stock");
    }
}

class RestaurantFacade{
    private Kitchen kitchen;
    private PaymentSystem paymentSystem;
    private DeliveryService deliveryService;
    private InventorySystem inventorySystem;

    public RestaurantFacade() {
        this.kitchen = new Kitchen();
        this.paymentSystem = new PaymentSystem();
        this.deliveryService = new DeliveryService();
        this.inventorySystem = new InventorySystem();
    }

    public void placeOrder(String address) {
        inventorySystem.checkStock();
        inventorySystem.updateStock();
        kitchen.cookFood();
        paymentSystem.processPayment();
        deliveryService.assignDriver(address);
        deliveryService.dispatch();
    }
}


public class FacadeMain {
    public static void main(String[] args) {
        RestaurantFacade restaurantFacade = new RestaurantFacade();
        restaurantFacade.placeOrder("123 Main St");
    }
    
}
