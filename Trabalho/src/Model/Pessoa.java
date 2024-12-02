package Model;

/**
 * Representa uma pessoa com informações básicas como nome, e-mail e telefone.
 * Essa classe é usada para identificar e armazenar dados pessoais associados a
 * um titular de uma conta.
 */
public class Pessoa {

    private String nome;
    private String email;
    private String telefone;

    /**
     * Retorna o nome da pessoa.
     *
     * @return o nome da pessoa
     */
    public String getNome() {
        return nome;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Define o nome da pessoa. O nome não pode ser {@code null}. Caso
     * contrário, uma exceção será lançada.
     *
     * @param nome o nome a ser definido
     */
    public void setNome(String nome) {
        try {
            if (nome == null || nome.trim().isEmpty()) {
                throw new IllegalArgumentException("O nome não pode ser vazio ou nulo");
            }
            if (nome.length() < 3 || nome.length() > 50) {
                throw new IllegalArgumentException("O nome deve ter entre 3 e 50 caracteres");
            }
            if (!nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
                throw new IllegalArgumentException("O nome contém caracteres inválidos");
            }
            this.nome = nome;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Retorna o e-mail da pessoa.
     *
     * @return o e-mail da pessoa
     */
    public String getEmail() {
        return email;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Define o e-mail da pessoa.
     *
     * @param email o e-mail a ser definido
     */
    public void setEmail(String email) {
        try {
            if (email.length() < 3 || email.length() > 50) {
                throw new IllegalArgumentException("O email deve ter entre 3 e 50 caracteres");
            }
            if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                throw new IllegalArgumentException("Formato de e-mail inválido");
            }
            this.email = email;
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Retorna o telefone da pessoa.
     *
     * @return o telefone da pessoa
     */
    public String getTelefone() {
        return telefone;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Define o telefone da pessoa.
     *
     * @param telefone o telefone a ser definido
     */
    public void setTelefone(String telefone) {
        try {        
            if (!telefone.matches("\\d+")) {
                throw new IllegalArgumentException("O telefone deve conter apenas números");
            }
            if (telefone.length() != 11) {
                throw new IllegalArgumentException("O tumero deve ter 11 numeros, lembre do 9 a mais");
            }
            this.telefone = telefone;
        }   
        catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
