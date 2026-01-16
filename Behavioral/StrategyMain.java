package Behavioral;

//context class
 class Coffee{
    private String desc = "coffee";
    private double baseCost = 2.00;
    private CoffeeCustomization customization;

    public Coffee(CoffeeCustomization customization) {
        this.customization = customization;
    }

    public void setCustomization(CoffeeCustomization customization){
        this.customization = customization;
    }

    public void addDescription(String desc){
        this.desc = desc;
    }

    public String getDescription(){
        return desc;
    }

    public void prepare(){
        customization.customize(this);
    }

    public double getTotalCost(){
        return baseCost + customization.cost();
    }

 }

 //strategy interface
 interface CoffeeCustomization{
    void customize(Coffee coffee);
    double cost();
 }

//concrete strategy classes

class SyrupCustomization implements CoffeeCustomization{
    String flavor;

    public SyrupCustomization(String flavor){
        this.flavor = flavor;
    }

    public void customize(Coffee coffee) {
        coffee.addDescription(" + " + flavor + " syrup");
    }

    public double cost(){
        return 0.50;
    }
}

class SugarCustomization implements CoffeeCustomization{
    int spoons;

    public SugarCustomization(int spoons){
        this.spoons = spoons;
    }

    public void customize(Coffee coffee) {
        coffee.addDescription(" + " + spoons + " spoons of sugar");
    }

    public double cost(){
        return 0.10;
    }
}

//Client class
public class StrategyMain {
    public static void main(String[] args) {
        // Coffee with sugar
        Coffee coffee1 = new Coffee(new SugarCustomization(2));
        coffee1.prepare();
        System.out.println(coffee1.getDescription() + " - $" + coffee1.getTotalCost());
        
        // Coffee with syrup
        Coffee coffee2 = new Coffee(new SyrupCustomization("Vanilla"));
        coffee2.prepare();
        System.out.println(coffee2.getDescription() + " - $" + coffee2.getTotalCost());
        
        
    }
    
}
