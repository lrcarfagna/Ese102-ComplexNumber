/**
 * @author Lorenzo Carfagna
 */
package ese102;


import complexnumber.*;

public class Ese102 {

	public static void main(String[] args) {
		
			ComplexNumber.setInitRectangular(1 , 5);
			ComplexNumber c1 = new ComplexNumber();
			ComplexNumber.setInitRectangular(0 , 5);
			ComplexNumber c2 = new ComplexNumber();
			
			ComplexNumber risultato = new ComplexNumber();
			
			ComplexNumber.setInitPolar(0,0);
			ComplexNumber c3 = new ComplexNumber();
			ComplexNumber.setInitPolar(4 , 60);
			ComplexNumber c4 = new ComplexNumber();
			
			
			System.out.println("c1:  " + c1);
			System.out.println("c2:  " + c2);
			//PERCHE' C3 E C4 NON VENGONO RAPPRESENTATI IN FORMA POLARE?
			System.out.println("c3:  " + c3);
			System.out.println("c4:  " + c4);
			
			risultato = c1.add(c2);
			risultato.setStringFormat(ComplexNumber.StringFormat.RETTANGOLARI); // va richiamato dopo l'assegnamento sennò il campo formato di risultato 
																				// sarà uguale a quello del formato iniziale impostato dall'ultimo setInit... chiamato
			System.out.println("Addizione:  " + risultato);
			
			risultato = c1.sub(c2);
			System.out.println("Sottrazione:  " + risultato);
			
			
			risultato = c1.multiply(c2);
			risultato.setStringFormat(ComplexNumber.StringFormat.POLARI);
			System.out.println("Moltiplicazione  " +risultato);
			
			risultato = c1.divide(c2);
			risultato.setStringFormat(ComplexNumber.StringFormat.POLARI);
			System.out.println("Divisione  " +risultato);
			
			System.out.println("Coniugato di C1 (metodo di istanza):  " +c1.getConjugate());
			
			
			risultato=ComplexNumber.add(c3,c4);
			risultato.setStringFormat(ComplexNumber.StringFormat.RETTANGOLARI);
			System.out.println("Addizione a due parametri:  " +risultato);
			
			risultato=ComplexNumber.sub(c3,c4);
			System.out.println("Sottrazione a due parametri:  " +risultato);
			
			risultato=ComplexNumber.multiply(c3,c4);
			risultato.setStringFormat(ComplexNumber.StringFormat.POLARI);
			System.out.println("Moltiplicazione a due parametri  " +risultato);
			
			risultato=ComplexNumber.divide(c3,c4);
			risultato.setStringFormat(ComplexNumber.StringFormat.POLARI);
			System.out.println("Divisione a due parametri  " +risultato);
			
			System.out.println("Coniugato di C1 (metodo di classe):  "+ ComplexNumber.getConjugate(c1));
			
			//--------------------------------------------- VERIFICARE SE DUE OGGETTI SONO UGUALI----------------------------------------------//
			ComplexNumber a = new ComplexNumber();
			ComplexNumber b = new ComplexNumber();
			a.setRectangular(1,1);
			b.setRectangular(1,-1);
			System.out.println("a:  " + a);
			System.out.println("b:  " + b);
			//b=a;
			if(a == b) {
			    System.out.println("a e b si riferiscono alla medesima istanza");
			}
			else {
			    System.out.println("a e b si riferiscono a due istanze differenti");
			}
			boolean risposta=a.equals(b);
			System.out.println("a e b sono uguali?  "+risposta);
			
	}

}
