public class NPC {
    private String name;
    private String description;

    public NPC(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void talk() {
        Game.print(name + ": " + description);
        talk();
    }
}
