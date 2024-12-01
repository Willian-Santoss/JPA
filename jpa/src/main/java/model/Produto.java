package model; 

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 

@Entity // Indica que esta classe é uma entidade JPA que será mapeada para uma tabela no banco de dados
public class Produto {
    @Id // Indica que o campo id é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que o id será gerado automaticamente pelo banco de dados
    private Long id; // Campo id armazena a chave primária do produto
    private String nome; // Campo nome que armazena o nome do produto
    private Double preco; // Campo preco que armazena o preço do produto

    // Métodos Getters e Setters para acessar e modificar os campos privados
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
