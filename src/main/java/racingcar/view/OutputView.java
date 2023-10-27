package racingcar.view;

public class OutputView {
    public static final String START_GAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ASK_GAME_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void printStartGame(){
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printAskGameRound(){
        System.out.println(ASK_GAME_ROUND_MESSAGE);
    }
}
