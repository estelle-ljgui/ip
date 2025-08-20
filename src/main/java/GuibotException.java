public class GuibotException extends Exception {
	private String message;

	public GuibotException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
