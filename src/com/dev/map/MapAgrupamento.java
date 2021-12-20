package com.dev.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapAgrupamento {

    public static void main(String[] args) {

        Map<Integer, Integer> dados = new LinkedHashMap<>();
        String path = "src/com/dev/files/dados.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(", ");
                int ano = Integer.parseInt(fields[0]);
                int valor = Integer.parseInt(fields[1]);

                //FIXME: Se nao contem o ano, adiciona. Caso contrario, soma o valor ao ano existente
                if (!dados.containsKey(ano)) {
                    dados.put(ano, valor);
                } else {
                    dados.put(ano, dados.get(ano) +  valor);
                }

                line = br.readLine();
            }

            for (Map.Entry<Integer, Integer> entry: dados.entrySet()) {
                System.out.println("Ano: " + entry.getKey() + " - valor: " + entry.getValue());
            }


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
