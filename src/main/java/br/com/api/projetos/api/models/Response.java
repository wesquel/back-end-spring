package br.com.api.projetos.api.models;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Response {
    private String mensagem;
}
