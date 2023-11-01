package racingcar;

import java.util.List;

public class UserOutput {

    private static final String DASH = "-";
    private static final String COLON = " : ";
    private static final String CAR_NAME_OUTPUT_DELIMITER = ", ";
    private static final String START_RACE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PLAY_OUTPUT = "실행 결과";
    private static final String FINAL_RESULT = "최종 우승자 : ";

    public void printStart() {
        System.out.println(START_RACE);
    }

    public void printPlay() {
        printBlank();
        System.out.println(PLAY_OUTPUT);
    }

    public void printBlank() {
        System.out.println();
    }

    public void printProgress(String carName, int forwardCount) {
        System.out.print(carName + COLON);
        System.out.println(DASH.repeat(forwardCount));
    }

    public void printResult(List<Car> winnerCars) {

        List<String> winnerCarsNames = Car.getCarsNames(winnerCars);

        System.out.print(FINAL_RESULT);
        System.out.println(String.join(CAR_NAME_OUTPUT_DELIMITER, winnerCarsNames));
    }
}
