import java.util.ArrayList;

public class Macchinetta {
    ArrayList<Prodotto> prodotti;

    public Macchinetta() {
        this.prodotti = new ArrayList<>();
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    public Merendina compraMerendina(int soldi, int calorie) {
        for (Prodotto prodotto : this.prodotti) {
            if (prodotto instanceof Merendina merendina) {
                if (merendina.costo <= soldi && merendina.calorie <= calorie) {
                    this.prodotti.remove(merendina);
                    return merendina;
                }
            }

        }
        return null;
    }

    public Bevanda compraBevanda(int soldi, int volume) {
        for (Prodotto prodotto : this.prodotti) {
            if (prodotto instanceof Bevanda bevanda) {
                if (bevanda.costo <= soldi && bevanda.volume >= volume) {
                    this.prodotti.remove(bevanda);
                    return bevanda;
                }
            }

        }
        return null;
    }
}
