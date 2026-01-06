package Structural;

import java.util.HashMap;
import java.util.Map;

interface Shape{
    public void draw();
}

class Circle implements Shape{
    private final String color;
    private final int radius;
    public Circle(String color, int raidus){
        this.color = color;
        this.radius = raidus;
    }
    @Override
    public void draw(){
        System.out.println("Drawing Circle of color: " + color + ", radius: " + radius);
    }
}

class Rectangle implements Shape{
    private final String color;
    private final int length;
    private final int breadth;
    public Rectangle(String color, int length, int breadth){
        this.color = color;
        this.length = length;
        this.breadth = breadth;
    }
    @Override
    public void draw(){
        System.out.println("Drawing Rectangle of color: " + color + ", length: " + length + ", breadth: " + breadth);
    }
}

class ShapeFactory {
    private static final Map<String, Shape> shapeMap = new HashMap<>();
    
    public static Shape getCircle(String color, int radius) {
        String key = "CIRCLE-" + color + "-" + radius;
        
        if (!shapeMap.containsKey(key)) {
            shapeMap.put(key, new Circle(color, radius));
        }
        
        return shapeMap.get(key);
    }
    
    public static Shape getRectangle(String color, int width, int height) {
        String key = "RECTANGLE-" + color + "-" + width + "-" + height;
        
        if (!shapeMap.containsKey(key)) {
            shapeMap.put(key, new Rectangle(color, width, height));
        }
        
        return shapeMap.get(key);
    }
}
public class FlyweightMain {
    public static void main(String[] args) {
        Shape circle1 = ShapeFactory.getCircle("Red", 10);
        Shape circle2 = ShapeFactory.getCircle("Red", 10);
        Shape rectangle1 = ShapeFactory.getRectangle("Blue", 20, 30);
        Shape rectangle2 = ShapeFactory.getRectangle("Blue", 20, 30);
        
        circle1.draw();
        circle2.draw();
        rectangle1.draw();
        rectangle2.draw();
        
        System.out.println("circle1 and circle2 are the same instance: " + (circle1 == circle2));
        System.out.println("rectangle1 and rectangle2 are the same instance: " + (rectangle1 == rectangle2));
    }

    
}
