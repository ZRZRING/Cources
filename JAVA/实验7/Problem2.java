import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

public class Problem2 {
	private static String generateGradeLine(String ID) {
        DecimalFormat df = new DecimalFormat("0.0");
		return ID + " " + df.format(Math.random() * 100) + " " + df.format(Math.random() * 100) + " " + df.format(Math.random() * 100);
	}

	private static double CalMean(List<Double> numbers) {
		double sum = 0;
		for (double x : numbers) {
			sum += x;
		}
		return sum / numbers.size();
	}

	private static double CalVar(List<Double> numbers, double mean) {
		double sumSquaredDiff = 0;
		for (double x : numbers) {
			sumSquaredDiff += Math.pow(x - mean, 2);
		}
		return sumSquaredDiff / numbers.size();
	}
	
	public static void main(String[] args) {
		List<Double> G1 = new ArrayList<>();
		List<Double> G2 = new ArrayList<>();
		List<Double> G3 = new ArrayList<>();
		try {
			FileInputStream FIS = new FileInputStream("studentInfo.txt");
			BufferedReader BR = new BufferedReader(new InputStreamReader(FIS));
			FileWriter FW = new FileWriter("studentGrades.txt");
			String line;
			while ((line = BR.readLine()) != null) {
				String[] parts = line.split(",");
				String name = parts[0];
				String ID = parts[2];
				String GradeLine = generateGradeLine(ID);
				FW.write(GradeLine + "\n");
				String[] grades = GradeLine.split("\\s+");
				G1.add(Double.parseDouble(grades[1]));
				G2.add(Double.parseDouble(grades[2]));
				G3.add(Double.parseDouble(grades[3]));
			}
			FW.close();
			BR.close();
			DecimalFormat df = new DecimalFormat("0.0");
			double meanCourse1 = CalMean(G1);
			double meanCourse2 = CalMean(G2);
			double meanCourse3 = CalMean(G3);
			double varianceCourse1 = CalVar(G1, meanCourse1);
			double varianceCourse2 = CalVar(G2, meanCourse2);
			double varianceCourse3 = CalVar(G3, meanCourse3);
			FileWriter writerStats = new FileWriter("studentGrades.txt", true);
			writerStats.write(String.format("均值和方差 %.1f/%.1f %.1f/%.1f %.1f/%.1f",
					meanCourse1, Math.sqrt(varianceCourse1),
					meanCourse2, Math.sqrt(varianceCourse2),
					meanCourse3, Math.sqrt(varianceCourse3)));
			writerStats.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
