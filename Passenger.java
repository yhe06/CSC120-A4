public class Passenger implements PassengerRequirements{
    
    private String name;

    public Passenger(String name) {
        this.name = name;
    }
    /**
     * Checks to see if the car is eligible to add passenger, and if so, the passenger is permitted to get on car.
     * 
     *@param c The car object 
     */

    // Add passenger to the ArrayList in Object Car.
    public void boardCar(Car c){

        // The parameters for .addPassenger is just 'this' because it refers to the Passenger Object as a whole.
        if (c.addPassenger(this)) {
            c.passengers.add(this);           
        } else {
            System.out.println("The car is at max capacity.");
        }

    }
    /**
     * Checks to see if the car is eligible to remove passenger, and if so, the passenger is permitted to get off car.
     * 
     *@param c The car object 
     */
    public void getOffCar(Car c){

        if (c.removePassenger(this)) {
            c.passengers.remove(this);           
        } else {
            System.out.println("This passenger is not on board.");
        }

    }
    /**
     * Returns the object as a string.
     */
    public String toString() {
        return this.name;
    }

    // Checking to see that everything works!
    public static void main(String[] arguments) {
    Car myCar = new Car(3);
    Passenger passenger1 = new Passenger("Thomas");
    Passenger passenger2 = new Passenger("Dash");
    Passenger passenger3 = new Passenger("Aiden");

    passenger1.boardCar(myCar);
    passenger2.boardCar(myCar);
    passenger3.boardCar(myCar);

    myCar.printManifest();

    System.out.println(myCar.seatsRemaining());
    System.out.println(myCar.getCapacity());

    passenger1.getOffCar(myCar);
    passenger2.getOffCar(myCar);

    passenger3.getOffCar(myCar);

    myCar.printManifest();

    System.out.println(myCar.seatsRemaining());

}
}
