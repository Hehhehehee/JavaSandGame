package main.tiles.elements;

import main.graphics.GameMap;
import main.tiles.bases.*;

public class powders {
    public powders(GameMap gameMap) {
        gameMap.addElement(new Powder(0x808080, "Ash"));
        gameMap.addElement(new Powder(0xC6C6C6, "Salt"));
        gameMap.addElement(new Powder(0xFFFF00, "sand"));
        gameMap.addElement(new Powder(0x008000, "Grass"));
    }
}
