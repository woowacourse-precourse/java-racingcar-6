package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class RacingGame {

    String[] names;
    private int carnum;
    private ArrayList<Car> cars;

    public RacingGame() {
        progress();
    }

    private void progress() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        inputName();
        createCar();

        System.out.println("시도할 회수는 몇회인가요?");
        int num = inputNumber();

        System.out.println("\n실행 결과");

    }

    private void inputName() {
        String[] names = Console.readLine().split(",");
        //검사-자동차 수가 2개보다 작으면 예외처리
        if (names.length <= 1) {
            throw new IllegalArgumentException();
        }
        this.carnum = names.length; //
        this.names = names;
    }

    private int inputNumber() {
        int num;
        try {
            //검사
            num = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException();
        }
        return num;
    }

    private void createCar() {
        cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }
}
