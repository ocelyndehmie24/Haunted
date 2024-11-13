
public class World {
    
    public static Room buildWorld() {
        
    	Room foyer = new Room("Foyer", "You are in a dimly lit foyer.");
        Room hallway = new Room("Hallway", "You are in a long, narrow hallway with creepy paintings.");
        Room library = new Room("Library", "You are in a dusty old library filled with ancient books.");
        Room basement = new Room("Basement", "You are in a cold, damp basement. The walls are crumbling.");
        Room attic = new Room("Attic", "You are in a dark, cluttered attic.");
        Room kitchen = new Room("Kitchen", "You are in a decrepit kitchen. The appliances are rusted and broken.");

        Item key = new Key("Key", "A small rusty key", library);
        Item book = new Item("Book", "An old, dusty book with strange symbols");
        Item candle = new Item("Candle", "A half-burnt candle.");
        Item knife = new Item("Knife", "A rusty kitchen knife");
        Item map = new Item("Map", "A torn and faded map of the house.");
        Item skull = new Item("Skull", "A human skull with cracks running through it.");
        Item combination = new Combination("Combination", "A small slip of paper with numbers on it.");
        Item safe = new Safe("Safe", "It's an impressive safe!");

        Item mirror = new MagicMirror("Mirror", "A magical mirror that teleports you.");
        Item scroll = new Scroll("Scroll", "An ancient scroll revealing a hidden message.");
        Item potion = new Potion("Potion", "A mysterious potion that creates a protective shield.");
        
        library.addItem(combination);
        basement.addItem(safe);
        
        foyer.addItem(key);
        foyer.addItem(book);
        foyer.addItem(candle);
        foyer.addItem(map);
        library.addItem(book);
        library.addItem(key);
        library.addItem(candle);
        library.addItem(map);
        library.addItem(skull);
        attic.addItem(map);
        attic.addItem(key);
        attic.addItem(candle);
        attic.addItem(book);
        attic.addItem(skull);
        kitchen.addItem(knife);
        kitchen.addItem(map);
        kitchen.addItem(skull);
        kitchen.addItem(candle);
        basement.addItem(map);
        basement.addItem(candle);
        basement.addItem(knife);
        basement.addItem(map);
        basement.addItem(skull);
        basement.addItem(key);
        hallway.addItem(skull);
        hallway.addItem(key);
        hallway.addItem(book);
        hallway.addItem(candle);
        hallway.addItem(knife);
        hallway.addItem(skull);
        kitchen.addItem(potion);
        attic.addItem(mirror);
        attic.addItem(scroll);
        
        
        
        foyer.addExit(hallway, 'e');
        hallway.addExit(foyer, 'w');
        hallway.addExit(library, 'n');
        library.addExit(hallway, 's');
        basement.addExit(foyer, 'u');
        foyer.addExit(basement, 'd');
        attic.addExit(hallway, 'u');
        hallway.addExit(attic, 'd');
        kitchen.addExit(hallway, 'e');
        hallway.addExit(kitchen, 'w');
        foyer.addExit(attic,'u');
        attic.addExit(basement, 'd');
        
        library.setLocked(true);

        
        return foyer;
    }
}
