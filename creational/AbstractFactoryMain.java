package Creational;

interface Chair{
    void hasLegs();
    void sitOn();
}

interface Table{
    void hasTableTop();
    void putOn();
}

class VictorianChair implements Chair{
    @Override
    public void hasLegs() {
        System.out.println("Victorian Chair has 4 legs.");
    }

    @Override
    public void sitOn() {
        System.out.println("Sitting on a Victorian Chair.");
    }
}

class ModernChair implements Chair{
    @Override
    public void hasLegs() {
        System.out.println("Modern Chair has 4 sleek legs.");
    }

    @Override
    public void sitOn() {
        System.out.println("Sitting on a Modern Chair.");
    }
}

class VictorianTable implements Table{
    @Override
    public void hasTableTop() {
        System.out.println("Victorian Table has a wooden tabletop.");
    }

    @Override
    public void putOn() {
        System.out.println("Putting items on a Victorian Table.");
    }
}

class ModernTable implements Table{
    @Override
    public void hasTableTop() {
        System.out.println("Modern Table has a glass tabletop.");
    }

    @Override
    public void putOn() {
        System.out.println("Putting items on a Modern Table.");
    }
}

interface FurnitureFactory{
    Chair createChair();
    Table createTable();
}

class VictorianFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
}

class ModernFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}

public class AbstractFactoryMain {
    public static void main(String[] args) {
        // This is a placeholder for the Abstract Factory pattern demonstration.
        System.out.println("Abstract Factory Pattern Main Method");
        FurnitureFactory victorianFactory = new VictorianFactory();
        Chair victorianChair = victorianFactory.createChair();
        Table victorianTable = victorianFactory.createTable();
        victorianChair.hasLegs();
        victorianChair.sitOn();
        victorianTable.hasTableTop();
        victorianTable.putOn();

        FurnitureFactory modernFactory = new ModernFactory();
        Chair modernChair = modernFactory.createChair();
        Table modernTable = modernFactory.createTable();
        modernChair.hasLegs();
        modernChair.sitOn();
        modernTable.hasTableTop();
        modernTable.putOn();
        
    }
    
}
