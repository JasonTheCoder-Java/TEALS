import java.util.Scanner;

public class FractionCalculator {
	public static void main(String args[]) {
		while (true) {

			System.out.println("This program is a fraction calculator");
			System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit");
			System.out.println("Please enter your fractions in the form a/b, where a and b are integers:");
			Scanner in = new Scanner(System.in);
			if (in.equals("q"))
				break;
			Fraction fracNo = getFraction(in);
			String op = getOperation(in);
			System.out.println("Please enter a fraction(a/b) or integer(a)");
			Fraction fracDe = getFraction(in);
			if (op.equals("+")) {
				System.out.println(fracNo.add(fracDe));
			}
			if (op.equals("-")) {
				System.out.println(fracNo.substract(fracDe));
			}
			if (op.equals("*")) {
				System.out.println(fracNo.multiply(fracDe));
			}
			if (op.equals("/")) {
				System.out.println(fracNo.divide(fracDe));
			}
		}
	}

	public static String getOperation(Scanner in) {
		while (true) {
			System.out.println("Please enter an operation (+,-,*,/, = or Q to quit)");
			String operation = in.nextLine();
			if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
				return operation;

			} else if (operation.equalsIgnoreCase("q")) {
				System.exit(0);
			} else {
				System.out.println("Invalid input!!!");
			}

		}
	}

	public static Fraction getFraction(Scanner in) {
		int no;
		int de;
		while (true) {
			String frac = in.nextLine();

			if (validFraction(frac)) {
				int slash = frac.indexOf("/");
				if (slash == -1) {
					no = Integer.parseInt(frac);
					return new Fraction(no, 1);
				} else {
					String[] split = frac.split("/");
					no = Integer.parseInt(split[0]);
					de = Integer.parseInt(split[1]);
					return new Fraction(no, de);
				}
			} else if (frac.equals("q")) {
				System.exit(0);
			} else {
				System.out.println("Your input is invalid!");
			}

		}

	}

	public static boolean validFraction(String input) {
		// 1.check first character
		if (input.charAt(0) == '-') {
			input = input.substring(1);
		}

		int slash = input.indexOf("/");
		if (slash == -1) {
			if (!isNumber(input)) {
				return false;
			}
		} else {
			String[] nums = input.split("/");
			if (!isNumber(nums[0]) || !isNumber(nums[1])) {
				return false;
			}
			if ((nums[1].equals("0"))) {
				return false;
			}
		}
		return true;

	}

	public static boolean isNumber(String input) {
		if (input == null || input.length() == 0) {
			return false;
		}
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
