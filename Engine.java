public class Engine implements EngineRequirements {
    // Attributes

    // FuelType as the identifier

    private FuelType fuelType;
    private double currentFuel;
    private double maxFuel;

    // Constructor
    public Engine(FuelType fuelType, double currentFuel, double maxFuel) {

    this.fuelType = fuelType;
    this.currentFuel = currentFuel;
    this.maxFuel = maxFuel;

    }

    // Methods

    /**
     * Returns the fuel type of the engine.
     * 
     * @return fuelType The fuel type of the engine.
     */
    public FuelType getFuelType(){
        return this.fuelType;
    }

    /**
     * Returns the current fuel amount
     * 
     * @return currentFuel Current Fuel integer.
     */
    public double getCurrentFuel(){
        return this.currentFuel;
    }

    /**
     * Returns the max fuel amount.
     * 
     * @return maxFuel Max fuel capacity.
     */
    public double getMaxFuel(){
        return this.maxFuel;
    }
    /**
     * Refuels engine back to max capacity.
     */

    //a `refuel()` method which will reset the `Engine`'s current fuel level to the maximum, and which doesn't need to `return` anything.
    public void refuel() {
        this.currentFuel = this.maxFuel;

    }
    /**
     * Decreases currentFuel to resemble engine running.
     * 
     * @return Boolean
     */
    // a `go()` which will decrease the current fuel level, print some useful information (e.g. remaining fuel level), and return `True` if the fuel level is above 0 and `False` otherwise.
    public Boolean go() {
        this.currentFuel = this.currentFuel - 10.00;
        System.out.println("Remaining fuel level: " + this.getCurrentFuel());

        if (this.currentFuel > 0) {
            return true;
        } else {
            return false;
        }

    }

    
    
    // Testing that Engine.java runs!
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0.0, 100.0);
        
        // currentFuel is empty, so you have to refuel first:
        myEngine.refuel();

        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }
}

