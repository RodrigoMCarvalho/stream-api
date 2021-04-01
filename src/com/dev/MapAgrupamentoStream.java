package com.dev;

import com.dev.models.Investimento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapAgrupamentoStream {

    public static void main(String[] args) {

        Map<Long, Double> dados = new LinkedHashMap<>();
        List<Investimento> investOriginalList = new ArrayList<>();

        String path = "src/com/dev/files/dados.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(", ");
                Investimento invest = new Investimento();
                invest.setAno(Long.parseLong(fields[0]));
                invest.setValor(Double.parseDouble(fields[1]));
                investOriginalList.add(invest);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("============ Valores originais =============");
        investOriginalList.forEach(System.out::println);

        for (Investimento invest : investOriginalList) {
            if (!dados.containsKey(invest.getAno())) {
                dados.put(invest.getAno(), invest.getValor());
            } else {
                dados.put(invest.getAno(), dados.get(invest.getAno()) + invest.getValor());
            }
        }

        List<Investimento> investimentos = new ArrayList<>();
        for (Map.Entry<Long, Double> entry : dados.entrySet()) {
            Investimento invest = new Investimento();
            invest.setAno(entry.getKey());
            invest.setValor(entry.getValue());
            investimentos.add(invest);
        }

        System.out.println("============ Valores agrupados por ano =============");
        investimentos.forEach(System.out::println);

        System.out.println("===== Valores agrupados por ano usando Stream ======");
        Map<Long, Double> mapInvest = investOriginalList.stream()
                .collect(Collectors.groupingBy(Investimento::getAno, Collectors.summingDouble(Investimento::getValor)));

        mapInvest.entrySet().stream()
                .map(e -> new Investimento(e.getKey(), e.getValue()))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}