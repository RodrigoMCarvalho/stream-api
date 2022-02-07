package com.dev.utils;

import com.dev.models.Pessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;

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


    }

}