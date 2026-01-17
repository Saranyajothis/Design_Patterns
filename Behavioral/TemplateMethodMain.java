package Behavioral;
abstract class Lunch{
    //template method
    public final void prepareLunch() {
        getIngredients();
        doPrperation();
        cook();
        serve();
        eating();
    }

    abstract void getIngredients();
    abstract void doPrperation();
    abstract void cook();
    abstract void serve();
    
    void eating() {
        System.out.println("Eating the lunch. Yum Yum!");
    }

}

class ItalianLunch extends Lunch{

    @Override
    void getIngredients() {
        System.out.println("Getting ingredients for Italian Lunch: Pasta, Tomato Sauce, Cheese");
    }

    @Override
    void doPrperation() {
        System.out.println("Preparing ingredients for Italian Lunch: Chopping vegetables, Boiling pasta");
    }

    @Override
    void cook() {
        System.out.println("Cooking Italian Lunch: Mixing pasta with sauce and cheese");
    }

    @Override
    void serve() {
        System.out.println("Serving Italian Lunch on a plate.");
    }
    
}

class MexicanLunch extends Lunch{

    @Override
    void getIngredients() {
        System.out.println("Getting ingredients for Mexican Lunch: Tortillas, Beans, Cheese, Salsa");
    }

    @Override
    void doPrperation() {
        System.out.println("Preparing ingredients for Mexican Lunch: Heating beans, Grating cheese");
    }

    @Override
    void cook() {
        System.out.println("Cooking Mexican Lunch: Assembling tortillas with beans, cheese and salsa");
    }

    @Override
    void serve() {
        System.out.println("Serving Mexican Lunch on a plate.");
    }
    
}

public class TemplateMethodMain {
    public static void main(String[] args) {
        Lunch italianLunch = new ItalianLunch();
        italianLunch.prepareLunch();
        
        Lunch mexicanLunch = new MexicanLunch();
        mexicanLunch.prepareLunch();
        
    }
    
}
