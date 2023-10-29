package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;
    private final View view = new View();

    public Cars(String names) {
        String[] splitNames = names.split(",");
        cars = Arrays.stream(splitNames)
                .map(name -> new Car(name.strip()))
                .collect(Collectors.toList());
        validateCarNames();
    }

    private void validateCarNames() {
        InputValidator validator = new InputValidator();
        validator.nameNonInputValidate(cars.size(), firstElement().getName());
        for (Car car : cars) {
            validator.nameLengthValidate(car);
        }
    }

    private Car firstElement() {
        return cars.get(0);
    }

    public void roundStatus(int round) {
        for (int i = 0; i < round; i++) {
            printRoundResult();
        }
    }

    private void printRoundResult() {
        for (Car car : cars) {
            updatePositionComparedToRandNum(car);
            view.carResultMsg(car.getName(), car.process());
        }
        view.printEmptyLine();
    }

    private void updatePositionComparedToRandNum(Car car) {
        int randNum = Randoms.pickNumberInRange(0, 9);
        if (randNum >= 4) {
            car.updatePosition();
        }
    }
}
