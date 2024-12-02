package Model;

import java.time.LocalDate;

/**
 * Classe abstrata que representa um lançamento financeiro.
 * Um lançamento pode ser uma receita ou uma despesa, e contém informações
 * básicas como ID, valor e data.
 *
 */
public abstract class Lancamento {
    
    private int Id;
    private double valor;
    private LocalDate data;
    
    /**
     * Construtor para inicializar um lançamento com os dados fornecidos.
     * 
     * @param Id    o identificador único do lançamento
     * @param valor o valor do lançamento
     * @param data  a data do lançamento
     */
    public Lancamento(int Id, double valor, LocalDate data) {
        this.Id = Id;
        this.valor = valor;
        this.data = data;        
    }    

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Retorna o ID do lançamento.
     * 
     * @return o ID do lançamento
     */
    public int getId() {
        return Id;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Define o ID do lançamento.
     * 
     * @param Id o ID a ser definido
     */
    public void setId(int Id) {
        try {
            if (Id <= 0) {
                throw new IllegalArgumentException("Valor do lancamento nao pode ser igual a zero ou negativo");
            }
            this.Id = Id;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Retorna o valor do lançamento.
     * 
     * @return o valor do lançamento
     */
    public double getValor() {
        return this.valor;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Define o valor do lançamento.
     * O valor não pode ser zero ou negativo. Caso contrário, uma exceção será
     * lançada.
     * 
     * @param valor o valor a ser definido
     */
    public void setValor(double valor) {
        try {
            if (valor <= 0) {
                throw new IllegalArgumentException("Valor do lancamento nao pode ser igual a zero ou negativo");
            }
            this.valor = valor;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Retorna a data do lançamento.
     * 
     * @return a data do lançamento
     */
    public LocalDate getData() {
        return this.data;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Define a data do lançamento.
     * A data não pode ser {@code null}. Caso contrário, uma exceção será
     * lançada.
     * 
     * @param data a data a ser definida
     */
    public void setData(LocalDate data) {
        try {
            if (data == null) {
                throw new NullPointerException("A data nao pode ser nula");
            }
            this.data = data;
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

