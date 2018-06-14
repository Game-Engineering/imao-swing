package Frontend;

public class Blutbild {
	private int budget;
	private String name;

	private float Haemoglobinkonzentration;
	private float Haemoglobinkonzentration_min_normal;
	private float Haemoglobinkonzentration_max_normal;
	private float Haemoglobinkonzentration_min_veringert;
	private float Haemoglobinkonzentration_max_veringert;
	private float Haemoglobinkonzentration_min_erhoeht;
	private float Haemoglobinkonzentration_max_erhoeht;
	private float Leukozyten;
	private float Leukozyten_min_normal;
	private float Leukozyten_max_normal;
	private float Leukozyten_min_veringert;
	private float Leukozyten_max_veringert;
	private float Leukozyten_min_erhoeht;
	private float Leukozyten_max_erhoeht;
	private float Thrombozyten;
	private float Thrombozyten_min_normal;
	private float Thrombozyten_max_normal;
	private float Thrombozyten_min_veringert;
	private float Thrombozyten_max_veringert;
	private float Thrombozyten_min_erhoeht;
	private float Thrombozyten_max_erhoeht;
	private float Haematokrit;
	private float Haematokrit_min_normal;
	private float Haematokrit_max_normal;
	private float Haematokrit_min_veringert;
	private float Haematokrit_max_veringert;
	private float Haematokrit_min_erhoeht;
	private float Haematokrit_max_erhoeht;
	private float MCH;
	private float MCH_min_normal;
	private float MCH_max_normal;
	private float MCH_min_veringert;
	private float MCH_max_veringert;
	private float MCH_min_erhoeht;
	private float MCH_max_erhoeht;
	private float MCHC;
	private float MCHC_min_normal;
	private float MCHC_max_normal;
	private float MCHC_min_veringert;
	private float MCHC_max_veringert;
	private float MCHC_min_erhoeht;
	private float MCHC_max_erhoeht;
	private float MCV;
	private float MCV_min_normal;
	private float MCV_max_normal;
	private float MCV_min_veringert;
	private float MCV_max_veringert;
	private float MCV_min_erhoeht;
	private float MCV_max_erhoeht;

	public boolean inHaemoglobinkonzentrationNormal() {
		return Haemoglobinkonzentration > Haemoglobinkonzentration_min_normal
				&& Haemoglobinkonzentration < Haemoglobinkonzentration_max_normal;
	}

	public boolean inHaemoglobinkonzentrationVerringert() {
		return Haemoglobinkonzentration > Haemoglobinkonzentration_min_normal
				&& Haemoglobinkonzentration < Haemoglobinkonzentration_max_veringert;
	}

	public boolean inHaemoglobinkonzentrationERhoet() {
		return Haemoglobinkonzentration > Haemoglobinkonzentration_min_erhoeht
				&& Haemoglobinkonzentration < Haemoglobinkonzentration_max_erhoeht;
	}

	public String getHaemoglobinkonzentrationNormalBereich() {
		return Haemoglobinkonzentration_min_normal + " - " + Haemoglobinkonzentration_max_normal;
	}

	public String getHaemoglobinkonzentrationVeringertBereich() {
		return Haemoglobinkonzentration_min_veringert + " - " + Haemoglobinkonzentration_max_veringert;
	}

	public String getHaemoglobinkonzentrationErhoetBereich() {
		return Haemoglobinkonzentration_min_erhoeht + " - " + Haemoglobinkonzentration_max_erhoeht;
	}

	public boolean inLeukozytenNormal() {
		return Leukozyten > Leukozyten_min_normal && Leukozyten < Leukozyten_max_normal;
	}

	public boolean inLeukozytenVerringert() {
		return Leukozyten > Leukozyten_min_veringert && Leukozyten < Leukozyten_max_veringert;
	}

	public boolean inLeukozytenERhoet() {
		return Leukozyten > Leukozyten_min_erhoeht && Leukozyten < Leukozyten_max_erhoeht;
	}

	public String getLeukozytenNormalBereich() {
		return Leukozyten_min_normal + " - " + Leukozyten_max_normal;
	}

	public String getLeukozytenVeringertBereich() {
		return Leukozyten_min_veringert + " - " + Leukozyten_max_veringert;
	}

	public String getLeukozytenErhoetBereich() {
		return Leukozyten_min_erhoeht + " - " + Leukozyten_max_erhoeht;
	}

	public boolean inThrombozytenNormal() {
		return Thrombozyten > Thrombozyten_min_normal && Thrombozyten < Thrombozyten_max_normal;
	}

