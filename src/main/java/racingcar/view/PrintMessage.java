package racingcar.view;

import java.util.List;

public class PrintMessage {
	public PrintMessage() {}
	
	public static String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static String QUESTION_CHANCE = "시도할 회수는 몇회인가요?";
	public static String GAME_RESULT = "실행 결과";
	public static String END_GAME = "최종 우승자 : ";
	public static String DELIMITER = ",";
	public static String RACING_RESULT_BAR = "-";

	public static void printRacingWinner(List<String> winners){
		System.out.println(END_GAME + String.join(DELIMITER, winners));
	}

	public static void printStartMessage(){
		System.out.println(START_MESSAGE);
	}

	public static void printQuestionChanceMessage(){
		System.out.println(QUESTION_CHANCE);
	}
	
	public static void printGameResult(List<String> names, int numberOfMoves) {
		for (String name : names) {
			System.out.println(name + " : " + RACING_RESULT_BAR.repeat(numberOfMoves));
		}
		System.out.println();
	}
	

}

	





