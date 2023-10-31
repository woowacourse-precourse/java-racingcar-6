package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.validation.Validator;

import java.util.ArrayList;
import java.util.Arrays;

public class InputView {
    private Validator validator;

    public InputView() {
        this.validator = new Validator();
    }

    public CarList inputPlayer() {
        OutputView.printStart();
        String[] cars = Console.readLine().split(",");

        return new CarList(createCarList(cars));
    }

    public ArrayList<Car> createCarList(String[] cars) {
        ArrayList<Car> carList = new ArrayList<>();

        Arrays.stream(cars)
                .forEach(car->{
                    carList.add(new Car(car));
                });
        return carList;
    }
}
