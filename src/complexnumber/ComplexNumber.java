/**
 *
 * @author Lorenzo Carfagna
 * 
 * La classe gestisce TUTTE le coordinate di ingresso come coordinate RETTANGOLARI.
 * Sono presenti solo 2 metodi Setter poichè i parametri devono NECESSARIAMENTE lavorare in coppia.
 * Sono presenti 4 metodi Getter poichè un metodo deve ritornare un solo valore e risulta una comodità.
 * Le relazioni utilizzate sono incluse nel codice.
 * Gli angoli multipli di 360 hanno valore 0
 *
 */
package complexnumber;

public class ComplexNumber {
	private double re;
	private double im;
	static private double initRe;
	static private double initIm;

	/**
	 *
	 * @param re
	 * @param im
	 * Inizializza i campi di classe initRe ed initIm
	 */
	static public void setInitRectangular(double re, double im) {
		initRe = re;
		initIm = im;
	}

	/**
	 *
	 * @param modulus
	 * @param argument
	 * Inizializza i campi di classe initRe ed initIm convertendo le coordinate polari
	 * 
	 */
	static public void setInitPolar(double modulus, double argument) {
		if (modulus < 0) {
			throw new IllegalArgumentException(
					"Il mudulo non può essere negativo");
		}
		initRe = modulus * Math.cos(argument);
		initIm = modulus * Math.sin(argument);
	}
	/**
	 * Costruttore che inizializza l'oggetto partendo dai campi di classe initRe ed initIm
	 */
	public ComplexNumber(){
		this.re=ComplexNumber.initRe;
		this.im=ComplexNumber.initIm;
		//chiedere perchè non uso solo le variabili
	}
	
/*
	/**
	 * UTILIZZA I METODI getRe e getIm

	 * 
	 * @return stringa preformattata che indica le componenti Reali ed
	 *         Immaginarie dell'oggetto.
	 */
	/*
	public String formatComplexNumberCartesian() {
		String r = this.getRe() + "+(" + this.getIm() + ")i";
		return r;
	}
/*
	/**
	 * UTILIZZA I METODI getModulus e getArgument
	 * 
	 * @return stringa preformattata che indica il modulo e l'argomento
	 *         dell'oggetto.
	 */
	/*
	public String formatComplexNumberPolar() {
		String r = "Modulo:" + this.getModulus() + " Argomento:"
				+ this.getArgument();
		return r;
	}*/

	public String toString(){
		
		return this.re+"+("+this.im+")i";
	}
	
	/**
	 * Permette di accedere al campo re dell'oggetto in lettura RITORNA
	 * COMPONENTE REALE QUINDI COORDINATA RETTANGOLARE
	 * 
	 * @return valore del campo re dell'oggetto.
	 */
	public double getRe() {
		return re;
	}

	/**
	 * Permette di accedere al campo im dell'oggetto in lettura RITORNA
	 * COMPONENTE IMMAGINARIA QUINDI COORDINATA RETTANGOLARE
	 * 
	 * @return Ritorna il valore del campo im dell'oggetto
	 */
	public double getIm() {
		return im;
	}

	/**
	 *
	 * Non riceve nessun parametro.
	 * 
	 * @return valore di tipo Double = al modulo delle componenti REALE ed
	 *         IMMAGINARIA dell'oggetto.
	 */
	public double getModulus() {
		return Math.sqrt((this.re * this.re) + (this.im * this.im));
	}

	/**
	 *
	 * Non riceve nessun parametro Per Modulo=0 e Argomento=0 il metodo ritorna
	 * 0. Il valore di ritorno è in GRADI SESSAGESIMALI.
	 * 
	 * @return var ritorna di tipo double = all'argomento.
	 */
	public double getArgument() {
		double argomento = 0;
		if (re == 0) {
			if (im == 0)
				argomento = 0;
			else if (im > 0)
				argomento = 90;
			else
				argomento = 270;
		} else {
			if (re < 0 && im > 0 || re < 0 && im < 0)
				argomento = Math.toDegrees(Math.atan(im / re)) + 180;
			else if (re > 0 && im < 0)
				argomento = Math.toDegrees(Math.atan(im / re)) + 360;
			else
				argomento = Math.toDegrees(Math.atan(im / re));
		}
		return argomento;
	}

	/**
	 *
	 * @param re
	 *            di tipo Double
	 * @param im
	 *            di tipo Double
	 *
	 *
	 *            Metodo utilizzato per per accedere in scrittura ai campi re ed
	 *            im dell'oggetto in caso di coordinate RETTANGOLARI.
	 */
	public void setRectangular(double re, double im) {
		this.re = re;
		this.im = im;
	}

	/**
	 *
	 * @param modulus
	 *            di tipo Double
	 * @param argument
	 *            di tipo Double
	 *
	 *            Metodo utilizzato per memorizzare le coordinate POLARI,
	 *            (permette di accedere in scrittura ai campi re ed im nel caso
	 *            in cui si ricevono in input coordinate polari)
	 *            Il metodo non accetta moduli negativi.
	 *
	 */
	public void setPolar(double modulus, double argument) {
		argument -= (((int) argument / 360) * 360); // riduce ogni angolo ad
													// angoli compresi tra -359° e
													// +359° gradi
		if (modulus >= 0) {
			this.re = modulus * (Math.cos(argument * Math.PI / 180));
			this.im = modulus * (Math.sin(argument * Math.PI / 180));
		} else
			
			throw new IllegalArgumentException("Il modulo NON può essere negativo");
		
	}

