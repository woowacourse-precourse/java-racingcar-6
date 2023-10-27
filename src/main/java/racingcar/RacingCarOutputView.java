package racingcar;


public class RacingCarOutputView {

    public static final String RACING_EXECUTE_MESSAGE = "실행 결과";
    public static final String EACH_RACING_RESULT_FORMAT = "%s : %s";
    public static final String POSITION_PROGRESS = "-";

    public void printStartMessage() {
        System.out.println(RACING_EXECUTE_MESSAGE);
    }

    public void printEachRacingResult(Cars cars) {
        for (Car car : cars.getReadOnlyCarList()) {
            String carName = car.getName();
            int position = car.getPosition();
            String positionProgress = convertPositionValue(position);
            String result = String.format(EACH_RACING_RESULT_FORMAT, carName, positionProgress);
            System.out.println(result);
        }
    }

    private String convertPositionValue(int position) {
        return POSITION_PROGRESS.repeat(position);
    }
}
