package Model.VO;

public class ProdutoVO {

	
	private String nome;
	private float preco;
	private short codigo;
	
	
	
	public ProdutoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProdutoVO(String nome, float preco, short codigo) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public short getCodigo() {
		return codigo;
	}
	public void setCodigo(short codigo) {
		this.codigo = codigo;
	}
	@Override
	public String toString() {
		return nome + ", " + preco + ", " + codigo;
	}
	
	
	
}
	
	
	
	