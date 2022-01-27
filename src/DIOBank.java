public class DIOBank {
    public static void main(String[] args) {
            // criar cliente
            Cliente novoCliente = new Cliente();
            novoCliente.setNome("Vinicius de Souza Fornazier");

            // usando polimorfismo
            // pode usar referencia como Conta ou ContaCorrente e/ou ContaPoupanca
            // para instanciar ( criar ) as contas .
            // ContaCorrente cc = new ContaCorrente();

            // indicar nome do cliente
            Conta cc = new ContaCorrente(novoCliente);
            Conta cp = new ContaPoupanca(novoCliente);

            // depositar na cc
            cc.depositar(350.54);

            // impimir extratos
            cc.imprimirExtrato();
            cp.imprimirExtrato();

            // transferir para a poupança
            // se olharmos o metodo transferir espera uma Conta
            // mas ele entende de Conta e ContaPoupanca são contas e aceita o ação
            // Polimorfismo
            cc.transferir(cp, 100.0);

            // impimir extratos
            cc.imprimirExtrato();
            cp.imprimirExtrato();

    }
}
