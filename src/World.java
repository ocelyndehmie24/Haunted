
public class World {
    
    public static Room buildWorld() {
        
        Room foyer = new Room("You are in a dimly lit foyer.");
        Room hallway = new Room("You are in a long, narrow hallway with creepy paintings.");
        Room library = new Room("You are in a dusty old library filled with ancient books.");
        Room basement = new Room("You are in a cold, damp basement. The walls are crumbling.");
        Room attic = new Room("You are in a dark, cluttered attic.");
        Room kitchen = new Room("You are in a decrepit kitchen. The appliances are rusted and broken.");

        Item key = new Item("Key", "A small rusty key");
        Item book = new Item("Book", "An old, dusty book with strange symbols");
        Item candle = new Item("Candle", "A half-burnt candle.");
        Item knife = new Item("Knife", "A rusty kitchen knife");
        Item map = new Item("Map", "A torn and faded map of the house.");
        Item skull = new Item("Skull","A human skull with cracks running through it.");
        
        Item combination = new Combination("Combination", "A small slip of paper with numbers on it.");
        Item safe = new Safe("Safe", "It's an impressive safe!");
        
        library.addItem(combination);
        basement.addItem(safe);
        
        foyer.addItem(key);
        foyer.addItem(book);
        foyer.addItem(candle);
        foyer.addItem(knife);
        foyer.addItem(map);
        foyer.addItem(skull);
        library.addItem(book);
        library.addItem(key);
        library.addItem(candle);
        library.addItem(knife);
        library.addItem(map);
        library.addItem(skull);
        attic.addItem(map);
        attic.addItem(key);
        attic.addItem(candle);
        attic.addItem(knife);
        attic.addItem(book);
        attic.addItem(skull);
        kitchen.addItem(knife);
        kitchen.addItem(map);
        kitchen.addItem(book);
        kitchen.addItem(skull);
        kitchen.addItem(knife);
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

        
        return foyer;
    }
}
