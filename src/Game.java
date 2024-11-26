import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    public static Room currentRoom = World.buildWorld();
    static HashMap<String, String> roomDescriptions = new HashMap<>();
    static ArrayList<Item> inventory = new ArrayList<>();
    public static Scanner scan = new Scanner(System.in);

    public static void loadRoomDescriptions(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String roomName = null;
            StringBuilder description = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.equals("#")) {
                    if (roomName != null && description.length() > 0) {
                        roomDescriptions.put(roomName, description.toString().trim());
                    }
                    roomName = null;
                    description.setLength(0);
                } else if (roomName == null) {
                    roomName = line.trim();
                } else {
                    description.append(line).append(" ");
                }
            }
            if (roomName != null && description.length() > 0) {
                roomDescriptions.put(roomName, description.toString().trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading room descriptions file: " + e.getMessage());
        }
    }

    public static String getRoomDescription(String roomName) {
        return roomDescriptions.getOrDefault(roomName, "No description available.");
    }

    public static Item getInventoryItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        loadRoomDescriptions("room_descriptions.txt");

        System.out.println("Welcome to the Haunted Escape Room!");
        System.out.println(getRoomDescription(currentRoom.getName()));

        while (true) {
            System.out.print("> ");
            String command = scan.nextLine().trim().toLowerCase();
            String[] commandParts = command.split(" ", 2);
            String action = commandParts[0];
            String parameter = (commandParts.length > 1) ? commandParts[1] : null;

            switch (action) {
                case "quit":
                    print("Thanks for playing!");
                    return;
                case "look":
                    print(getRoomDescription(currentRoom.getName()));
                    break;
                case "i":
                    if (inventory.isEmpty()) {
                        print("You are carrying nothing.");
                    } else {
                        print("You are carrying:");
                        for (Item item : inventory) {
                            print("- " + item.getName());
                        }
                    }
                    break;
                case "take":
                    if (parameter == null) {
                        print("Take what?");
                    } else {
                        Item item = currentRoom.removeItem(parameter);
                        if (item != null) {
                            inventory.add(item);
                            print("You took the " + item.getName() + ".");
                        } else {
                            print("No such item here.");
                        }
                    }
                    break;
                case "use":
                    if (parameter == null) {
                        print("Use what?");
                    } else {
                        Item item = getInventoryItem(parameter);
                        if (item != null) {
                            item.use();
                        } else {
                            print("You don't have that item.");
                        }
                    }
                    break;
                case "move":
                    if (parameter == null || parameter.length() != 1) {
                        print("Move where? (n, s, e, w, u, d)");
                    } else {
                        char direction = parameter.charAt(0);
                        Room nextRoom = currentRoom.getExit(direction);
                        if (nextRoom != null && !nextRoom.isLocked()) {
                            currentRoom = nextRoom;
                            print("You moved to " + currentRoom.getName() + ".");
                            print(getRoomDescription(currentRoom.getName()));
                        } else if (nextRoom != null && nextRoom.isLocked()) {
                            print("The " + nextRoom.getName() + " is locked.");
                        } else {
                            print("You can't go that way.");
                        }
                    }
                    break;
                case "talk":
                    if (parameter == null) {
                        print("Talk to whom?");
                    } else {
                        NPC npc = currentRoom.getNPC(parameter);
                        if (npc != null) {
                            npc.talk();
                        } else {
                            print("No one like that here.");
                        }
                    }
                    break;
                default:
                    print("I don't understand that command.");
                    break;
            }
        }
    }
}
