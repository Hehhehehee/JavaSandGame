package main.tiles.elements;

import main.graphics.GameMap;
import main.tiles.Tile;

public class solids {
    public solids(GameMap gameMap) {
        Tile metal = new Tile(0x999999,"metal"){
            public void update(Tile[][] map, int x, int y) {
                if (timeSparked > 0) {
                    c = 0x333300 + (0x444400 * timeSparked);
                    for (int i = 1; i > -2; i--) {
                        for (int j = 1; j > -2; j--) {
                            if (map[i + x][j + y]!=null&&(i!=0||j!=0)) {
                                if (map[i + x][j + y].timeSparked == 0 && !map[i + x][j + y].alreadysparked && map[i + x][j + y].conducts) {
                                    map[i + x][j + y].timeSparked = 4;
                                    map[i + x][j+y].alreadysparked = true;
                                }
                            }
                        }
                    }
                    timeSparked--;
                } else {
                    c = 0x999999;
                }
                alreadysparked = false;
            }
        };
        Tile battery = new Tile(0x229911,"battery"){
            public void update(Tile[][] map, int x, int y) {
                for (int i = 1; i > -2; i--) {
                    for (int j = 1; j > -2; j--) {
                        if ((i!=0||j!=0)&&map[i + x][j + y]!=null) {
                            if (!map[i + x][j + y].alreadysparked && map[i + x][j + y].conducts && map[i+x][j+y].timeSparked == 0) {
                                map[i + x][j + y].timeSparked = 4;
                                map[i + x][j + y].alreadysparked = true;
                            }
                        }
                    }
                }
            }
        };
        metal.conducts = true;
        gameMap.addElement(metal);
        gameMap.addElement(battery);
        gameMap.addElement(new Tile(0x999999, "Tile"));
    }
}
