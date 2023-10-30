package racingcar.view;

public class OutputView {
    public static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String GAME_END_MESSAGE = "실행 결과";
    public static final String WINNER_ANNOUNCEMENT_MESSAGE = "최종 우승자 : ";
    public static final String DASH = "=";


    public static void printCarNameFormat(String carName) {
        System.out.print(carName + " : ");
    }
    public static void printOneCarResult(String carName, int distance) {
        printCarNameFormat(carName);
        for (int i = 0; i < distance; i++) {
            System.out.print(DASH);
        }
        System.out.print("\n");
    }

    public static void printGameResult() {
        System.out.println(GAME_END_MESSAGE);
    }

}
