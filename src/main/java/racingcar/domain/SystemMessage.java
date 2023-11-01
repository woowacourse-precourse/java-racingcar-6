package racingcar.domain;

public class SystemMessage {
    final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final String USER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    final String RESULT_MESSAGE = "\n실행 결과";
    final String WINNER_MESSAGE = "최종 우승자 : ";
    public void printStartMessage(){
        System.out.println(START_MESSAGE);
    }
    public void printUserInputMessage(){
        System.out.println(USER_INPUT_MESSAGE);
    }
    public void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }
    public void printWinnerMessage(){
        System.out.print(WINNER_MESSAGE);
    }
}
