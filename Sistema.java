fdgdimport java.util.ArrayList;
import java.util.ArrayList;

public class Sistema {
    private ArrayList<Cliente> clientes;
    private ArrayList<Gerente> gerentes;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Veiculo> veiculos;

    public Sistema() {
        this.clientes = new ArrayList<>();
        this.gerentes = new ArrayList<>();
        this.vendedores = new ArrayList<>();
        this.veiculos = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void adicionar(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void listarClientes() {
        System.out.println("Clientes cadastrados:");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado");
        }
        else {
            for (Cliente c : this.clientes) {
                System.out.println(c);
            }
        }
    }

    public Cliente localizarCliente(String cpf) {
        for (Cliente c : this.clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    public void adicionar(Gerente gerente){
        this.gerentes.add(gerente);
    }

    public void listarGerentes() {
        System.out.println("Gerentes cadastrados:");

        if (gerentes.isEmpty()) {
            System.out.println("Nenhum gerente cadastrado");
        }
        else {
            for (Gerente g : this.gerentes) {
                System.out.println(g);
            }
        }
    }

    public Gerente localizarGerente(String cpf) {
        for (Gerente g : this.gerentes) {
            if (g.getCpf().equals(cpf)) {
                return g;
            }
        }
        return null;
    }

    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    public void adicionar(Vendedor vendedor){
        this.vendedores.add(vendedor);
    }

    public void listarVendedores() {
        System.out.println("Vendedores cadastrados:");

        if (vendedores.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado");
        }
        else {
            for (Vendedor v : this.vendedores) {
                System.out.println(v);
            }
        }
    }

    public Vendedor localizarVendedor(String cpf) {
        for (Vendedor v : this.vendedores) {
            if (v.getCpf().equals(cpf)) {
                return v;
            }
        }
        return null;
    }
    
    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionar(Veiculo veiculo){
        this.veiculos.add(veiculo);
    }

    public void listarVeiculos() {
        System.out.println("Veiculos cadastrados:");

        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo cadastrado");
        }
        else {
            for (Veiculo v : this.veiculos) {
                System.out.println(v);
            }
        }
    }

    public Veiculo localizarVeiculo(String marca, String modelo) {
        for (Veiculo v : this.veiculos) {
            if (v.marca.equals(marca) && v.modelo.equals(modelo)) {
                return v;
            }
        }
        return null;
    }

    public void atribuirVendaVendedor(Venda venda, Vendedor vendedor) {
        vendedor.addVenda(venda);
    }
/* *** RELATÓRIO DE VENDAS MENSAL DE 9/2025 ***
Vendedor: Maria da Silva (Salário neste mês: RS3398.0)
Veiculo: BYD Song Pro 2025/2026 - Autonomia: 1110.0km (Híbrido)
Cliente: Hilario Seibel Junior - CPF: 123 - hsjunior@gmail.com
Valor da venda: R$194000.0
Data: 5/9/2025
***************************************
Total: R$194000.0 */
    public void relatorio (int mes, int ano) {
        System.out.println("*** RELATÓRIO DE VENDAS MENSAL DE " + mes + "/" + ano + "***");
        double totalVendas = 0.0;
        for (Vendedor v : this.vendedores) {
            double comissaoVendedor = v.comissaoTotal(mes, ano);
            if (comissaoVendedor > 0) {
                System.out.println("Vendedor: " + v.getNome() + " (Salário neste mês: R$" + v.getSalario(mes, ano) + ")");
                for (Venda venda : v.vendidos) {
                    if (venda.d.getMes() == mes && venda.d.getAno() == ano) {
                        System.out.println(venda);
                        System.out.println("***************************************");
                        totalVendas += venda.valor();
                    }
                }
            }
        }
        System.out.println("Total: R$" + String.format("%.2f", totalVendas));
    }
    
    public void relatorio (int ano) {
        System.out.println("*** RELATÓRIO DE VENDAS ANUAL DE " + ano + " ***");
        double totalVendas = 0.0;
        for (Vendedor v : this.vendedores) {
            double comissaoVendedor = v.comissaoTotal(ano);
            if (comissaoVendedor > 0) {
                System.out.println("Vendedor: " + v.getNome() + " (Salário neste ano: R$" + (v.salario * 12 + comissaoVendedor) + ")");
                for (Venda venda : v.vendidos) {
                    if (venda.d.getAno() == ano) {
                        System.out.println(venda);
                        System.out.println("***************************************");
                        totalVendas += venda.valor();
                    }
                }
            }
        }
        System.out.println("Total: R$" + String.format("%.2f", totalVendas));
    }

    public void relatorio (Vendedor vendedor) {
        System.out.println("*** RELATÓRIO DE VENDAS DO VENDEDOR ***");
        System.out.println("Vendas do vendedor " + vendedor.getNome() + " :");
        double totalVendas = 0.0;
        for (Venda venda : vendedor.vendidos) {
            System.out.println(venda);
            System.out.println("***************************************");
            totalVendas += venda.valor();
        }
        System.out.println("Total: R$" + String.format("%.2f", totalVendas));
    }
}
