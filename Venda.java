public class Venda {
    private Veiculo veiculo;
    private Cliente cliente;
    private double desconto;
    private Data d;
    private String chassi;

    public Venda(Veiculo veiculo, Cliente cliente, double desconto, Data d, String chassi) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.desconto = desconto;
        this.d = d;
        this.chassi = chassi;
    }

    public double valor() {
        return this.veiculo.valor - this.desconto;
    }

    public void setDesconto(double desconto, Gerente gerente, String senha) {
        if (gerente.validarAcesso(senha)) {
            this.desconto = desconto;
        }
    }

    public void toString() {
        // ihul, vai dar 23h, boa noite
    }
}
