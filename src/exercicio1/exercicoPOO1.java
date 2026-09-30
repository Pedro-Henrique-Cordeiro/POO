/**
 * 1 - class carta; atributos {vida, custo, dano}
 * 2 - class player; atributos {vida, ouro, quantidade, carta}
 */

package exercicio1;

import java.util.ArrayList;

class Carta {
    String nome;
    private int vida;
    int custo;
    int dano;

    public int getVida() {
        return this.vida;
    }

    public void setVida(int novaVida) {
        this.vida = novaVida;
    }

    // Construtor
    Carta(String nome, int vida, int custo, int dano) {
        this.nome = nome;
        this.vida = vida; // CORRIGIDO
        this.custo = custo;
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
}

class Player {
    String nome;
    private int vida;

    public int getVida() {
        return vida;
    }

    public int ouro;
    public int quantidade;

    // Carta que o jogador está usando na batalha
    public Carta ataque;

    public ArrayList<Carta> inventario = new ArrayList<>();

    public void capturar(Carta carta) {
        this.inventario.add(carta);
        System.out.println(nome + " capturou " + carta.nome);
    }

    public void invocarBatalha(String nome, Player jogador) {
        for (int i = 0; i < jogador.inventario.size(); i++) {

            if (jogador.inventario.get(i).nome.equals(nome)) {

                this.ataque = jogador.inventario.get(i);

                System.out.println(
                    jogador.nome + " invocou " +
                    jogador.inventario.get(i).nome
                );

                return;
            }
        }

        System.out.println("Invocação Falhou!");
    }

    public void batalha(Inimigo adversario, Player jogador) {

        // Verifica se o jogador possui uma carta para atacar
        if (jogador.ataque == null) {
            System.out.println("O jogador não possui uma carta invocada!");
            return;
        }

        // Verifica se o inimigo possui uma carta
        if (adversario.iniCarta == null) {
            System.out.println("O inimigo não possui uma carta invocada!");
            return;
        }

        // Jogador ataca o inimigo
        adversario.iniCarta.setVida(
            adversario.iniCarta.getVida() - jogador.ataque.getDano()
        );

        System.out.println(
            jogador.ataque.nome + " causou " +
            jogador.ataque.getDano() + " de dano em " +
            adversario.iniCarta.nome
        );

        // Verifica se a carta inimiga morreu
        if (adversario.iniCarta.getVida() <= 0) {
            System.out.println(
                adversario.iniCarta.nome + " esta morto"
            );
        }

        // Inimigo ataca o jogador
        jogador.ataque.setVida(
            jogador.ataque.getVida() - adversario.iniCarta.getDano()
        );

        System.out.println(
            adversario.iniCarta.nome + " causou " +
            adversario.iniCarta.getDano() + " de dano em " +
            jogador.ataque.nome
        );

        // Verifica se a carta do jogador morreu
        if (jogador.ataque.getVida() <= 0) {
            System.out.println(
                jogador.ataque.nome + " esta morto"
            );
        }
    }
}

class Inimigo extends Player {
    public Carta iniCarta;
}

public class exercicoPOO1 {

    public static void main(String[] args) {

        // Criar o jogador
        Player jogador = new Player();
        jogador.nome = "Pedro";

        // Criar o inimigo
        Inimigo boss = new Inimigo();
        boss.nome = "boss";

        // Criar as cartas
        Carta lobo = new Carta("lobo", 7, 3, 10);
        Carta tartaruga = new Carta("tartaruga", 10, 9, 7);

        // Capturar cartas
        jogador.capturar(lobo);
        boss.capturar(tartaruga);

        // Invocar cartas para a batalha
        jogador.invocarBatalha("lobo", jogador);

        boss.iniCarta = tartaruga;

        // Iniciar batalha
        jogador.batalha(boss, jogador);
    }
}