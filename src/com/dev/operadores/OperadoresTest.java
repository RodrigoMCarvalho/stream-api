package com.dev.operadores;

import com.dev.models.Funcionario;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class OperadoresTest {

    public static void main(String[] args) {

        int valor1 = 4;
        int valor2 = 5;
        int valor3 = 6;

        if((valor1 == 4 || valor2 == 5) && (valor3 == 7)) {
            System.out.println("Deve entrar");
        } else {
            System.out.println("Nao deve entrar");
        }

        int ano = LocalDateTime.now().getYear();
        int idade = ano - 2003;
        String situacao = (idade >= 16 && idade <= 18) || idade > 70 ? "OPCIONAL" : "OBRIGADOTORIO OU MENOR";

        System.out.println(situacao);

        List<Funcionario> funcionarios = Arrays.asList(
                new Funcionario("Rodrigo", true, 5000.0),
                new Funcionario("Ailton", false, 6000.0),
                new Funcionario("Gustavo", true, 2000.0),
                new Funcionario("Raquel", false, 13000.0));

//        funcionarios.stream()
//                .filter(f -> (f.getNome().equals("Rodrigo") || f.getNome().equals("Ailton")) && !f.getAtivo())
//                .forEach(System.out::println);

        for (Funcionario f : funcionarios) {
            if ((f.getNome().equals("Rodrigo") || f.getNome().equals("Ailton")) && f.getSalario() == 6000.0) {
                System.out.println(f);
            }
        }

    }

}
