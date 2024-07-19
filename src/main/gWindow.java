package main;

import main.graphics.GUI;
import main.graphics.GameMap;
import main.tiles.controller.gameController;

public class gWindow extends GUI implements Runnable {
    private static final int BLOCK_SIZE = 4;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int MAP_WIDTH = WIDTH / BLOCK_SIZE;
    private static final int MAP_HEIGHT = HEIGHT / BLOCK_SIZE;
    private final Thread thread;
    private boolean running;

    public gWindow(Main main) {
        super(new GameMap(MAP_WIDTH, MAP_HEIGHT, main), new gameController(), main);
        thread = new Thread(this);
        start();
    }

    public void run() {
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        requestFocus();
        running = true;
        while (running) {
            long now = System.nanoTime();
            delta = delta + ((now - lastTime) / ns);
            lastTime = now;
            while (delta >= 1) {
                try {
                    getGameController().update();
                } catch (Exception ignored) {}
                (getGameMap()).update();
                delta--;
            }
            try {
                render();
                Thread.sleep(2);
            } catch (InterruptedException ignored) {}
        }
    }

    public synchronized void start() {
        thread.start();
        running = true;
    }
}