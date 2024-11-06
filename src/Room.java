import java.util.HashMap;

public class Room {
	private String description;
    private Room east, west, north, south, up, down;
    private HashMap<String, Item> items = new HashMap<>();

    
    public Room(String description) {
        this.description = description;	
        this.items = new HashMap<>();

}
    
    public void addItem(Item item)  {
    	items.put(item. getName().toLowerCase(), item);
    }
    
    public Item getItem(String itemName) {
    	return items.get(itemName.toLowerCase());
    }
    
    public Item removeItem(String itemName) {
    	return items.remove(itemName.toLowerCase());
    }
    
   
    public void addExit(Room room, char direction) {
    	if (direction == 'e')
    		east = room;
    	else if (direction == 'w')
    		west = room;
    	else if (direction == 'n')
    		north = room;
    	else if (direction == 's')
    		south = room;
    	else if (direction == 'u')
    		up = room;
    	else if (direction == 'd')
    		down = room;
    }
    
    public Room getExit(char direction) {
    	if (direction == 'e')
    		return east;
    	else if (direction == 'w')
    		return west;
    	else if (direction == 'n')
    		return north;
    	else if (direction == 's')
    		return south;
    	else if (direction == 'u')
    		return up;
    	else if (direction == 'd')
    		return down;
    	else
    		return null;  
    
    }


   
   public String toString() {
   	return description;
   	
   }
}