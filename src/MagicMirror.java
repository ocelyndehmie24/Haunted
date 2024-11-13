public class MagicMirror extends Item {
    public MagicMirror(String name, String description) {
        super(name, description);
    }

   
    public void use() {
        Room randomRoom = World.buildWorld(); 
        Game.print("You look into the mirror and suddenly find yourself in " + randomRoom.getName() + ".");
        Game.currentRoom = randomRoom;
        Game.print(Game.currentRoom);
    }
}
