import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

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
                break;
        }
    }

    private static void colocarNoBarco(){

    }

    private static void tirarDobarco(){

    }

    private static void verificacaoLadoDireito()  {
        int quantidadeCanibais = 0, quantidadeMissionarios = 0;

        for (int i = 0; i < Pessoa.ladoDireito.size(); i++) {
            if (Pessoa.ladoDireito.get(i) instanceof Canibal) {
                quantidadeCanibais++;
            } else if (Pessoa.ladoDireito.get(i) instanceof Missionario) {
                quantidadeMissionarios++;
            }
        }

        if (quantidadeCanibais > quantidadeMissionarios) {
            //throw new GameOver();
        }
    }

    private static void tirarDoBarcoQuemVeioDoLadoDireito() {
        System.out.print("\nAtravessou o rio! Lado: esquerdo");

        System.out.print("\nQuem você quer tirar do barco?");
        for (int j = 0; j < Pessoa.barco.size(); j++) {
            System.out.print("\n" + (j + 1) + " - " + Pessoa.barco.get(j).toString());
        }
        System.out.print("\nR: ");
        int tirarDoBarco = sc.nextInt();

        for (int x = 0; x < Pessoa.barco.size(); x++) {
            if (tirarDoBarco - 1 == x) {
                Pessoa.ladoEsquerdo.add((Pessoa.barco.get(x)));
                Pessoa.barco.remove(x);
            }
        }

        continuacaoTirarDoBarcoQuemVeioDoLadoDireito();
    }

    private static void continuacaoTirarDoBarcoQuemVeioDoLadoDireito() {
        System.out.print("\nComo você quer prosseguir?");

        if (Pessoa.barco.size() == 1) {
            System.out.print("\n1 - Voltar com um personagem" +
                    "\n2 - Tirar do barco o outro personagem" +
                    "\n3 - Colocar outro personagem do lado esquerdo" +
                    "\nR: ");
        } else if (Pessoa.barco.size() == 0) {
            System.out.print("\n1 - Colocar um personagem do lado esquerdo" +
                    "\nR: ");
        }
        int continuacao = sc.nextInt();

        switch (continuacao) {
            case 1:
                if (Pessoa.barco.size() != 0) {
                    colocarNoBarcoLadoDireito();
                } else if (Pessoa.barco.size() == 0) {
                    colocarNoBarcoLadoEsquerdo();
                }
                break;

            case 2:
                tirarDoBarcoQuemVeioDoLadoDireito();
                break;

            case 3:
                colocarNoBarcoLadoEsquerdo();
                break;
        }
    }

    private static void vitoria() {
        if (Pessoa.ladoDireito.size() == 0 && Pessoa.barco.size() == 0 && Pessoa.ladoEsquerdo.size() == 6) {
            System.out.print("\nVITÓRIA!\nVocê conseguiu atravessar todo mundo.");
            inicio();
        }
    }
}