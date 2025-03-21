class TicketCounter {
    private int availableSeats = 10;

    // Synchronized method to book a ticket
    public synchronized void bookTicket(String customerType, String customerName, int seatsRequired) {
        System.out.println(customerType + " Booking Request: " + customerName + " - Seats Requested: " + seatsRequired);

        if (availableSeats >= seatsRequired) {
            System.out.println("Booking in progress for " + customerName + "...");
            try {
                Thread.sleep(1000); // simulate processing delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            availableSeats -= seatsRequired;
            System.out.println("✅ Booking successful for " + customerName + ". Seats booked: " + seatsRequired);
            System.out.println("Remaining Seats: " + availableSeats);
        } else {
            System.out.println("❌ Booking failed for " + customerName + ". Not enough seats.");
            System.out.println("Remaining Seats: " + availableSeats);
        }
    }
}

// Booking thread class
class BookingThread extends Thread {
    private TicketCounter counter;
    private String customerName;
    private int seatsRequired;
    private String customerType;

    public BookingThread(TicketCounter counter, String customerName, int seatsRequired, String customerType) {
        this.counter = counter;
        this.customerName = customerName;
        this.seatsRequired = seatsRequired;
        this.customerType = customerType;
    }

    @Override
    public void run() {
        counter.bookTicket(customerType, customerName, seatsRequired);
    }
}

// Main class
public class TicketBookingSystem {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        // VIP Customers
        BookingThread vip1 = new BookingThread(counter, "VIP-John", 3, "VIP");
        BookingThread vip2 = new BookingThread(counter, "VIP-Sarah", 2, "VIP");

        // Regular Customers
        BookingThread reg1 = new BookingThread(counter, "User-Alice", 4, "Regular");
        BookingThread reg2 = new BookingThread(counter, "User-Bob", 3, "Regular");

        // Set priorities: VIP > Regular
        vip1.setPriority(Thread.MAX_PRIORITY);     // Priority 10
        vip2.setPriority(Thread.MAX_PRIORITY);     // Priority 10
        reg1.setPriority(Thread.NORM_PRIORITY);    // Priority 5
        reg2.setPriority(Thread.MIN_PRIORITY);     // Priority 1

        // Start booking threads
        vip1.start();
        vip2.start();
        reg1.start();
        reg2.start();
    }
}
