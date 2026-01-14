package Behavioral;

class Mediator{
    private Buyer IndianBuyer;
    private Buyer FranceBuyer;
    private AmericanSeller americanSeller;
    private DollarConverter dollarConverter;

    public Mediator(){ }

    public void registerIndianBuyer(Buyer buyer){
        this.IndianBuyer = buyer;
    }
    public void registerFranceBuyer(Buyer buyer){
        this.FranceBuyer = buyer;
    }
    public void registerAmericanSeller(AmericanSeller seller){
        this.americanSeller = seller;
    }
    public void registerDollarConverter(DollarConverter dollarConverter){
        this.dollarConverter = dollarConverter;
    }
    public boolean placeBid(float bid, String unitOfCurrency){
        float bidInUSD = dollarConverter.convertToUSD(bid, unitOfCurrency);
        return americanSeller.isBidAccepted(bidInUSD);

    }
}

class Buyer{
    Mediator mediator;
    String unitOfCurrency;

    public Buyer(Mediator mediator, String unitOfCurrency){
        this.mediator = mediator;
        this.unitOfCurrency = unitOfCurrency;
    }

    public boolean attemptToBuy(float bidAmount){
        return mediator.placeBid(bidAmount, unitOfCurrency);
    }
}

class IndianBuyer extends Buyer{
    
    public IndianBuyer(Mediator mediator){
        super(mediator, "INR");
        this.mediator.registerIndianBuyer(this);
    }
    
}

class FranceBuyer extends Buyer{
    
    public FranceBuyer(Mediator mediator){
        super(mediator, "EURO");
        this.mediator.registerFranceBuyer(this);
    }
    
}

class AmericanSeller{
    Mediator mediator;
    private float priceInUSD;

    public AmericanSeller(Mediator mediator, float priceInUSD){
        this.mediator = mediator;
        this.priceInUSD = priceInUSD;
        this.mediator.registerAmericanSeller(this);
    }

    public boolean isBidAccepted(float bidInUSD){
        if(bidInUSD >= priceInUSD){
            System.out.println("Bid of USD " + bidInUSD + " accepted.");
            return true;
        } else {
            System.out.println("Bid of USD " + bidInUSD + " rejected.");
            return false;
        }
    }
}

class DollarConverter{
    private final float INR_TO_USD = 0.012f;
    private final float EURO_TO_USD = 1.1f;

    public DollarConverter(){}

    public float convertToUSD(float amount, String fromCurrency){
        switch(fromCurrency){
            case "INR":
                return amount * INR_TO_USD;
            case "EURO":
                return amount * EURO_TO_USD;
            default:
                return amount; // assuming it's already in USD
        }
    }
}

public class MediatorMain {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Buyer indianBuyer = new IndianBuyer(mediator);
        Buyer franceBuyer = new FranceBuyer(mediator);
        AmericanSeller americanSeller = new AmericanSeller(mediator, 100.0f);
        DollarConverter dollarConverter = new DollarConverter();
       
        while(!indianBuyer.attemptToBuy(7000.0f)){
            System.out.println("Indian buyer increasing bid...");
        }
        while(!franceBuyer.attemptToBuy(80.0f)){
            System.out.println("France buyer increasing bid...");
        }
    }
}
