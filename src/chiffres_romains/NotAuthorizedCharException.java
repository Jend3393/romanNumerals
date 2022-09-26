package chiffres_romains;

public class NotAuthorizedCharException extends Exception {
	
	public NotAuthorizedCharException() {
		super();
	}
	
	public NotAuthorizedCharException(String message) {
		super(message);
	}
	
	public NotAuthorizedCharException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NotAuthorizedCharException(Throwable cause) {
		super(cause);
	}

}
