package racingcar;


import java.util.List;
import java.util.stream.Collectors;

public class CarField {

    private final StringConverter stringConverter;

    CarField() {
        this.stringConverter = new StringConverter();
    }

    private int round;
    private List<Car> cars;

    public void run() {
        OutputView.printInitCars();
        List<String> carNames = stringConverter.stringToCarNames(",");
        cars = carNames.stream()
                .map(Car::attendCar)
                .collect(Collectors.toUnmodifiableList());


        OutputView.printRoundSet();
        round = stringConverter.stringToInteger();

        while(round-- > 0){
            cars.stream()
                    .forEach(Car::roundStart);

            cars.stream()
                    .forEach(OutputView::printCarField);
        }
    }


}
