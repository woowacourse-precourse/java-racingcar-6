package Carset;

import camp.nextstep.edu.missionutils.Console;

public class CarFuctSet {
	private static final String CAR_MARKER = "-";

	public static int inputNumber() {
		System.out.println("시도할 회수는 몇회인가요?");
		String input = Console.readLine();
		return Integer.parseInt(input);
	}
}
