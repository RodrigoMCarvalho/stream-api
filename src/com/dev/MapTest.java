package com.dev;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("firstName", "Wolmir");
		map.put("lastName", "Garbin");
		map.put("blog", "Receitas de Código");
		map.put("url", "https://receitasdecodigo.com.br");
		
		for (String key : map.keySet()) {
			System.out.println(String.format("Valor da key: %s", key));
		}
		map.keySet().forEach(key -> System.out.println(String.format("Valor da key: %s", key)));
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    System.out.println(String.format("key: %s | value: %s", key, value));
		}
		map.entrySet().forEach(entry -> System.out.println(String.format("key: %s | value: %s", entry.getKey(), entry.getValue())));
		
		boolean nomeCerto = false;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if(entry.getKey().equals("firstName") && entry.getValue().contains("Wolmir")) {
				nomeCerto = true;
			}
		}

		boolean nomeCerto2 = map.entrySet().stream().anyMatch(entry -> entry.getKey().equals("firstName") && entry.getValue().contains("Wolmir"));

		System.out.println("Nome certo: " + nomeCerto);
		System.out.println("Nome certo2: " + nomeCerto2);

	}

}

