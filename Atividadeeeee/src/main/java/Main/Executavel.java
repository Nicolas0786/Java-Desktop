package Main;

import java.io.IOException;

import Model.VO.ProdutoVO;
import View.MenuProduto;

public class Executavel {

	public static void main(String[] args) throws IOException {
		ProdutoVO produtoVO = new ProdutoVO();
		MenuProduto menuProduto = new MenuProduto();
		menuProduto.apresentarMenuProduto(produtoVO);

	}

}
