package oop;

import java.util.HashMap;
import java.util.Map;

/* In a text-based adventure game, we need a single, \
 * consistent game state that can be accessed and modified from different parts of the game logic.
 */

public class GameStateManager {
    private static GameStateManager instance;
    private Map<String, Integer> playerInventory;
    private String currentLocation;
    private int playerHealth;
    private boolean[] unlockedAreas;

    private GameStateManager() {
        playerInventory = new HashMap<>();
        currentLocation = "Starting Room";
        playerHealth = 100;
        unlockedAreas = new boolean[5]; // Assume 5 areas in the game
        unlockedAreas[0] = true; // Starting area is unlocked
    }

    public static GameStateManager getInstance() {
        if (instance == null) {
            instance = new GameStateManager();
        }
        return instance;
    }

    public void addToInventory(String item, int quantity) {
        playerInventory.put(item, playerInventory.getOrDefault(item, 0) + quantity);
    }

    public void removeFromInventory(String item, int quantity) {
        int currentQuantity = playerInventory.getOrDefault(item, 0);
        if (currentQuantity <= quantity) {
            playerInventory.remove(item);
        } else {
            playerInventory.put(item, currentQuantity - quantity);
        }
    }

    public void setLocation(String location) {
        currentLocation = location;
    }

    public void changeHealth(int change) {
        playerHealth += change;
        if (playerHealth < 0) playerHealth = 0;
        if (playerHealth > 100) playerHealth = 100;
    }

    public void unlockArea(int areaIndex) {
        if (areaIndex >= 0 && areaIndex < unlockedAreas.length) {
            unlockedAreas[areaIndex] = true;
        }
    }

    public String getGameStatus() {
        StringBuilder status = new StringBuilder();
        status.append("Current Location: ").append(currentLocation).append("\n");
        status.append("Health: ").append(playerHealth).append("\n");
        status.append("Inventory: ").append(playerInventory).append("\n");
        status.append("Unlocked Areas: ");
        for (int i = 0; i < unlockedAreas.length; i++) {
            if (unlockedAreas[i]) status.append(i).append(" ");
        }
        return status.toString();
    }
}