	public boolean inThrombozytenVerringert() {
		return Thrombozyten > Thrombozyten_min_veringert && Thrombozyten < Thrombozyten_max_veringert;
	}

	public boolean inThrombozytenERhoet() {
		return Thrombozyten > Thrombozyten_min_erhoeht && Thrombozyten < Thrombozyten_max_erhoeht;
	}

	public String getThrombozytenNormalBereich() {
		return Thrombozyten_min_normal + " - " + Thrombozyten_max_normal;
	}

	public String getThrombozytenVeringertBereich() {
		return Thrombozyten_min_veringert + " - " + Thrombozyten_max_veringert;
	}

	public String getThrombozytenErhoetBereich() {
		return Thrombozyten_min_erhoeht + " - " + Thrombozyten_max_erhoeht;
	}

	public boolean inHaematokritNormal() {
		return Haematokrit > Haematokrit_min_normal && Haematokrit < Haematokrit_max_normal;
	}

	public boolean inHaematokritVerringert() {
		return Haematokrit > Haematokrit_min_veringert && Haematokrit < Haematokrit_max_veringert;
	}

	public boolean inHaematokritERhoet() {
		return Haematokrit > Haematokrit_min_erhoeht && Haematokrit < Haematokrit_max_erhoeht;
	}

	public String getHaematokritNormalBereich() {
		return Haematokrit_min_normal + " - " + Haematokrit_max_normal;
	}

	public String getHaematokritVeringertBereich() {
		return Haematokrit_min_veringert + " - " + Haematokrit_max_veringert;
	}

	public String getHaematokritErhoetBereich() {
		return Haematokrit_min_erhoeht + " - " + Haematokrit_max_erhoeht;
	}

	public boolean inMCHNormal() {
		return MCH > MCH_min_normal && MCH < MCH_max_normal;
	}

	public boolean inMCHVerringert() {
		return MCH > MCH_min_veringert && MCH < MCH_max_veringert;
	}

	public boolean inMCHERhoet() {
		return MCH > MCH_min_erhoeht && MCH < MCH_max_erhoeht;
	}

	public String getMCHNormalBereich() {
		return MCH_min_normal + " - " + MCH_max_normal;
	}

	public String getMCHVeringertBereich() {
		return MCH_min_veringert + " - " + MCH_max_veringert;
	}

	public String getMCHErhoetBereich() {
		return MCH_min_erhoeht + " - " + MCH_max_erhoeht;
	}

	public boolean inMCHCNormal() {
		return MCHC > MCHC_min_normal && MCHC < MCHC_max_normal;
	}

	public boolean inMCHCVerringert() {
		return MCHC > MCHC_min_veringert && MCHC < MCHC_max_veringert;
	}

	public boolean inMCHCERhoet() {
		return MCHC > MCHC_min_erhoeht && MCHC < MCHC_max_erhoeht;
	}

	public String getMCHCNormalBereich() {
		return MCHC_min_normal + " - " + MCHC_max_normal;
	}

	public String getMCHCVeringertBereich() {
		return MCHC_min_veringert + " - " + MCHC_max_veringert;
	}

	public String getMCHCErhoetBereich() {
		return MCHC_min_erhoeht + " - " + MCHC_max_erhoeht;
	}

	public boolean inMCVNormal() {
		return MCV > MCV_min_normal && MCV < MCV_max_normal;
	}

	public boolean inMCVVerringert() {
		return MCV > MCV_min_veringert && MCV < MCV_max_veringert;
	}

	public boolean inMCVERhoet() {
		return MCV > MCV_min_erhoeht && MCV < MCV_max_erhoeht;
	}

	public String getMCVNormalBereich() {
		return MCV_min_normal + " - " + MCV_max_normal;
	}

	public String getMCVVeringertBereich() {
		return MCV_min_veringert + " - " + MCV_max_veringert;
	}

	public String getMCVErhoetBereich() {
		return MCV_min_erhoeht + " bis " + MCV_max_erhoeht;
	}

	public float getHaemoglobinkonzentration() {
		return Haemoglobinkonzentration;
	}

	public float getLeukozyten() {
		return Leukozyten;
	}

	public float getThrombozyten() {
		return Thrombozyten;
	}

	public float getHaematokrit() {
		return Haematokrit;
	}

	public float getMCH() {
		return MCH;
	}

	public float getMCHC() {
		return MCHC;
	}

	public float getMCV() {
		return MCV;
	}

}
