abstract class Room {
    protected int roomNumber;
    protected int numberOfBeds;
    protected double price;

    public Room(int roomNumber, int numberOfBeds, double price) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.price = price;
    }

    public abstract void displayRoomDetails();
}

class SingleRoom extends Room {

    public SingleRoom(int roomNumber, int numberOfBeds, double price) {
        super(roomNumber, numberOfBeds, price);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: Single Room");
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Price: " + price);
    }
}

class DoubleRoom extends Room {

    public DoubleRoom(int roomNumber, int numberOfBeds, double price) {
        super(roomNumber, numberOfBeds, price);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: Double Room");
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Price: " + price);
    }
}

class SuiteRoom extends Room {

    public SuiteRoom(int roomNumber, int numberOfBeds, double price) {
        super(roomNumber, numberOfBeds, price);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: Suite Room");
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Price: " + price);
    }
}

public class BookMyStay {
    public static void main(String[] args) {

        Room singleRoom = new SingleRoom(101, 1, 2000);
        Room doubleRoom = new DoubleRoom(201, 2, 3500);
        Room suiteRoom = new SuiteRoom(301, 4, 8000);

        int singleRoomAvailable = 5;
        int doubleRoomAvailable = 3;
        int suiteRoomAvailable = 2;

        System.out.println("=== Room Details & Availability ===\n");

        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + singleRoomAvailable + "\n");

        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleRoomAvailable + "\n");

        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteRoomAvailable + "\n");
    }
}
