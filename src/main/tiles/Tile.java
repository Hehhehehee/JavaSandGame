package main.tiles;

public class Tile implements Cloneable {
    public int timeSparked;
    public int c;
    public float temp=293;
    public boolean alreadyupdated;
    public boolean alreadymoved;
    public boolean conducts = false;
    public String id;
    public boolean isSparked = false;
    public boolean alreadysparked;

    public Tile(int c, String id) {
        this.c = c;
        this.id = id;
    }

    public void tempCheck(int x, int y, Tile[][] map) {
        map[x][y]=map[x][y];
    }

    public void update(Tile[][] map, int x, int y) {
    }

    @Override
    public Tile clone() {
        Tile clone;
        try {
            clone = (Tile) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        // Perform deep copy of fields
        clone.timeSparked = this.timeSparked;
        clone.c = this.c;
        clone.temp = this.temp;
        clone.alreadyupdated = this.alreadyupdated;
        clone.alreadymoved = this.alreadymoved;
        clone.conducts = this.conducts;
        clone.id = this.id; // Assuming id is immutable, if not, create a new instance
        clone.isSparked = this.isSparked;

        return clone;
    }
}
