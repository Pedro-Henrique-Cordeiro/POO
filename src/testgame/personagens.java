package testgame;

abstract  class personagens {
    private int vida;
    private int dano;
    private String nome;
    
    
    public int getVida() {
        return vida;
    }
    
    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    String ficha(){
        return getNome()+"( vida " + getVida() + ", dano" + getDano() + ", { habilidade " + habilidade() + " }";
    }

    String receberDano(int quantidade){
        setVida(getVida()-quantidade);
        return  getNome() + " sofreu " + quantidade +" de dano";
    }

    String atacarString(personagens inimigo){
        inimigo.receberDano(dano);
        return getNome() +" atacou " + inimigo.getNome();
    }

    public abstract  String habilidade();
}

class Mago extends personagens{
    private int mana;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    
    @Override
    public String habilidade() {
        return "mana regen";
    }

    @Override
    String ficha() {
        return super.ficha()+" [mana"+getMana()+"]";
    }

    String recuperacaoMana(){
        return recuperacaoMana(10);
    }

    String recuperacaoMana(int quantidade){
        setMana(getMana()+quantidade);
        return String.format("%s recuperou +%d mana", getNome(),quantidade);

    }

}

class Barbaro extends personagens{
    private int stamina;


    @Override 
    public String habilidade() {
        return "furia";
    }

    

    @Override
    String receberDano(int quantidade) {
        if(getVida() <= 30 ){
            System.out.println(getNome() + " usou a habilidade " + habilidade() + "dano aumentado em 30%");
            double danoAumentado = ( (double) getDano()*0.3);
            setDano( (int) danoAumentado +getDano());
        }
        return super.receberDano(quantidade);
    }

    
    @Override
    String ficha() {
        return super.ficha() + " [ " + getStamina() +" ]" ;
    }

    
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

}