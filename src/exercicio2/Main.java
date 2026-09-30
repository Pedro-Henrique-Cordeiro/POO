package exercicio2;
public class Main {
    public static void main(String[] args) {
        // 1. Instanciando o Agiota (Capital: R$ 5.000, Taxa de Juros: 10% ao mês = 0.10f)
        Agiota agiota = new Agiota(5000.0f, 0.10f);
        agiota.setNome("Seu Madruga");
        agiota.setCPF("111.222.333-44");
        agiota.setTelefone("(43) 99999-1111");

        // 2. Instanciando o Caloteiro (Inicialmente sem dívidas = true, Limite: R$ 2.000)
        Caloteiro caloteiro = new Caloteiro(true, 2000.0f, 0.0f);
        caloteiro.setNome("Kiko");
        caloteiro.setCPF("555.666.777-88");
        caloteiro.setTelefone("(43) 98888-2222");

        // 3. Criando a solicitação de Empréstimo (Data: 1, Parcelas: 5, Taxa: 10%, Valor: R$ 1.000)
        // Nota: O valor devido será calculado e atualizado no método emprestar.
        Emprestimo emprestimo = new Emprestimo(1, 5, agiota.getTaxa_juros(), 0.0f, 1000.0f);

        System.out.println("=== ESTADO INICIAL ===");
        System.out.println("Capital do Agiota: R$ " + agiota.getCapital_emprestimo());
        System.out.println("Saldo devido do Caloteiro: R$ " + caloteiro.getSaldo_devido());
        System.out.println("----------------------------------------\n");

        // 4. Realizando o empréstimo
        System.out.println("--- 1. SOLICITANDO EMPRÉSTIMO ---");
        agiota.emprestar(caloteiro, agiota, emprestimo);

        System.out.println("Capital restante do Agiota: R$ " + agiota.getCapital_emprestimo());
        System.out.println("Novo saldo devido do Caloteiro (com juros): R$ " + caloteiro.getSaldo_devido());
        System.out.println("Empréstimo concluído/quitado? " + caloteiro.isEmprestimo_comcluido());
        System.out.println("----------------------------------------\n");

        // 5. Tentando pedir outro empréstimo estando devendo (deve negar)
        System.out.println("--- 2. TENTANDO NOVO EMPRÉSTIMO SEM QUITAR O ANTERIOR ---");
        agiota.emprestar(caloteiro, agiota, emprestimo);
        System.out.println("----------------------------------------\n");

        // 6. Pagando parcelas
        System.out.println("--- 3. PAGANDO PARCELAS ---");
        float valorParcelaCalculado = emprestimo.getValor_devido() / emprestimo.getParcela();
        System.out.printf("Valor mínimo de cada parcela: R$ %.2f\n\n", valorParcelaCalculado);

        // Tentativa de pagamento com valor menor que a parcela
        System.out.println("Tentativa de pagamento insuficiente:");
        emprestimo.pagar_parcela(caloteiro, agiota, 100.0f);

        System.out.println("\nPagamento da 1ª Parcela:");
        emprestimo.pagar_parcela(caloteiro, agiota, valorParcelaCalculado);

        System.out.println("\nPagamento de todo o saldo restante:");
        float saldoRestante = caloteiro.getSaldo_devido();
        emprestimo.pagar_parcela(caloteiro, agiota, saldoRestante);

        System.out.println("\n========================================");
        System.out.println("=== ESTADO FINAL ===");
        System.out.println("Capital final do Agiota: R$ " + agiota.getCapital_emprestimo());
        System.out.println("Saldo devido final do Caloteiro: R$ " + caloteiro.getSaldo_devido());
        System.out.println("Status do Caloteiro (concluído/livre): " + caloteiro.isEmprestimo_comcluido());
    }
}