package api.elements.recipes;

import main.tiles.controller.gameController;

public class recipesloader {
    public recipesloader(gameController gm) {
        new powders(gm);
        new liquids(gm);
        new solids(gm);
    }
}
