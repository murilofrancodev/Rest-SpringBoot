package com.marketplace.mf;

import java.util.Arrays;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marketplace.mf.domain.Categoria;
import com.marketplace.mf.domain.Cidade;
import com.marketplace.mf.domain.Cliente;
import com.marketplace.mf.domain.Endereco;
import com.marketplace.mf.domain.Estado;
import com.marketplace.mf.domain.PagamentoComCartao;
import com.marketplace.mf.domain.Pedido;
import com.marketplace.mf.domain.Produto;
import com.marketplace.mf.domain.Pagamento;
import com.marketplace.mf.domain.PagamentoComBoleto;
import com.marketplace.mf.domain.enums.EstadoPagamento;
import com.marketplace.mf.domain.enums.TipoCliente;
import com.marketplace.mf.repositories.CategoriaRepository;
import com.marketplace.mf.repositories.CidadeRepository;
import com.marketplace.mf.repositories.ClienteRepository;
import com.marketplace.mf.repositories.EnderecoRepository;
import com.marketplace.mf.repositories.EstadoRepository;
import com.marketplace.mf.repositories.PagamentoRepository;
import com.marketplace.mf.repositories.PedidoRepository;
import com.marketplace.mf.repositories.ProdutoRepository;

@SpringBootApplication
public class DevApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DevApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Murilo Franco", "murilofrancodev@gmail.com", "40563844590", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("11953505545", "11998754898"));

		Endereco e1 = new Endereco(null, "Rua Ancara", "150", "Fundo", "Centro", "09450000", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Bartolomeu", "120", null, "Centro", "09220420", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
	}

}