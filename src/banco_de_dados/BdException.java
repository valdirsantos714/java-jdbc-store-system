package banco_de_dados;

public class BdException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BdException(String msg) {
		super(msg);
	}
}
