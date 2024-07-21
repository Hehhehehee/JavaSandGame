package api.materials;

import main.graphics.GameMap;
import main.tiles.Tile;
import main.tiles.bases.*;

public class MaterialService {
    public GameMap gameMap;
    public MaterialService(GameMap gameMap) {this.gameMap = gameMap;}
    public void createMaterial(String name, materialParams mp) {
        if ((mp.GLS >> 2 & 1)==1) {
            Tile gas = new Gas(mp.color + mp.gasColorChange, "gaseous " + name) {
                @Override
                public void tempCheck(int x, int y, GameMap gameMap) {
                    if (temp < mp.boilingPoint && temp > mp.meltingPoint) {
                        if ((mp.GLS >> 1 & 1)==1) {
                            gameMap.createTile(x, y, "liquid " + name);
                        }
                    } else if (temp < mp.boilingPoint && temp < mp.meltingPoint) {
                        if ((mp.GLS & 1)==1) {
                            gameMap.createTile(x, y, "solid " + name);
                        }
                    }
                }
            };
            gas.temp = mp.boilingPoint;
            gameMap.addElement(gas);
        }if ((mp.GLS >> 1 & 1)==1) {
            Tile liquid = new Liquid(mp.color + mp.liquidColorChange, "liquid " + name) {
                @Override
                public void tempCheck(int x, int y, GameMap gameMap) {
                    if (temp > mp.boilingPoint && temp > mp.meltingPoint) {
                        if ((mp.GLS >> 2 & 1) == 1) {
                            gameMap.createTile(x, y, "gaseous " + name);
                        }
                    } else if (temp < mp.boilingPoint && temp < mp.meltingPoint) {
                        if ((mp.GLS & 1) == 1) {
                            gameMap.createTile(x, y, "solid " + name);
                        }
                    }
                }
            };
            liquid.temp = mp.meltingPoint;
            gameMap.addElement(liquid);
        }if ((mp.GLS & 1)==1) {
            if (mp.solidOrPowder == 0) {
                Tile solid = new Tile(mp.color + mp.solidColorChange, "solid " + name) {
                    @Override
                    public void tempCheck(int x, int y, GameMap gameMap) {
                        if (temp > mp.boilingPoint && temp > mp.meltingPoint) {
                            if ((mp.GLS >> 1 & 1) == 1) {
                                gameMap.createTile(x, y, "gaseous " + name);
                            }
                        } else if (temp < mp.boilingPoint && temp > mp.meltingPoint) {
                            if ((mp.GLS >> 1 & 1) == 1) {
                                gameMap.createTile(x, y, "liquid " + name);
                            }
                        }
                    }
                };
                gameMap.addElement(solid);
            } else if (mp.solidOrPowder == 1) {
                Tile solid = new Powder(mp.color + mp.solidColorChange, "solid " + name) {
                    @Override
                    public void tempCheck(int x, int y, GameMap gameMap) {
                        if (temp > mp.boilingPoint && temp > mp.meltingPoint) {
                            if ((mp.GLS >> 1 & 1) == 1) {
                                gameMap.createTile(x, y, "gaseous " + name);
                            }
                        } else if (temp < mp.boilingPoint && temp > mp.meltingPoint) {
                            if ((mp.GLS >> 1 & 1) == 1) {
                                gameMap.createTile(x, y, "liquid " + name);
                            }
                        }
                    }
                };
                gameMap.addElement(solid);
            }
        }
    }
}
