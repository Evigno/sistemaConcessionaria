public class Combustao extends Veiculo {
    private double autonomiaComb;
    private double capacidadeComb;
    private double autonomiaBat;
    private double capacidadeBat;

    public Combustao(String marca, String modelo, int anoFab, int mesFab, int anoMod, double valor, double autonComb, double capComb, double autonBat, double capBat) {
        super(marca, modelo, anoFab, mesFab, anoMod, valor);
        this.autonomiaComb = autonComb;
        this.capacidadeComb = capComb;
        this.autonomiaBat = autonBat;
        this.capacidadeBat = capBat;
    }

    public int getAutonomia() {
        return autonomiaComb;
    }

    public String toString() {
        // Alguma coisa...
    }
}