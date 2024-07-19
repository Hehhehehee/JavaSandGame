package main.tiles.controller;

import main.Main;
import main.graphics.GameMap;
import main.recipes.recipe;

import java.util.ArrayList;

public class gameController {
    public GameMap gameMap;
    private final ArrayList<recipe> recipes = new ArrayList<>();
    public Main main;
    public void addRecipe(recipe recipe) {
        recipes.add(recipe);
    }
    public gameController() {
    }

    public void update() {
        // update the game state
        for (recipe recipe : recipes) {
            recipe.checkfor(gameMap.getMap(), gameMap);
        }
    }
}