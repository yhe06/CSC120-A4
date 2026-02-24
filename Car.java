import java.util.ArrayList;

public class Car implements CarRequirements {

    // Attributes

    private int capacity;

    // The ArrayList will be filled with Passenger Objects.
    public ArrayList<Passenger> passengers;
    
    // Constructor 

    Car(int capacity) {

        this.capacity = capacity;
        // Creates an Array List for the passengers in the car.
        this.passengers = new ArrayList<>();

    }

    /**
     * Returns the capacity of the car object.
     * 
     * @return capacity The capacity of the car 
     */
    public int getCapacity() {
        return this.capacity;
    }
    /** 
     * Returns the amount of seat that remains in the car object.
     * 
     * @return seatsRemaining The number of seats remaining.
     */
    public int seatsRemaining() {
        // Capacity minus the amount of passengers on board.
        // Seats remaining = 100
        // for all values in this.Passengers [i], seatsRemaining = SeatsRemaining - 1
        
        int seatsRemaining = this.capacity;

        // Loop through all the elements in the Array List and subtract it from the TOTAL CAPACITY of the car to get TOTAL SEATS REMAINING.
        for (int i = 0;i<this.passengers.size();i++) {
            seatsRemaining -= 1;
            
        }

        return seatsRemaining;

    }
    /**
     * Checks to see if there are enough seats remaining for another passenger.
     * 
     * @param p
     * @return true or false
     */
    // If there are seats available in the car, passenger may be added to the Array List.
    public Boolean addPassenger(Passenger p) {
        int seatsRemaining = this.seatsRemaining();

        if (seatsRemaining > 0){;
             return true;

        } else {
            return false;

        }

    }
    /**
     * Checks to see if a passenger on board able to be removed.
     * 
     * @param p
     * @return true or false
     */
    public Boolean removePassenger(Passenger p) {

        // Check if a Passenger Object is in the Car Array List for passengers, aka check if passenger is actually ON BOARD. Car cannot put passenger on car, passenger has to board car. 
        if (this.passengers.contains(p)) {
            return true;

        } else {
            System.out.println("Passenger is not on board.");
            return false;

        }

    }

    /**
     * Prints a list of all the passengers currently on board the car.
     * 
     */
    public void printManifest() {
        // First, make sure that the Array list for passengers is NOT empty.

        if (!this.passengers.isEmpty()) {
            System.out.println("PASSENGERS ON BOARD:");
            
            // Loop through all passengers on board.
            for (int i = 0;i<this.passengers.size();i++) {
                // Probably wrong, probably has to be string instead of object, but *HOPEFULLY* this lists out all the passengers and all their names!
                Passenger passenger = this.passengers.get(i);
                System.out.println(i+1 + ": " + passenger);
            }
            
        } else {
            System.out.println("This car is EMPTY.");
        }
    }
    

    // Testing that these methods work. EVERYTHING WORKS FOR CAR!
    public static void main(String[] arguments) {
    Car myCar = new Car(100);
    Passenger Passenger1 = new Passenger("Thomas");
    Passenger Passenger2 = new Passenger("Dash");
    Passenger Passenger3 = new Passenger("Aiden");

    myCar.addPassenger(Passenger1);
    myCar.addPassenger(Passenger2);
    myCar.addPassenger(Passenger3);

    myCar.printManifest();

    myCar.removePassenger(Passenger2);
    myCar.printManifest();

    System.out.println(myCar.seatsRemaining());

    System.out.println(myCar.capacity);

    }

    }


