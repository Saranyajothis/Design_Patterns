package Structural;

interface Coffee{
    String prepare();
    double getCost();
}

class SimpleCoffee implements Coffee{
    @Override
    public String prepare() {
        System.out.println("Recipe: Coffee");
    }

    @Override
    public double getCost() {
        System.out.println("Cost: $2.00");
    }

}

abstract class CoffeeDecorator implements Coffee{
    Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee){
        this.decoratedCoffee = coffee;

    }
    @Override
    public String prepare() {
        decoratedCoffee.prepare();
    }
    @Override
    public double getCost() {
        decoratedCoffee.getCost();
    }

}

class CaramelDecorator extends CoffeeDecorator{
    public CaramelDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public void prepare() {
        decoratedCoffee.prepare() + " + Caramel";
    }
    @Override
    public void getCost() {
        decoratedCoffee.getCost() + " + $0.50";
    }
}



public class DecoratorMain {
    
}
