package api.elements.recipes;

import main.recipes.recipe;
import main.tiles.controller.gameController;

public class solids {
    public solids(gameController gc) {
        gc.addRecipe(new recipe("Stone", "Stone", "Stone"));
        gc.addRecipe(new recipe("Dirt", "Dirt", "Dirt"));
        gc.addRecipe(new recipe("Stone", "Fire", "Coal"));
        gc.addRecipe(new recipe("Ice", "", "Ice"));
        gc.addRecipe(new recipe("Dirt", "Water", "Grass"));
        gc.addRecipe(new recipe("Coal", "Fire", "Ash"));
    }
}
