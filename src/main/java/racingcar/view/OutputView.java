package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.MessageConstant;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

    public void printResultMessage() {
        System.out.println();
        System.out.println(MessageConstant.RESULT_MESSAGE);
    }

    public void printCars(Cars cars) {
        List<Car> carList = cars.getCars();
        carList.forEach(car -> printCar(car.getName(), car.getDistance()));
        System.out.println();
    }

    private void printCar(String name, int distance) {
        System.out.print(name + " : ");
        IntStream.range(0, distance).
                mapToObj(i -> "-").
                forEach(System.out::print);
        System.out.println();
    }

    public void printWinner(Cars cars) {
        List<String> winners = cars.findWinners();
        String result = String.join(", ", winners);
        System.out.print(MessageConstant.WINNER_MESSAGE + result);
    }
}
