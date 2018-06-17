
public class Carte {

    private Case[][] ensembleCase = new Case[16][12];
    private int nbMassifMaximum = 4;
    private int nbRiviereMaximum = 2;

    public Carte() {
        Generation();
    }

    public void Generation() {

        //Ocean
        for (int i = 0; i < 12; i++) {
            ensembleCase[15][i] = new Terrain("Ocean");
            generationOcean(0.4, 14, i);
        }

        //Montagne
        int nbMassif = (int) (Math.random() * nbMassifMaximum) + 1;

        for (int i = 0; i < nbMassif; i++) {
            boolean choisi = false;

            while (!choisi) {
                int x = (int) (Math.random() * 16);
                int y = (int) (Math.random() * 12);

                if (ensembleCase[x][y] == null) {
                    choisi = true;
                    generationMontagne(0.5, x, y);
                }
            }
        }

        //Rivière

        int nbRiviere = (int) (Math.random() * nbRiviereMaximum) + 1;

        for (int i = 0; i < nbRiviere; i++) {
            boolean choisi = false;
            int j = 0;

            while (!choisi) {
                int y = (int) (Math.random() * 12);

                if (ensembleCase[0][y] == null) {
                    choisi = true;
                    generationRivière(0, y);
                }

                if (j == 12)
                    break;

                j++;
            }
        }

        //Rempli le reste avec de la plaine
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 12; j++) {
                if (ensembleCase[i][j] == null)
                    ensembleCase[i][j] = new Terrain("Plaine");
            }
        }

    }

    public void generationOcean(double proba, int x, int y) {

        double perte = 0.04;
        ensembleCase[x][y] = new Terrain("Ocean");

        if (proba > 0) {
            if (y + 1 < 12 && ensembleCase[x][y + 1] == null && Math.random() < proba)
                generationOcean(proba - perte, x, y + 1);

            if (x + 1 < 16 && ensembleCase[x + 1][y] == null && Math.random() < proba)
                generationOcean(proba - perte, x + 1, y);

            if (y - 1 > 0 && ensembleCase[x][y - 1] == null && Math.random() < proba)
                generationOcean(proba - perte, x, y - 1);

            if (x - 1 > 0 && ensembleCase[x - 1][y] == null && Math.random() < proba)
                generationOcean(proba - perte, x - 1, y);

        }

    }

    public void generationMontagne(double proba, int x, int y) {

        double perte = 0.25;
        ensembleCase[x][y] = new Terrain("Montagne");

        if (proba > 0) {
            if (y + 1 < 12 && ensembleCase[x][y + 1] == null && Math.random() < proba)
                generationMontagne(proba - perte, x, y + 1);

            if (x + 1 < 16 && ensembleCase[x + 1][y] == null && Math.random() < proba)
                generationMontagne(proba - perte, x + 1, y);

            if (y - 1 > 0 && ensembleCase[x][y - 1] == null && Math.random() < proba)
                generationMontagne(proba - perte, x, y - 1);

            if (x - 1 > 0 && ensembleCase[x - 1][y] == null && Math.random() < proba)
                generationMontagne(proba - perte, x - 1, y);

        }
    }

    public void generationRivière(int x, int y) {

        //Entre 0 et 1
        double droitesse = 0.7;
        double r = (1 - droitesse)/2;
        Case c = ensembleCase[x][y];

        if ((c instanceof Terrain && ((Terrain)c).getType() != "Ocean") || c == null ) {
            ensembleCase[x][y] = new Terrain("Rivière");
            double direction = Math.random();

            if (x + 1 < 16 && direction <= droitesse) {
                generationRivière(x+1,y);
            }

            if(y + 1 < 12 && direction > droitesse && direction <= droitesse + r){
                generationRivière(x,y+1);
            }

            if(y - 1 >= 0 && direction > droitesse + r && direction <= droitesse + 2*r){
                generationRivière(x,y-1);
            }
        }
    }

    public Case[][] getEnsembleCase() {
        return ensembleCase;
    }

    public String toString() {
        return ensembleCase.toString();
    }
}
