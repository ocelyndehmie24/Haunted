import java.util.HashMap;

public class Room {
    private String name;
    private boolean locked;
    private Room east, west, north, south, up, down;
    private HashMap<String, Item> items = new HashMap<>();
    private HashMap<String, NPC> npcs = new HashMap<>();

    public Room(String name) {
        this.name = name;
        this.locked = false;
    }

    public String getName() {
        return name;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void addItem(Item item) {
        items.put(item.getName().toLowerCase(), item);
    }

    public Item getItem(String itemName) {
        return items.get(itemName.toLowerCase());
    }

    public Item removeItem(String itemName) {
        return items.remove(itemName.toLowerCase());
    }

    public void addExit(Room room, char direction) {
        switch (direction) {
            case 'e' -> east = room;
            case 'w' -> west = room;
            case 'n' -> north = room;
            case 's' -> south = room;
            case 'u' -> up = room;
            case 'd' -> down = room;
        }
    }

    public Room getExit(char direction) {
        return switch (direction) {
            case 'e' -> east;
            case 'w' -> west;
            case 'n' -> north;
            case 's' -> south;
            case 'u' -> up;
            case 'd' -> down;
            default -> null;
        };
    }

    public void addNPC(NPC npc) {
        npcs.put(npc.getName().toLowerCase(), npc);
    }

    public NPC getNPC(String npcName) {
        return npcs.get(npcName.toLowerCase());
    }
    
    public boolean hasNPC(String npcName) {
    	return npcs.containsKey(npcName.toLowerCase());
    }
    
    public boolean hasItem(String itemName) {
    	return items.containsKey(itemName.toLowerCase());
    }
}
