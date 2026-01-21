package Creational;

abstract class Animal implements Cloneable {
    private String name;
    private String desc;

    public Animal(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Animal clone(){
        Animal clonedAnimal = null;
        try {
            clonedAnimal = (Animal) super.clone();
            clonedAnimal.setName(name);
            clonedAnimal.setDesc(desc);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonedAnimal;
    }

    public abstract String helloAnimal();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}

class Sheep extends Animal {
    public Sheep(String name, String desc) {
        super(name, desc);
    }

    @Override
    public String helloAnimal() {
        return "Baa Baa! I am a Sheep. My name is " + getName() + ". " + getDesc();
    }
}

class Dog extends Animal {
    public Dog(String name, String desc) {
        super(name, desc);
    }

    @Override
    public String helloAnimal() {
        return "Woof Woof! I am a Dog. My name is " + getName() + ". " + getDesc();
    }
}

class AnimalPrototypeFactory {
    private Animal sheepPrototype;
    private Animal dogPrototype;

    public AnimalPrototypeFactory() {
        sheepPrototype = new Sheep("Default Sheep", "I love grazing in the fields.");
        dogPrototype = new Dog("Default Dog", "I am a loyal companion.");
    }

    public Animal createSheep() {
        return sheepPrototype.clone();
    }

    public Animal createDog() {
        return dogPrototype.clone();
    }
}
public class PrototypeMain {
    public static void main(String[] args) {
        AnimalPrototypeFactory animalFactory = new AnimalPrototypeFactory();

        Animal sheep1 = animalFactory.createSheep();
        sheep1.setName("Dolly");
        System.out.println(sheep1.helloAnimal());

        Animal dog1 = animalFactory.createDog();
        dog1.setName("Buddy");
        System.out.println(dog1.helloAnimal());

    }
    
}
