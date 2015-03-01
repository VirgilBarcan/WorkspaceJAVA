/**
 * 
 */
package SparseMatrix;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Set;

/**
 * @author Virgil Barcan
 *
 */
public class SparseMatrix {
	
	private ArrayList<Hashtable<Integer, Double>> sparseMatrix;
	private int noOfLines;
	private int noOfColumns;
	
	//Constructors
	//Implicit constructor
	public SparseMatrix(){
		Initialize();
		
		noOfLines = 0;
		noOfColumns = 0;
	}
	
	//Constructor used to initialize a matrix with n lines and m columns
	public SparseMatrix(Integer noOfLines, Integer noOfColumns){
		Initialize();
		
		this.noOfLines = noOfLines;
		this.noOfColumns = noOfColumns;
		
		for (int i = 0; i < noOfLines; ++i){
			Hashtable<Integer, Double> matrixLine = new Hashtable<Integer, Double>();
			sparseMatrix.add(matrixLine);
		}
	}
	
	//Constructors used to initialize matrix with a single line
	public SparseMatrix(Double[] inputLine){
		Initialize();
		Hashtable<Integer, Double> matrixLine = new Hashtable<Integer, Double>();
		
		noOfLines = 1;
		noOfColumns = inputLine.length;
		
		for (int i = 0; i < inputLine.length; ++i){
			Double value = new Double(inputLine[i]);
			matrixLine.put(i, value);
		}
		sparseMatrix.add(matrixLine);
	}
	
	public SparseMatrix(Hashtable<Integer, Double> matrixLine){
		Initialize();
		
		noOfLines = 1;
		noOfColumns = matrixLine.size();
		
		sparseMatrix.add(matrixLine);
	}
	
	//Constructors used to initialize matrix with an entire matrix
	public SparseMatrix(Double[][] inputMatrix){
		Initialize();
		int key = 0;
		
		noOfLines = inputMatrix.length;
		
		for (int i = 0; i < inputMatrix.length; ++i){
			Hashtable<Integer, Double> matrixLine = new Hashtable<Integer, Double>();
			
			if (noOfColumns < inputMatrix[i].length) noOfColumns = inputMatrix[i].length;
			
			for (int j = 0; j < inputMatrix[i].length; ++j){
				Double value = new Double(inputMatrix[i][j]);
				matrixLine.put(key, value);
				key++;
			}
		}
	}
	
	public SparseMatrix(ArrayList<Hashtable<Integer, Double>> inputMatrix){
		Initialize();
		
		noOfLines = inputMatrix.size();
	
		for (int i = 0; i < noOfLines; ++i)
			if (noOfColumns < inputMatrix.get(i).size()) noOfColumns = inputMatrix.get(i).size();
		
		sparseMatrix = inputMatrix;
	}
	
	//Method used to initialize the sparseMatrix
	private void Initialize(){
		sparseMatrix = new ArrayList<Hashtable<Integer, Double>>();
		noOfLines = 0;
		noOfColumns = 0;
	}
	
	//Methods used to add new lines to the matrix
	public void addLine(Double[] inputLine){
		Hashtable<Integer, Double> matrixLine = new Hashtable<Integer, Double>();
		
		for (int i = 0; i < inputLine.length; ++i){
			Double value = new Double(inputLine[i]);
			matrixLine.put(i, value);
		}
		sparseMatrix.add(matrixLine);
	}
	
	public void addLine(Hashtable<Integer, Double> inputLine){
		sparseMatrix.add(inputLine);
	}
	
	public void addLines(ArrayList<Hashtable<Integer, Double>> inputLines){
		sparseMatrix.addAll(inputLines);
	}
	
	public boolean addElement(Integer line, Integer column, Double value){
		if (noOfLines <= line || 0 > line){ //the matrix does not have this line
			System.out.println("[Error] The line you want to access isn't present in the matrix!");
			return false;
		}
		if (noOfColumns <= column || 0 > column){ //the matrix does not have this column
			System.out.println("[Error] The column you want to access isn't present in the matrix!");
			return false;
		}
		if (value != 0.0){
			sparseMatrix.get(line).put(column, value);
			return true;
		}
		return false;
	}
	
	public boolean setElement(Integer line, Integer column, Double value){
		if (noOfLines <= line || 0 > line){ //the matrix does not have this line
			System.out.println("[Error] The line you want to access isn't present in the matrix!");
			return false;
		}
		if (noOfColumns <= column || 0 > column){ //the matrix does not have this column
			System.out.println("[Error] The column you want to access isn't present in the matrix!");
			return false;
		}
		
		sparseMatrix.get(line).put(column, value);
		return true;
	}
	
