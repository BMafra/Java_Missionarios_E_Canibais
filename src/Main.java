import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static Rio rio = new Rio(1);

    public static void main(String[] args) {
        inicio();
    }

    private static void limparListas() {
        Pessoa.ladoDireito.clear();
        Pessoa.ladoEsquerdo.clear();
        Pessoa.barco.clear();
    }

    private static void criacaoPersonagens() {
        Pessoa c1 = new Canibal("C1");
        Pessoa.ladoDireito.add(c1);

        Pessoa c2 = new Canibal("C2");
        Pessoa.ladoDireito.add(c2);

        Pessoa c3 = new Canibal("C3");
        Pessoa.ladoDireito.add(c3);

        Pessoa m1 = new Missionario("M1");
        Pessoa.ladoDireito.add(m1);

        Pessoa m2 = new Missionario("M2");
        Pessoa.ladoDireito.add(m2);

        Pessoa m3 = new Missionario("M3");
        Pessoa.ladoDireito.add(m3);
    }

    private static void inicio() {
        limparListas();
        criacaoPersonagens();

        System.out.print("---- INÍCIO ----" +
                "\n1 - Jogar" +
                "\n2 - Encerrar" +
                "\nR: ");
        int opcaoInicio = sc.nextInt();

        switch (opcaoInicio) {
            case 1:
                menuJogo();
                break;

            case 2:
                System.out.print("\nEncerrando...");
                System.exit(0);

            default:
                System.out.print("\nOpção inválida! Tente novamente:\n");
                inicio();
        }
    }

    private static void menuJogo(){
        System.out.print("MENU" +
                "\n1 - Colocar personagem no barco" +
                "\n2 - Tirar do barco" +
                "\n3 - Atravessar o rio");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                colocarNoBarco();
                break;
            case 2:
                tirarDobarco();
                break;
            case 3:
                System.out.println("Atravessou o rio");
                tirarDobarco();
                break;
        }
    }

    private static void colocarNoBarco(){
        if (Pessoa.barco.size() >= 2){
            System.out.println("Barco lotado!");
            menuJogo();
        } else {
            System.out.println("Quem deseja colocar no barco?");
            if (rio.getLado() == 1) {
                System.out.println("Lado direito\n");
                for (int i = 0; i < Pessoa.ladoDireito.size(); i++) {
                    System.out.print("\n" + (i + 1) + " - " + Pessoa.ladoDireito.get(i).toString());
                }
            } else if (rio.getLado() == 2) {
                System.out.println("Lado Esquerdo\n");
                for (int i = 0; i < Pessoa.ladoEsquerdo.size(); i++) {
                    System.out.print("\n" + (i + 1) + " - " + Pessoa.ladoEsquerdo.get(i).toString());
                }
            }
            int opcao = sc.nextInt();

            for (int i = 0; i < Pessoa.ladoDireito.size(); i++) {
                if (opcao - 1 == i) {
                    Pessoa.barco.add((Pessoa.ladoDireito.get(i)));
                    Pessoa.ladoDireito.remove(i);
                }
            }
        }
        menuJogo();
    }

    private static void tirarDobarco(){
        System.out.println("Quem deseja tirar do barco?\n");
        for (int i = 0; i < Pessoa.barco.size(); i++) {
            System.out.print("\n" + (i + 1) + " - " + Pessoa.barco.get(i).toString());
        }
        int opcao = sc.nextInt();

        if (rio.getLado() == 1) {
            for (int i = 0; i < Pessoa.barco.size(); i++) {
                if (opcao - 1 == i) {
                    Pessoa.ladoDireito.add((Pessoa.barco.get(i)));
                    Pessoa.barco.remove(i);
                }
            }
        } else if (rio.getLado() == 2){
            for (int i = 0; i < Pessoa.barco.size(); i++) {
                if (opcao - 1 == i) {
                    Pessoa.ladoEsquerdo.add((Pessoa.barco.get(i)));
                    Pessoa.barco.remove(i);
                }
            }
        }
        menuJogo();
    }


//    private static void vitoria() {
//        if (Pessoa.ladoDireito.size() == 0 && Pessoa.barco.size() == 0 && Pessoa.ladoEsquerdo.size() == 6) {
//            System.out.print("\nVITÓRIA!\nVocê conseguiu atravessar todo mundo.");
//            inicio();
//        }
//    }
}