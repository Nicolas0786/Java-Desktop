package View;

import java.io.IOException;

import javax.swing.JOptionPane;

import Controler.ProdutoController;
import Model.VO.ProdutoVO;

public class MenuProduto {

	private static final int OPCAO_DE_MUDAR_DIRETORIO = 0;
	private static final int OPCAO_INSERIR_PRODUTO_COMID = 1;
	private static final int PROCURAR_PRODUTO_COM_ID = 2;
	private static final int EXIBIR_TODOS_PRODUTOS = 3;
	private static final int EXCLUIR_PRODUTO_POR_ID = 4;
	private static final int SAIR = 5;
	
	
	public void apresentarMenuProduto(ProdutoVO produtoVO) throws IOException {
		//byte opcao = this.apresentarOpcaoMenu();
		byte opcao =0;
		while(opcao >= 0) {
			String opcaoTxt = JOptionPane.showInputDialog("Menu:\n"+ OPCAO_DE_MUDAR_DIRETORIO +": Mudar de Diretorio" + "\n"+ OPCAO_INSERIR_PRODUTO_COMID +": Inserir Novo produto com ID\n"+ PROCURAR_PRODUTO_COM_ID +": Pesquisar produto existente por codigo\n"+EXIBIR_TODOS_PRODUTOS+": Exibir todos os produtos\n"+EXCLUIR_PRODUTO_POR_ID+": Excluir um produto informando o codigo\n"+SAIR+": Encerrar o programa");
			
			if(opcaoTxt == null || opcaoTxt.equals("") || opcaoTxt.equals("5")) {
				opcao = -1;
			}
			
			try {
				opcao = Byte.parseByte(opcaoTxt);
				switch(opcao) {
				case OPCAO_DE_MUDAR_DIRETORIO:
					this.mudarDiretorio();
					break;
				case OPCAO_INSERIR_PRODUTO_COMID:
					this.cadastrarProduto(produtoVO);
					break;
				case PROCURAR_PRODUTO_COM_ID:
					this.exibirProdutoPorCodigo();
					break;
				case EXIBIR_TODOS_PRODUTOS:
					this.exibirTodosProdutos();
					break;
				case EXCLUIR_PRODUTO_POR_ID:
					this.excluirProdutoPorID();
					break;
				default:
					opcao = -1;
				}
			}catch(NumberFormatException e) {
				opcao = -1;
				e.printStackTrace();
			}
			
			
		}
	}


	private void mudarDiretorio() throws IOException {
		//JOptionPane.showInputDialog("Selecione um diretorio");
		ProdutoController produtoController = new ProdutoController();
		produtoController.mudarDiretorioController();
		
	}


	private void excluirProdutoPorID() throws IOException {
		String  produtoVO1 = ""; 
		
		short codigo = Short.parseShort(JOptionPane.showInputDialog("Digite o Codigo do Produto para Excluir"));
		
		produtoVO1(String.valueOf(codigo));
		
		//ProdutoController produtoControllerVO = new ProdutoController();
		//produtoVO1 = produtoControllerVO.excluirProdutoPorCodigo(produtoVO1);
	}


	private void produtoVO1(String codigo) throws IOException {
		ProdutoController produtoControllerVO = new ProdutoController();
		produtoControllerVO.excluirProdutoPorCodigo(codigo);
	}


	private void exibirTodosProdutos() throws IOException {
		String conteudo = exibiTodosProdutos();
		//int linhas = conteudo.split("\n").length;
		JOptionPane.showMessageDialog(null, conteudo);
	}


	private String exibiTodosProdutos() throws IOException {
		ProdutoController produtoController = new ProdutoController();
		return produtoController.exibirTodosProdutosController();
	}


	private void  exibirProdutoPorCodigo() throws IOException {
		ProdutoVO  produtoVO1 = new ProdutoVO(); 
		
		produtoVO1.setCodigo(Short.parseShort(JOptionPane.showInputDialog("Digite o Codigo do Produto para Exibir")));
		
		ProdutoController produtoControllerVO = new ProdutoController();
		produtoVO1 = produtoControllerVO.exibirProdutoPorCodigo(produtoVO1);
		
		JOptionPane.showMessageDialog(null, produtoVO1);
	}


	private void cadastrarProduto(ProdutoVO produtoVO) throws IOException {
		
			String nome = JOptionPane.showInputDialog("Digite o nome do produto");
			float preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o preço do Produto"));  
			short codigo = Short.parseShort(JOptionPane.showInputDialog("Digite o codigo do Produto"));
			
			produtoVO.setNome(nome);
			produtoVO.setPreco(preco);
			produtoVO.setCodigo(codigo);
			
			ProdutoController produtoController = new ProdutoController();
			produtoVO = produtoController.cadastrarProdutoController(produtoVO);
			
			
	}
	
	
}