	/**
	 *
	 * @param operand
	 *            di tipo ComplexNumber (addendo) svolge le operazioni con
	 *            coordinate rettangolari
	 * @return istanza somma.
	 */
	public ComplexNumber add(ComplexNumber operand) {
		/*
		 * svolge le operazioni
		 * con coordinate rettangolari
		 */
		ComplexNumber somma = new ComplexNumber();
		double re = this.re + operand.getRe();
		double im = this.im + operand.getIm();
		somma.setRectangular(re, im);
		return somma;
	}

	/**
	 *
	 * @param operand
	 *            di tipo ComplexNumber (sottraendo) svolge le operazione con
	 *            coordinate rettangoli
	 * @return istanza differenza
	 */
	public ComplexNumber sub(ComplexNumber operand) {
		/*
		 * svolge le operazioni
		 * con coordinate rettangolari
		 */
		ComplexNumber differenza = new ComplexNumber();
		double re = this.re - operand.getRe();
		double im = this.im - operand.getIm();
		differenza.setRectangular(re, im);
		return differenza;
	}

	/**
	 *
	 * @param operand
	 * @return nuova istanza contenente il prodotto
	 */
	public ComplexNumber multiply(ComplexNumber operand) {
		/*
		 * svolge le operazioni
		 * in coordinate polari
		 */
		ComplexNumber prodotto = new ComplexNumber();
		double modulo = this.getModulus() * operand.getModulus();
		double argomento = this.getArgument() + operand.getArgument();
		prodotto.setPolar(modulo, argomento);
		return prodotto;
	}

	/**
	 *
	 * @param operand
	 * @return nuova istanza contenente il risultato della divisione
	 */
	public ComplexNumber divide(ComplexNumber operand) {
		
		/*
		 * svolge le operazioni
		 * con coordinate polari
		 */
		ComplexNumber risultato = new ComplexNumber();
		if (operand.getModulus() != 0) {
			double modulo = this.getModulus() / operand.getModulus();
			double argomento = this.getArgument() - operand.getArgument();
			risultato.setPolar(modulo, argomento);
		} else
			throw new IllegalArgumentException("Il modulo deve essere != da 0");
		return risultato;
	}

	/**
	 * Non riceve in input alcun parametro restituisce il coniugato del
	 * numeroComplesso invocante
	 * 
	 * @return nuova istanza contenente il coniugato
	 */
	public ComplexNumber getConjugate() {
		/*
		 * svolge l'operazione
		 * con coordinate rettangolari
		 */
		
		ComplexNumber coniugato = new ComplexNumber();
		if (this.im != 0) {
			coniugato.setRectangular(this.re, -this.im);
		} else
			coniugato.setRectangular(this.re, 0);
		return coniugato;
	}

	/**
	 *
	 * @param operand1
	 * @param operand2
	 * @return nuova istanza somma contenente la somma dei due numeri complessi ricevuti in input
	 */
	static public ComplexNumber add(ComplexNumber operand1,ComplexNumber operand2) {
		/*
		 * svolge le operazioni
		 * con coordinate rettangolari
		 */
		ComplexNumber somma = new ComplexNumber();
		somma.setRectangular(operand1.getRe() + operand2.getRe(),
				operand1.getIm() + operand1.getIm());
		return somma;
	}

	/**
	 *
	 * @param operand1
	 * @param operand2
	 * @return nuova istanza differenza contenente la differenza fra il primo numero complesso e il secondo ricevuti
	 * in input
	 */
	static public ComplexNumber sub(ComplexNumber operand1,ComplexNumber operand2) {
		/*
		 * svolge le operazioni
		 * con coordinate rettangolari
		 */
		ComplexNumber differenza = new ComplexNumber();
		differenza.setRectangular(operand1.getRe() - operand2.getRe(),
				operand1.getIm() - operand1.getIm());
		return differenza;
	}

	/**
	 *
	 * @param operand1
	 * @param operand2
	 * @return nuova istanza prodotto contenente il prodotto dei 2 numeri complessi in input
	 */
	static public ComplexNumber multiply(ComplexNumber operand1,ComplexNumber operand2) {
		/*
		 * svolge le operazioni
		 * con coordinate polari
		 */
		ComplexNumber prodotto = new ComplexNumber();
		prodotto.setPolar(operand1.getModulus() * operand2.getModulus(),
				operand1.getArgument() + operand2.getArgument());
		return prodotto;
	}

	/**
	 *
	 * @param operand1
	 * @param operand2
	 * @return nuova istanza risutlato contenente il risultato del primo numero complesso ricevuto in input diviso
	 *         per il secondo
	 */
	static public ComplexNumber divide(ComplexNumber operand1,ComplexNumber operand2) {
		/*
		 * svolge le operazioni
		 * con coordinate polari
		 */
		ComplexNumber risultato = new ComplexNumber();
		if(operand2.getModulus()!=0)
			risultato.setPolar(operand1.getModulus() / operand2.getModulus(),operand1.getArgument() - operand2.getArgument());
		else
			throw new IllegalArgumentException("Il modulo deve essere diverso da 0");
		
		return risultato;
	}

	/**
	 *
	 * @param operand
	 * @return nuova istanza contenente il coniugato del numero complesso ricevuto in input
	 */
	static public ComplexNumber getConjugate(ComplexNumber operand) {
		/*
		 * svolge l'operazione
		 * con coordinate rettangolari
		 */
		
		ComplexNumber coniugato = new ComplexNumber();
		if (operand.getIm() != 0) {
			coniugato.setRectangular(operand.getRe(), -operand.getIm());
		} else
			coniugato = operand;
		return coniugato;
	}
}

