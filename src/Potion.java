public class Potion extends Item {
    public Potion(String name, String description) {
        super(name, description);
    }

    
    public void use() {
        Item shield = new Item("Shield", "A protective shield that guards against danger.");
        Game.inventory.add(shield);
        Game.print("You drink the potion, and a shield materializes in your hands!");
    }
}

