package Behavioral;

abstract class SupportHandler{
    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler supportHandler){
        this.nextHandler = supportHandler;
    }

    public abstract void handleRequests(String issues, int priority);

}

class Level1Support extends SupportHandler{
    @Override
    public void handleRequests(String issues, int priority) {
       if(priority <= 1){

       }else if(nextHandler != null){
            nextHandler.handleRequests(issues, priority);
       }
    }
}

class Level2Support extends SupportHandler{
    @Override
    public void handleRequests(String issues, int priority) {
       if(priority <= 2){

       }else if(nextHandler != null){
            nextHandler.handleRequests(issues, priority);
       }
    }
}

class Level3Support extends SupportHandler{
    @Override
    public void handleRequests(String issues, int priority) {
       if(priority <= 3){

       }else if(nextHandler != null){
            nextHandler.handleRequests(issues, priority);
       }
    }
}
public class CORMain {
    public static void main(String[] args){
        Level1Support level1 = new Level1Support();
        Level2Support level2 = new Level2Support();
        Level3Support level3 = new Level3Support();

        level1.setNextHandler(level2);
        level2.setNextHandler(level3);

        level1.handleRequests("Password Reset", 1);
        level1.handleRequests("Software Installation", 2);
        level1.handleRequests("System Crash", 3);
    

    }

    
}
