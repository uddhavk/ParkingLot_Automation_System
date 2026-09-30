/*
    ParkingLot Automation System

    Step 1 : Create required enums
    Step 2 : Vehicle Hierarchy creation
    Step 3 : VehicleFactory Creation (Factory Patter)
    Step 4 : ParkingSpot Hierarchy 
    Step 5 : ParkingObserver Class 
    Step 6 : ParkingFloor Class 
    Step 7 : ParkingDisplayBoard (Oberver Pattern) 
    Step 8 : ParkingStrategy class (Strategy Pattern) 
    Step 9 : PricingStrategy class (Strategy Pattern) 
    Step 10 : PaymentStrategy class
    Step 11 : ParkingTicket class
    Step 12 : EntryGate class
    Step 13 : ExitGate class
    Step 14 : ParkingLot class (Singleton Pattern)
    Step 15 : Main class (Controller)
*/

import java.util.*;
import java.time.Duration;
import java.time.LocalDateTime;

/////////////////////////////////////////////////////////////////////////////////
//  Step 1 : Create Enums
//  It is used to create fixed constants which are required
//  through the project
/////////////////////////////////////////////////////////////////////////////////

// Represent the different types of Vehicle 
enum VehicleType
{
    BIKE,
    CAR, 
    TRUCK
}

// Represent the different types of Parking Spots 
enum SpotType
{
    BIKE,
    CAR, 
    TRUCK
}

// Represent the current state of parking ticket 
enum TicketStatus
{
    ACTIVE,
    CLOSED
}

/////////////////////////////////////////////////////////////////////////////////
//  Step 2 : Create Vehicle Class Hierarchy
//  It is used to create multiple tyepes of classes which
//  represents the types of vehicle
//  Concepts : Abstraction, Inheritacne, Polymorphism, Encapsulation
/////////////////////////////////////////////////////////////////////////////////

// class which represents a generic vehicle type
abstract class Vehicle
{

    //  Abstracted characteristics of class
    private String vehicleNumber;
    private VehicleType vehicleType;

    // paramterized constructor
    public Vehicle(String vehicleNumber,VehicleType vehicleType)
    {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    // Concrete getter method
    public VehicleType getVehicleType()
    {
        return this.vehicleType;
    }

    // Concrete getter method
    public String getVehicleNumber()
    {
        return this.vehicleNumber;
    }

    // Every Concrete class will provide its own defination
    public abstract void display();

}

// Class which represent the vechile type as Bike
class Bike extends Vehicle
{
    // paramterized constructor
    public Bike(String vehicleNumber)
    {
        // Calls vechile class Constructor
        super(vehicleNumber, VehicleType.BIKE);
    }

    // Method Overriding
    @Override 
    public void display()
    {
        System.out.println("Bike : " + getVehicleNumber());
    }
}

// Class which represent the vechile type as Car
class Car extends Vehicle
{
    // paramterized constructor
    public Car(String vehicleNumber)
    {
        // Calls vechile class Constructor
        super(vehicleNumber, VehicleType.CAR);
    }

    // Method Overriding
    @Override 
    public void display()
    {
        System.out.println("Car : " + getVehicleNumber());
    }
}

// Class which represent the vechile type as Truck
class Truck extends Vehicle
{
    // paramterized constructor
    public Truck(String vehicleNumber)
    {
        // Calls vechile class Constructor
        super(vehicleNumber, VehicleType.TRUCK);
    }

    // Method Overriding
    @Override 
    public void display()
    {
        System.out.println("Truck : " + getVehicleNumber());
    }
}

/////////////////////////////////////////////////////////////////////////////////
//  Step 3 : Create VehicleFactory Class 
//  It is used to centrailized the creation of vehicle objects
//  Concepts : Factory Design Pattern
/////////////////////////////////////////////////////////////////////////////////

class VehicleFactory
{

    // creates and return the desired class object

    public static Vehicle creatVehicl(VehicleType type, String number)
    {
        switch(type)    
        {
            case BIKE:
                return new Bike(number);

            case CAR:
                return new Car(number);

            case TRUCK:
                return new Truck(number);

            default: 
                throw new IllegalArgumentException("Invalid vehicleType");
        }
    }

}

/////////////////////////////////////////////////////////////////////////////////
//  Step 4 : Create ParkingSpot Hierarchy 
//  It is used to create Hierarchy of Parking Spots
//  Concepts : Abstraction, Inheritacne, Polymorphism, Encapsulation
/////////////////////////////////////////////////////////////////////////////////

abstract class ParkingSpot
{
    // unique number for parking spot (Primary Key)
    private int spotNumber;

    // Type of parking spot
    private SpotType spotType;

    // Indicates whether spot is currrent occupied or not
    private boolean occupied;

    // stores information about the vehicle
    private Vehicle vehicle;

    // Parameterised constructor
    public ParkingSpot(int spotNumber, SpotType spotType)
    {
        this.spotNumber = spotNumber;
        this.spotType = spotType;

        // Initialised with default values
        this.occupied = false;
        this.vehicle = null;
    }

    public int getSoptNumber()
    {
        return this.spotNumber = spotNumber;
    }

    public SpotType getSpotType()
    {
        return this.spotType = spotType;
    }

    public boolean isOccupied()
    {
        return this.occupied;
    }

    public Vehicle getVehicle()
    {
        return this.vehicle;
    }

    // It is used to park the vehicle 
    public void parkVehicle(Vehicle vehicle)
    {
        if(this.occupied == true)
        {
            throw new RuntimeException("Parking Spot is already occupied");
        }
        else
        {
            this.vehicle = vehicle;
            this.occupied = true;
        }
    }

    public Vehicle removeVehicle()
    {   
        if(this.occupied == true)
        {
            Vehicle temp = vehicle;

            this.vehicle = null;
            this.occupied = false;

            return temp;
        }
        else
        {
            throw new RuntimeException("ParkingSpot is already empty");            
        }
    }

//  This method decide wheter we can park it in the sopt or not
    public abstract boolean canFitVehicle(Vehicle vehicle);
    public void display()
    {
        System.out.println("Spot : " + spotNumber + "[ " + spotType + " ]");

        if(this.occupied == true)
        {
            System.out.println("Occupied by : " + vehicle.getVehicleNumber());
        }
        else    
        {
            System.out.println("Spot is available");
        }
    }
}   // End of ParkingSpot class

class BikeSpot extends ParkingSpot
{

        public BikeSpot(int spotNumber)
        {
            super(spotNumber, SpotType.BIKE);
        }

        @Override 
        public  boolean canFitVehicle(Vehicle vehicle)
        {
            // return vehicle.getVehicleType() == VehicleType.BIKE; or

            if(vehicle.getVehicleType() == VehicleType.BIKE)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
}

class CarSpot extends ParkingSpot
{

        public CarSpot(int spotNumber)
        {
            super(spotNumber, SpotType.CAR);
        }

        @Override 
        public  boolean canFitVehicle(Vehicle vehicle)
        {
            // return vehicle.getVehicleType() == VehicleType.BIKE; or

            if(vehicle.getVehicleType() == VehicleType.CAR)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
}

class TruckSpot extends ParkingSpot
{

        public TruckSpot(int spotNumber)
        {
            super(spotNumber, SpotType.TRUCK);
        }

        @Override 
        public  boolean canFitVehicle(Vehicle vehicle)
        {
            // return vehicle.getVehicleType() == VehicleType.BIKE; or

            if(vehicle.getVehicleType() == VehicleType.TRUCK)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
}


class program
{
    public static void main(String A[])
    {

    }

}