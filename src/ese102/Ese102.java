package ese102;


import complexnumber.*;

public class Ese102 {

	public static void main(String[] args) {
			ComplexNumber.setInitRectangular(0, 0);
			ComplexNumber c1 = new ComplexNumber();
			ComplexNumber.setInitRectangular(1, 1);
			ComplexNumber c2 = new ComplexNumber();
			ComplexNumber.setInitRectangular(1, 1);
			ComplexNumber c3 = new ComplexNumber();
			ComplexNumber.setInitRectangular(1, 1);
			ComplexNumber c4 = new ComplexNumber();
			System.out.println("c1:  " + c1);
			System.out.println("c2:  " + c2);
			System.out.println("Addizione:  " + c1.add(c2));
			System.out.println("Sottrazione:  " + c1.sub(c2));
			System.out.println("Moltiplicazione  " + c1.multiply(c2));
			System.out.println("Divisione  " + c1.divide(c2));
			System.out.println("Addizione a due parametri:  " + ComplexNumber.add(c3,c4));
			System.out.println("Sottrazione a due parametri:  " + ComplexNumber.sub(c3,c4));
			System.out.println("Moltiplicazione a due parametri  " + ComplexNumber.multiply(c3,c4));
			System.out.println("Divisione a due parametri  " + ComplexNumber.divide(c3,c4));
			
	}

}
