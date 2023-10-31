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

        validator.emptyName(cars);
        validator.lengthValidate(cars);
        validator.duplicatedName(cars);

        return new CarList(createCarList(cars));
    }

    public Integer inputAttempt() {
        OutputView.printAsk();
        String attempt = Console.readLine();

        validator.isNumber(attempt);

        return Integer.parseInt(attempt);
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
