package Frontend;

public class Patient {
	public int erscheinung;
	public int ID;

	@Override
	public String toString() {

		return "Erscheinung: " + erscheinung + " ID: " + ID + "\n";
	}

	public int getErscheinung() {
		return erscheinung;
	}

	public int getID() {
		return ID;
	}

}
