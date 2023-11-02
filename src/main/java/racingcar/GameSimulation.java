package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameSimulation {
    public static final int ZERO = 0;

    private int number;
    private final List<Car> cars;

    public GameSimulation() {
        this.cars = new ArrayList<>();
    }

    public void gamePlay() {
        lineUp();
        inputTryNum();
        raceStart(this.number);
        awards();
    }

    public void lineUp() {
        String userInput;
        String[] names;
        do {
            System.out.println("경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,) 기준으로 구분)");
            userInput = Console.readLine();
            names = userInput.split(",");
        } while (!Validator.checkName(names));
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

    public void inputTryNum() {
        String userInput;
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            userInput = Console.readLine();
        } while (!Validator.checkNumber(userInput));
        this.number = Integer.parseInt(userInput);
    }

    public void raceStart(int number) {
        System.out.println("실행 결과");
        while (number > ZERO) {
            for (Car car : this.cars) {
                car.moveCar();
                car.statusReport();
            }
            System.out.println();
            number--;
        }
    }

    public int findMaxPosition() {
        int maxPosition = ZERO;
        for (Car car : this.cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public void awards() {
        List<String> winners = new ArrayList<>();
        int maxPosition = findMaxPosition();
        for (Car car : this.cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }


}
