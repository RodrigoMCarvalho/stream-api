package com.dev.utils;

import com.dev.models.Pessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Calendar;
import java.util.*;
import java.util.Optional;

public class FormatterUtils {

    public static void main(String[] args) {

        Integer d3 = 90;
        System.out.println(String.format("0.%04d", d3));  //0.0090
        System.out.println(String.format("0,%04d", d3));  //0,0090
        System.out.println(String.format("0.%05d", d3));  //0.00090
        System.out.println(String.format("%06d", d3));  //000090

        BigDecimal d4 = BigDecimal.valueOf(50);
        System.out.println(d4.divide(BigDecimal.valueOf(10000)).setScale(4, RoundingMode.HALF_EVEN)); //0.0050

        String pi1 = String.format("%s = %f", "PI", Math.PI);  //PI = 3,141593
        String pi2 = String.format("%s = %.3f", "PI", Math.PI);  //PI = 3,142
        System.out.println(pi1);
        System.out.println(pi2);
        String nome = "Rodrigo";
        String sobreNome = "Moreira";
        System.out.println(String.format("Ola, %s! ", nome));

        System.out.println(String.format("Nome completo: %s %s", nome, sobreNome));

        System.out.println(String.format("|%10d|", 101));

        long milissegundos = System.currentTimeMillis();
        System.out.println(milissegundos);
        System.out.println(String.format("%tT", milissegundos));

        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(String.format("%tT", Calendar.getInstance().getTimeInMillis()));

        LocalTime agora = LocalTime.now();

        System.out.println(String.format("%tT", agora));
        System.out.println(DateTimeFormatter.ofPattern("HH:mm:ss").format(agora));
        System.out.println(DateTimeFormatter.ofPattern("HH:mm").format(agora));

        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));

        String nome2 = "   primeiro*segundo";
        System.out.println(nome2.replace("*", ", ").trim());

        String teste = "Isso é um teste.";
        System.out.println(teste.substring(10, 13));

        String espacos = "i s p a c o s";
        String semEspacos = espacos.replaceAll(" ", "");
        System.out.println(semEspacos.replace("i", "e"));

        String alfabeto = String.join(", ", "A", "B", "C", "D");
        System.out.println(alfabeto);

        String[] split = alfabeto.split(", ");
        Arrays.stream(split).forEach(System.out::println);

        String doArquivo = "1;Gustavo;7;";
        String[] infos = doArquivo.split(";");
        Arrays.stream(infos).forEach(System.out::println);

        Pessoa pessoa = new Pessoa(infos[1], Integer.parseInt(infos[2]));
        System.out.println(pessoa);

        System.out.println("============================");


        String produto = "CDB 1";
        String produto2 = "  CDB 9 ANOS";
        String produto3 = " LDI 9 ANOS";
        String produto4 = null;

        System.out.println(produto.trim().substring(0,3));
        System.out.println(produto2.trim().substring(0,3));
        System.out.println(produto3.trim().substring(0,3));

        System.out.println(Optional.ofNullable(produto4).map(String::trim).map(p -> p.substring(0,3)).orElse("Sem produto"));
        System.out.println(Optional.ofNullable(produto2).map(String::trim).map(p -> p.substring(0,3)).orElse("Sem produto"));

        String cpf = "746.697.500-38";
        String cnpj = "16.414.781/0001-09";
        System.out.println("CPF tem " + cpf.length());
        System.out.println("CNPJ tem " + cnpj.length());

        // Remover os caracteres e deixar somente os numeros
        String cnpjSoNumeros = cnpj.replaceAll("[^0-9]", "");
        String cpfSoNumeros = cpf.replaceAll("[^0-9]", "");
        System.out.println("CNPJ so numeros: " + cnpjSoNumeros);
        System.out.println("CPF so numeros: " + cpfSoNumeros);
        System.out.println("Teste so numeros: " + "123456789".replaceAll("[^0-9]", ""));

        System.out.println("============================");

        LocalDateTime primeiroM2 = LocalDateTime.now().minusMonths(2).with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime ultimoM1 = LocalDateTime.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        String primeiroM2Format = primeiroM2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String ultimoM1Format = ultimoM1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String join = String.join(", ", primeiroM2Format, ultimoM1Format);
        System.out.println(join);

        String format = String.format("EXEC PROC '%s', '%s'", primeiroM2Format, ultimoM1Format);
        System.out.println(format);


        List<Integer> numeros = List.of(2, 4, 8);
        System.out.println(numeros.contains(2));


        LocalDateTime primeiroMes2 = LocalDateTime.now().minusMonths(2).with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime ultimoMes2 = LocalDateTime.now().minusMonths(2).with(TemporalAdjusters.lastDayOfMonth());
        String primeiroMes2Format = primeiroMes2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String ultimoMes2Format = ultimoMes2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        LocalDateTime primeiroMes1 = LocalDateTime.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime ultimoMes1 = LocalDateTime.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        String primeiroMes1Format = primeiroMes1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String ultimoMes1Format = ultimoMes1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println("============================");
        System.out.println(String.format("EXEC PROC '%s', '%s'", primeiroMes2Format, ultimoMes2Format));
        System.out.println(String.format("EXEC PROC '%s', '%s'", primeiroMes1Format, ultimoMes1Format));


    }

}