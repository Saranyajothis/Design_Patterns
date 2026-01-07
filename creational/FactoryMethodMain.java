package Creational;

interface Coffee{
    void prepare();
}
class Espresso implements Coffee{
    @Override
    public void prepare() {
        System.out.println("Preparing an Espresso.");
    }
}

class Cappuccino implements Coffee{
    @Override
    public void prepare() {
        System.out.println("Preparing a Cappuccino.");
    }
}

class Latte implements Coffee{
    @Override
    public void prepare() {
        System.out.println("Preparing a Latte.");
    }
}

class CoffeeFactory {
   public Coffee creatCoffee(String type){
         switch (type.toLowerCase()){
              case "espresso":
                return new Espresso();
              case "cappuccino":
                return new Cappuccino();
              case "latte":
                return new Latte();
              default:
                throw new IllegalArgumentException("Unknown coffee type: " + type);
         }

   }

public class FactoryMethodMain {
    public static void main(String[] args) {
        // Create a factory for creating different types of documents
       CoffeeFactory coffeeFactory = new CoffeeFactory();
       
        // Create an Espresso
        Coffee espresso = coffeeFactory.creatCoffee("espresso");
        espresso.prepare();

        // Create a Cappuccino
        Coffee cappuccino = coffeeFactory.creatCoffee("cappuccino");
        cappuccino.prepare();

        // Create a Latte
        Coffee latte = coffeeFactory.creatCoffee("latte");
        latte.prepare();

    }
}