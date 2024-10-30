import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Game {
	private static ArrayList<Item> inventory = new ArrayList<>();
	
    public static void main(String[] args) {
        Room currentRoom = World.buildWorld(); 
        Scanner scanner = new Scanner(System.in);
        String command =  "";
        
        System.out.println(currentRoom);
        
        while (true) {
            System.out.print("> ");
            command = scanner.nextLine().trim().toLowerCase();
         
            

            String[] commandParts = command.split(" ", 2);
            String action = commandParts[0];
            String itemName = (commandParts.length > 1) ? commandParts[1] : null;

            switch (action) {
                case "quit":
                    System.out.println("Thanks for playing!");
                    return;

                case "i":
                    
                    if (inventory.isEmpty()) {
                        System.out.println("You are carrying nothing.");
                    } else {
                        System.out.println("You are carrying:");
                        for (Item item : inventory) {
                            System.out.println("- " + item.getName());
                        }
                    }
                    break;

                case "take":
                    
                    if (itemName == null) {
                        System.out.println("Take what?");
                    } else {
                        Item item = currentRoom.removeItem(itemName);
                        if (item != null) {
                            inventory.add(item);
                            System.out.println("You took the " + item.getName() + ".");
                        } else {
                            System.out.println("No such item here.");
                        }
                    }
                    break;

                case "look":
                    
                    if (itemName == null) {
                        System.out.println("Look at what?");
                    } else {
                        Item item = currentRoom.getItem(itemName);
                        if (item == null) {
                            for (Item invItem : inventory) {
                                if (invItem.getName().equalsIgnoreCase(itemName)) {
                                    item = invItem;
                                    break;
                                }
                            }
                        }
                        if (item != null) {
                            System.out.println(item.getDescription());
                        } else {
                            System.out.println("No such item found.");
                        }
                    }
                    break;

                default:
                    System.out.println("I don't understand that command.");
                    break;
            }
            
        }
        
    } 
    
}  
    