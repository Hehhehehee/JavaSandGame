package main.tiles.bases;

import main.tiles.Tile;

import java.util.Random;

public class Gas extends Tile {
    public Gas(int c, String id) {
        super(c, id);
    }
    public void update(Tile[][] map, int x, int y) {
        if (y - 1 > map[x].length && map[x][y - 1] == null) {
            map[x][y - 1] = this;
            map[x][y] = null;
        } else {
            Random rand = new Random();
            int randint = rand.nextInt(2);
            if (randint == 1) {
                if (x - 1 >= 0 && y < map[x].length && map[x - 1][y] == null) {
                    map[x - 1][y] = this;
                    map[x][y] = null;
                }
            }
            if (randint == 0) {
                if (x + 1 < map.length && y < map[x].length && map[x + 1][y] == null) {
                    map[x + 1][y] = this;
                    map[x][y] = null;
                }
            }
        }
    }

}