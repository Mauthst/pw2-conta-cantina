package br.com.etechoracio.Models;

import br.com.etechoracio.Enums.TipoContaEnum;

public class ContaCantina {

    private TipoContaEnum tipoConta;
    private double saldo;
    private double limite;
    private double saldoMinimo;

    public ContaCantina(double saldo) {
        this.saldo = saldo;
        this.tipoConta = TipoContaEnum.ALUNO;
        this.saldoMinimo = 10;
    }

    public ContaCantina(TipoContaEnum tipoConta, double saldo) {

        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.saldoMinimo = 10;

        if (tipoConta == TipoContaEnum.PROFESSOR) {
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

        if (tipoConta == TipoContaEnum.DIRETOR) {

            saldo -= valor;
            emitirAlertaSaldoBaixo();

        } else if (tipoConta == TipoContaEnum.PROFESSOR) {

            if (valor < saldo + limite) {

                saldo -= valor;
                emitirAlertaSaldoBaixo();

            } else {

                System.out.println("Conta sem saldo suficiente");

            }

        } else if (tipoConta == TipoContaEnum.ALUNO) {

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

        if (tipoConta == TipoContaEnum.ALUNO && valor > 100) {
            saldo += 5;
        }

        emitirAlertaSaldoBaixo();

    }

    public void setSaldoMinimo(double saldoMinimo) {

        this.saldoMinimo = saldoMinimo;

        emitirAlertaSaldoBaixo();

    }

}