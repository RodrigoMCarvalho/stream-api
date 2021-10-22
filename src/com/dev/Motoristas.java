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
        Seguro seguro = new Seguro("Parcial - n�o cobre roubo", new BigDecimal("5000"));
        Caminhao caminhao = new Caminhao("Mercedes Atron", seguro);
        
        Optional<Motorista> motoristaJoao = Optional.ofNullable(new Motorista("Jo�o", 40, caminhao));
        Optional<Motorista> motoristaJose = Optional.ofNullable(new Motorista("Jos�", 25, null)); // N�o tem caminh�o
         
        motoristas.put("Jo�o", motoristaJoao);
        motoristas.put("Jos�", motoristaJose);
    }
     
    public Optional<Motorista> porNome(String nome) {
        return motoristas.get(nome);
    }
}
