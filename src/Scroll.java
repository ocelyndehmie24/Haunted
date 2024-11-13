public class Scroll extends Item {
    public Scroll(String name, String description) {
        super(name, description);
    }

    
    public void use() {
        Game.print("The scroll reveals a hidden message: 'Seek the key where the skulls lie.'");
    }
}