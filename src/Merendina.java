public class Merendina extends Prodotto {
    int calorie;

    public Merendina(int costo, String nome, int calorie) {
        super(costo, nome);
        this.calorie = calorie;
    }

    @Override
    public String toString() {
        return "Merendina{" +
                "calorie=" + calorie +
                ", costo=" + costo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
