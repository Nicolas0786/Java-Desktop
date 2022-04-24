package Model.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFileChooser;

import Model.VO.ProdutoVO;

public class ProdutoDAO {
	
	String produto_path = "C:\\Users\\Nicol\\Desktop\\avaliacao\\produto.txt";
	String dataLog_path = "C:\\Users\\Nicol\\Desktop\\avaliacao\\log.txt";
	 String path_file = "";
	String localTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	

	public ProdutoVO cadastrarProdutoDAO(ProdutoVO produtoVO) throws IOException {
		
		File f = new File(produto_path);
		try {
			FileOutputStream fos = new FileOutputStream(f, true);
			fos.write(new String(produtoVO.toString() + "\n").getBytes());
			fos.close();
			//String produtoTXT = "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataLog("Produto Inserido ".toUpperCase());
		
	}


	private ProdutoVO dataLog(String mensagemLog) throws IOException {
		mensagemLog = localTime + " - " + mensagemLog;
		
		
		File f = new File(dataLog_path);
		FileOutputStream fos = new FileOutputStream(f, true);
		fos.write(mensagemLog.getBytes());
		fos.write("\n".getBytes());
		fos.close();
		System.out.println("Executando");
		
		
		return null;
		
	}


	public ProdutoVO exibirProdutoPorCodigoDAO(short codigo) throws IOException {
		File f = new File(produto_path);
		ProdutoVO produto =  new ProdutoVO();
		
		try {
			FileInputStream fis = new FileInputStream(f);
			byte[] dados = fis.readAllBytes();
			String conteudoArquivo = new String(dados);
			String[] linhas = conteudoArquivo.split("\n");
			fis.close();
			
			//lista = new ProdutoVO[linhas.length];
			//int i =0;		
			for(String linha: linhas) {
				//ProdutoVO produtoVO1 = new ProdutoVO();
				//lista[i] = produtoVO1;
				String[] colunas = linha.split(",");
				if(colunas[2].trim().equals(String.valueOf(codigo))) {
				produto.setNome(colunas[0]);
				produto.setPreco(Float.parseFloat(colunas[1].trim()));
				produto.setCodigo(Short.parseShort(colunas[2].trim()));
				
				}
				
				//i++;
				//return produto;
			}
			} catch (Exception e) {
			System.out.println(e);
		}
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.dataLog("Exibiu o produto selecionado".toUpperCase());
		return produto;
}


	public String exibirTodosProdutosDAO() throws IOException {
		String retorno = "";
		File f = new File(produto_path);
		try {
			FileInputStream fis = new FileInputStream(f);
			byte[] conteudo = fis.readAllBytes();
			retorno = new String(conteudo);
			retorno = retorno.replaceAll(",", " - ");
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.dataLog("Exibiu todos Produtos".toUpperCase());
		return retorno;
	}


	public  String excluirProdutoPorCodigoDAO(String codigo) throws IOException {
		File f = new File(produto_path);
		//ProdutoVO produtoVO1 = new ProdutoVO();
		String produto = "";
		//String retorno = "";
		
		try {
			FileInputStream fis = new FileInputStream(f);
			byte[] conteudo = fis.readAllBytes();
			produto = new String(conteudo);
			//retorno = new String(conteudo);
			String[] linhas = produto.split("\n");
			String novoTexto = "";
			
			//int i=0;
				for(String linha: linhas) {
				String[] colunas = linha.split(", ");
				if(!colunas[2].trim().equals(codigo)) {
					novoTexto = novoTexto + linha +"\n";
				}
				//i ++;
			}
			
			FileOutputStream fos = new FileOutputStream(f, false);
			fos.write(new String(novoTexto).getBytes());
			fos.close();
			fis.close();
			System.out.println(novoTexto);
			//return retorno;
		} catch (Exception e) {
			System.out.println(e);
		}
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.dataLog("Excluiu o Produto Selecionado".toUpperCase());
		return produto;
	}


	public void mudarDiretorioDAO() throws IOException {
		final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setMultiSelectionEnabled(true);
        int retorno = fc.showDialog(null,"Confirmar Seleção");
        //fc.showOpenDialog(null); //blocking method
        //fc.showSaveDialog(null); 
        if(retorno == JFileChooser.APPROVE_OPTION) {
            File[] files = fc.getSelectedFiles();
             File file = fc.getSelectedFile();
            // System.out.println(file.getAbsoluteFile());
            for(File f: files){
              // System.out.println(f.getAbsoluteFile());
            	  path_file(String.valueOf(f.getAbsoluteFile()));
            }
        }else if(retorno == JFileChooser.CANCEL_OPTION) {
            System.out.println("Seleção cancelada");
        }else if(retorno == JFileChooser.ERROR_OPTION) {
            System.out.println("Seleção abortada...");
        }
			
		
	}


	private void path_file(String file) throws IOException {
		//System.out.println(file);
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.dataLog("O diretorio Foi Alterado".toUpperCase());
		
	}


	
	


	
}
