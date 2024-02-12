package com.mproject.fopag.view;

import com.mproject.fopag.models.SalarioPessoa;
import com.mproject.fopag.service.CalculoSalarioService;

import java.util.Scanner;

public class CadastroMain {
    public static void main(String[] args) {

        CalculoSalarioService calculoSalarioService = new CalculoSalarioService();
        SalarioPessoa salarioPessoa = new SalarioPessoa();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o Nome: ");
        salarioPessoa.setNome(scanner.nextLine());

        System.out.println("CPF: ");
        salarioPessoa.setCpf(scanner.nextLine());

        System.out.println("Salario: ");
        salarioPessoa.setSalarioBase(scanner.nextFloat());

        System.out.println("Quantidade de Dependentes: ");
        salarioPessoa.setQtdDependente(scanner.nextInt());

        System.out.println("=====================================================");

        System.out.println("Desconto INSS");
        System.out.println(calculoSalarioService.retornaDescontoInss(salarioPessoa.getSalarioBase()));
        System.out.println("Desconto IRRF");
        System.out.println(calculoSalarioService.retornaDescontoIrrf(salarioPessoa.getSalarioBase(), salarioPessoa.getQtdDependente()));
        System.out.println("Salario Liquido a receber");
        System.out.println(calculoSalarioService.retornaSalarioLiquido(salarioPessoa.getSalarioBase(), salarioPessoa.getQtdDependente()));
        System.out.println("=====================================================");
        System.out.println("FGTS 8%");
        System.out.println(calculoSalarioService.retornaFgtsEmpregado(salarioPessoa.getSalarioBase()));
        System.out.println("FGTS 0,5%");
        System.out.println(calculoSalarioService.retornaFgtsGoverno(salarioPessoa.getSalarioBase()));
    }
}
