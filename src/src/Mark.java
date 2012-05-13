package src;

public enum Mark {
	Empty, X, O, Null;

	@Override
	public String toString() {
		if (this == Mark.Empty) {
			return ".";
		}
		return super.toString();
	}

	public static Mark createMarkFromString(String c) {
		if (c.equals(Mark.X.toString())) {
			return Mark.X;
		}
		else if (c.equals(Mark.O.toString())) {
			return Mark.O;
		}
		return Mark.Empty;
	}
	
	
}
