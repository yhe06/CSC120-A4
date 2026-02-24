import java.util.ArrayList;

public class Train implements TrainRequirements {

    // Attributes

    private Engine engine;
    private ArrayList<Car> cars;    
    private int nCars;
    private int passengerCapacity;

    // Constructor

    Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity);
        this.cars = new ArrayList<>();
        this.nCars = nCars;

        // Create a loop that creates Car Objects depending on how many the user inputs, and creates a set amount of capacity for each car
        for (int i = 0;i<this.nCars;i++){
            this.cars.add(new Car(passengerCapacity));
        }

    }

    // Accessors / Public Methods

    /**
     * Returns the type of engine.
     * 
     * @return fuelType
     */
    public Engine getEngine() {
        return this.engine;

    }

    /**
     * Returns the specific Car object you want to access.
     * 
     * @return Car object
     */
    public Car getCar(int i) {
        return this.cars.get(i);

    }

    /**
     * Returns the max capacity of all the cars attached to the train combined.
     * 
     * @return maxCapacity total train capacity
     */
    public int getMaxCapacity() {
        // We want to add together all the capacity of the all the cars...

        int maxCapacity = 0;

        for (int i = 0;i<this.cars.size();i++) {

            // Find the cars for all the cars in the Array List. Assigns it to a Car variable. Gets the capacity of the specific car. Adds EACH CAR CAPACITY to MAX CAPACITY.
            Car car = this.cars.get(i);
            maxCapacity += car.getCapacity();

        }

        return maxCapacity;

    }

    /**
     * Returns the amount of seat remaining throughout entire train with cars attached.
     * 
     * @return seatsRemaining total seats remaining.
     */
    public int seatsRemaining() {

        int seatsRemaining = 0;

        for (int i = 0;i<this.cars.size();i++) {
            Car car = this.cars.get(i);
            seatsRemaining += car.seatsRemaining();
        }

        return seatsRemaining;

    }

    /**
     * Prints a list of all the cars attached to the train. 
     */
    public void printManifest() {
        for (int i = 0;i<this.cars.size();i++) {
            Car car = this.cars.get(i);
            System.out.println("Car " + (i+1) );
            car.printManifest();


    }
}

    // Testing that all the methods work.
    public static void main(String[] arguments) {

    Passenger passenger1 = new Passenger("Thomas");
    Passenger passenger2 = new Passenger("Dash");
    Passenger passenger3 = new Passenger("Aiden");


    Train myTrain = new Train(FuelType.ELECTRIC, 100, 100, 4, 20);
    passenger2.boardCar(myTrain.cars.get(1));


    System.out.println(myTrain.getEngine());
    System.out.println(myTrain.getMaxCapacity());
    System.out.println(myTrain.seatsRemaining());
    myTrain.printManifest();

    System.out.println(myTrain.engine);
    System.out.println(myTrain.cars);

    //System.out.println(myTrain.getCar(0));

    }
}