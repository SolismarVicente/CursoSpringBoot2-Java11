package com.educandoweb.cursojpa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.cursojpa.entities.Categoria;
import com.educandoweb.cursojpa.entities.ItemPedido;
import com.educandoweb.cursojpa.entities.Pagamento;
import com.educandoweb.cursojpa.entities.Pedido;
import com.educandoweb.cursojpa.entities.Produto;
import com.educandoweb.cursojpa.entities.Usuario;
import com.educandoweb.cursojpa.entities.enums.StatusPedido;
import com.educandoweb.cursojpa.repositories.RepositorioCategoria;
import com.educandoweb.cursojpa.repositories.RepositorioItemPedido;
import com.educandoweb.cursojpa.repositories.RepositorioPedido;
import com.educandoweb.cursojpa.repositories.RepositorioProduto;
import com.educandoweb.cursojpa.repositories.RepositorioUsuario;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Autowired
	private RepositorioPedido repositorioPedido;

	@Autowired
	private RepositorioCategoria repositorioCategoria;

	@Autowired
	private RepositorioProduto repositorioProduto;
	
	@Autowired
	private RepositorioItemPedido repositorioItemPedido;

	@Override
	public void run(String... args) throws Exception {
		//atributos do usuario: codigo, nomeUsuario,
		//emailUsuario, telefoneUsuario e senhaUsuario
		Usuario usu1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario usu2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		//salvar os dados do usuário na tb_usuario
		repositorioUsuario.saveAll(Arrays.asList(usu1, usu2));
		
		//atributos da categoria: codigo e nomeCategoria
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		//salvar os dados do usuário na tb_categoria
		repositorioCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		//atributos do produto: código, nomeProduto,
		//descricaoProduto, precoProduto, imgUrl
		Produto prod1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto prod2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto prod3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto prod4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto prod5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		//salvar os dados do usuário na tb_produto
		repositorioProduto.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));
		
		// Após instanciar a categorias e os produtos e salvar
		// tenho que falar qual categoria de qual produto
		prod1.getCategorias().add(cat2);
		prod2.getCategorias().add(cat1);
		prod2.getCategorias().add(cat3);
		prod3.getCategorias().add(cat3);
		prod3.getCategorias().add(cat3);
		prod4.getCategorias().add(cat3);
		prod5.getCategorias().add(cat2);
		
		// salvar os produtos com associação
		//salvar os dados do usuário na tb_produto_categoria
		repositorioProduto.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));
		
		//atributos do pedido: codigo, momento, statusPedido e 
		//cliente(usuario)
		Pedido ped1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAID, usu1);
		Pedido ped2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.WAITING_PAYMENT, usu2);
		Pedido ped3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.WAITING_PAYMENT, usu1);
		//salvar os dados do usuário na tb_pedido
		repositorioPedido.saveAll(Arrays.asList(ped1, ped2, ped3));
		
		//atributos do ItemPedido: pedigo, produto, 
		//quantidade e preco
		ItemPedido itemPed1 = new ItemPedido(ped1, prod1, 2, prod1.getPrecoProduto());
		ItemPedido itemPed2 = new ItemPedido(ped1, prod3, 1, prod3.getPrecoProduto());
		ItemPedido itemPed3 = new ItemPedido(ped2, prod3, 2, prod3.getPrecoProduto());
		ItemPedido itemPed4 = new ItemPedido(ped3, prod5, 2, prod5.getPrecoProduto());
		//salvar os dados do usuário na tb_item_pedido
		repositorioItemPedido.saveAll(Arrays.asList(itemPed1, itemPed2, itemPed3, itemPed4));
		
		Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), ped1);
		//Vou associar o ped1 ao pag1
		ped1.setPagamento(pag1);
		repositorioPedido.saveAll(Arrays.asList(ped1));
	}

}
