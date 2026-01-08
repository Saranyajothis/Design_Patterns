package Behavioral;

//command interface
interface Command{
     void execute();
}

//receiver class
class Light{
    String name;
    Light(String name){
        this.name = name;
    }
    public void turnOn(){
        System.out.println(name + " light is ON.");
    }
    public void turnOff(){
        System.out.println(name + " light is OFF.");
    }

}

//concrete command to turn on the light
class LightOnCommand implements Command{
    Light light;

    LightOnCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.turnOn();
    }
}
//concrete command to turn off the light
class LightOffCommand implements Command{
    Light light;

    LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

//invoker class
class RemoteControl{
    Command command;
    
    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}


public class CommandMain {
    public static void main(String[] args) {
        Light light = new Light("Living Room");
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        
        RemoteControl remote = new RemoteControl();
        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
        
}
       
