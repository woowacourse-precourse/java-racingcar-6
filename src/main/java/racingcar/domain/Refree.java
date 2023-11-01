package racingcar.domain;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class Refree {
    public List<Car> cars;
    public void playRace() {
        CarGenerator carGenerator = new CarGenerator();

        String carList = Console.readLine();
        cars = carGenerator.createCar(carList);

        int moveNum = Integer.parseInt(Console.readLine());
        for(int i = 0; i < moveNum; i++) {
            playTurn();
        }
    }
    public Boolean isForward(int num) {
        return num >= 4;
    }

    public void playTurn() {
        NumberGenerator numberGenerator = new NumberGenerator();
        for (Car car : cars) {
            int randNum = numberGenerator.createRandomNumber();
            if (isForward(randNum)) {
                car.moveForward();
            }
        }

        for (Car car : cars) {
            car.printStatus();
        }
    }
}
