public abstract class Conta implements iConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL =1 ;

    //atributos
    protected int agencia;
    protected int numero;
    protected double saldo;
    //usando uma classe como tipo de um atributo
    protected Cliente cliente;

    //construtor de conta
    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    // expor acesso - getters
    // sem expor os modificadores ( setters )

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(Double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(Double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(Conta contaDestino, Double valor) {
        this.sacar(valor);
        //a conta que está recebendo transferencia
        //é depositado o dinheiro
        contaDestino.depositar(valor);
    }

    protected void imprimirAtributosConta() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}

