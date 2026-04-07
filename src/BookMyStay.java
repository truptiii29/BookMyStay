import java.util.*;

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

class RoomInventory {
    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void reduceAvailability(String type) {
        inventory.put(type, getAvailability(type) - 1);
    }
}

class BookingService {
    private Queue<Reservation> queue;
    private RoomInventory inventory;
    private HashMap<String, Set<String>> allocatedRooms;

    public BookingService(RoomInventory inventory) {
        this.inventory = inventory;
        this.queue = new LinkedList<>();
        this.allocatedRooms = new HashMap<>();
    }

    public void addRequest(Reservation r) {
        queue.add(r);
    }

    public void processBookings() {
        while (!queue.isEmpty()) {
            Reservation r = queue.poll();
            String type = r.getRoomType();

            if (inventory.getAvailability(type) > 0) {
                String roomId = generateRoomId(type);

                allocatedRooms.putIfAbsent(type, new HashSet<>());
                Set<String> assigned = allocatedRooms.get(type);

                if (!assigned.contains(roomId)) {
                    assigned.add(roomId);
                    inventory.reduceAvailability(type);

                    System.out.println("Booking Confirmed for " + r.getGuestName());
                    System.out.println("Room Type: " + type + ", Room ID: " + roomId);
                    System.out.println();
                }
            } else {
                System.out.println("Booking Failed for " + r.getGuestName() + " (No rooms available)");
                System.out.println();
            }
        }
    }

    private String generateRoomId(String type) {
        String prefix = type.substring(0, 2).toUpperCase();
        int number = new Random().nextInt(1000);
        return prefix + number;
    }
}

public class UseCase6RoomAllocationService {
    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        BookingService service = new BookingService(inventory);

        service.addRequest(new Reservation("Alice", "Single Room"));
        service.addRequest(new Reservation("Bob", "Single Room"));
        service.addRequest(new Reservation("Charlie", "Single Room"));
        service.addRequest(new Reservation("David", "Double Room"));

        System.out.println("----- Processing Bookings -----\n");

        service.processBookings();
    }
}
