package padroescomportamentais.observer;

import java.util.Observable;

public class Conta extends Observable {
    private Integer agencia;
    private Integer numero;
    private String nomeBanco;
    private String tipoConta;

    public Conta(Integer agencia, Integer numero, String nomeBanco, String tipoConta) {
        this.agencia = agencia;
        this.numero = numero;
        this.nomeBanco = nomeBanco;
        this.tipoConta = tipoConta;
    }

    public void realizarMovimentacao() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", nomeBanco='" + nomeBanco + '\'' +
                ", tipoConta='" + tipoConta + '\'' +
                '}';
    }
}



