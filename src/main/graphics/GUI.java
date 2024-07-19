package main.graphics;

import main.Main;
import main.tiles.controller.gameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

public class GUI extends JFrame {
    private final GameMap gMap;
    private final gameController gController;
    private final Main main;
    public GUI(GameMap gameMap, gameController gameController,Main m) {
        this.main = m;
        this.gMap = gameMap;
        this.gController = gameController;
        this.gController.gameMap = gMap;
        setSize(600, 600);
        setUndecorated(true);
        setResizable(false);
        setTitle("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.black);
        setLocationRelativeTo(null);
        setVisible(true);
        createBufferStrategy(3);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {
                /*Point mouse = MouseInfo.getPointerInfo().getLocation();
                main.currentTile = gameMap.getMap()[(int) ((mouse.getX()-getLocation().getX())/4)][(int) ((mouse.getY()-getLocation().getY())/4)];
                gameMap.getMap()[(int) ((mouse.getX()-getLocation().getX())/4)][(int) ((mouse.getY()-getLocation().getY())/4)]=null;*/
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                /*Point mouse = MouseInfo.getPointerInfo().getLocation();
                gameMap.getMap()[(int) ((mouse.getX()-getLocation().getX())/4)][(int) ((mouse.getY()-getLocation().getY())/4)]=main.currentTile;*/
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Point mouse = MouseInfo.getPointerInfo().getLocation();
                gameMap.createTile((int) ((mouse.getX()-getLocation().getX())/4),(int) ((mouse.getY()-getLocation().getY())/4),main.c.getSelectedItem());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
    public gameController getGameController() {
        return this.gController;
    }
    public GameMap getGameMap() {
        return this.gMap;
    }
    public void render() {
        BufferStrategy bs = getBufferStrategy();
        Graphics g = bs.getDrawGraphics();
        gMap.render(g);
        Point point = MouseInfo.getPointerInfo().getLocation();
        point.setLocation(point.getX() - getLocation().getX(), point.getY() - getLocation().getY());
        int x = (int) (point.getX() / 4);
        int y = (int) (point.getY() / 4);
        Font font = new Font("Consolas", Font.BOLD, 12);
        g.setFont(font);
        g.setColor(Color.WHITE);
        if (x < 150 && x > 0 && y < 150 && y > 0) {
            if (gMap.getMap()[x][y] != null) {
                g.drawString(gMap.getMap()[x][y].id+","+gMap.getMap()[x][y].temp+","+gMap.getMap()[x][y].timeSparked+","+gMap.getMap()[x][y].conducts, (int) point.getX(), (int) point.getY());
            } else {
                g.drawString("nothing", (int) point.getX(), (int) point.getY());
            }
        }
        g.dispose();
        bs.show();
    }
}