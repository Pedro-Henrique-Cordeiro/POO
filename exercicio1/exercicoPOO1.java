
/**
 * 1 - class carta; atributos {vida, custo, dano} 15 min 
 * 2 - class player; atributos {vida, ouro, quantida , carta} 15 min
 */

//definir as class e seus atributos 
import java.util.ArrayList;

class  Carta{
        String nome;
        private   int vida;

        int custo;
        int dano;

        public int getVida(){
            return this.vida;
        }
        public void setVida(int novaVida){
            this.vida = novaVida;
        }
        
        //construtor 
        Carta(String nome, int vida, int custo, int dano){
            this.nome = nome;
            this.vida = 10;
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
    private    int vida;
    public int getVida(){
        return vida;
    }
    public  int ouro;
    public  int quanatidade; 
    public Carta ataque;
    public ArrayList<Carta> inventario = new ArrayList<>();
    


    
    public void capturar(Carta carta){
        this.inventario.add(carta);
        System.out.println(nome + " capturou " + carta.nome);
    }

    public void invocarBatalha(String nome, Player jogador){
        for(int i = 0; i < jogador.inventario.size() ;i++){

            if(jogador.inventario.get(i).nome.equals(nome)){
                this.ataque = jogador.inventario.get(i);
                System.out.println(jogador.nome + " invocou " + jogador.inventario.get(i).nome);

                return;
            }
        }
        System.out.println("Invocação Falhou!");
    }

    public void batalha(Inimigo adverInimigo, Player jogador){
      jogador.inventario.get(0).setVida (jogador.inventario.get(0).getVida() - adverInimigo.iniCarta.dano);
      if(jogador.inventario.get(0).getVida() <= 0){
        System.out.println(jogador.inventario.get(0).nome + " esta morto");

      }
      if(adverInimigo.iniCarta.getVida() <= 0){
        System.out.println(adverInimigo.iniCarta.nome + " esta morto");
      }
    }

        
    }

    class Inimigo extends  Player{
        public Carta iniCarta;

    }  

public class exercicoPOO1{
    public static void main(String[] args) {
        //criar o player 
        Player jogador = new Player();
        jogador.nome = "Pedro";
        Inimigo boss =new Inimigo();
        boss.nome = "boss";

        Carta lobo = new Carta("lobo",7,3,10);
        Carta tartaruga = new Carta("tartaruga",10,9,7);

        jogador.capturar(lobo);
        boss.capturar(tartaruga);

        jogador.batalha(boss, jogador);
        
    } 
}