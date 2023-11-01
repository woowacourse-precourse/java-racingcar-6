package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingcarGame {
    Input input = new Input();
    Cars cars = new Cars();
    Exception exception = new Exception();

    public void playRacingcarGame() {
        String carsName = input.inputCarName();
        String[] splitCarName = splitCarsName(carsName);
        exceptionSplitCarName(splitCarName);
        addCars(splitCarName);

        int number = input.inputNumber();
        playGame(number);
        printWinner(getWinner());
    }

    public String[] splitCarsName(String carsName) {
        return carsName.split(",");
    }

    public void exceptionSplitCarName(String[] splitCarName) {
        exception.validateNumberOfCarName(splitCarName);
        exception.validateDuplicateCarName(splitCarName);
    }

    public void addCars(String[] CarsName) {
        for (String name : CarsName) {
            Car car = new Car(name.trim(), 0);
            cars.addCarList(car);
        }
    }

    public void playGame(int number) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < number; i++) {
            printResult();
        }
    }

    public void printResult() {
        for (Car car : cars.carsList) {
            getRandom(car);
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void getRandom(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.incrementNumber();
        }
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxNumber = -1;

        for (Car car : cars.carsList) {
            if (car.getNumber() > maxNumber) {
                maxNumber = car.getNumber();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getNumber() == maxNumber) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1)
                System.out.print(", ");
        }
    }
}
