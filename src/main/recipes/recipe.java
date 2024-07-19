package main.recipes;


import main.gWindow;
import main.graphics.GameMap;
import main.tiles.Tile;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class recipe {
    public String subs1;
    public String subs2;
    public String prod;

    public recipe(String subs1, String subs2, String prod) {
        System.out.println("Creating recipe with subs1=" + subs1 + ", subs2=" + subs2 + ", prod=" + prod);
        this.subs1 = subs1;
        this.subs2 = subs2;
        this.prod = prod;
    }

    public void checkfor(Tile[][] map, GameMap gamemap) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != null) {
                    if (Objects.equals(map[i][j].id, subs1)) {
                        for (int k = -1; k <= 1; k++) {
                            for (int l = -1; l <= 1; l++) {
                                if (k != 0 || l != 0) {
                                    int x = i + k;
                                    int y = j + l;
                                    if (x >= 0 && x < map.length && y >= 0 && y < map[i].length) {
                                        Tile neighbor = map[x][y];
                                        if (neighbor != null && Objects.equals(neighbor.id, subs2)) {
                                            map[x][y] = null;
                                            map[i][j] = null;
                                            gamemap.createTile(x,y,prod);
                                        }
                                    }
                                }
                            }
                        }
                    }else if (Objects.equals(map[i][j].id, subs2)) {
                        for (int k = -1; k <= 1; k++) {
                            for (int l = -1; l <= 1; l++) {
                                if (k != 0 || l != 0) {
                                    int x = i + k;
                                    int y = j + l;
                                    if (x >= 0 && x < map.length && y >= 0 && y < map[i].length) {
                                        Tile neighbor = map[x][y];
                                        if (neighbor != null && Objects.equals(neighbor.id, subs1)) {
                                            map[x][y] = null;
                                            map[i][j] = null;
                                            gamemap.createTile(x,y,prod);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

