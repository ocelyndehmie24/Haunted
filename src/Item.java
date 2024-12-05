public class Item {
    private final String name;
    private final String description;

    public Item(String name, String description) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be null or empty.");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Item description cannot be null or empty.");
        }
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void open() {
        System.out.println("You can't open that!");
    }

    public void use() {
        System.out.println("This item doesn't seem to do anything special.");
    }

    
    public String toString() {
        return name + ": " + description;
    }
    
}
