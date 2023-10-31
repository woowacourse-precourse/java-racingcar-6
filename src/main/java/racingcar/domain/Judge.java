package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.InputHandler;
import racingcar.util.NumericUtility;
import racingcar.util.OutputHandler;

public class Judge {
    private List<Car> cars;
    private int numberOfAttempts;

    public Judge() {
        this.cars = new ArrayList<>();
    }

    public void setCars(String[] carNamesWithStringArray) {
        for (String carName : carNamesWithStringArray) {
            cars.add(new Car(carName));
        }
    }

    protected List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            int randomNumber = NumericUtility.getConvertedNumber();
            car.move(randomNumber);
        }
    }

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        setCars(InputHandler.makeCarNamesArray());
        System.out.println("시도할 회수는 몇회인가요?");
        numberOfAttempts = InputHandler.makeNumberOfAttempts();
        System.out.println("\n실행결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            moveCars();
            OutputHandler.printResult(this.cars);
        }
        selectWinner();
    }

    public void selectWinner() {
        int maxPosition = NumericUtility.findMaxPosition(this.cars);
        List<String> winners = getWinners(maxPosition);
        OutputHandler.printWinners(winners);
    }

    private List<String> getWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
