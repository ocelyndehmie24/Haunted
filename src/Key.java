
public class Key extends Item {
    private final Room targetRoom;

    public Key(String name, String description, Room targetRoom) {
        super(name, description);
        if (targetRoom == null) {
            throw new IllegalArgumentException("Target room cannot be null.");
        }
        this.targetRoom = targetRoom;
    }

    public void use() {
        boolean isAdjacent = false;

        for (char direction : new char[]{'n', 's', 'e', 'w', 'u', 'd'}) {
            if (Game.currentRoom.getExit(direction) == targetRoom) {
                isAdjacent = true;
                break;
            }
        }

        if (isAdjacent) {
            if (targetRoom.isLocked()) {
                targetRoom.setLocked(false);
                System.out.println("You unlocked the " + targetRoom.getName() + ".");
            } else {
                System.out.println("The " + targetRoom.getName() + " is already unlocked.");
            }
        } else {
            System.out.println("You must be in a room adjacent to the " + targetRoom.getName() + " to use the key.");
        }
    }
}
