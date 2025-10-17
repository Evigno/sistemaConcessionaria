import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe com as rotinas de entrada e saída do projeto
 * @author Hilario Seibel Junior, Larissa Santos e Lucas Silva
 */
public class Entrada {
    public Scanner input;

    /**
     * Construtor da classe Entrada
     * Se houver um arquivo input.txt na pasta em que o projeto está sendo executado,
     * define que o Scanner vai ler deste arquivo e não do teclado.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     * NÃO ALTERE O CODIGO DESSA CLASSE!
     */
    public Entrada() {
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para double
     */
    private double lerDouble(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = this.lerLinha(msg);
        return Double.parseDouble(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public int menu() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar Cliente\n" +
                "2) Cadastrar Vendedor\n" +
                "3) Cadastrar Gerente\n" +
                "4) Cadastrar Veículo Elétrico\n" +
                "6) Cadastrar Veículo A Combustão\n" +
                "7) Cadastrar Veículo Híbrido\n" +
                "8) Cadastrar Venda\n" +
                "9) Histórico de Vendas Mensal\n" +
                "10) Histórico de Vendas Anual\n" +
                "11) Histórico de Vendas do Vendedor:\n" +
                "0) Sair\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 11) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }

    /***************************************************/

    /**
     * Lê os dados de um novo Cliente e cadastra-o no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadCliente(Sistema s) {
        s.listarClientes();

        String nome = this.lerLinha("Digite o nome do cliente: ");
        String cpf = this.lerLinha("Digite o cpf do cliente: ");
        int dia = this.lerInteiro("Digite o dia do nascimento do cliente: ");
        int mes = this.lerInteiro("Digite o mês do nascimento do cliente: ");
        int ano = this.lerInteiro("Digite o ano do nascimento do cliente: ");
        String email = this.lerLinha("Digite o email do cliente: ");

        if (s.localizarCliente(cpf) == null) { // Garantindo que o não CPF esteja duplicado.
            Cliente c = new Cliente(nome, cpf, dia, mes, ano, email);
            s.adicionar(c);
        }
        else {
            System.out.println("Erro: CPF duplicado. Cliente não adicionado.");
        }
    }

    public void cadVendedor (Sistema s) {
        s.listarVendedores();

        String nome = this.lerLinha("Digite o nome do vendedor: ");
        String cpf = this.lerLinha("Digite o cpf do vendedor: ");
        int dia = this.lerInteiro("Digite o dia do nascimento do vendedor: ");
        int mes = this.lerInteiro("Digite o mês do nascimento do vendedor: ");
        int ano = this.lerInteiro("Digite o ano do nascimento do vendedor: ");
        int salario = this.lerInteiro("Digite o salário mensal fixo do vendedor: ");
        double comissao = this.lerInteiro("Digite o percentual de comissão deste vendedor: ");


        if (s.localizarVendedor(cpf) == null) { // Garantindo que o não CPF esteja duplicado.
            Vendedor c = new Vendedor(nome, cpf, dia, mes, ano, salario, comissao); // CHECAAAARRRR
            s.adicionar(c); // CHECARRRRR
        }
        else {
            System.out.println("Erro: CPF duplicado. Vendedor não adicionado.");
        }
    }
    
    public void cadGerente (Sistema s) {
        s.listarGerentes();

        String nome = this.lerLinha("Digite o nome do gerente: ");
        String cpf = this.lerLinha("Digite o cpf do gerente: ");
        int dia = this.lerInteiro("Digite o dia do nascimento do gerente: ");
        int mes = this.lerInteiro("Digite o mês do nascimento do gerente: ");
        int ano = this.lerInteiro("Digite o ano do nascimento do gerente: ");
        int salario = this.lerInteiro("Digite o salário mensal fixo do gerente: ");
        int senha = this.lerInteiro("Digite a senha do gerente: ");

        if (s.localizarGerente(cpf) == null) { // Garantindo que o não CPF esteja duplicado.
            Gerente c = new Gerente(nome, cpf, dia, mes, ano, salario, senha); // CHECAAAARRRR
            s.adicionar(c); // CHECARRRRR
        }
        else {
            System.out.println("Erro: CPF duplicado. Vendedor não adicionado.");
        }
    }

    public void cadVeiculo (Sistema s) {
        s.listarVeiculos();

        String marca = this.lerLinha("Digite a marca do veículo: ");
        String modelo = this.lerLinha("Digite o modelo do veículo: ");
        int anoFab = this.lerLinha("Digite o ano de fabricação do veículo: ");
        int mesFab = this.lerLinha("Digite o mês de fabricação do veículo: ");
        int anoMod = this.lerInteiro("Digite o ano do modelo do veículo: ");
        int valor = this.lerInteiro("Digite o valor do veículo: ")
        int tipo = this.lerInteiro("Escolha o tipo do veículo: \n1) Elétrico \n2) Combustão \n3) Híbrido:");
        while (!(tipo == 0 || tipo == 1 || tipo == 2 || tipo == 3)) {
            System.out.println("Erro: Tipo inválido. Tente novamente (para sair, digite 0).");
            tipo = this.lerInteiro("Escolha o tipo do veículo: \n1) Elétrico \n2) Combustão \n3) Híbrido:");
        }
        if (tipo == 0) {
            menu();
        }
        if (tipo == 1) {
            int autonBateria = this.lerInteiro("Digite a autonomia da bateria (em km): ");
            int capBateria = this.lerInteiro("Digite a capacidade da Bateria (em kwH): ");  
        }
        if (tipo == 2) {
            int autonMotor = this.lerInteiro("Digite a autonomia do motor (em km): ");
            int capMotor = this.lerInteiro("Digite a capacidade do motor (em L): ");
        }
        if (tipo == 3) {
            int autonMotor = this.lerInteiro("Digite a autonomia do motor (em km): ");
            int capMotor = this.lerInteiro("Digite a capacidade do motor (em L): ");
            int autonBateria = this.lerInteiro("Digite a autonomia da bateria (em km): ");
            int capBateria = this.lerInteiro("Digite a capacidade da Bateria (em kwH): ");  
        }

        if (s.localizarGerente(cpf) == null) { // Garantindo que o não CPF esteja duplicado.
            Veiculo c = new Veiculo(marca, modelo, anoFab, mesFab, anoMod, valor, tipo, autonMotor, capMotor, autonBateria, capBateria);
            s.adicionar(c); // CHECARRRRR
        }
        else {
            System.out.println("Erro: CPF duplicado. Vendedor não adicionado.");
        }
    }

    public void cadVenda (Sistema s) {
        s.listarVend();
        /* Vendedores cadastrados:
        Maria da Silva - CPF: 345
        Digite o CPF do vendedor: 345
        Veiculos cadastrados:
        1) BYD Song Pro 2025/2026 - Autonomia: 1100.0km (Híbrido)
        Escolha um veículo pelo número: 1
        Clientes cadastrados:
        Hilario Seibel Junior - CPF: 123 - hsjunior@gmail.com
        Wagner Kirmse - CPF: 234 - wagnerkc@gmail.com
        Digite o CPF do cliente: 123
        Digite o desconto (em R$): 5000
        Digite o dia da venda: 5
        Digite o mês da venda: 9
        Digite o ano da venda: 2025
        Digite o chassi do veículo: 1234 */
        String cpfVendedor = this.lerLinha("Digite o CPF do vendedor: ");
        s.listarVeiculos();
        int numVeiculo = this.lerInteiro("Escolha um veículo pelo número: ");
        

        Cliente c = s.localizarCliente(cpfCliente);
        Vendedor v = s.localizarVendedor(cpfVendedor);
        Veiculo veic = s.localizarVeiculo(marca, modelo);

        if (c == null) {
            System.out.println("Erro: Cliente não encontrado. Venda não cadastrada.");
            return;
        }
        if (v == null) {
            System.out.println("Erro: Vendedor não encontrado. Venda não cadastrada.");
            return;
        }
        if (veic == null) {
            System.out.println("Erro: Veículo não encontrado. Venda não cadastrada.");
            return;
        }
        // Veiculo veiculo, Cliente cliente, double desconto, Data d, String chassi
        Venda venda = new Venda(c, v, veic, 0.0, new Data(dia, mes, ano), ""); // desconto 0.0 e chassi vazio
        s.adicionar(venda);
    }

    /* *** RELATÓRIO DE VENDAS MENSAL DE 9/2025 ***
Vendedor: Maria da Silva (Salário neste mês: RS3398.0)
Veiculo: BYD Song Pro 2025/2026 - Autonomia: 1110.0km (Híbrido)
Cliente: Hilario Seibel Junior - CPF: 123 - hsjunior@gmail.com
Valor da venda: R$194000.0
Data: 5/9/2025
***************************************
Total: R$194000.0 */
    private void relatorioMensal (Sistema s) {
        int mes = this.lerInteiro("Digite o mês desejado: ");
        int ano = this.lerInteiro("Digite o ano desejado: ");

        s.relatorio(mes, ano);
    }

    private void relatorioAnual (Sistema s) {
        int ano = this.lerInteiro("Digite o ano desejado: ");

        s.historicoAnual(ano);
    }

    private void relatorioVendedor (Sistema s) {
        String cpf = this.lerLinha("Digite o CPF do vendedor: ");

        Vendedor v = s.localizarVendedor(cpf);
        if (v == null) {
            System.out.println("Erro: Vendedor não encontrado.");
            return;
        }

        s.historicoVendedor(v);
    }
}
