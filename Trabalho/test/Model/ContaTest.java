package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContaTest {

    @Test
    public void test01_IncluirLancamentoTipoReceita() {
        Pessoa titular = new Pessoa();
        Conta conta = new Conta(titular);
        Receita receita = new Receita(1, CategoriaReceita.SALARIO, 100.1, LocalDate.now());

        conta.incluirLancamento(receita);

        assertEquals(100.1, conta.getSaldo(), 0.0);
    }

    @Test
    public void test02_IncluirLancamentoTipoDespesa() {
        Pessoa titular = new Pessoa();
        Conta conta = new Conta(titular);
        Despesa despesa = new Despesa(1, CategoriaDespesa.AGUA, 53.0, LocalDate.now());

        conta.incluirLancamento(despesa);

        assertEquals(-53.0, conta.getSaldo(), 0.0);
    }

    @Test
    public void test03_ConsultarSaldoDataAtualComLancamentosFuturos() {
        Conta conta = new Conta(new Pessoa());
        conta.incluirLancamento(new Receita(1, CategoriaReceita.SALARIO, 1000, LocalDate.now()));
        conta.incluirLancamento(new Receita(2, CategoriaReceita.INVESTIMENTOS, 500, LocalDate.now().plusDays(1)));

        double saldoDataAtual = 0;

        for (Lancamento lancamento : conta.consultarSaldoDataAtual()) {
            saldoDataAtual += lancamento.getValor();
        }

        assertEquals(1000, saldoDataAtual, 0.0);
    }

    @Test
    public void test04_ConsultarSaldoPeriodoEspecifico() {
        Pessoa titular = new Pessoa();
        Conta conta = new Conta(titular);
        Receita receita = new Receita(1, CategoriaReceita.FERIAS, 589.0, LocalDate.now());
        Receita receita2 = new Receita(2, CategoriaReceita.VALE_TRANSPORTE, 122.12, LocalDate.of(2025, Month.JANUARY, 10));
        Despesa despesa = new Despesa(3, CategoriaDespesa.ALIMENTACAO, 89.0, LocalDate.now());

        conta.incluirLancamento(receita);
        conta.incluirLancamento(receita2);
        conta.incluirLancamento(despesa);

        double saldoPeriodoEspecifico = 0;

        for (Lancamento lancamento : conta.consultarSaldoPeriodoEspecifico(LocalDate.now().plusDays(1), LocalDate.of(2025, Month.JANUARY, 11))) {
            saldoPeriodoEspecifico += lancamento.getValor();
        }

        assertEquals(122.12, saldoPeriodoEspecifico, 0.0);
    }

    @Test
    public void test05_ListarReceitas() {
        Pessoa titular = new Pessoa();
        Conta conta = new Conta(titular);

        Despesa despesa = new Despesa(1, CategoriaDespesa.SAUDE, 402.56, LocalDate.of(2024, Month.MARCH, 20));
        Receita receita = new Receita(2, CategoriaReceita.INVESTIMENTOS, 1080.0, LocalDate.of(2024, Month.OCTOBER, 01));
        Receita receita2 = new Receita(3, CategoriaReceita.ALUGUEL_DE_IMOVEL, 169.99, LocalDate.of(2024, Month.AUGUST, 06));

        conta.incluirLancamento(despesa);
        conta.incluirLancamento(receita);
        conta.incluirLancamento(receita2);

        assertEquals(Month.OCTOBER, conta.listarReceitas().get(0).getData().getMonth());
    }

    @Test
    public void test06_ListarDespesas() {
        Pessoa titular = new Pessoa();
        Conta conta = new Conta(titular);

        Despesa despesa = new Despesa(1, CategoriaDespesa.SAUDE, 402.56, LocalDate.of(2024, Month.MARCH, 20));
        Receita receita = new Receita(2, CategoriaReceita.INVESTIMENTOS, 1080.0, LocalDate.of(2024, Month.OCTOBER, 01));
        Despesa despesa2 = new Despesa(3, CategoriaDespesa.INTERNET_TELEFONE, 169.99, LocalDate.of(2024, Month.AUGUST, 06));

        conta.incluirLancamento(despesa);
        conta.incluirLancamento(receita);
        conta.incluirLancamento(despesa2);

        assertEquals(169.99, conta.listarDespesas().get(1).getValor(), 0.0);
    }

    @Test
    public void test07_ListarLancamentosOrdenadosData() {
        Pessoa titular = new Pessoa();
        Conta conta = new Conta(titular);

        Receita receita = new Receita(1, CategoriaReceita.INVESTIMENTOS, 1080.0, LocalDate.of(2024, Month.OCTOBER, 01));
        Despesa despesa = new Despesa(2, CategoriaDespesa.SAUDE, 402.56, LocalDate.of(2024, Month.MARCH, 20));

        conta.incluirLancamento(receita);
        conta.incluirLancamento(despesa);

        assertEquals(402.56, conta.listarLancamentosOrdenadosData(conta.getLancamentos()).get(0).getValor(), 0.0);
    }

    @Test
    public void test08_ListarLancamentosComListaVazia() {
        Conta conta = new Conta(new Pessoa());
        assertTrue(conta.listarReceitas().isEmpty());
        assertTrue(conta.listarDespesas().isEmpty());
        assertTrue(conta.listarLancamentosOrdenadosData(new ArrayList<>()).isEmpty());
    }

    @Test
    public void test09_ImportarLancamentosParaTXT() throws FileNotFoundException, IOException {
        String arquivo = "testes08_lancamentos.txt";
        try (PrintWriter writer = new PrintWriter(arquivo)) {
            writer.println("ID,Valor,Data,Categoria");
            writer.println("1,2500.0,10/11/2024,SALARIO");
            writer.println("2,500.0,15/11/2024,ALIMENTACAO");
        }

        Pessoa titular = new Pessoa();
        Conta conta = new Conta(titular);
        conta.importarLancamentosParaTXT(arquivo);

        ArrayList<Lancamento> lancamentos = conta.getLancamentos();
        assertEquals(2, lancamentos.size());

        Lancamento lancamento1 = lancamentos.get(0);
        assertTrue(lancamento1 instanceof Receita);
        assertEquals(1, lancamento1.getId());
        assertEquals(2500.0, lancamento1.getValor(), 0.01);
        assertEquals(LocalDate.of(2024, 11, 10), lancamento1.getData());
        //Vai dar erro pq e uma string a  nao ser que transforme
        //assertEquals("SALARIO", ((Receita) lancamento1).getCategoria());

        Lancamento lancamento2 = lancamentos.get(1);
        assertTrue(lancamento2 instanceof Despesa);
        assertEquals(2, lancamento2.getId());
        assertEquals(500.0, lancamento2.getValor(), 0.01);
        assertEquals(LocalDate.of(2024, 11, 15), lancamento2.getData());
        //Vai dar erro pq e uma string a  nao ser que transforme
        // assertEquals("ALIMENTACAO", ((Despesa) lancamento2).getCategoria());

        new File(arquivo).delete();
    }

    @Test(expected = IOException.class)
    public void test10_ImportarLancamentosComArquivoInvalido() throws IOException {
        Conta conta = new Conta(new Pessoa());
        conta.importarLancamentosParaTXT("arquivo_inexistente.txt");
    }

    @Test
    public void test11_ExportarLancamentosParaTXT() throws FileNotFoundException, IOException {
        String arquivo = "testes09_lancamentos.txt";
        Receita receita = new Receita(1, CategoriaReceita.SALARIO, 2500.0, LocalDate.of(2024, 11, 10));
        Despesa despesa = new Despesa(2, CategoriaDespesa.ALIMENTACAO, 500.0, LocalDate.of(2024, 11, 15));

        ArrayList<Lancamento> lancamentos = new ArrayList<>();
        lancamentos.add(receita);
        lancamentos.add(despesa);

        Pessoa titular = new Pessoa();
        Conta conta = new Conta(titular);
        conta.incluirLancamento(receita);
        conta.incluirLancamento(despesa);
        conta.exportarLancamentosParaTXT(arquivo);

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha = reader.readLine();
            assertEquals("ID,Valor,Data,Categoria", linha);

            linha = reader.readLine();
            assertEquals("1,2500.00,10/11/2024,SALARIO", linha);

            linha = reader.readLine();
            assertEquals("2,500.00,15/11/2024,ALIMENTACAO", linha);
        }
        new File(arquivo).delete();
    }

    @Test(expected = IllegalStateException.class)
    public void test12_ExportarLancamentosComListaVazia() throws IOException {
        Conta conta = new Conta(new Pessoa());
        String resultado = conta.exportarLancamentosParaTXT("lancamentos_vazios.txt");
        assertEquals("Dados exportados para: lancamentos_vazios.txt", resultado);
    }

    @Test
    public void test13_CriarLancamentoPorCategoria() {
        Pessoa titular = new Pessoa();
        Conta conta = new Conta(titular);

        Lancamento lancamento = conta.criarLancamentoPorCategoria(1, 200, LocalDate.of(2024, Month.AUGUST, 1), "SALARIO");

        assertEquals(1, lancamento.getId());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test14_CriarLancamentoComCategoriaInvalida() {
        Conta conta = new Conta(new Pessoa());
        Lancamento lancamento = conta.criarLancamentoPorCategoria(1, 1000, LocalDate.of(2024, Month.DECEMBER, 1), "CATEGORIA_INVALIDA");
        assertNull(lancamento);
        assertTrue(conta.getLancamentos().isEmpty());
    }

    @Test
    public void test15_ExcluirLancamentoPorId() {
        Pessoa titular = new Pessoa();
        Conta conta = new Conta(titular);
        Receita receita = new Receita(1, CategoriaReceita.SALARIO, 100.1, LocalDate.now());

        conta.incluirLancamento(receita);
        conta.excluirLancamentoPorId(1);

        assertEquals(0.0, conta.getSaldo(), 0.0);
    }

    @Test
    public void test16_ExcluirTodosOsLancamentos() {
        Conta conta = new Conta(new Pessoa());
        conta.incluirLancamento(new Receita(1, CategoriaReceita.SALARIO, 1000, LocalDate.now()));
        conta.incluirLancamento(new Despesa(2, CategoriaDespesa.MORADIA, 500, LocalDate.now()));

        conta.excluirLancamentoPorId(1);
        conta.excluirLancamentoPorId(2);

        assertTrue(conta.getLancamentos().isEmpty());
        assertEquals(0.0, conta.getSaldo(), 0.0);
    }

    @Test
    public void test17_ExcluirLancamentoComIdInexistente() {
        Conta conta = new Conta(new Pessoa());
        conta.incluirLancamento(new Receita(1, CategoriaReceita.SALARIO, 1000, LocalDate.now()));
        conta.excluirLancamentoPorId(2); // ID inexistente
        assertEquals(1000, conta.getSaldo(), 0.0);
    }

    @Test
    public void test18_GetMaiorId() {
        Pessoa titular = new Pessoa();
        Conta conta = new Conta(titular);
        assertEquals(1, conta.getMaiorId(), 0.0);
    }
}
