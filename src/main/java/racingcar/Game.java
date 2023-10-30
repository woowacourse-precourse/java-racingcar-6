package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private ArrayList<Car> cars = new ArrayList<Car>();
    private int times = 0;

    public void play() {
        String readLine;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        addCar(parser(readLine()));
        System.out.println("시도할 회수는 몇회인가요?");
        setTimes();
        moveCar();
        // System.out.println(readLine);

    }

    public String[] parser(String readLine) {
        String[] cars = readLine.trim().split("\\s*,\\s*");
        // System.out.println(Arrays.toString(cars));
        // parsing 하면서 error 검사하면 될 듯
        return cars;
    }

    public boolean checkValidate(String str) {
        return true;
    }

    private void addCar(String[] cars) {
        for (String car : cars) {
            this.cars.add(new Car(car));
        }
    }

    private void setTimes() {
        this.times = Integer.parseInt(readLine());
        // System.out.println(time);
    }

    public void moveCar() {
        for (int i=0; i<this.times; i++) {
            for (Car car : cars) {
                car.choosePosition();
            }
            System.out.println();
        }
    }
}
