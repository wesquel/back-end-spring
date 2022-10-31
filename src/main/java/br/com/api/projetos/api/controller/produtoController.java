package br.com.api.projetos.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.projetos.api.models.Produto;
import br.com.api.projetos.api.models.Response;
import br.com.api.projetos.api.service.ProdutoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/produtos")
public class produtoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @ResponseBody
    public Iterable<Produto> listar(@RequestParam(name = "sortBy" , required=false) String sort){;
        if (sort != null && (sort.equals("valor") || sort.equals("nome"))){
            return produtoService.listarOrdenador(sort);
        }
        return produtoService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto){
        return produtoService.cadastrarAlterar(produto, "cadastrar");
    }

    @PutMapping(value="/alterar")
    public ResponseEntity<?> alterar(@RequestBody Produto produto){
        return produtoService.cadastrarAlterar(produto, "alterar");
    }

    @DeleteMapping(value="remover/{id}")
    public ResponseEntity<Response> remover(@PathVariable long id) {        
        return produtoService.remover(id);
    }
}
