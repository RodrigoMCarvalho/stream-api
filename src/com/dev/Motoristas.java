package com.dev;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.dev.models.Caminhao;
import com.dev.models.Motorista;
import com.dev.models.Seguro;

public class Motoristas {

	private Map<String, Optional<Motorista>> motoristas  = new HashMap<>();
    
    public Motoristas() {
        Seguro seguro = new Seguro("Parcial - não cobre roubo", new BigDecimal("5000"));
        Caminhao caminhao = new Caminhao("Mercedes Atron", seguro);
        
        Optional<Motorista> motoristaJoao = Optional.ofNullable(new Motorista("João", 40, caminhao));
        Optional<Motorista> motoristaJose = Optional.ofNullable(new Motorista("José", 25, null)); // Não tem caminhão
         
        motoristas.put("João", motoristaJoao);
        motoristas.put("José", motoristaJose);
    }
     
    public Optional<Motorista> porNome(String nome) {
        return motoristas.get(nome);
    }
}
