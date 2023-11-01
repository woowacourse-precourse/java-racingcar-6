package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Racing {
    private int tryNumber;
    private List<Car> cars;

    public Racing() {
        this.cars = new ArrayList<>();
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public void start() {
        carSetting();
        setTryNumber();
        playing();
    }

    private void playing() {
        while (this.tryNumber > 0) {
            carMove();
            this.tryNumber--;
        }
    }

    private void carMove() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void setTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = Console.readLine();
        try {
            this.tryNumber = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void carSetting() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        StringTokenizer stringTokenizer = new StringTokenizer(Console.readLine(), ",");

        while (stringTokenizer.hasMoreTokens()) {
            cars.add(new Car(stringTokenizer.nextToken()));
        }
    }
}