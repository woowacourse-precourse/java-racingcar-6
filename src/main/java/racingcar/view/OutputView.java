package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void writeNewlineMessage(String message) {
        System.out.println(message);
    }

    public void writeOneRoundResult(List<Car> cars) {
        StringBuilder content = new StringBuilder();
        cars.forEach(car -> buildOneCarResult(content, car));
        writeNewlineMessage(content.toString());
    }

    public void writeWinners(List<Car> winners) {
        final String DELIMITER = ", ";
        final String WIN = "최종 우승자 : ";

        String message = winners.stream()
                .map(Car::getName)
                .map(Object::toString)
                .collect(Collectors.joining(DELIMITER));

        writeNewlineMessage(WIN + message);
    }

    private void buildOneCarResult(StringBuilder roundResult, Car car) {
        final String DELIMITER = " : ";
        final char NEWLINE = '\n';
        final String CAR_RESULT = car.getName() + DELIMITER + convertPosition(car.getPosition().getValue()) + NEWLINE;
        roundResult.append(CAR_RESULT);
    }

    private String convertPosition(int position) {
        final String POSITION = "-";
        return POSITION.repeat(position);
    }
}
