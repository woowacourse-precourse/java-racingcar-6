package racingcar.io;

public class OutputViewPrinter implements Printer{
	
	@Override
	public void printLine(String message) {
		System.out.println(message);
	}
	
	@Override
	public void printFormat(String format, String message) {
		System.out.printf(format, message);
	}
}
