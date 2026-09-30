package exercicio2;
public class Emprestimo{
    private float valor_devido;
    private int data_inicial;//data inicil do emprstimo
    private float valor_inicial;//sem juros
    private int parcela;//numeros de parcelas do emprestimo
    private float taxa_juros;//juros ao mes 

    public Emprestimo(int data_inicial, int parcela, float taxa_juros, float valor_devido, float valor_inicial) {
        this.data_inicial = data_inicial;
        this.parcela = parcela;
        this.taxa_juros = taxa_juros;
        this.valor_devido = valor_devido;
        this.valor_inicial = valor_inicial;
    }

    public float getValor_devido() {
        return valor_devido;
    }

    public void setValor_devido(float valor_devido) {
        this.valor_devido = valor_devido;
    }

    public int getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(int data_inicial) {
        this.data_inicial = data_inicial;
    }

    public float getValor_inicial() {
        return valor_inicial;
    }

    public void setValor_inicial(float valor_inicial) {
        this.valor_inicial = valor_inicial;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public float getTaxa_juros() {
        return taxa_juros;
    }

    public void setTaxa_juros(float taxa_juros) {
        this.taxa_juros = taxa_juros;
    }

    void pagar_parcela(Caloteiro calo, Agiota agi, float valor_pagamento) {
        if (calo.isEmprestimo_comcluido() || calo.getSaldo_devido() <= 0) {
            System.out.println("Não há pendências de pagamento.");
            return;
        }

        float valor_parcela = this.valor_devido / this.parcela;

        if (valor_pagamento >= valor_parcela) {
            // Abate a dívida do caloteiro
            float novo_saldo = calo.getSaldo_devido() - valor_pagamento;
            calo.setSaldo_devido(novo_saldo);

            // Devolve o valor pago ao capital do agiota
            agi.setCapital_emprestimo(agi.getCapital_emprestimo() + valor_pagamento);

            // Se a dívida for totalmente paga, conclui o empréstimo
            if (novo_saldo <= 0) {
                calo.setSaldo_devido(0);
                calo.setEmprestimo_comcluido(true);
                System.out.println("Empréstimo totalmente quitado!");
            } else {
                System.out.println("Parcela paga com sucesso. Saldo restante: R$ " + novo_saldo);
            }
        } else {
            System.out.println("Valor insuficiente para pagar a parcela. Valor mínimo: R$ " + valor_parcela);
        }
    }
}
