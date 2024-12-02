package Model;

import java.time.LocalDate;

/**
 * Representa uma receita financeira, que é um tipo de lançamento na conta.
 * Cada receita está associada a uma categoria específica, além de conter
 * informações sobre o valor, a data e o ID do lançamento.
 * 
 */

public class Receita extends Lancamento {

    private CategoriaReceita categoria;

    /**
     * Construtor para criar uma receita com os dados especificados.
     * 
     * @param Id        o ID do lançamento
     * @param categoria a categoria da receita
     * @param valor     o valor da receita
     * @param data      a data do lançamento
     */
    public Receita(int Id, CategoriaReceita categoria, double valor, LocalDate data) {
        super(Id, valor, data);
        this.setCategoria(categoria);
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Retorna a categoria da receita.
     * 
     * @return a categoria da receita
     */
    public CategoriaReceita getCategoria() {
        return this.categoria;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Define a categoria da receita.
     * Caso a categoria fornecida seja {@code null}, uma exceção será lançada.
     * 
     * @param categoria a categoria a ser definida
     */
    public void setCategoria(CategoriaReceita categoria) {
        try {
            if (categoria == null) {
                throw new NullPointerException("A categoria nao pode ser nula");
            }
            this.categoria = categoria;
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
