public class Terrain extends Case {
    private String type;

    public Terrain(int posX, int posY, String type){
        super.posX = posX;
        super.posY = posY;
        this.type = type;

        changementEtatChemin(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        changementEtatChemin(type);
    }

    public void changementEtatChemin(String type){
        switch(type){
            case "Plaine" : super.etatChemin = 3;
                break;
            case "Foret" : super.etatChemin = 2;
                break;
            case "Route" : super.etatChemin = 4;
                break;
            case "Montagne" : super.etatChemin = 1;
                break;
            case "Riviere" : super.etatChemin = 0;
                break;
            case "Ocean" : super.etatChemin = 0;
                break;
            case "Pont" : super.etatChemin = 4;
                break;
            default: super.etatChemin = 0;
                break;
        }
    }

    public String toString(){
        return "X: " + super.posX + " Y: " + super.posY + " type: " + type + " etat chemin: " + super.etatChemin;
    }
}
