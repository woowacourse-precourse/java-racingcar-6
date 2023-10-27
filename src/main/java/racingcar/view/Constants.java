package racingcar.view;

public enum Constants {
    INPUT_CARS_NAME_MESSAGE("경주할 자동차 이름을 입력하세.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_MESSAGE("시도할 횟수는 몇회인가요?");
    private static String message;

    Constants(String message) {
    }
}
