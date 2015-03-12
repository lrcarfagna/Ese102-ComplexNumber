/**
 *
 * @author Lorenzo Carfagna
 * 
 * La classe gestisce TUTTE le coordinate di ingresso come coordinate RETTANGOLARI.
 * Sono presenti solo 2 metodi Setter poichè i parametri devono NECESSARIAMENTE lavorare in coppia.
 * Sono presenti 4 metodi Getter poichè un metodo deve ritornare un solo valore e risulta una comodità.
 * Le relazioni utilizzate sono incluse nel codice.
 * Gli angoli multipli di ±360 hanno valore 0
 * La classe lavora con angoli compresi tra -359 e +359
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
	 * Inizializza i campi di classe initRe,initIm oltre che impostare come formato iniziale di rappresentazione quello rettangolare
	 */
	static public void setInitRectangular(double re, double im) {
		
		initRe = re;
		initIm = im;
		formatoIniziale = StringFormat.RETTANGOLARI; //setto il formato delle successive visualizzazioni a RETTANGOLARE
		
	}

	/**
	 *
	 * @param modulus
	 * @param argument
	 * Inizializza i campi di classe initRe initIm oltre che impostare come formato iniziale di rappresentazione quello polare
	 * 
	 */
	static public void setInitPolar(double modulus, double argument) {
		
		argument -= (((int) argument / 360) * 360); /* riduce ogni angolo ad
													   angoli compresi tra -359° e
													   +359° gradi*/
		if (modulus >= 0) {
				initRe = modulus * (Math.cos(argument * Math.PI / 180));
				initIm = modulus * (Math.sin(argument * Math.PI / 180));
		} else
		
		formatoIniziale = StringFormat.POLARI; //setto il formato delle successive visualizzazioni a POLARE
	}
	
	/**
	 * Costruttore che inizializza i campi dell'oggetto a initRe, initIm e formatoIniziale
	 * 
	 */
	
	public ComplexNumber(){
		this.re=ComplexNumber.initRe;
		this.im=ComplexNumber.initIm;
		this.formato=ComplexNumber.formatoIniziale;  //analogamente a quanto fatto con im e re inizializzo il formato al valore di ComplexNumber.formatoIniziale
		
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
	
	public enum StringFormat{
		
		//definisco i due possibili valori che una variabile di tipo StringFormat può assumere
		RETTANGOLARI,
		POLARI
		
	}
	
	static private StringFormat formatoIniziale;  
	private StringFormat formato; 
    /**
     * @return la rappresentazione a stringa dell'istanza, a seconda del formato richiesto
     */
	@Override
	public String toString(){
		
		//specializzazione del metodo toString di base,ora quando si invocherà toString() in un oggetto ComplexNumber il corpo del metodo sarà il seguente
		
		return toString(this.formato); //richiama il metodo toString passando il membro di classe formato
		//this.formato COME FA A FUNZIONARE? NON SERVE UN METODO getFormato?
	}
	/**
	 * 
	 * @param formato
	 * @return istanza della Classe String contenente una stringa formattata in base al formato ricevuto
	 */
	public String toString(StringFormat formato){
		/*
		 * Metodo differente da toString() siccome differisce per numero di parametri
		 */
		 
		 String r = new String();
		 
		 switch(formato) {
		 
			 case RETTANGOLARI:
				 r = this.re + "+(" + this.im + ")i";
				 break;
			 case POLARI:
				 r = "Modulo: " +this.getModulus() + " ; Theta: " + this.getArgument();
				 break;
			 default:
				 throw new UnsupportedOperationException();
				 
		 }
		 return r;
		
	}
	
	/**
	 * 
	 * @param formato
	 * setta il formato ricevuto in input come formato dell'istanza
	 */
	
	public void setStringFormat(StringFormat formato) {
		this.formato = formato;
		}
	
	/**
	 * Permette di accedere al campo re dell'oggetto in lettura 
	 * RITORNA COMPONENTE REALE QUINDI COORDINATA RETTANGOLARE
	 * 
	 * @return valore del campo re dell'oggetto invocante
	 */
	public double getRe() {
		return re;
	}

	/**
	 * Permette di accedere al campo im dell'oggetto in lettura 
	 * RITORNA COMPONENTE IMMAGINARIA QUINDI COORDINATA RETTANGOLARE
	 * 
	 * @return valore del campo im dell'oggetto invocante
	 */
	public double getIm() {
		return im;
	}

	/**
	 *
	 * 
	 * @return modulo del numero complesso
	 */
	public double getModulus() {
		return Math.sqrt((this.re * this.re) + (this.im * this.im));
	}

	/**
	 * Per Modulo=0 e Argomento=0 il metodo ritorna 0. 
	 * Il valore di ritorno è in GRADI SESSAGESIMALI.
	 * 
	 * @return argomento del numero complesso
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
	 * @param im
	 *
	 *
	 *            Metodo utilizzato per accedere in scrittura ai campi re ed
	 *            im dell'oggetto in caso di coordinate RETTANGOLARI.
	 */
	public void setRectangular(double re, double im) {
		this.re = re;
		this.im = im;
	}

	/**
	 *
	 * @param modulus
	 * @param argument
	 *
	 *            Metodo utilizzato per memorizzare le coordinate POLARI,
	 *            (permette di accedere in scrittura ai campi re ed im nel caso
	 *            in cui si ricevono in input coordinate polari)
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
	 * somma il valore dell'oggetto invocante a quello dell'oggetto ottenuto come parametro
	 * @param  operand
	 * @return nuova istanza contenente il risultato della somma
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
	 * sottrae il valore dell'oggetto invocante a quello dell'oggetto ottenuto come parametro
	 * @param operand
	 * @return istanza contenente il risultato della differenza
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
	 * moltiplica il valore dell'oggetto invocante a quello dell'oggetto ottenuto come parametro
	 * @param operand
	 * @return nuova istanza contenente il risultato della moltiplicazione
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
	 * divide il valore dell'oggetto invocante per quello dell'oggetto ottenuto come parametro
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
			throw new IllegalArgumentException("Il modulo del divisore deve essere diverso da 0");
		return risultato;
	}

	/**
     * restituisce il coniugato del numeroComplesso invocante
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
	 * somma i valori dei 2 oggetti ottenuti come parametri
	 * @param operand1
	 * @param operand2
	 * @return nuova istanza somma contenente il risultato della somma
	 */
	static public ComplexNumber add(ComplexNumber operand1,ComplexNumber operand2) {
		/*
		 * svolge le operazioni
		 * con coordinate rettangolari
		 */
		ComplexNumber somma = new ComplexNumber();
		somma.setRectangular(operand1.getRe() + operand2.getRe(),operand1.getIm() + operand1.getIm());
		return somma;
	}

	/**
	 * sottrae il valore del secondo oggetto ricevuto come parametro al primo.
	 * @param operand1
	 * @param operand2
	 * @return nuova istanza differenza contenente il risultato della sottrazione
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
	 * moltiplica i valori dei 2 oggetti ottenuti come parametri
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
		prodotto.setPolar(operand1.getModulus() * operand2.getModulus(),operand1.getArgument() + operand2.getArgument());
		return prodotto;
	}

	/**
	 * divide il valore del primo oggetto ottenuto come parametro per il secondo
	 * @param operand1
	 * @param operand2
	 * @return nuova istanza risultato contenente il risultato della divisione
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
			throw new IllegalArgumentException("Il modulo del divisore deve essere diverso da 0");
		
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
	
	/**
	 * restituisce vero se l'oggetto invocante della classe ComplexNumber e
	 * quello passato come argomento,della medesima classe,sono uguali
	 */
	@Override
	public boolean equals(Object obj){
		
		//specializzazione del metodo di base equals(Object obj), ora quando si invocherà equals() in un oggetto ComplexNumber il corpo del metodo sarà il seguente
		
		boolean equal=false;
		if(obj instanceof ComplexNumber){//verifica se obj è un istanza di ComplexNumber
	
			ComplexNumber nuovaIstanza=(ComplexNumber)obj; //ora che so che è un'istanza di ComplexNumber eseguo il casting, 
														   //copiando l'istanza in un'altra per non modificare obj.
			
			if((this.re==nuovaIstanza.getRe())&&(this.im==nuovaIstanza.getIm())) equal=true;
		}
		
		return equal;
	}
		

}

