public class Mine extends Terrain{
    Ressource minerai;

    public Mine(int posX, int posY, String type, Ressource res){
        super(posX,posY,type);
        minerai = res;
    }

    public String toString(){
        return super.toString() + " minerai: " + minerai;
    }
}
