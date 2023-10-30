package racingcar.view;

public class OutputView {

    private static final String RACE_START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉽표(,) 기준으로 구분)";
    private static final String RACE_TRY_COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    public static void printRaceStart() {
        System.out.println(RACE_START_MESSAGE);
    }
    public static void printRaceTryCount(){
        System.out.println(RACE_TRY_COUNT_MESSAGE);
    }
}
