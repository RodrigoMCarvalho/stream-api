package com.dev.patterns.strategy.pormetodo;


import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.function.Function;

public class Agendamento {
    private Long cdAgendamento;

    public Agendamento(Long cdAgendamento) {
        this.cdAgendamento = cdAgendamento;
    }

    public Long getCdAgendamento() {
        return cdAgendamento;
    }
}

class DadosAgendamento {
    private Integer cdStatus;
    private Agendamento agendamento;

    public DadosAgendamento(Integer cdStatus, Agendamento agendamento) {
        this.cdStatus = cdStatus;
        this.agendamento = agendamento;
    }

    public Integer getCdStatus() {
        return cdStatus;
    }

}

class AgendamentoService {

    public static Agendamento salvar(DadosAgendamento dadosAgendamento) {
        System.out.println("Executando salvar para: " + dadosAgendamento.getCdStatus());
        return new Agendamento(1001L);
    }

    public static Agendamento aprovar(DadosAgendamento dadosAgendamento) {
        System.out.println("Executando aprovar para: " + dadosAgendamento.getCdStatus());
        return new Agendamento(2002L);
    }

    public static Agendamento editar(DadosAgendamento dadosAgendamento) {
        System.out.println("Executando editar para: " + dadosAgendamento.getCdStatus());
        return new Agendamento(3003L);
    }
}

enum AgendamentoEnum {

    SALVAR(1, AgendamentoService::salvar),
    APROVAR(2, AgendamentoService::aprovar),
    EDITAR(3, AgendamentoService::editar);

    private final Integer cdStatus;
    private final Function<DadosAgendamento, Agendamento> metodo;

    AgendamentoEnum(Integer cdStatus, Function<DadosAgendamento, Agendamento> metodo) {
        this.cdStatus = cdStatus;
        this.metodo = metodo;
    }

    public Agendamento executar(DadosAgendamento dadosAgendamento) {
        return metodo.apply(dadosAgendamento);
    }

    public static AgendamentoEnum obterMetodo(Integer status) {
        return Arrays.stream(values())
                .filter(p -> p.cdStatus.equals(status))
                .findFirst()
                .orElseThrow(() -> new InvalidParameterException("Service não encontrado para o status: " + status));
    }
}

class Main {
    public static void main(String[] args) {
        Agendamento agendamento = new Agendamento(1L);
        DadosAgendamento dadosAgendamento = new DadosAgendamento(1, agendamento);

        AgendamentoEnum metodoEnum = AgendamentoEnum.obterMetodo(dadosAgendamento.getCdStatus());

        Agendamento response = metodoEnum.executar(dadosAgendamento);
        System.out.println(response.getCdAgendamento());
    }
}