package main;

import main.tiles.Tile;

import java.awt.*;

public class Main {
    public Choice c;
    public Frame f;
    public Tile currentTile = null;
    public Main() {
        gWindow gw = new gWindow(this);
        f = new Frame();
        c = new Choice();
        c.setBounds(5, 5, 190, 190);
        for (int i = 0; i < gw.getGameMap().elements.toArray().length; i++) {
            if (gw.getGameMap().elements.get(i).loud) c.addItem(gw.getGameMap().elements.get(i).id);
        }
        f.add(c);
        f.setSize(200, 600);
        f.setLayout(null);
        f.setUndecorated(true);
        f.setLocation(gw.getX()+600,gw.getY());
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}