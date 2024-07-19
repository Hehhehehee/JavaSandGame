package main.tiles.elements;

import main.graphics.GameMap;
import main.tiles.bases.Liquid;

import java.util.Random;

import static java.lang.Math.floor;

public class liquids {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    public String generateRandomWord(int n) {
        String out = "";

        while (n >= 0) {
            out = out.concat(CHARACTERS.split("")[n%62]);
            n = (int) ((double) (n / 62) -1);
        }
        return out;
    }
    public liquids(GameMap gameMap) {
        for (int i = 0; i < 256*256; i+=256) {
            gameMap.addElement(new Liquid(i,generateRandomWord(i/256)));
        }
    }
}
