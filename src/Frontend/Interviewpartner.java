package Frontend;

public class Interviewpartner {
	private int id;
	private String name;
	private int maxAnsehen;
	private int schwierigkeit;

	public Interviewpartner(int id, String name, int maxAnsehen, int schwierigkeit) {
		super();
		this.id = id;
		this.name = name;
		this.maxAnsehen = maxAnsehen;
		this.schwierigkeit = schwierigkeit;
	}

	@Override
	public String toString() {

		return "ID: " + id + " \nname: " + name + " \nmaxAnsehen: " + maxAnsehen + " \nschwierigkeit:" + schwierigkeit
				+ "\n";
	}

}
