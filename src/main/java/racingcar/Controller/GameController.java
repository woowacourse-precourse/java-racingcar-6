package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;
import racingcar.Model.RandomNumberGenerator;
import racingcar.Util.NameUtil;
import racingcar.Util.ValidateTryNumber;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class GameController {

    String carsName;
    int tryNumber;
    List<String> carsNameList;
    List<Car> cars = new ArrayList<>();

    public void playGame() {
        inputCarsName();
        howManyTimesToTry();
        this.carsNameList = NameUtil.splitName(this.carsName);
        makeCarsList(this.carsNameList);
        tryingResult(this.cars);
        printWinner();
    }

    public void inputCarsName() {
        InputView.printInputCarsName();
        this.carsName = Console.readLine();
    }

    public void howManyTimesToTry() {
        InputView.printHowManyTimesToTry();
        int inputTryNumber = Integer.parseInt(Console.readLine());
        ValidateTryNumber.validateTryNumberIsPositive(inputTryNumber);
        this.tryNumber = inputTryNumber;
    }

    public void makeCarsList(List<String> carsNameList) {
        carsNameList.forEach(carName -> this.cars.add(Car.from(carName)));
    }

    public void tryingResult(List<Car> cars) {
        OutputView.printResult();
        for (int i = 0; i < this.tryNumber; i++) {
            moveCars(cars);
            printCarsLocation(cars);
        }
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (canMove()) {
                // goForward 수정 필요
                car.goForward(car);
            }
        }
    }

    public boolean canMove() {
        int randomNumber = RandomNumberGenerator.newInstance().getRandomNumber();
        return randomNumber > 3;
    }

    public void printCarsLocation(List<Car> cars) {
        for (Car car : cars) {
            printCarLocation(car);
        }
        System.out.println();
    }

    public void printCarLocation(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner() {
        OutputView.printWinner();
        System.out.print(checkWhoIsWinner(this.cars));
    }

    public String checkWhoIsWinner(List<Car> cars) {
        int maxLocation = cars.stream()
                .map(Car::getLocation)
                .max(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);

        List<String> winnerCars = cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .toList();

        return String.join(", ", winnerCars);
    }
}