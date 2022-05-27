import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Pessoa canibal1 = new Canibal();
        Pessoa.ladoDireito.add(canibal1);

        Pessoa canibal2 = new Canibal();
        Pessoa.ladoDireito.add(canibal2);

        Pessoa canibal3 = new Canibal();
        Pessoa.ladoDireito.add(canibal3);

        Pessoa missionario1 = new Missionario();
        Pessoa.ladoDireito.add(missionario1);

        Pessoa missionario2 = new Missionario();
        Pessoa.ladoDireito.add(missionario2);

        Pessoa missionario3 = new Missionario();
        Pessoa.ladoDireito.add(missionario3);

        menu();
    }

    private static void menu() {
        System.out.println("\nMENU" +
                "\n1 - Jogar" +
                "\n2 - Encerrar");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                jogo ();
                break;
            case 2:
                System.out.println("\nTchau!");
                System.exit(0);
                break;
            default:
                System.out.print("\nNúmero inválido. Tente novamente!");
                menu();
        }
    }

    private static void colocarNoBarcoLadoDireito() {
        for(int i = 0; i < 2; i++){
            System.out.print("\nQuem você quer colocar no barco?");

            for (int j = 0; j < Pessoa.ladoDireito.size(); j++) {
                System.out.print("\n" + (j + 1) + " - " + Pessoa.ladoDireito.get(j).toString());
            }

            System.out.print("\nR: ");
            int colocarNoBarco = sc.nextInt();

            for(int x = 0; x < Pessoa.ladoDireito.size(); x++){
                if(colocarNoBarco - 1 == x){
                    Pessoa.barco.add((Pessoa.ladoDireito.get(x)));
                    Pessoa.ladoDireito.remove(x);
                }
            }
        }
    }

    private static void verificacaoLadoDireito() {
        int quantidadeCanibais = 0, quantidadeMissionarios = 0;

        for(int i = 0; i < Pessoa.ladoDireito.size(); i++) {
            if (Pessoa.ladoDireito.get(i) instanceof Canibal) {
                quantidadeCanibais++;
            } else if (Pessoa.ladoDireito.get(i) instanceof Missionario) {
                quantidadeMissionarios++;
            }
        }

        if(quantidadeCanibais > quantidadeMissionarios){
            System.out.print("\nFim de jogo! Os missionários foram comidos!\n\n");
            menu();
        }
    }

    private static void vitoria() {
        if(Pessoa.ladoDireito.isEmpty() && Pessoa.barco.isEmpty() && Pessoa.ladoEsquerdo.size() == 6){
            System.out.print("\nVITÓRIA\nVocê conseguiu atravessar todo mundo!");
            menu();
        }
    }

    public static void jogo() {
        colocarNoBarcoLadoDireito();

        verificacaoLadoDireito();


        System.out.print("\nBarco");
        for(int i = 0; i < Pessoa.barco.size(); i++){
            System.out.print("\n" + (i + 1) + " - " + Pessoa.barco.get(i).toString());
        }

        System.out.print("\nLado Direito");
        for (int j = 0; j < Pessoa.ladoDireito.size(); j++) {
            System.out.print("\n" + (j + 1) + " - " + Pessoa.ladoDireito.get(j).toString());
        }
    }
}
