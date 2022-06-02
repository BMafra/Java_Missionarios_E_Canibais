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
                jogo();
                break;

            case 2:
                System.out.print("\nEncerrando...");
                System.exit(0);

            default:
                System.out.print("\nOpção inválida! Tente novamente:\n");
                inicio();
        }
    }

    private static void colocarNoBarcoLadoDireito() {
        for (int i = 0; i < 2; i++) {
            System.out.print("\nQuem você quer colocar no barco?");
            for (int j = 0; j < Pessoa.ladoDireito.size(); j++) {
                System.out.print("\n" + (j + 1) + " - " + Pessoa.ladoDireito.get(j).toString());
            }
            System.out.print("\nR: ");
            int colocarNoBarco = sc.nextInt();

            for (int x = 0; x < Pessoa.ladoDireito.size(); x++) {
                if (colocarNoBarco - 1 == x) {
                    Pessoa.barco.add((Pessoa.ladoDireito.get(x)));
                    Pessoa.ladoDireito.remove(x);
                }
            }
        }
    }

    private static void verificacaoLadoDireito() {
        int quantidadeCanibais = 0, quantidadeMissionarios = 0;

        for (int i = 0; i < Pessoa.ladoDireito.size(); i++) {
            if (Pessoa.ladoDireito.get(i) instanceof Canibal) {
                quantidadeCanibais++;
            } else if (Pessoa.ladoDireito.get(i) instanceof Missionario) {
                quantidadeMissionarios++;
            }
        }

        if (quantidadeCanibais > quantidadeMissionarios) {
            System.out.print("\nDERROTA! Os missionários foram comidos.\n\n");
            inicio();
        }
    }

    private static void tirarDoBarcoQuemVeioDoLadoDireito() {
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
                    "\n2 - Tirar do barco o personagem" +
                    "\n3 - Colocar outro personagem da margem esquerda" +
                    "\nR: ");
        } else if (Pessoa.barco.size() == 0) {
            System.out.print("\n1 - Colocar um personagem da margem" +
                    "\nR: ");
        }
        int continuacao = sc.nextInt();

        switch (continuacao) {
            case 1:
                colocarNoBarcoLadoDireito();
                break;

            case 2:
                tirarDoBarcoQuemVeioDoLadoDireito();
                break;


        }
    }

    private static void colocarNoBarcoLadoEsquerdo() {
        for (int i = 0; i < 2; i++) {
            System.out.print("\nQuem você quer colocar no barco?");
            for (int j = 0; j < Pessoa.ladoEsquerdo.size(); j++) {
                System.out.print("\n" + (j + 1) + " - " + Pessoa.ladoEsquerdo.get(j).toString());
            }
            System.out.print("\nR: ");
            int colocarNoBarco = sc.nextInt();

            for (int x = 0; x < Pessoa.ladoEsquerdo.size(); x++) {
                if (colocarNoBarco - 1 == x) {
                    Pessoa.barco.add((Pessoa.ladoEsquerdo.get(x)));
                    Pessoa.ladoEsquerdo.remove(x);
                }
            }
        }
    }

    private static void verificacaoLadoEsquerdo() {
        int quantidadeCanibais = 0, quantidadeMissionarios = 0;

        for (int i = 0; i < Pessoa.ladoEsquerdo.size(); i++) {
            if (Pessoa.ladoEsquerdo.get(i) instanceof Canibal) {
                quantidadeCanibais++;
            } else if (Pessoa.ladoEsquerdo.get(i) instanceof Missionario) {
                quantidadeMissionarios++;
            }
        }

        if (quantidadeCanibais > quantidadeMissionarios) {
            System.out.print("\nDERROTA! Os missionários foram comidos.\n\n");
            inicio();
        }
    }

    private static void vitoria() {
        if (Pessoa.ladoDireito.size() == 0 && Pessoa.barco.size() == 0 && Pessoa.ladoEsquerdo.size() == 6) {
            System.out.print("\nVITÓRIA!\nVocê conseguiu atravessar todo mundo.");
            inicio();
        }
    }

    public static void jogo() {
        colocarNoBarcoLadoDireito();

        verificacaoLadoDireito();

        colocarNoBarcoLadoEsquerdo();

        verificacaoLadoEsquerdo();

        System.out.print("\nLado Direito");
        for (int j = 0; j < Pessoa.ladoDireito.size(); j++) {
            System.out.print("\n" + (j + 1) + " - " + Pessoa.ladoDireito.get(j).toString());
        }

        System.out.print("\nLado Esquerdo");
        for (int j = 0; j < Pessoa.ladoEsquerdo.size(); j++) {
            System.out.print("\n" + (j + 1) + " - " + Pessoa.ladoEsquerdo.get(j).toString());
        }

        System.out.print("\nBarco");
        for (int i = 0; i < Pessoa.barco.size(); i++) {
            System.out.print("\n" + (i + 1) + " - " + Pessoa.barco.get(i).toString());
        }

    }
}