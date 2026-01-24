package Structural;

interface TV {
    void on();
    void off();
    void tuneChannel(int channel);
}

class GoogleTV implements TV {
    public void on() {
        System.out.println("Google TV is ON");
    }
    public void off() {
        System.out.println("Google TV is OFF");
    }
    public void tuneChannel(int channel) {
        System.out.println("Google TV tuned to channel " + channel);
    }
}
class AppleTV implements TV {
    public void on() {
        System.out.println("Apple TV is ON");
    }
    public void off() {
        System.out.println("Apple TV is OFF");
    }
    public void tuneChannel(int channel) {
        System.out.println("Apple TV tuned to channel " + channel);
    }
}

abstract class TVRemote{
    private TV tv;

    public TVRemote(TV tv) {
        this.tv = tv;
    }
    
    public void on(){
        tv.on();

    }
    public void off(){
        tv.off();

    }
    public void tuneChannel(int channel){
        tv.tuneChannel(channel);

    }
}

class ConcreteTVRemote extends TVRemote{
    private int Currentchannel;
    
    public ConcreteTVRemote(TV tv) {
        super(tv);
    }

    public void nextChannel(){
        Currentchannel++;
        System.out.println("Using ConcreteTVRemote to tune channel." + Currentchannel);
    }

    public void previousChannel(){
        Currentchannel--;
        System.out.println("Using ConcreteTVRemote to tune channel." + Currentchannel);
    }
}

public class BuilderMain {
    public static void main(String[] args) {
        TVRemote googleTVRemote = new ConcreteTVRemote(new GoogleTV());
        googleTVRemote.on();
         ((ConcreteTVRemote) googleTVRemote).nextChannel();
         ((ConcreteTVRemote) googleTVRemote).previousChannel();
        googleTVRemote.off();

        TVRemote appleTVRemote = new ConcreteTVRemote(new AppleTV());
        appleTVRemote.on();
        ((ConcreteTVRemote) appleTVRemote).nextChannel();
        ((ConcreteTVRemote) appleTVRemote).previousChannel();
        appleTVRemote.off();
        
    }
    
}
