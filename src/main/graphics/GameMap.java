package main.graphics;

import api.materials.MaterialService;
import main.Main;
import main.tiles.Tile;
import api.elements.loader;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class GameMap {
    private Tile[][] map;
    public Main m;
    public MaterialService ms = new MaterialService(this);
    public final ArrayList<Tile> elements = new ArrayList<>();

    private int MAP_WIDTH;
    private int MAP_HEIGHT;
    private static final int BLOCK_SIZE = 4;

    public void addElement(Tile element) {
        elements.add(element);
    }

    public GameMap(int width, int height, Main main) {
        m = main;
        new loader(this);
        MAP_WIDTH = width;
        MAP_HEIGHT = height;
        map = new Tile[MAP_WIDTH][MAP_HEIGHT];
    }
    public void castLight(int startX, int startY, Graphics g, int raySpacing, int lightRadius, int color) {
        for (int i = 0; i < 360; i += raySpacing) {
            float angle = (float) Math.toRadians(i);
            int endX = (int) (startX + Math.cos(angle) * lightRadius);
            int endY = (int) (startY + Math.sin(angle) * lightRadius);

            int dx = endX - startX;
            int dy = endY - startY;

            int distance = (int) Math.sqrt(dx * dx + dy * dy);
            for (int j = 0; j <= distance; j++) {
                float fraction = (float) j / distance;
                int x = startX + (int) (dx * fraction);
                int y = startY + (int) (dy * fraction);

                if (x < 0 || x >= MAP_WIDTH || y < 0 || y >= MAP_HEIGHT) {
                    break;
                }

                if (map[x][y] != null) {
                    break;
                }
                g.setColor(new Color(color,true));
                g.fillRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
            }
        }
    }
    public void render(Graphics g) {
        g.clearRect(0, 0, MAP_WIDTH * BLOCK_SIZE, MAP_HEIGHT * BLOCK_SIZE);
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                if (map[x][y] != null) {
                    int color = map[x][y].c;
                    g.setColor(new Color(color));
                    g.fillRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }

    }

    public void update() {
        for (int i = 0; i < MAP_WIDTH; i++) {
            createTile(i,0,"Tile");
        }
        for (int i = 0; i < MAP_WIDTH; i++) {
            createTile(i,MAP_WIDTH-1,"Tile");
        }
        for (int i = 0; i < MAP_HEIGHT; i++) {
            createTile(0,i,"Tile");
        }
        for (int i = 0; i < MAP_HEIGHT; i++) {
            createTile(MAP_HEIGHT-1,i,"Tile");
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != null) {
                    if (!map[i][j].alreadyupdated) {
                        map[i][j].alreadyupdated = true;
                        map[i][j].temp += (273F - map[i][j].temp) * 0.001f;
                        for (int dx = -1; dx <= 1; dx++) {
                            for (int dy = -1; dy <= 1; dy++) {
                                int nx = i + dx;
                                int ny = j + dy;
                                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                                    Tile neighbor = map[nx][ny];
                                    if (neighbor != null) {
                                        float tempDiff = 0;
                                        if (map[i][j] != null) {
                                            tempDiff = map[i][j].temp - neighbor.temp;
                                        }
                                        if (tempDiff > 0) {
                                            neighbor.temp += tempDiff * 0.1f; // adjust temperature spread rate
                                        }
                                    }
                                }
                            }
                        }
                        if (map[i][j] != null) {
                            map[i][j].tempCheck(i, j, this);
                        }
                        map[i][j].update(map, i, j);
                    }
                }
            }
        }
        for (Tile[] Tiles : map) {
            for (Tile tile : Tiles) {
                if (tile != null) {
                    tile.alreadyupdated = false;
                    tile.alreadymoved = false;
                }
            }
        }
    }
    public void createTile(int x, int y, String name) {
        for (Tile element : elements) {
            if (Objects.equals(element.id, name)) {
                Tile clonedTile = element.clone();
                map[x][y] = clonedTile;
            }
        }
    }
    public Tile[][] getMap() {
        return map;
    }
}
