package racingcar.view;

public class RacingCarView {

    private static final String RACING_CAR_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASKING_NUMBER_OF_RETRIES = "시도할 회수는 몇회인가요?";

    public void printStartRacingCar() {
        System.out.println(RACING_CAR_START);
    }

    public void printAskingNumberOfRetries() {
        System.out.println(ASKING_NUMBER_OF_RETRIES);
    }


}
