import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solver {

    Macchinetta macchinetta;
    int soldi;

    public Solver(Macchinetta macchinetta) {
        this.macchinetta = macchinetta;
        this.soldi = 0;
    }

    public void leggiRiga() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String path = "in1.txt";
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            String input;
            do {
                input = scanner.nextLine();
                if (!input.equals("F")) {
                    String[] array = input.split(" ");
                    String nome;
                    int costo, volume, calorie;
                    switch (array[0]) {
                        case "B":
                            nome = array[1];
                            try {
                                costo = Integer.parseInt(array[2]);
                                volume = Integer.parseInt(array[3]);
                                Bevanda bevanda = new Bevanda(costo, nome, volume);
                                this.macchinetta.prodotti.add(bevanda);
                            } catch (NumberFormatException ex) {
                                ex.printStackTrace();
                            }
                            break;

                        case "M":
                            nome = array[1];
                            try {
                                costo = Integer.parseInt(array[2]);
                                calorie = Integer.parseInt(array[3]);
                                Merendina merendina = new Merendina(costo, nome, calorie);
                                this.macchinetta.prodotti.add(merendina);
                            } catch (NumberFormatException ex) {
                                ex.printStackTrace();
                            }
                            break;
                        case "S":
                            int soldi = Integer.parseInt(array[1]);
                            if (soldi < 0)
                                throw new Exception("soldi negativi comando non valido");
                            this.soldi += soldi;

                            break;
                        case "CB":
                            volume = Integer.parseInt(array[1]);
                            Bevanda bevanda = this.macchinetta.compraBevanda(this.soldi, volume);
                            if (bevanda != null) {
                                System.out.println(bevanda);
                                this.soldi -= bevanda.costo;
                                fw.write("Ho bevuto " + bevanda.nome + "\n");
                            }
                            break;
                        case "CM":
                            calorie = Integer.parseInt(array[1]);
                            Merendina merendina = this.macchinetta.compraMerendina(this.soldi, calorie);
                            if (merendina != null) {
                                System.out.println(merendina);
                                this.soldi -= merendina.costo;
                                fw.write("Ho mangiato " + merendina.nome + "\n");

                            }
                            break;
                        default:
                            System.out.println("errore in input");
                            break;
                    }
                }

            } while (!input.equals("F"));
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void leggiRigaDaFile(String arg) {
        File file = new File(arg);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            String input;
            while (scanner.hasNextLine()) {
                input = scanner.nextLine();
                if (!input.equals("F")) {
                    String[] array = input.split(" ");
                    String nome;
                    int costo, volume, calorie;
                    switch (array[0]) {
                        case "B":
                            nome = array[1];
                            try {
                                costo = Integer.parseInt(array[2]);
                                volume = Integer.parseInt(array[3]);
                                Bevanda bevanda = new Bevanda(costo, nome, volume);
                                this.macchinetta.prodotti.add(bevanda);
                            } catch (NumberFormatException ex) {
                                ex.printStackTrace();
                            }
                            break;

                        case "M":
                            nome = array[1];
                            try {
                                costo = Integer.parseInt(array[2]);
                                calorie = Integer.parseInt(array[3]);
                                Merendina merendina = new Merendina(costo, nome, calorie);
                                this.macchinetta.prodotti.add(merendina);
                            } catch (NumberFormatException ex) {
                                ex.printStackTrace();
                            }
                            break;
                        case "S":
                            int soldi = Integer.parseInt(array[1]);
                            if (soldi < 0)
                                try {
                                    throw new Exception("soldi negativi comando non valido");
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            this.soldi += soldi;

                            break;
                        case "CB":
                            volume = Integer.parseInt(array[1]);
                            Bevanda bevanda = this.macchinetta.compraBevanda(this.soldi, volume);
                            if (bevanda != null) {
                                this.soldi -= bevanda.costo;
                                System.out.println("Ho bevuto " + bevanda.nome + "\n");
                            }
                            break;
                        case "CM":
                            calorie = Integer.parseInt(array[1]);
                            Merendina merendina = this.macchinetta.compraMerendina(this.soldi, calorie);
                            if (merendina != null) {
                                this.soldi -= merendina.costo;
                                System.out.println("Ho mangiato " + merendina.nome + "\n");

                            }
                            break;
                        case "SORT":
                            int[] array_int = {2, 1, 4, 5, 3, 6, 7, 9, 8};
                            Arrays.sort(array_int);
                            System.out.println(Arrays.toString(array_int));
//                            this.macchinetta.prodotti.sort(Comparator.comparing(Prodotto::getCosto));
                            this.macchinetta.prodotti.sort(Comparator.comparing(Prodotto::getNome));
//                            Collections.sort(this.macchinetta.prodotti);//ordinare oggetti tramite metodo compareTo
                            Collections.reverse(this.macchinetta.prodotti); //invertire ordine oggetti
                            for (Prodotto prodotto : this.macchinetta.prodotti) {
                                System.out.println(prodotto);
                            }
                            break;
                        default:
                            System.out.println("errore in input");
                            break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
