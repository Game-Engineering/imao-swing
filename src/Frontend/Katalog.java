package Frontend;

import java.util.List;

public class Katalog {
	List<KatalogEintrag> methoden;

	public Katalog() {
		// TODO Auto-generated constructor stub
	}

	public Katalog(List<KatalogEintrag> methoden) {
		super();
		this.methoden = methoden;
	}

	@Override
	public String toString() {
		String erg = "";
		for (KatalogEintrag eintrag : methoden) {
			erg += eintrag.toString();
		}
		return erg;
	}

}
