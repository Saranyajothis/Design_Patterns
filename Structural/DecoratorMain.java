package Structural;

interface Coffee{
    String prepare();
    double getCost();
}

class SimpleCoffee implements Coffee{
    @Override
    public String prepare() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 2.0;
    }

}

abstract class CoffeeDecorator implements Coffee{
    Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee){
        this.decoratedCoffee = coffee;

    }
    @Override
    public String prepare() {
        return decoratedCoffee.prepare();
    }
    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

}

class CaramelDecorator extends CoffeeDecorator{
    public CaramelDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String prepare() {
        return decoratedCoffee.prepare() + " + Caramel";
    }
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}


class WhippedCreamDecorator extends CoffeeDecorator{
    public WhippedCreamDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String prepare() {
        return decoratedCoffee.prepare() + " + Whipped Cream";
    }
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.7;
    }
}

public class DecoratorMain {
    public static void main(String[] args) {
        // Create a simple coffee
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.prepare() + " Cost: $" + simpleCoffee.getCost());

        // Decorate with Caramel
        Coffee caramelCoffee = new CaramelDecorator(simpleCoffee);
        System.out.println(caramelCoffee.prepare() + " Cost: $" + caramelCoffee.getCost());

        // Decorate with Whipped Cream
        Coffee whippedCreamCoffee = new WhippedCreamDecorator(caramelCoffee);
        System.out.println(whippedCreamCoffee.prepare() + " Cost: $" + whippedCreamCoffee.getCost());
    }
    
}
