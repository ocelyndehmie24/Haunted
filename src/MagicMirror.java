import java.util.List;
import java.util.Random;

public class MagicMirror extends Item {

    public MagicMirror(String name, String description) {
        super(name, description);
    }

    
    public void use() {
        List<Room> allRooms = World.getAllRooms();

        if (allRooms == null || allRooms.isEmpty()) {
            System.out.println("The magic mirror doesn't seem to work right now.");
            return;
        }

        Random random = new Random();
        Room randomRoom = allRooms.get(random.nextInt(allRooms.size()));
        Game.currentRoom = randomRoom;
        System.out.println("You look into the mirror and suddenly find yourself in " + randomRoom.getName() + ".");
    }
}
