package br.com.api.projetos.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.projetos.api.models.Produto;
import br.com.api.projetos.api.models.Response;
import br.com.api.projetos.api.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    Response response;

    public Iterable<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Iterable<Produto> listarOrdenador(String type){
        return produtoRepository.findAll(Sort.by(type));
    }

    public ResponseEntity<?> cadastrarAlterar(Produto produto, String acao){

        if(produto.getNome().equals("")){
            response.setMensagem("O nome do produto é obrigatório !");
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }
        else if (produto.getValor() == 0){
            response.setMensagem("O Valor do produto é obrigatório!");
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }
        else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<Produto>(produtoRepository.save(produto), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<Produto>(produtoRepository.save(produto), HttpStatus.OK);
            }
        }
    }


    // Remoção de produtos
    public ResponseEntity<Response> remover(long id){
        produtoRepository.deleteById(id);
        response.setMensagem("Produto removido com sucesso!");
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

}
