package api.elements;
import main.graphics.GameMap;

public class loader {
    public loader(GameMap gm) {
        new powders(gm);
        new liquids(gm);
        new solids(gm);
    }
}
