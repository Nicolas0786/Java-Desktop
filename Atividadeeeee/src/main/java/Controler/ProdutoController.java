package Controler;


import java.io.IOException;
import Model.BO.ProdutoBO;
import Model.VO.ProdutoVO;

public class ProdutoController {

	public ProdutoVO cadastrarProdutoController(ProdutoVO produtoVO) throws IOException {
		ProdutoBO produtoBO = new ProdutoBO();
		return produtoBO.cadastrarProdutoBO(produtoVO);
	}

	public ProdutoVO exibirProdutoPorCodigo(ProdutoVO produtoVO) throws IOException {
		ProdutoBO produtoBO = new ProdutoBO();
		return produtoBO.exibirProdutoPorCodigoBO(produtoVO);
	}

	public String exibirTodosProdutosController() throws IOException {
		ProdutoBO produtoBO = new ProdutoBO();
		return produtoBO.exibirTodosProdutosBO();
		
	}

	public String excluirProdutoPorCodigo(String codigo) throws IOException {
		ProdutoBO produtoBO = new ProdutoBO();
		return produtoBO.excluirProdutoPorCodigoBO(codigo);
	}

	public void mudarDiretorioController() throws IOException {
		ProdutoBO produtoBO = new ProdutoBO();
		produtoBO.mudarDiretorioBO();
		
	}

	

}
