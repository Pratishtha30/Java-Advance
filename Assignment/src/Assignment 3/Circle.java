package homeWork3;

import java.text.NumberFormat;

public class Circle {

	private double radius;

	private static int objectCount;

	public Circle(double radius) {
		this.radius = radius;
		objectCount++;
	}

	// circumference

	public double getCircumference() {
		double circumference = Math.PI * 2 * radius;

		return circumference;

	}

	public String getFormattedCircumference() {
		String fc = this.formatNumber(this.getCircumference());
		return fc;
	}

	public double getArea() {
		double area = Math.PI * radius * radius;
		return area;

	}

	public String getFormattedArea() {
		String fa = this.formatNumber(this.getArea());
		return fa;
	}

	// private formatNumber method
	private String formatNumber(double x) {
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMaximumFractionDigits(2);
		return number.format(x);
	}

	public static int getObjectCount() {
		return objectCount;
	}
}
