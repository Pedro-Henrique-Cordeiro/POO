/*
 uma game q tem tres personagens sendo eles :

MAGO
        
TANK

BARBARO


o cambate tera as seguinte mecanica :

custo de ataque como Mana e estamima *a estamina diminui a cd turno 
cada class tem dois atk e uma habilidade

n tera loop apenas print de texto, pois n tenho tempo

*/
package testgame;

public class Main {
    public static void main(String[] args) {
        // Creating and configuring the wizard
        Mago mago = new Mago();
        mago.setNome("Gandalf");
        mago.setVida(100);
        mago.setDano(70);
        mago.setMana(30);

        Barbaro barbaro = new Barbaro();
        barbaro.setNome("Bjorn");
        barbaro.setVida(100);
        barbaro.setDano(25);
        barbaro.setStamina(30);

        // Displaying the initial character sheet
        System.out.println("--- Ficha Inicial ---");
        System.out.println(mago.ficha());

        // Testing standard mana recovery (+10)
        System.out.println("\n--- Recuperação Padrão ---");
        System.out.println(mago.recuperacaoMana());
        System.out.println(mago.ficha());

        // Testing custom mana recovery (+25)
        System.out.println("\n--- Recuperação Personalizada ---");
        System.out.println(mago.recuperacaoMana(25));
        System.out.println(mago.ficha());

        System.out.println(barbaro.ficha());

        System.out.println(mago.atacarString(barbaro));

        System.out.println(barbaro.ficha());


    }
}