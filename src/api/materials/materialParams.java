package api.materials;

public class materialParams {
    //FIXME the following piece of code, can be defined as completely terrible, and requires a total rewrite to be possibly accepted into society, considering its generally horrible methods
    public int meltingPoint;
    public int boilingPoint;
    public int GLS;
    public int solidOrPowder;
    public int color;
    public int gasColorChange;
    public int liquidColorChange;
    public int solidColorChange;
    public materialParams setMeltingPoint(int s) {meltingPoint=s;return this;}
    public materialParams setBoilingPoint(int s) {boilingPoint=s;return this;}
    public materialParams setGLS(int s) {GLS=s;return this;}
    public materialParams setSolidOrPowder(int s) {solidOrPowder=s;return this;}
    public materialParams setColor(int s) {color=s;return this;}
    public materialParams setGasColorChange(int s) {gasColorChange=s;return this;}
    public materialParams setLiquidColorChange(int s) {liquidColorChange=s;return this;}
    public materialParams setSolidColorChange(int s) {solidColorChange=s;return this;}
}
