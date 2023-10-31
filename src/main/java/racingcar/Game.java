package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private ArrayList<Car> cars = new ArrayList<Car>();
    private int times = 0;

    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        addCar(parser(readLine()));
        System.out.println("시도할 회수는 몇회인가요?");
        setTimes();
        moveCar();
        printWinner();
    }

    public String[] parser(String readLine) {
        Validator validator = new Validator();

        String[] cars = readLine.trim().split("\\s*,\\s*");
        validator.isNameValidated(cars);
        return cars;
    }

    private void addCar(String[] cars) {
        for (String car : cars) {
            this.cars.add(new Car(car));
        }
    }

    private void setTimes() {
        Validator validator = new Validator();

        String timeValue = readLine();
        validator.isTimesValidated(timeValue);
        this.times = Integer.parseInt(timeValue);
    }

    public void moveCar() {
        for (int i=0; i<this.times; i++) {
            for (Car car : cars) {
                car.choosePosition();
            }
            System.out.println();
        }
    }

    public void printWinner() {
        int max = -1;
        ArrayList<String> winners = new ArrayList<String>();
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winners.add(car.getName());
            }
        }
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
