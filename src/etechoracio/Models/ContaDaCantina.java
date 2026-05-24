package etechoracio.Models;

import br.com.etechoracio.Enums.TipoDaContaEnum;

public class ContaDaCantina {

    private TipoDaContaEnum tipoConta;
    private double saldo;
    private double limite;
    private double saldoMinimo;

    public ContaDaCantina(double saldo) {
        this.saldo = saldo;
        this.tipoConta = TipoDaContaEnum.ALUNO;
        this.saldoMinimo = 10;
    }

    public ContaDaCantina(TipoDaContaEnum tipoConta, double saldo) {

        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.saldoMinimo = 10;

        if (tipoConta == TipoDaContaEnum.PROFESSOR) {
            this.limite = 100;
        }

    }

    public void emitirAlertaSaldoBaixo() {

        if (saldo <= saldoMinimo) {
            System.out.println("Conta sem saldo suficiente: R$ " + saldo);
        } else {
            System.out.println("Saldo: R$ " + saldo);
        }

    }

    public void debitar(double valor) {

        if (tipoConta == TipoDaContaEnum.DIRETOR) {

            saldo -= valor;
            emitirAlertaSaldoBaixo();

        } else if (tipoConta == TipoDaContaEnum.PROFESSOR) {

            if (valor < saldo + limite) {

                saldo -= valor;
                emitirAlertaSaldoBaixo();

            } else {

                System.out.println("Conta sem saldo suficiente");

            }

        } else if (tipoConta == TipoDaContaEnum.ALUNO) {

            if (saldo > valor) {

                saldo -= valor;
                emitirAlertaSaldoBaixo();

            } else {

                System.out.println("Conta sem saldo suficiente");

            }

        }

    }

    public void creditar(double valor) {

        saldo += valor;

        if (tipoConta == TipoDaContaEnum.ALUNO && valor > 100) {
            saldo += 5;
        }

        emitirAlertaSaldoBaixo();

    }

    public void setSaldoMinimo(double saldoMinimo) {

        this.saldoMinimo = saldoMinimo;

        emitirAlertaSaldoBaixo();

    }

}