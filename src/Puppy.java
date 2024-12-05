public class Puppy extends NPC {
    private int dialogCount = 0;

    public Puppy() {
        super("puppy", "A hideous puppy wags his tail.");
    }

    @Override
    public void talk() {
        switch (dialogCount) {
            case 0 -> {
                Game.print("Hi! I'm an adorable puppy!");
                String[] options = {
                    "Yes you are! Who's a good boy?",
                    "Ew, no. You're actually kinda hideous."
                };
                int choice = Game.scanOption(options);
                response(choice);
                dialogCount++;
            }
            case 1 -> {
                Game.print("Hey! Wanna play fetch?");
                String[] options = {
                    "Yes! I love fetch!",
                    "No. I am a horrible person and don't like playing with puppies."
                };
                int choice = Game.scanOption(options);
                response(choice);
                dialogCount++;
            }
            default -> Game.print("Yip! *wags tail*");
        }
    }

    public void response(int option) {
        switch (dialogCount - 1) {
            case 0 -> {
                if (option == 1) {
                    Game.print("I am! I'm a good boy!");
                } else if (option == 2) {
                    Game.print("I am adorable! Why are you so mean?");
                    Game.print("The puppy bites you. You deserve it.");
                }
            }
            case 1 -> {
                if (option == 1) {
                    Game.print("Yay! Fetch!");
                    Item ball = new Item("Ball", "A ball brought back by the puppy.");
                    Game.inventory.add(ball);
                } else if (option == 2) {
                    Game.print("You're a bad person! I don't like you!");
                }
            }
        }
    }
}
