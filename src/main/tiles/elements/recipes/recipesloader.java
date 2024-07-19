package main.tiles.elements.recipes;

import main.tiles.controller.gameController;
import main.tiles.elements.recipes.liquids;
import main.tiles.elements.recipes.powders;
import main.tiles.elements.recipes.solids;

public class recipesloader {
    public recipesloader(gameController gm) {
        new powders(gm);
        new liquids(gm);
        new solids(gm);
    }
}
