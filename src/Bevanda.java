public class Bevanda extends Prodotto {
    int volume;

    public Bevanda(int costo, String nome, int volume) {
        super(costo, nome);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Bevanda{" +
                "volume=" + volume +
                ", costo=" + costo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
