public class Safe extends Item {

    public Safe(String name, String description) {
        super(name, description);
    }

   
    public void open() {
        Item combination = Game.getInventoryItem("Combination");
        if (combination != null) {
            System.out.println("Using the combination, you open the safe and find a diamond inside!");
            Item diamond = new Item("Diamond", "A beautiful, sparkling diamond.");
            Game.inventory.add(diamond);
        } else {
            System.out.println("The safe is locked, and you don't have the combination.");
        }
    }
}
