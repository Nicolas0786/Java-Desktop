package Model.BO;


import java.io.IOException;


import Model.DAO.ProdutoDAO;
import Model.VO.ProdutoVO;

public class ProdutoBO {

	
	public ProdutoVO cadastrarProdutoBO(ProdutoVO produtoVO) throws IOException {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.cadastrarProdutoDAO(produtoVO);
		
	}

	public ProdutoVO exibirProdutoPorCodigoBO(ProdutoVO produtoVO) throws IOException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.exibirProdutoPorCodigoDAO(produtoVO.getCodigo());

	}

	public String exibirTodosProdutosBO() throws IOException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.exibirTodosProdutosDAO();
	}

	public String excluirProdutoPorCodigoBO(String codigo) throws IOException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.excluirProdutoPorCodigoDAO(codigo);
	}

	public void mudarDiretorioBO() throws IOException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.mudarDiretorioDAO();
		
	}


}
