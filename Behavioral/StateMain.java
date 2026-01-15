package Behavioral;

interface State{
    void handleRequest(Context context);
}

class OnState implements State{
    public void handleRequest(Context context) {
        System.out.println("Light is ON. Switching to OFF..");
        context.setState(new OffState());
    }
}

class OffState implements State{
    public void handleRequest(Context context) {
        System.out.println("Light is OFF. Switching to ON..");
        context.setState(new OnState());
    }
}

class Context{
    private State state;

    Context(){;
        this.state = new OffState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handleRequest(this);
    }
}
 public class StateMain {
    public static void main(String[] args) {
        Context context = new Context();

        context.request(); // Light is OFF. Switching to ON..
        context.request(); // Light is ON. Switching to OFF..
        context.request(); // Light is OFF. Switching to ON..
        context.request(); // Light is ON. Switching to OFF..
    }
}
