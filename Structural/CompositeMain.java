package Structural;

import java.util.ArrayList;
import java.util.List;

// Component interface
interface FileSystemComponent {
    void display(String indent);
    int getSize();
}

//leaf class
class File implements FileSystemComponent {
    private final String name;
    private final int size; // size in KB

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + "KB)");
    }

    @Override
    public int getSize() {
        return size;
    }
   
}

// Composite class
class Directory implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> components = new ArrayList<>();
    public Directory(String name) {
        this.name = name;
    }
    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }
    @Override
    public void display(String indent) {
        System.out.println(indent + "Directory: " + name);
        for (FileSystemComponent component : components) {
            component.display(indent + "  ");

        }
    }
    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}
// Client code
public class CompositeMain {
    public static void main(String[] args) {
        File file1 = new File("file1.txt", 10);
        File file2 = new File("file2.txt", 20);
        Directory dir1 = new Directory("Documents");
        dir1.addComponent(file1);
        dir1.addComponent(file2);
        File file3 = new File("file3.txt", 15);
        Directory dir2 = new Directory("Pictures");
        dir2.addComponent(file3);
        Directory rootDir = new Directory("Root");
        rootDir.addComponent(dir1);
        rootDir.addComponent(dir2);
        rootDir.display("");
        System.out.println("Total size: " + rootDir.getSize() + "KB");
    }
        
}
