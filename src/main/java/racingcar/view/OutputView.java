package racingcar.view;

public class OutputView {

    private static final String INPUT_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBERS_OF_MOVES_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void printInputCarsNameMessage() {
        System.out.println(INPUT_CARS_NAME_MESSAGE);
    }

    public static void printInputNumberOfMovesMessage() {
        System.out.println(INPUT_NUMBERS_OF_MOVES_MESSAGE);
    }

    public static void printCurrentLocation(String currentLocation) {
        System.out.println(currentLocation);
    }
}
