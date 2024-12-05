 public class Ghost extends NPC {
    public Ghost() {
        super("ghost", "A ghostly figure floats nearby.");
    }

    
    public void talk() {
        say("Who dares disturb my rest?");
        String[] options = {
            "I'm sorry! I'll leave now.",
            "I seek your wisdom."
        };
        int choice = getResponse(options);
        response(choice);
    }

    private void say(String message) {
        System.out.println("Ghost: " + message);
    }

    private int getResponse(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        while (true) {
            System.out.print("Choose an option: ");
            String input = Game.scan.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice > 0 && choice <= options.length) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please choose a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    
    public void response(int option) {
        if (option == 1) {
            say("Leave now and never return!");
        } else if (option == 2) {
            say("Find the scroll and you shall have my wisdom.");
        } else {
            say("I do not understand your choice.");
        }
    }
}