	public Double getElement(Integer line, Integer column){
		Double value = (double) (0);
		
		if (noOfLines <= line || 0 > line){ //the matrix does not have this line
			System.out.println("[Error] The line you want to access isn't present in the matrix!");
			return (double) (-1);
		}
		if (noOfColumns <= column || 0 > column){ //the matrix does not have this column
			System.out.println("[Error] The column you want to access isn't present in the matrix!");
			return (double) (-1);
		}
		if (sparseMatrix.get(line).containsKey(column) == true){
			value = sparseMatrix.get(line).get(column);
		}
		
		return value;
	}
	
	public static SparseMatrix sum(SparseMatrix A, SparseMatrix B){
		SparseMatrix S;
		
		int noOfLinesA = A.getNoOfLines();
		int noOfColumnsA = A.getNoOfColumns();
		int noOfLinesB = B.getNoOfLines();
		int noOfColumnsB = B.getNoOfColumns();
		
		if (noOfLinesA != noOfLinesB || noOfColumnsA != noOfColumnsB){ //the matrices are not of the same size
			System.out.println("[Error] The matrices are not of the same size!");
			return null;
		}
		
		S = new SparseMatrix(noOfLinesA, noOfColumnsA);
		
		//System.out.println("A:");
		//A.printMatrix();
		//System.out.println("B");
		//B.printMatrix();
		//System.out.println("S:");
		//S.printMatrix();
		
		for (int line = 0; line < A.getNoOfLines(); ++line){
			Set<Integer> keys = A.getKeysOnLine(line);
			
			for (Integer column : keys){
				Double valueA = A.getElement(line, column);
				Double valueB = B.getElement(line, column);
				
				//System.out.println("A(" + line + ", " + column + ")=" + valueA);
				//System.out.println("B(" + line + ", " + column + ")=" + valueA);
				
				if (valueB != 0.0){
					S.setElement(line, column, valueA + valueB);
				}
				else{
					S.setElement(line, column, valueA);
				}
				//System.out.println("S(" + line + ", " + column + ")=" + S.getElement(line, column));
			}
			
		}
		
		//S.printMatrix();
		//System.out.println();
		
		for (int line = 0; line < B.getNoOfLines(); ++line){
			Set<Integer> keys = B.getKeysOnLine(line);
			
			for (Integer column : keys){
				Double valueA = A.getElement(line, column);
				Double valueB = B.getElement(line, column);
				
				//System.out.println("bA(" + line + ", " + column + ")=" + valueA);
				//System.out.println("bB(" + line + ", " + column + ")=" + valueB);
				
				if (valueA == 0.0){
					S.setElement(line, column, valueB);
				}
				//System.out.println("bS(" + line + ", " + column + ")=" + S.getElement(line, column));
			}
		}
		
		//S.printMatrix();
		//System.out.println();
		
		return S;
	}
	
	public static SparseMatrix multiplyWithScalar(SparseMatrix A, Double scalar){
		SparseMatrix S = A;
		
		for (int line = 0; line < S.getNoOfLines(); ++line){
			Set<Integer> keys = S.getKeysOnLine(line);
			
			for (Integer column : keys){
				Double value = S.getElement(line, column);
				value *= scalar;
				
				S.setElement(line, column, value);
			}
			
		}
		
		return S;
	}
	
	public static SparseMatrix multiply(SparseMatrix A, SparseMatrix B){
		SparseMatrix P;
		
		int noOfLinesA = A.getNoOfLines();
		int noOfColumnsA = A.getNoOfColumns();
		int noOfLinesB = B.getNoOfLines();
		int noOfColumnsB = B.getNoOfColumns();
		
		if (noOfColumnsA != noOfLinesB){ //the matrices can not be multiplied
			System.out.println("[Error] The matrices can not be multiplied!");
			return null;
		}
		
		P = new SparseMatrix(noOfLinesA, noOfColumnsB);

		//for each line of A
		for (int line = 0; line < noOfLinesA; ++line){
			Set<Integer> keys = A.getKeysOnLine(line);
			
			//for each column of B
			for (int columnB = 0; columnB < noOfColumnsB; ++columnB){
				Double valueS = new Double(0);
				
				//for each column of A
				for (Integer columnA : keys){
					Double valueA = A.getElement(line, columnA);
					Double valueB = B.getElement(columnA, columnB);
					valueS += valueA * valueB;
				}
				
				P.setElement(line, columnB, valueS);
				
			}
		}
		
		return P;
		
	}
	
	public static SparseMatrix transpose(SparseMatrix A){
		SparseMatrix T;
		
		int noOfLinesA = A.getNoOfLines();
		int noOfColumnsA = A.getNoOfColumns();
		
		T = new SparseMatrix(noOfColumnsA, noOfLinesA);
		
		for (int line = 0; line < A.getNoOfLines(); ++line){
			Set<Integer> keys = A.getKeysOnLine(line);
			
			for (Integer column : keys){
				Double value = A.getElement(line, column);
				T.setElement(column, line, value);
			}
		}
		
		return T;
	}

