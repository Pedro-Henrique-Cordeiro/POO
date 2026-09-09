/**
 * 1 - class carta; atributos {vida, custo, dano} 15 min 
 * 2 - class player; atributos {vida, ouro, quantida , carta} 15 min
 */

//definir as class e seus atributos 
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
            this.vida = vida;
            this.custo = custo;
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
    public   Carta cartaP;
    
    
    public void invocar(Carta carta){
        this.cartaP = carta;
        System.out.println(nome + " invocou " + carta.nome);
    }

    public void batalha(Inimigo adverInimigo, Player jogador){
      jogador.cartaP.setVida  (jogador.cartaP.getVida() - adverInimigo.iniCarta.dano);
      if(jogador.cartaP.getVida() <= 0){
        System.out.println(jogador.cartaP.nome + " esta morto");

      }
      if(adverInimigo.iniCarta.getVida() <= 0){
        System.out.println(adverInimigo.iniCarta.nome + " esta morto");
      }
    }

        
    }

    class Inimigo{
        String nome;
        public int vida;
        public Carta iniCarta;

        public void invocar(Carta carta){
        this.iniCarta = carta;
        System.out.println(nome + " invocou " + carta.nome);
    }
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

        jogador.invocar(lobo);
        boss.invocar(tartaruga);

        jogador.batalha(boss, jogador);
        
    } 
}