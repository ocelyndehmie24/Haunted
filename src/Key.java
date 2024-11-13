
public class Key extends Item {
	private Room targetRoom;
	public Key(String name, String description, Room targetRoom) {
        super(name, description);
        this.targetRoom = targetRoom;
    }

  
    public void use() {
        if (targetRoom.isLocked()) {
            targetRoom.setLocked(false);
            Game.print("You unlocked the " + targetRoom.getName() + ".");
        } else {
            Game.print("The " + targetRoom.getName() + " is already unlocked.");
        }
    }
}
