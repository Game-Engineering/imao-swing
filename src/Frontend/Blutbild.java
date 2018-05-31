package Frontend;

public class Blutbild {
	private int budget;
	private String name;
	private float Erythrozyten;
	private float Leukozyten;
	private float Thrombozyten;
	private float Haemoglobinkonzentration;
	private float Haematokrit;
	private float MCH;
	private float MCHC;
	private float MCV;

	@Override
	public String toString() {
		return "<html>Erythrozyten: " + Erythrozyten + "<br>Leukozyten: " + Leukozyten + "<br>Thrombozyten: "
				+ Thrombozyten + "<br>Haemoglobinkonzentration: " + Haemoglobinkonzentration + "<br>Haematokrit: "
				+ Haematokrit + "<br>MCH: " + MCH + "<br>MCHC: " + MCHC + "<br>MCV: " + MCV + "</html>";
	}

}
