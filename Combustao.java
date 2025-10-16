public class Combustao extends Veiculo {
    private double autonomiaComb;
    private double capacidadeComb;

    public Combustao(String marca, String modelo, int anoFab, int mesFab, int anoMod, double valor, double autonComb, double capComb) {
        super(marca, modelo, anoFab, mesFab, anoMod, valor);
        this.autonomiaComb = autonComb;
        this.capacidadeComb = capComb;
    }

    public int getAutonomia() { // !!!!!!!!!! Por que ele quer int, sendo que a variável é double???
        return autonomiaComb;
    }

    public String toString() {
        // Alguma coisinha...
    }
}
