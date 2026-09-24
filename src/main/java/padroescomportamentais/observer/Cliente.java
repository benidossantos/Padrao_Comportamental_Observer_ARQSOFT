package padroescomportamentais.observer;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void vincular(Conta conta) {
        conta.addObserver(this);
    }

    public void update(Observable conta, Object arg1) {
        this.ultimaNotificacao = this.nome + ", movimentação realizada na " + conta.toString();

    }
}