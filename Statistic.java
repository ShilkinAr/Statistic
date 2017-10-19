import java.util.Arrays;

public class Statistic {

	public static void main(String[] args) {
		int massive[][] = new int[1000][1000];
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				massive[i][j] = (int) ((Math.random() * 900) + 100);
			}
		}
		double[] SrAr = SrAr(massive);
		double Srar = SrArAll(massive);
		double[] SrKv = SrKv(massive, SrAr);
		double Srkv = SrKvAll(massive, Srar);
		System.out.println(Srkv);
		a(massive, SrAr, Srar, SrKv, Srkv);
		b(massive, SrAr, Srar, SrKv, Srkv);
		c(massive, SrAr, Srar, SrKv, Srkv);
		d(massive, SrAr, Srar, SrKv, Srkv);

	}

	public static double[] SrAr(int[][] massive) {
		int sum = 0;
		double SrAr[] = new double[1000];
		for (int i = 0; i < 1000; i++) {
			Arrays.sort(massive[i]);
			for (int j = 1; j < 999; j++) {
				sum = sum + massive[i][j];
			}
			SrAr[i] = (double) sum / 998;
			sum = 0;
		}
		return SrAr;
	}

	public static double SrArAll(int[][] massive) {
		int sum = 0;
		double SrAr = 0;
		int max = 0;
		int min = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				sum = sum + massive[i][j];
				if (massive[i][j] > max) {
					max = massive[i][j];
				} else if (massive[i][j] < min) {
					min = massive[i][j];
				}
			}
		}
		sum = sum - min - max;
		SrAr = (double) sum / 999998;
		return SrAr;
	}

	public static double[] SrKv(int[][] massive, double[] SrAr) {
		double sum = 0;
		double SrKv[] = new double[1000];
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				sum = sum + ((massive[i][j] - SrAr[i]) * (massive[i][j] - SrAr[i]));
			}
			sum = sum / 1000;
			SrKv[i] = Math.sqrt(sum);
			sum = 0;
		}
		return SrKv;
	}

	public static double SrKvAll(int[][] massive, double SrAr) {
		long sum = 0;
		double SrKv = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				sum = (long) (sum + ((massive[i][j] - SrAr) * (massive[i][j] - SrAr)));
			}
		}
		sum = sum / 1000000;
		SrKv = Math.sqrt(sum);
		return SrKv;
	}

	public static void a(int[][] massive, double[] SrAr, double Srar, double[] SrKv, double Srkv) {
		int yes = 0;
		double o = 0;
		System.out.println("По строкам:");
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++)
				if ((massive[i][j] < (SrAr[i] + SrKv[i])) && (massive[i][j] > (SrAr[i] - SrKv[i])))
					yes++;

			o = (double) yes / 10;
			System.out.print("#" + i + " " + o + " ");
			if (i < 10) {
				System.out.print(" ");
			}
			if (i < 100) {
				System.out.print(" ");
			}
			if ((i + 1) % 100 == 0 && i != 0) {
				System.out.println();
			}
			o = 0;
			yes = 0;
		}
		System.out.print("По всему массиву: ");
		for (int i = 0; i < 1000; i++)
			for (int j = 0; j < 1000; j++)
				if ((massive[i][j] < (Srar + Srkv)) && (massive[i][j] > (Srar - Srkv)))
					yes++;

		o = (double) yes / 10000;
		System.out.println(o);
		System.out.println();
	}

	public static void b(int[][] massive, double[] SrAr, double Srar, double[] SrKv, double Srkv) {
		int yes = 0;
		double o = 0;
		System.out.println("По строкам:");
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if ((massive[i][j] > (SrAr[i] - (2 * SrKv[i]))) && (massive[i][j] < (SrAr[i] - SrKv[i])))
					yes++;
				else if ((massive[i][j] > (SrAr[i] + SrKv[i])) && (massive[i][j] < (SrAr[i] + (2 * SrKv[i]))))
					yes++;
			}
			o = (double) yes / 10;
			System.out.print("#" + i + " " + o + " ");
			if (i < 10) {
				System.out.print(" ");
			}
			if (i < 100) {
				System.out.print(" ");
			}
			if ((i + 1) % 100 == 0 && i != 0) {
				System.out.println();
			}
			o = 0;
			yes = 0;
		}
		System.out.print("По всему массиву: ");
		for (int i = 0; i < 1000; i++)
			for (int j = 0; j < 1000; j++)
				if ((massive[i][j] > (Srar - (2 * Srkv))) && (massive[i][j] < (Srar - Srkv)))
					yes++;
				else if ((massive[i][j] > (Srar + Srkv)) && (massive[i][j] < (Srar + (2 * Srkv))))
					yes++;
		o = (double) yes / 10000;
		System.out.println(o);
		System.out.println();
	}

	public static void c(int[][] massive, double[] SrAr, double Srar, double[] SrKv, double Srkv) {
		int yes = 0;
		double o = 0;
		System.out.println("По строкам:");
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if ((massive[i][j] > (SrAr[i] - (3 * SrKv[i]))) && (massive[i][j] < (SrAr[i] - (2 * SrKv[i]))))
					yes++;
				else if ((massive[i][j] > (SrAr[i] + 2 * (SrKv[i]))) && (massive[i][j] < (SrAr[i] + (3 * SrKv[i]))))
					yes++;
			}
			o = (double) yes / 10;
			System.out.print("#" + i + " " + o + " ");
			if (i < 10) {
				System.out.print(" ");
			}
			if (i < 100) {
				System.out.print(" ");
			}
			if ((i + 1) % 100 == 0 && i != 0) {
				System.out.println();
			}
			o = 0;
			yes = 0;
		}
		System.out.print("По всему массиву: ");
		for (int i = 0; i < 1000; i++)
			for (int j = 0; j < 1000; j++)
				if ((massive[i][j] > (Srar - (3 * Srkv))) && (massive[i][j] < (Srar - (2 * Srkv))))
					yes++;
				else if ((massive[i][j] > (Srar + 2 * (Srkv))) && (massive[i][j] < (Srar + (3 * Srkv))))
					yes++;
		o = (double) yes / 10000;
		System.out.println(o);
		System.out.println();
	}

	public static void d(int[][] massive, double[] SrAr, double Srar, double[] SrKv, double Srkv) {
		int yes = 0;
		double o = 0;
		System.out.println("По строкам:");
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if ((massive[i][j] > 99) && (massive[i][j] < (SrAr[i] - (3 * SrKv[i]))))
					yes++;
				else if ((massive[i][j] > (SrAr[i] + (3 * (SrKv[i])))) && (massive[i][j] < 1000))
					yes++;
			}
			o = (double) yes / 10;
			System.out.print("#" + i + " " + o + " ");
			if (i < 10) {
				System.out.print(" ");
			}
			if (i < 100) {
				System.out.print(" ");
			}
			if ((i + 1) % 100 == 0 && i != 0) {
				System.out.println();
			}
			o = 0;
			yes = 0;
		}
		System.out.print("По всему массиву: ");
		for (int i = 0; i < 1000; i++)
			for (int j = 0; j < 1000; j++)
				if ((massive[i][j] > 99) && (massive[i][j] < (Srar - (3 * Srkv))))
					yes++;
				else if ((massive[i][j] > (Srar + (3 * (Srkv)))) && (massive[i][j] < 1000))
					yes++;
		o = (double) yes / 10000;
		System.out.println(o);
		System.out.println();
	}
}