	public void transpose(){
		SparseMatrix T;
		
		int noOfLinesA = this.getNoOfLines();
		int noOfColumnsA = this.getNoOfColumns();
		
		T = new SparseMatrix(noOfColumnsA, noOfLinesA);
		
		for (int line = 0; line < this.getNoOfLines(); ++line){
			Set<Integer> keys = this.getKeysOnLine(line);
			
			for (Integer column : keys){
				Double value = this.getElement(line, column);
				T.setElement(column, line, value);
			}
		}
		
		this.Initialize();
		this.setNoOfLines(noOfColumnsA);
		this.setNoOfColumns(noOfLinesA);
		
		for (int line = 0; line < T.getNoOfLines(); ++line){
			Hashtable<Integer, Double> newLine = T.getLine(line);
			this.addLine(newLine);
		}
		
	}
	
	public static SparseMatrix generateRandomMatrix(int noOfLines, int noOfColumns, int noOfValuesToGenerate, double intervalMin, double intervalMax){
		SparseMatrix matrix = new SparseMatrix(noOfLines, noOfColumns);
		
		for (int i = 0; i < noOfValuesToGenerate; ++i){
			int line;
			int column;
			double value;
			
			line = (int)(Math.random() * (noOfLines - 1));
			column = (int)(Math.random() * (noOfColumns - 1));
			value = Math.random() * intervalMax + intervalMin;
			
			while(matrix.getElement(line, column) != 0){
				line = (int)(Math.random() * (noOfLines - 1));
				column = (int)(Math.random() * (noOfColumns - 1));
			}
			
			//System.out.println("M(" + line + ", " + column + ") = " + value);
			
			matrix.addElement(line, column, value);
		}
		
		return matrix;
	}
	
	
	//getters setters
	public int getNoOfLines(){
		return noOfLines;
	}
	
	public int getNoOfColumns(){
		return noOfColumns;
	}
	
	public void setNoOfLines(int noOfLines){
		this.noOfLines = noOfLines;
	}
	
	public void setNoOfColumns(int noOfColumns){
		this.noOfColumns = noOfColumns;
	}
	
	public Set<Integer> getKeysOnLine(int lineNo){
		return sparseMatrix.get(lineNo).keySet();
	}
	
	public Hashtable<Integer, Double> getLine(int lineNo){
		return sparseMatrix.get(lineNo);
	}
	
	public void printMatrix(){
		int maximumNumberOfCharacters = this.getMaximumNumberOfCharacters();
		
		for (int i = 0; i < this.getNoOfLines(); ++i){
			for (int j = 0; j < this.getNoOfColumns(); ++j){
				String elementToPrint = this.printElement(this.getElement(i, j), maximumNumberOfCharacters);
				System.out.print(elementToPrint + " ");
			}
			System.out.println();
		}
	}
	
	private String printElement(Double element, int maximumNumberOfCharacters){
		String returnedString = new String();		
		String elementString = element.toString();
		int numberOfCharacters = elementString.length();
		int difference = maximumNumberOfCharacters - numberOfCharacters;
	
		while (difference > 0){
			
			returnedString += " ";
			
			--difference;
		}
		
		returnedString += elementString;
		
		return returnedString;
	}
	
	private int getMaximumNumberOfCharacters(){
		int maxim = 0;
		
		for (int i = 0; i < this.getNoOfLines(); ++i){
			Set<Integer> keys = this.getKeysOnLine(i);
			
			for (Integer column : keys){
				Double value = this.getElement(i, column);
				if (value.toString().length() > maxim) 
					maxim = value.toString().length();
			}
			
		}
		
		return maxim;
	}

	@Override
	public String toString(){
		StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");

	    result.append(this.getClass().getName() + " Object {" + NEW_LINE);
	    result.append(" No of lines: " + this.getNoOfLines() + NEW_LINE);
	    result.append(" No of columns: " + this.getNoOfColumns() + NEW_LINE);
	    result.append(" Matrix: " + sparseMatrix.toString() + NEW_LINE);
	    result.append("}");

	    return result.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + noOfColumns;
		result = prime * result + noOfLines;
		result = prime * result
				+ ((sparseMatrix == null) ? 0 : sparseMatrix.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (!(obj instanceof SparseMatrix)){
			return false;
		}
		SparseMatrix other = (SparseMatrix) obj;
		if (noOfColumns != other.noOfColumns){
			return false;
		}
		if (noOfLines != other.noOfLines){
			return false;
		}
		if (sparseMatrix == null) {
			if (other.sparseMatrix != null)
				return false;
		} 
		else 
			if (!sparseMatrix.equals(other.sparseMatrix)){
				return false;
			}
		return true;
	}
}
