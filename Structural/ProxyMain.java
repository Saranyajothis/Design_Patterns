package Structural;

interface Image{
    void display();
}

class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName){
        this. fileName = fileName;
        loadFromDisk(fileName);

    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading image from disk: " + fileName);
    }

    public void display(){
        System.out.println("Displaying image: " + fileName);
    }

}

class ProxyImage implements Image{
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    public void display(){
        if(realImage == null)
            realImage = new RealImage(fileName);
        realImage.display();
    }
}

public class ProxyMain {
    public static void main(String[] args){

        Image image = new ProxyImage("test_image.jpg");

        // Image will be loaded from disk
        image.display();
        System.out.println("");

        // Image will not be loaded from disk
        image.display();
    }
}
