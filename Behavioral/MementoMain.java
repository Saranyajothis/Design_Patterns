package Behavioral;

import java.util.Stack;

// Memento
class EditorMemento{
    private final String content;
    private final int curorsorPosition;

    EditorMemento(String Content, int cursorPosition){
        this.content = Content;
        this.curorsorPosition = cursorPosition;

    }

    public String getContent(){
        return content;
    }

    public int getCursorPosition(){
        return curorsorPosition;
    }

}

// Originator
class TextEditor {
    private String content;
    private int cursorPosition;

    public void setContent(String content){
        this.content = content;
    }

    public void setCursorPosition(int cursorPosition){
        this.cursorPosition = cursorPosition;
    }

    public String getContent() {
        return content;
    }

    public EditorMemento save(){
        return new EditorMemento(content, cursorPosition);
    }

    public void restore(EditorMemento memento){
        this.content = memento.getContent();
        this.cursorPosition = memento.getCursorPosition();

    }
}
//caretaker
class History{
    private Stack<EditorMemento> historyStack = new Stack<>();
    
    public void save(TextEditor editor){
        historyStack.push(editor.save());
    }

    public void undo(TextEditor editor){
        if(!historyStack.isEmpty()){
             editor.restore(historyStack.pop());
        }
    }

}


public class MementoMain {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.setContent("Hello, World!");
        editor.setCursorPosition(13);
        history.save(editor);

        editor.setContent("Hello, Memento Pattern!");
        editor.setCursorPosition(23);
        history.save(editor);

        System.out.println("Current: " + editor.getContent()); 
        
        history.undo(editor);
        System.out.println("After undo: " + editor.getContent());
        
        history.undo(editor);
        System.out.println("After undo: " + editor.getContent());
    

    }
}