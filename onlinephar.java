package myjava;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Medicines{
    private String name;
    private double price;

    public Medicines(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class onlinephar {
    private static Map<Medicines, Integer> cart = new HashMap<>();
    private static List<Medicines> availableMedicines = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeMedicines();

        while (true) {
            displayMedicines();
            int choice = getUserChoice();
            

            if (choice == availableMedicines.size() + 1) {
                completeOrder();
                break;
            } else if (choice >= 1 && choice <= availableMedicines.size()) {
                Medicines selectedMedicines = availableMedicines.get(choice - 1);
                addToCart(selectedMedicines);
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void initializeMedicines() {
        System.out.println("WELCOME!");
        System.out.println("Request you to place your order ");

        availableMedicines.add(new Medicines("Medicine PARACETOMOL", 30));
        availableMedicines.add(new Medicines("Medicine IBUPROFEN", 50));
        availableMedicines.add(new Medicines("Medicine ASPIRIN", 25));
        availableMedicines.add(new Medicines("Medicine GRILINCTUS", 115));
        availableMedicines.add(new Medicines("Medicine FIRST AID KIT",700));
        availableMedicines.add(new Medicines("Medicine DEBROX EAR DROPS",80));
        availableMedicines.add(new Medicines("Medicine SYRINGES&INSULIN NEEDLES",300));
        availableMedicines.add(new Medicines("Medicine GLUCOSE 200gms",50));
        availableMedicines.add(new Medicines("Medicine OTRIVIN NASAL DROPS",200));
        availableMedicines.add(new Medicines("Medicine SURGICAL KIT BOX",1100));
}
    

    private static void displayMedicines() {
        System.out.println("Available Medicines:");
        for (int i = 0; i < availableMedicines.size(); i++) {
            Medicines medicines = availableMedicines.get(i);
            System.out.println((i + 1) + ". " + medicines.getName() + " - RS" + medicines.getPrice());
        }
        System.out.println((availableMedicines.size() + 1) + ". Complete Order");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void addToCart(Medicines medicines) {
        System.out.print("Enter the quantity of"+" "+ medicines.getName() + ": ");
        int quantity = scanner.nextInt();

        if (quantity > 0) {
            cart.put(medicines, quantity);
            System.out.println("The no.of"+" "+quantity +"in "+ "" + medicines.getName() + "(is) added to cart.");
        } else {
            System.out.println("Invalid quantity. Please enter a possible quantity.");
        }
    }

    private static void completeOrder() {
        double totalCost = 0.0;
        System.out.println("*****************************************");
        System.out.println("Order Summary:");
        System.out.println("*****************************************");
        for (Map.Entry<Medicines, Integer> entry : cart.entrySet()) {
            Medicines medicines = entry.getKey();
            int quantity = entry.getValue();
            double cost = medicines.getPrice() * quantity;

            System.out.println(
                medicines.getName() + " = Quantity: " + quantity + " = Cost:RS " + cost
            );

            totalCost += cost;
        }
        System.out.println("--------CUSTOMER DETAILS----------");
        String name;
        
        Scanner SC=new Scanner(System.in);
        System.out.print("Enter your Name:");
        name=SC.nextLine();
        System.out.print("Enter your Phone number:");
        String phone=SC.next();
        System.out.print("Enter your Place:");
        String place=SC.next();
        System.out.print("Enter your Age:");
        int age=SC.nextInt();
        
        

        System.out.println("------------------------------------------");
        System.out.println("Total Cost:RS " + totalCost);
        System.out.println("------------------------------------------");
        System.out.println("The payment will be received through COD");
        
        System.out.println("***********Thank you for your order!*******");
    }
}
