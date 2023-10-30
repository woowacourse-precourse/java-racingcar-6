package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private final static String WIN = "최종 우승자 : ";

    public void writeNewlineMessage(String message) {
        System.out.println(message);
    }

    public void printRoundResult(List<Car> cars) {
        StringBuilder content = new StringBuilder();
        cars.forEach(car -> addCarResult(content, car));
        writeNewlineMessage(content.toString());
    }

    public void printWinners(List<Car> winners) {
        final String DELIMITER = ", ";
        String message = winners.stream()
                .map(Car::getName)
                .map(Object::toString)
                .collect(Collectors.joining(DELIMITER));
        System.out.println(WIN + message);
    }

    private void addCarResult(StringBuilder roundResult, Car car) {
        final String DELIMITER = " : ";
        final String CAR_RESULT = car.getName() + DELIMITER + convertDistance(car.getPosition().getValue()) + '\n';
        roundResult.append(CAR_RESULT);
    }

    private String convertDistance(int position) {
        final String DISTANCE = "-";
        return DISTANCE.repeat(position);
    }
}
