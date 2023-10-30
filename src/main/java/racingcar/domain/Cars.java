package racingcar.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.response.RoundResultDto;
import racingcar.view.OutputView;

public class Cars {
    private OutputView outputView = new OutputView();
    private List<Car> carList;

    public Cars(List<String> carNames) {
        this.carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void playGame() {
        for (Car car : carList) {
            checkNumberAndMoveCar(car);
            printCarInfo(car);
        }
        System.out.println();
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

    private void printCarInfo(Car car) {
        outputView.printRoundResult(car.getCarInfo());
    }
}
