package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Conta conta = new Conta(1234, 56789, "Banco do Brasil", "Corrente");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.vincular(conta);
        conta.realizarMovimentacao();
        assertEquals("Cliente 1, movimentação realizada na Conta{agencia=1234, numero=56789, nomeBanco='Banco do Brasil', tipoConta='Corrente'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Conta conta = new Conta(1234, 56789, "Banco do Brasil", "Corrente");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.vincular(conta);
        cliente2.vincular(conta);
        conta.realizarMovimentacao();
        assertEquals("Cliente 1, movimentação realizada na Conta{agencia=1234, numero=56789, nomeBanco='Banco do Brasil', tipoConta='Corrente'}", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, movimentação realizada na Conta{agencia=1234, numero=56789, nomeBanco='Banco do Brasil', tipoConta='Corrente'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Conta conta = new Conta(1234, 56789, "Banco do Brasil", "Corrente");
        Cliente cliente = new Cliente("Cliente 1");
        conta.realizarMovimentacao();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteContaCorrente() {
        Conta contaCorrente = new Conta(1234, 56789, "Banco do Brasil", "Corrente");
        Conta contaPoupanca = new Conta(1234, 56789, "Banco do Brasil", "Poupanca");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.vincular(contaCorrente);
        cliente2.vincular(contaPoupanca);
        contaCorrente.realizarMovimentacao();
        assertEquals("Cliente 1, movimentação realizada na Conta{agencia=1234, numero=56789, nomeBanco='Banco do Brasil', tipoConta='Corrente'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}
