package Model;

import Model.Despesa;
import Model.Lancamento;
import Model.Receita;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

/**
 * Classe de uma conta financeira associada a um titular, contendo lançamentos
 * de receitas e despesas. Permite operações como inclusão, exclusão e consulta
 * de lançamentos, além de exportar e importar dados. Essa classe oferece
 * suporte para o gerenciamento de saldo, filtragem de lançamentos por período e
 * categoria, e ordenação por data.
 */
public class Conta {

    private double saldo;
    private Pessoa titular;
    private ArrayList<Lancamento> lancamentos = new ArrayList<>();

// --------------------------------------------------------------------------------------------------------------------------------------- 
    /**
     * Construtor para inicializar a conta com um titular.
     *
     * @param titular o titular da conta
     */
    public Conta(Pessoa titular) {
        this.titular = titular;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Retorna o saldo atual da conta.
     *
     * @return o saldo atual
     */
    protected double getSaldo() {
        return this.saldo;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Define o saldo da conta.
     * Método privado para evitar alterações diretas.
     *
     * @param saldo o saldo a ser definido
     */
    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Retorna o titular da conta.
     *
     * @return o titular
     */
    public Pessoa getTitular() {
        return this.titular;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Define o titular da conta.
     *
     * @param titular o titular a ser definido
     */
    public void setTitular(Pessoa titular) {
        try {
            if (titular == null) {
                throw new NullPointerException("O titular nao pode ser nulo");
            }
            this.titular = titular;
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Retorna a lista de lançamentos associados à conta.
     *
     * @return lista de lançamentos
     */
    public ArrayList<Lancamento> getLancamentos() {
        return this.lancamentos;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
/**
* Inclui um lançamento (receita ou despesa) na conta.
* Ajusta o saldo com base no tipo do lançamento.
*
* @param lancamento o lançamento a ser incluído
*/
public void incluirLancamento(Lancamento lancamento) {
    try {
        if (lancamento == null) {
            throw new NullPointerException("O lancamento nao pode ser nulo");
        }
        if (lancamento.getValor() <= 0) {
            throw new IllegalArgumentException("O valor do lançamento deve ser maior que zero.");
        }
        if (lancamento instanceof Receita) {
            setSaldo(getSaldo() + lancamento.getValor());
        } else if (lancamento instanceof Despesa) {
            setSaldo(getSaldo() - lancamento.getValor());
        }
        this.lancamentos.add(lancamento);
    } catch (NullPointerException | IllegalArgumentException e) {
        System.out.println("Erro: " + e.getMessage());
    }
}

// ---------------------------------------------------------------------------------------------------------------------------------------    
/**
* Retorna uma lista de lançamentos até a data atual.
*
* @return uma lista de lançamentos até a data atual
*/
public ArrayList<Lancamento> consultarSaldoDataAtual() {
    try {
        if (lancamentos.isEmpty()) {
            throw new IllegalStateException("Não há lançamentos para consultar.");
        }
        ArrayList<Lancamento> lancamentosDataAtual = new ArrayList<>();

        for (Lancamento lancamento : this.lancamentos) {
            if (lancamento.getData().isBefore(LocalDate.now()) || lancamento.getData().isEqual(LocalDate.now())) {
                lancamentosDataAtual.add(lancamento);
            }
        }

        if (lancamentosDataAtual.isEmpty()) {
            throw new IllegalStateException("Nenhum lançamento encontrado até a data atual.");
        }

        return lancamentosDataAtual;
    } catch (IllegalStateException e) {
        System.out.println("Erro: " + e.getMessage());
        return new ArrayList<>();
    }
}

// ---------------------------------------------------------------------------------------------------------------------------------
/**
* Filtra lançamentos com base em categoria e/ou período.
*
* @param dataInicio a data inicial do período
* @param dataFinal a data final do período
* @return uma lista de lançamentos filtrados
*/
public ArrayList<Lancamento> consultarSaldoPeriodoEspecifico(LocalDate dataInicio, LocalDate dataFinal) {
    try {
        if (dataInicio == null || dataFinal == null) {
            throw new IllegalArgumentException("As datas de início e fim não podem ser nulas.");
        }
        if (dataInicio.isAfter(dataFinal)) {
            throw new IllegalArgumentException("A data de início não pode ser posterior à data final.");
        }
        if (lancamentos.isEmpty()) {
            throw new IllegalStateException("Não há lançamentos para consultar no período especificado.");
        }

        ArrayList<Lancamento> lancamentosPeriodoEspecifico = new ArrayList<>();
        for (Lancamento lancamento : this.lancamentos) {
            if (dataInicio != null && dataFinal != null) {
                if ((lancamento.getData().isEqual(dataInicio) || lancamento.getData().isAfter(dataInicio))
                        && (lancamento.getData().isEqual(dataFinal) || lancamento.getData().isBefore(dataFinal))) {
                    lancamentosPeriodoEspecifico.add(lancamento);
                }
            }
        }

        if (lancamentosPeriodoEspecifico.isEmpty()) {
            throw new IllegalStateException("Nenhum lançamento encontrado no período especificado.");
        }

        return lancamentosPeriodoEspecifico;
    } catch (IllegalArgumentException | IllegalStateException e) {
        System.out.println("Erro: " + e.getMessage());
        return new ArrayList<>();
    }
}

// ---------------------------------------------------------------------------------------------------------------------------------------    
/**
 * Lista todas as receitas da conta.
 *
 * @return lista de receitas
 */
public ArrayList<Lancamento> listarReceitas() {
    try {
        ArrayList<Lancamento> receitas = new ArrayList<>();

        for (Lancamento lancamento : this.getLancamentos()) {
            if (lancamento instanceof Receita) {
                receitas.add(lancamento);
            }
        }

        if (receitas.isEmpty()) {
            throw new IllegalStateException("Nenhuma receita encontrada.");
        }

        return receitas;
    } catch (IllegalStateException e) {
        System.out.println("Erro: " + e.getMessage());
        return new ArrayList<>();
    }
}

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Lista todas as despesas da conta.
     *
     * @return lista de despesas
     */
    public ArrayList<Lancamento> listarDespesas() {
        try{
            ArrayList<Lancamento> despesas = new ArrayList<>();

            for (Lancamento lancamento : this.getLancamentos()) {
                if (lancamento instanceof Despesa) {
                    despesas.add(lancamento);
                }
            }

            if (listarReceitas().isEmpty()) {
                throw new IllegalStateException("Nenhuma despesa encontrada.");
            }
            return despesas;
        }
        catch (IllegalStateException e) {
        System.out.println("Erro: " + e.getMessage());
        return new ArrayList<>();
        }
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Lista os lançamentos ordenados por data.
     *
     * @return lista de lançamentos ordenados por data
     */
    public ArrayList<Lancamento> listarLancamentosOrdenadosData(ArrayList<Lancamento> lancamentos) {
        ArrayList<Lancamento> lancamentosOrdenados = this.lancamentos;
        try {
            if (lancamentos == null) {
                throw new NullPointerException("O lancamentos nao pode ser nulo");
            }
            lancamentosOrdenados.sort(Comparator.comparing(lancamento -> lancamento.getData()));
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lancamentosOrdenados;
    }

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Importa lançamentos de um arquivo de texto.
     *
     * @param arquivo o caminho do arquivo
     * @return o número de lançamentos importados
     * @throws IOException se ocorrer um erro ao ler o arquivo
     */
    public int importarLancamentosParaTXT(String arquivo) throws IOException {
        if (arquivo == null || arquivo.isEmpty()){
            throw new IllegalArgumentException("O caminho do arquivo não pode ser vazio.");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            reader.readLine();                        
            
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length != 4){ 
                    throw new IOException("Formato inválido no arquivo: esperados 4 campos por linha");
                }
                try{                       
                    if (dados.length == 4) {
                        int Id = Integer.parseInt(dados[0].trim());
                        double valor = Double.parseDouble(dados[1].trim());
                        LocalDate data = LocalDate.parse(dados[2].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        String categoria = dados[3].trim();

                        criarLancamentoPorCategoria(Id, valor, data, categoria);
                        System.out.println("Item importado com sucesso!");
                    }
                } 
                catch (NumberFormatException e) {
                    throw new IOException("Erro ao converter ID ou valor em número: " + linha, e);
                } 
                catch (DateTimeParseException e) {
                    throw new IOException("Erro ao interpretar a data no formato dd/MM/yyyy: " + linha, e);
                } 
                catch (IllegalArgumentException e) {                
                    throw new IOException("Erro ao processar categoria: " + e.getMessage() + " Linha: " + linha, e);
                }
                
            }
            System.out.println("Total de itens importados: " + lancamentos.size());
            System.out.println("Todos os dados importados com sucesso!");
        } catch (FileNotFoundException e) {
            throw new IOException("Arquivo não encontrado: " + arquivo, e);
        }
        return lancamentos.size();
    }

// ---------------------------------------------------------------------------------------------------------------------------------------  
    /**
     * Exporta lançamentos para um arquivo de texto.
     *
     * @param arquivo o caminho do arquivo
     * @return mensagem de sucesso
     * @throws IOException se ocorrer um erro ao escrever o arquivo
     */
    public String exportarLancamentosParaTXT(String arquivo) throws IOException {
        if (this.lancamentos.isEmpty()) {
            throw new IllegalStateException("Não há lançamentos para exportar.");
        }
        
        StringBuilder conteudo = new StringBuilder();
        conteudo.append("ID,Valor,Data,Categoria\n");

        for (Lancamento lancamento : this.lancamentos) {
            String linha = String.format(Locale.US, "%s,%.2f,%s,%s\n",
                    lancamento.getId(),
                    lancamento.getValor(),
                    lancamento.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    (lancamento instanceof Receita) ? ((Receita) lancamento).getCategoria()
                            : (lancamento instanceof Despesa) ? ((Despesa) lancamento).getCategoria() : "N/A");
            conteudo.append(linha);
        }      
        System.out.println("Dados exportados para: " + arquivo);
        try (PrintWriter writer = new PrintWriter(arquivo)) {
            writer.write(conteudo.toString());
            return "Dados exportados para: " + arquivo;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao exportar os dados para o arquivo: " + arquivo, e);
        }
    }
// ---------------------------------------------------------------------------------------------------------------------------------------      
    /**
    * Cria um lançamento (Receita ou Despesa) com base nos dados fornecidos. 
    * O tipo do lançamento é determinado automaticamente com base na categoria.
    *
    * @param Id o ID do lançamento
    * @param valor o valor do lançamento
    * @param data a data do lançamento
    * @param categoriaStr a categoria do lançamento como string
    * @return o lançamento criado
    * @throws IllegalArgumentException se a categoria for inválida ou se o ID já existir
    */
    protected Lancamento criarLancamentoPorCategoria(int Id, double valor, LocalDate data, String categoriaStr) {                
        try {
            while (lancamentoExiste(Id)) {
                Id++;
            }      
            try {
                CategoriaReceita categoriaReceita = CategoriaReceita.valueOf(categoriaStr.toUpperCase());
                Receita receita = new Receita(Id, categoriaReceita, valor, data);
                lancamentos.add(receita);
                return receita;
            } 
            catch (IllegalArgumentException e1) {        
                try {
                    CategoriaDespesa categoriaDespesa = CategoriaDespesa.valueOf(categoriaStr.toUpperCase());
                    Despesa despesa = new Despesa(Id, categoriaDespesa, valor, data);
                    lancamentos.add(despesa);
                    return despesa;
                } 
                catch (IllegalArgumentException e2) {            
                    throw new IllegalArgumentException(categoriaStr);
                }
            }
        } 
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Categoria inválida: " + categoriaStr);
        }
    }

// ---------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Exclui um lançamento pelo ID e ajusta o saldo.
     *
     * @param Id o ID do lançamento a ser excluído
     */
    public void excluirLancamentoPorId(int Id) {
        try {
            Lancamento lancamento = null;
            for (Lancamento l : this.lancamentos) {
                if (l.getId() == Id) {
                    lancamento = l;
                    break;
                }
            }
            if (lancamento == null) {
                throw new NullPointerException("Nenhum lancamento com o ID especificado foi encontrado");
            }

            if (lancamento instanceof Receita) {
                setSaldo(getSaldo() - lancamento.getValor());
            } else if (lancamento instanceof Despesa) {
                setSaldo(getSaldo() + lancamento.getValor());
            }

            this.lancamentos.remove(lancamento);
            System.out.println("Lancamento removido com sucesso!");
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
// ---------------------------------------------------------------------------------------------------------------------------------------        
    /**
    * Verifica se existe um lançamento com o ID especificado.
    *
    * @param id o ID do lançamento a ser verificado
    * @return {@code true} se o lançamento existe, {@code false} caso contrário
    */
    public boolean lancamentoExiste(int id) {
        try {                        
            for (Lancamento lancamento : lancamentos) {
                if (lancamento.getId() == id) {
                    return true;
                }
            }            
            throw new IllegalArgumentException("Lançamento com ID " + id + " não encontrado.");
        } 
        catch (IllegalArgumentException e) {            
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }        

// ---------------------------------------------------------------------------------------------------------------------------------------    
    /**
     * Retorna o maior ID dos lançamentos existentes na conta. Caso não existam
     * lançamentos, o método retorna {@code 1}. O próximo ID pode ser gerado
     * adicionando 1 ao maior ID retornado.
     *
     * @return o maior ID encontrado nos lançamentos ou {@code 1} se a lista
     * estiver vazia
     */
    public int getMaiorId() {
        return this.lancamentos.stream()
            .mapToInt(Lancamento::getId)
            .max()
            .orElse(0) + 1;
    }
}
