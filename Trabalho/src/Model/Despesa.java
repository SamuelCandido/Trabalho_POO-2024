package Model;

import java.time.LocalDate;

/**
 * Representa uma despesa financeira, que é um tipo de lançamento na conta.
 * Cada despesa está associada a uma categoria específica, além de ter
 * informações sobre o valor, a data e o ID do lançamento.
 *
 */
public class Despesa extends Lancamento {

    private CategoriaDespesa categoria;

    /**
     * Construtor para criar uma despesa com os dados especificados.
     * 
     * @param Id        o ID do lançamento
     * @param categoria a categoria da despesa
     * @param valor     o valor da despesa
     * @param data      a data do lançamento
     */
    public Despesa(int Id, CategoriaDespesa categoria, double valor, LocalDate data) {
        super(Id, valor, data);
        this.setCategoria(categoria);
    }

// --------------------------------------------------------------------------------------------------------------------------------------- 
    /**
     * Retorna a categoria da despesa.
     * 
     * @return a categoria da despesa
     */
    public CategoriaDespesa getCategoria() {
        return this.categoria;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------  
    /**
     * Define a categoria da despesa.
     * Caso a categoria fornecida seja {@code null}, uma exceção será lançada.
     * 
     * @param categoria a categoria a ser definida
     */
    public void setCategoria(CategoriaDespesa categoria) {
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
