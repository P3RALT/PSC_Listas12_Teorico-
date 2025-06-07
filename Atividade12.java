package atividade12;

import java.util.Scanner;

class Bola {
    private String cor;
    private double circunferencia;
    private String material;

    public Bola(String cor, double circunferencia, String material) {
        this.cor = cor;
        this.circunferencia = circunferencia;
        this.material = material;
    }

    public void trocarCor(String novaCor) {
        this.cor = novaCor;
    }

    public void mostrarCor() {
        System.out.println("Cor da bola: " + this.cor);
    }
}

class Quadrado {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public void mudarValorDoLado(double novoLado) {
        this.lado = novoLado;
    }

    public double retornarValorDoLado() {
        return lado;
    }

    public double calcularArea() {
        return lado * lado;
    }
}

class Retangulo {
    private double ladoA;
    private double ladoB;

    public Retangulo(double ladoA, double ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    public void mudarValorDosLados(double novoA, double novoB) {
        this.ladoA = novoA;
        this.ladoB = novoB;
    }

    public String retornarValorDosLados() {
        return "Lado A: " + ladoA + ", Lado B: " + ladoB;
    }

    public double calcularArea() {
        return ladoA * ladoB;
    }

    public double calcularPerimetro() {
        return 2 * (ladoA + ladoB);
    }
}

class Pessoa {
    private String nome;
    private int idade;
    private double peso;
    private double altura;

    public Pessoa(String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public void envelhecer() {
        idade++;
        if (idade < 21) {
            crescer(0.5);
        }
    }

    public void engordar(double quilos) {
        peso += quilos;
    }

    public void emagrecer(double quilos) {
        peso -= quilos;
    }

    public void crescer(double centimetros) {
        altura += centimetros / 100; // converter cm para metros
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Altura: " + String.format("%.2f", altura) + " m");
    }
}

class ContaCorrente {
    private String numeroConta;
    private String nomeCorrentista;
    private double saldo;

    public ContaCorrente(String numeroConta, String nomeCorrentista) {
        this.numeroConta = numeroConta;
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = 0.0;
    }

    public ContaCorrente(String numeroConta, String nomeCorrentista, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = saldoInicial;
    }

    public void alterarNome(String novoNome) {
        this.nomeCorrentista = novoNome;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void mostrarDados() {
        System.out.println("Conta: " + numeroConta);
        System.out.println("Correntista: " + nomeCorrentista);
        System.out.println("Saldo: R$ " + String.format("%.2f", saldo));
    }
}

public class Atividade12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Teste da Bola
        Bola bola = new Bola("Azul", 30.0, "Borracha");
        bola.mostrarCor();
        bola.trocarCor("Vermelha");
        bola.mostrarCor();

        System.out.println("---------------");

        // Teste do Quadrado
        Quadrado quadrado = new Quadrado(5.0);
        System.out.println("Lado do quadrado: " + quadrado.retornarValorDoLado());
        System.out.println("Área do quadrado: " + quadrado.calcularArea());

        System.out.println("---------------");

        // Teste do Retângulo com entrada do usuário
        System.out.print("Informe a largura do local: ");
        double largura = sc.nextDouble();

        System.out.print("Informe o comprimento do local: ");
        double comprimento = sc.nextDouble();

        Retangulo local = new Retangulo(largura, comprimento);
        double area = local.calcularArea();
        double perimetro = local.calcularPerimetro();

        System.out.println("Área do local: " + area + " m²");
        System.out.println("Pisos necessários: " + Math.ceil(area));
        System.out.println("Rodapés necessários: " + perimetro + " metros");

        System.out.println("---------------");

        // Teste da Pessoa
        Pessoa pessoa = new Pessoa("Gabriel", 18, 70.0, 1.75);
        pessoa.envelhecer(); // deve crescer 0.5cm
        pessoa.engordar(2);
        pessoa.emagrecer(1);
        pessoa.mostrarDados();

        System.out.println("---------------");

        // Teste da Conta Corrente
        ContaCorrente conta = new ContaCorrente("12345-6", "Gabriel", 100.0);
        conta.depositar(50.0);
        conta.sacar(30.0);
        conta.mostrarDados();

        sc.close();
    }
}
