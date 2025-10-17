//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Entrada io = new Entrada();
        Sistema s = new Sistema();

        int op = io.menu();

        while (op != 0) {
            switch(op) {
                case 1:
                    io.cadCliente(s); break;
                case 2:
                    io.cadVendedor(s); break;
                case 3:
                    io.cadProduto(s); break;
                case 4:
                    io.cadVenda(s); break;
                case 5:
                    io.relatorioVendas(s); break;
                case 6:
                    io.relatorioClientes(s); break;
                case 7:
                    io.relatorioVendedores(s); break;
                case 8:
                    io.relatorioProdutos(s); break;
                default:
                    io.opInvalida(); break;
            }

            op = io.menu();
        }
    }
}