package oop;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*It combines multiple aspects of game state (inventory, health, location, area unlocks) 
		 * into a single manager, which is more comprehensive than typical examples.*/
GameStateManager game = GameStateManager.getInstance();
        
        // Simulate game progress
        game.addToInventory("Sword", 1);
        game.addToInventory("Health Potion", 3);
        game.setLocation("Dark Forest");
        game.changeHealth(-20);
        game.unlockArea(1);
        
        System.out.println(game.getGameStatus());
        
        // Simulate actions in another part of the game
        /*The example shows how actions in one part of the game (like using a health potion)
         * affect the state that's visible in other parts.*/
        GameStateManager sameGame = GameStateManager.getInstance();
        sameGame.removeFromInventory("Health Potion", 1);
        sameGame.changeHealth(10);
        sameGame.setLocation("Ancient Ruins");
        sameGame.unlockArea(2);
        
        System.out.println(sameGame.getGameStatus());

	}

}
