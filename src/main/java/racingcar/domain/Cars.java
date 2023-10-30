package racingcar.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;

    public Cars(List<String> carNames) {
        this.carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void playGame() {
        for (Car car : carList) {
            checkNumberAndMoveCar(car);
        }
    }

    private void checkNumberAndMoveCar(Car car) {
        int randomNumber = Computer.createRandomNumber();
        if (checkNumberOverThree(randomNumber)) {
            car.moveCar();
        }
    }

    private boolean checkNumberOverThree(int number) {
        return number > 3;
    }
}
