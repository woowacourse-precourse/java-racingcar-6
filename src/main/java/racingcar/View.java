package racingcar;

import java.util.List;

public class View {
    private static final String MSG_ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private static final String MSG_ASK_ROUNDS = "시도할 회수는 몇회인가요?\n";
    private static final String MSG_FINAL_WINNERS = "최종 우승자 : %s\n";
    private static final String MSG_ALL_CARS = "%s\n";
    private static final String MSG_CAR_STATUS = "%s : %s\n";
    private static final String TOKEN_CAR_DISTANCE = "-";
    private static final String TOKEN_NAME_DELIMITER = ", ";

    public String renderAskCarNames() {
        return MSG_ASK_CAR_NAMES;
    }

    public String renderAskRounds() {
        return MSG_ASK_ROUNDS;
    }

    public String renderAllCars(final List<Car> carList) {
        List<String> renderedCars = carList.stream()
                .map(this::renderCar)
                .toList();
        return String.format(MSG_ALL_CARS, String.join("", renderedCars));
    }

    private String renderCar(final Car car) {
        return String.format(MSG_CAR_STATUS, car.getName(), renderDistance(car));
    }

    private String renderDistance(final Car car) {
        return TOKEN_CAR_DISTANCE.repeat(car.getPosition());
    }

    public String renderFinalWinners(final List<Car> carList) {
        List<String> carNamesList = carList.stream()
                .map(Car::getName)
                .toList();
        String carNames = String.join(TOKEN_NAME_DELIMITER, carNamesList);
        return String.format(MSG_FINAL_WINNERS, carNames);
    }
}
