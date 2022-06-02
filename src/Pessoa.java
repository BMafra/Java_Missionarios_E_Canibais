import java.util.ArrayList;

public class Pessoa {
    static ArrayList<Pessoa> ladoDireito = new ArrayList<>();
    static ArrayList<Pessoa> ladoEsquerdo = new ArrayList<>();
    static ArrayList<Pessoa> barco = new ArrayList<>();

    String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}