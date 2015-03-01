/**
 * 
 */
package SparseMatrix;

/**
 * @author Virgil Barcan
 *
 */
public class SparseMatrixTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		try{
			SparseMatrix A;
			SparseMatrix B;
			SparseMatrix C;
			SparseMatrix RandomMatrix;
			SparseMatrix T;
		
			A = new SparseMatrix(1, 3);
			B = new SparseMatrix(3, 4);
			C = new SparseMatrix(1, 4);
			RandomMatrix = SparseMatrix.generateRandomMatrix(10, 10, 15, 0, 10);
			T = new SparseMatrix(4, 1);
			
			A.addElement(0, 0, 3.0);
			A.addElement(0, 1, 4.0);
			A.addElement(0, 2, 2.0);
			
			B.addElement(0, 0, 13.0);
			B.addElement(0, 1, 9.0);
			B.addElement(0, 2, 7.0);
			B.addElement(0, 3, 15.0);
			B.addElement(1, 0, 8.0);
			B.addElement(1, 1, 7.0);
			B.addElement(1, 2, 4.0);
			B.addElement(1, 3, 6.0);
			B.addElement(2, 0, 6.0);
			B.addElement(2, 1, 4.0);
			//B.addElement(2, 2, 0.0);
			B.addElement(2, 3, 3.0);
			
			A.printMatrix();
			System.out.println();
			B.printMatrix();
			System.out.println();
			
			C = SparseMatrix.multiply(A, B);
			
			/*System.out.println(A.getElement(0, 0));
			System.out.println(B.getElement(0, 0));
			System.out.println(B.getElement(1, 1));
			System.out.println(A.getElement(10, 10));
			System.out.println(C.getElement(0, 0));
			System.out.println(C.getElement(1, 1));
			System.out.println(C.getElement(5, 6));
			*/
			C.printMatrix();
			
			System.out.println("T:");
			T = SparseMatrix.transpose(C);
			T.printMatrix();
			System.out.println();
			
			System.out.println("T.toString(): " + T.toString());
			System.out.println("T.equals(T): " + T.equals(T));
			System.out.println("T.equals(C): " + T.equals(C));
			System.out.println("C.hashCode(): " + C.hashCode());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println("The program took: " + elapsedTime + " milliseconds to run");
		
	}

}
