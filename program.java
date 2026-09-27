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


class program
{
    public static void main(String A[])
    {

    }

}