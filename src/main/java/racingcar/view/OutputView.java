package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void writeInlineMessage(String message) {
        System.out.print(message);
    }

    public void writeNewlineMessage(String message) {
        System.out.println(message);
    }

    public void printRoundResult(List<Car> cars) {
        StringBuilder content = new StringBuilder();
        cars.forEach(car -> addCarResult(content, car));
        writeNewlineMessage(content.toString());
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
