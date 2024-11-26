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
        getResponse(options);
    }

    private void getResponse(String[] options) {
		// TODO Auto-generated method stub
		
	}

	private void say(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
    public void response(int option) {
        switch (option) {
            case 1 -> say("Leave now and never return!");
            case 2 -> say("Find the scroll and you shall have my wisdom.");
            default -> Game.print("The ghost stares at you in silence, unimpressed by your incoherence.");
        }
    }
}
