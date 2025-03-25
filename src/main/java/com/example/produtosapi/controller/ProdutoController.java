package com.example.produtosapi.controller;

import com.example.produtosapi.model.Produto;
import com.example.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController // Marca para receber requisições HTTP
@RequestMapping("produtos") // ULR base desse controller, opcional usar a /

public class ProdutoController {

    private ProdutoRepository produtoRepository;
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping // Identificação do tipo de requisição, pode-se colocar uma url adicional
    public Produto salvar(@RequestBody Produto produto){           // Tem de informar que o objeto virá no body da requisição
        System.out.println("Produto recebido: " + produto);

        var id = UUID.randomUUID().toString();                    // Gera código unico pro id e seta o valor antes de salvar
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    // o Path Variable indica que receberá o valor do id via url, a url adicional é feita entre {} pois é a forma que receberá o dado
    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){
        Optional<Produto> produto = produtoRepository.findById(id); // pode ser que o id enviado para busca no banco não exista, por conta disso o optional
        return produto.isPresent() ? produto.get() : null;
//      return produtoRepository.findById(id).orElse((null));     // retorne a linha baseada no id informado e se não encontrar retorne nulo
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id,
                          @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("name") String name){
        return produtoRepository.findByName(name);
    }
}
