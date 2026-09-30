package exercicio2;

public class Pessoas{
    private String nome;
    private String telefone;
    private String CPF;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}

class Caloteiro extends Pessoas{
    private float limite_credito;
    private boolean emprestimo_comcluido;
    private float saldo_devido;

    public Caloteiro(boolean emprestimo_comcluido, float limite_credito, float saldo_devido) {
        this.emprestimo_comcluido = emprestimo_comcluido;
        this.limite_credito = limite_credito;
        this.saldo_devido = saldo_devido;
    }

    public Caloteiro() {
    }

    public float getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(float limite_credito) {
        this.limite_credito = limite_credito;
    }

    public boolean isEmprestimo_comcluido() {
        return emprestimo_comcluido;
    }

    public void setEmprestimo_comcluido(boolean emprestimo_comcluido) {
        this.emprestimo_comcluido = emprestimo_comcluido;
    }

    public void pode_emprestar(float valor_requerido,Caloteiro calo){
        if(valor_requerido <= calo.limite_credito){
            calo.setEmprestimo_comcluido(true);;
            System.out.println("Operação valida");
            
        }else{
            System.out.println("Operação invalida");
            calo.setEmprestimo_comcluido(false);
        }
        
    }

    public float getSaldo_devido() {
        return saldo_devido;
    }

    public void setSaldo_devido(float saldo_devido) {
        this.saldo_devido = saldo_devido;
    }
}

class Agiota extends Pessoas{
    private float capital_emprestimo;//capital q consegue emprestar 
    private float taxa_juros;//taxa de juros ao mes

    public Agiota(float capital_emprestimo, float taxa_juros) {
        this.capital_emprestimo = capital_emprestimo;
        this.taxa_juros = taxa_juros;
    }

    public float getCapital_emprestimo() {
        return capital_emprestimo;
    }

    public void setCapital_emprestimo(float capital_emprestimo) {
        this.capital_emprestimo = capital_emprestimo;
    }

    public float getTaxa_juros() {
        return taxa_juros;
    }

    public void setTaxa_juros(float taxa_juros) {
        this.taxa_juros = taxa_juros;
    }

public void emprestar(Caloteiro calo, Agiota agi,Emprestimo empre) {
    if (!calo.isEmprestimo_comcluido()) {
        return;
    }

    if (agi.getCapital_emprestimo() >= empre.getValor_inicial()) {
        double valor_total = empre.getValor_inicial() * Math.pow(1 + agi.getTaxa_juros(), empre.getParcela());

        agi.setCapital_emprestimo(agi.getCapital_emprestimo() - empre.getValor_inicial());
        
        calo.setSaldo_devido((float) valor_total);
        calo.setEmprestimo_comcluido(false);
    }
}
    
    
}