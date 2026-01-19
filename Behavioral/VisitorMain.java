package Behavioral;
//Element/Visitbale interface;
interface Shape{
    void accept(Visitor visitor);
}

//Concrete Element 1
class Circle implements Shape{
    private double radius;
    
    Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}

//Concrete Element 2
class Rectangle implements Shape{
    private double length;
    private double width;

    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//visitor interface
interface Visitor{
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

class AreaVisitor implements Visitor{
    private double area;

    public double getArea() {
        return area;
    }

    @Override
    public void visit(Circle circle) {
        area += Math.PI * Math.pow(circle.getRadius(), 2);
    }

    @Override
    public void visit(Rectangle rectangle) {
        area += rectangle.getLength() * rectangle.getWidth();
    }
}

class DrawVisitor implements Visitor{

    @Override
    public void visit(Circle circle) {
        System.out.println("Drawing Circle with radius: " + circle.getRadius());
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Drawing Rectangle with length: " + rectangle.getLength() + " and width: " + rectangle.getWidth());
    }
}


public class VisitorMain {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6)
        };

        AreaVisitor areaVisitor = new AreaVisitor();
        DrawVisitor drawVisitor = new DrawVisitor();

        for(Shape shape : shapes){
            shape.accept(areaVisitor);
            shape.accept(drawVisitor);
        }

        System.out.println("Total Area: " + areaVisitor.getArea());
        
    }
    
}
