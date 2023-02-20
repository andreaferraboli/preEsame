public abstract class Prodotto implements Comparable<Prodotto> {
    int costo;
    String nome;

    public Prodotto(int costo, String nome) {
        this.costo = costo;
        this.nome = nome;
    }

    public int getCosto() {
        return costo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Prodotto other) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.nome, other.nome);
    }
}
