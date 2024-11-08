import javax.management.RuntimeErrorException;

public class Engine {
    private FuelType fuelType;
    private double currentFuelLevel;
    private double maxFuelLevel;

    public Engine(FuelType fuelType, double currentFuelLevel, double maxFuelLevel){
        this.fuelType = fuelType;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }
    public Engine(FuelType fuelType, double fuelLevel){
        this(fuelType,fuelLevel,fuelLevel);
    }

    public void refuel(){
        this.currentFuelLevel = this.maxFuelLevel;
    }

    public FuelType getFuelType(){
        return this.fuelType;
    }

    public boolean go(){
        if (currentFuelLevel - 1 >= 0.0){
            this.currentFuelLevel -= 1; // there is enough fuel to decrease by 1
            System.out.println("Remaining fuel level: " + currentFuelLevel);
            return true;
        }
        else{
            throw new RuntimeException("Insufficient fuel level"); // not having return false is ok
        }
    
        
    }
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");

    




}