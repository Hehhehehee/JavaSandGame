package main.tiles.bases;

import main.tiles.Tile;

public class Powder extends Tile {
    public Powder(int c, String id) {
        super(c,id);
    }

    public void update(Tile[][] map, int x, int y) {
        if (y + 1 < map[x].length && map[x][y + 1] == null) {
            map[x][y + 1] = this;
            map[x][y] = null;
        } else if (x - 1 >= 0 && y + 1 < map[x].length && map[x - 1][y + 1] == null) {
            map[x - 1][y + 1] = this;
            map[x][y] = null;
        } else if (x + 1 < map.length && y + 1 < map[x].length && map[x + 1][y + 1] == null) {
            map[x + 1][y + 1] = this;
            map[x][y] = null;
        }
    }
}