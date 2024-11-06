import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static Room currentRoom = World.buildWorld(); 
    static ArrayList<Item> inventory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = "";

        Game.print(currentRoom);

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine().trim().toLowerCase();
            String[] commandParts = command.split(" ", 2);
            String action = commandParts[0];
            String itemName = (commandParts.length > 1) ? commandParts[1] : null;

            switch (action) {
                case "quit":
                    Game.print("Thanks for playing!");
                    return;
                case "i":
                    if (inventory.isEmpty()) {
                        Game.print("You are carrying nothing.");
                    } else {
                        Game.print("You are carrying:");
                        for (Item item : inventory) {
                            Game.print("- " + item.getName());
                        }
                    }
                    break;
                case "take":
                    if (itemName == null) {
                        Game.print("Take what?");
                    } else {
                        Item item = currentRoom.removeItem(itemName);
                        if (item != null) {
                            inventory.add(item);
                            Game.print("You took the " + item.getName() + ".");
                        } else {
                            Game.print("No such item here.");
                        }
                    }
                    break;
                    
                case "use":
                    if (itemName == null) {
                        Game.print("Use what?");
                    } else {
                        Item item = getInventoryItem(itemName);
                        if (item != null) {
                            item.use();
                        } else {
                            Game.print("You don't have that item.");
                        }
                    }
                    break;
                case "open":
                    if (itemName == null) {
                        Game.print("Open what?");
                    } else {
                        Item item = currentRoom.getItem(itemName);
                        if (item == null) item = getInventoryItem(itemName); 
                        if (item != null) {
                            item.open();
                        } else {
                            Game.print("No such item here.");
                        }
                    }
                    break;
                default:
                	
                    Game.print("I don't understand that command.");
                    break;
            }
        }
    }

    public static void print(Object obj) {
        System.out.println(obj.toString());
    }

    public static Item getInventoryItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}