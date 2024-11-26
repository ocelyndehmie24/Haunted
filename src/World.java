import java.util.ArrayList;
import java.util.List;

public class World {
    private static final List<Room> allRooms = new ArrayList<>();

    public static Room buildWorld() {
        
        Room foyer = new Room("Foyer");
        Room hallway = new Room("Hallway");
        Room library = new Room("Library");
        Room basement = new Room("Basement");
        Room attic = new Room("Attic");
        Room kitchen = new Room("Kitchen");
        
        Puppy puppy = new Puppy();
        hallway.addNPC(puppy);
        
        Ghost ghost = new Ghost();
        kitchen.addNPC(new Ghost());
        
        allRooms.add(foyer);
        allRooms.add(hallway);
        allRooms.add(library);
        allRooms.add(basement);
        allRooms.add(attic);
        allRooms.add(kitchen);

        
        Item key = new Key("Key", "A small rusty key", library);
        Item book = new Item("Book", "An old, dusty book with strange symbols");
        Item candle = new Item("Candle", "A half-burnt candle");
        Item knife = new Item("Knife", "A rusty kitchen knife");
        Item map = new Item("Map", "A torn and faded map of the house");
        Item skull = new Item("Skull", "A human skull with cracks running through it");
        Item combination = new Combination("Combination", "A small slip of paper with numbers on it");
        Item safe = new Safe("Safe", "It's an impressive safe!");
        Item mirror = new MagicMirror("Mirror", "A magical mirror that teleports you");
        Item scroll = new Scroll("Scroll", "An ancient scroll revealing a hidden message");
        Item potion = new Potion("Potion", "A mysterious potion that creates a protective shield");

        
        foyer.addItem(key);
        foyer.addItem(map);
        hallway.addItem(candle);
        hallway.addItem(skull);
        library.addItem(book);
        library.addItem(combination);
        basement.addItem(safe);
        attic.addItem(mirror);
        attic.addItem(scroll);
        kitchen.addItem(knife);
        kitchen.addItem(potion);

        
        foyer.addExit(hallway, 'e');
        hallway.addExit(foyer, 'w');
        hallway.addExit(library, 'n');
        library.addExit(hallway, 's');
        hallway.addExit(attic, 'u');
        attic.addExit(hallway, 'd');
        foyer.addExit(basement, 'd');
        basement.addExit(foyer, 'u');
        hallway.addExit(kitchen, 'e');
        kitchen.addExit(hallway, 'w');

        
        library.setLocked(true);

       
        return foyer;
    }

    public static List<Room> getAllRooms() {
        return allRooms;
    }
}
