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
//  Step 1 : Crate Enums
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

class program
{
    public static void main(String A[])
    {


    }

}