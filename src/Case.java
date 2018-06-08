public abstract class Case {
    protected int posX;
    protected int posY;
    protected int etatChemin;

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getEtatChemin() {
        return etatChemin;
    }

    public void setEtatChemin(int etatChemin) {
        this.etatChemin = etatChemin;
    }

    public abstract String toString();
}
