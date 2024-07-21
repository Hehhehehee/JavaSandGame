package api.elements;

import api.materials.materialParams;
import main.graphics.GameMap;
import main.tiles.bases.*;

public class powders {
    public powders(GameMap gameMap) {
        gameMap.addElement(new Powder(0x808080, "Ash"));
        gameMap.addElement(new Powder(0xC6C6C6, "Salt"));
        gameMap.addElement(new Powder(0xFFFF00, "sand"));
        gameMap.addElement(new Powder(0x008000, "Grass"));
        gameMap.ms.createMaterial("iron", new materialParams().setColor(0x999999).setBoilingPoint(8000).setMeltingPoint(2000).setGLS(0b111).setSolidOrPowder(0).setLiquidColorChange(0x666600).setGasColorChange(0).setSolidColorChange(0));
    }
}
