package dao; 
//import's obrigatórios para funcionamento do código
import model.Produto; 

import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory; 
import javax.persistence.Persistence; 
import java.util.List; 

public class ProdutoDAO { //Classe principal
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtoPU"); 
    // Cria uma instância de EntityManagerFactory utilizando a persistência "produtoPU" definida no persistence.xml

    public void criar(Produto produto) {  // Método para criar um novo produto no banco de dados
        EntityManager em = emf.createEntityManager(); 
        // Método para gerenciar as entidades
        em.getTransaction().begin(); 
        // Inicia uma nova transação
        em.persist(produto); 
        // Persiste produto no banco de dados
        em.getTransaction().commit(); 
        // Confirma a transação, confirmando as alterações no banco de dados
        em.close(); 
        // Fecha o EntityManager
    }

    public Produto ler(Long id) { // Método para ler (buscar) um produto pelo seu ID
        EntityManager em = emf.createEntityManager(); 
        // Método para gerenciar as entidades
        Produto produto = em.find(Produto.class, id); 
        // Busca e retorna a entidade Produto pelo seu ID
        em.close(); 
        // Fecha o EntityManager
        return produto; 
        // Retorna o produto encontrado
    }

    public List<Produto> listaTodos() { // Método para listar todos os produtos
        EntityManager em = emf.createEntityManager(); 
        // Método para gerenciar as entidades
        List<Produto> produtos = em.createQuery("FROM Produto", Produto.class).getResultList(); 
        // Cria uma consulta que retorna todos os produtos
        em.close(); 
        // Fecha o EntityManager
        return produtos; 
        // Retorna a lista de produtos
    }
}
