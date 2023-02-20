public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        Macchinetta macchinetta = new Macchinetta();
        Solver solver = new Solver(macchinetta);
//        solver.leggiRiga();
        solver.leggiRigaDaFile(args[0]);
    }
}