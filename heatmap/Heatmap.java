package heatmap;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Heatmap {
	private double[][] data;
	
	public Heatmap(int rows, int cols, String filename) throws IOException {
		data = new double[rows][cols];
		Scanner s = new Scanner(new File(filename));
		s.nextLine();
		int r = 0;
		while (s.hasNextLine()) {
			String[] temp = s.nextLine().split(",");
		    for (int i = 1; i<cols; i++) {
			  data[r][i] = Double.parseDouble(temp[i]);
		    }
		    r++;
		}
		s.close();
	}
	
	public void printHeatmap() {
		for (double[] i:data) {
			for (double j: i) {
				System.out.print(j+", ");
			}
		}
	}
	
	public double sumHeatmap() {
		double sum = 0;
		for (double[] i:data) {
			for (double j:i) {
				sum+=j;
			}
		}
		return sum;
	}
	
	public double avgHeatmap() {
		double sum = 0;
		double count = 0;
		for (double[] i:data) {
			for (double j:i) {
				sum += j;
				count++;
			}
		}
		return sum/count;
	}
	
	public double sumRow(int r) {
		double sum = 0;
		double[] row = data[r-1];
		for (double j:row) {
			sum+=j;
		}
		return sum;
	}
	
	public double sumColumn(int c) {
		double sum = 0;
		for (double[] i:data) {
			sum += i[c-1];
		}
		return sum;
	}
	
	public int areCold() {
		int count = 0;
		for (double[] i:data) {
			for (double j:i) {
				if (j<10) {
					count++;
				}
			}
		}
		return count;
	}
}
