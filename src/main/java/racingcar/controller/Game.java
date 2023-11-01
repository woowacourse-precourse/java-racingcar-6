package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import racingcar.domain.Car;
import racingcar.view.InputView;

public class Game {

    static private final String PROMPT_CAR_NAME = "경주할 자동차 이름을 입력하세요.";
    static private final String PROMPT_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    static private final String PROMPT_RUN = "실행 결과";
    static private final String PROMPT_RESULT = "최종 우승자 : ";
    private final List<Car> cars;
    private int tryNumber;

    public Game() {
        this.cars = new ArrayList<Car>();
        this.tryNumber = 0;
    }

    public Game(ArrayList<Car> cars, int tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public void init() {
        System.out.println(PROMPT_CAR_NAME);
        String[] names = InputView.getCarName();
        for (String name : names) {
            this.cars.add(new Car(name, 0));
        }
        System.out.println(PROMPT_TRY_NUMBER);
        this.tryNumber = InputView.getTryNumber();
        System.out.println();
    }

    public void run(BiFunction<Integer, Integer, Integer> randomFunction) {
        System.out.println(PROMPT_RUN);
        for (int tries = 0; tries < this.tryNumber; ++tries) {
            carForward(randomFunction);
            printCar();
            System.out.println();
        }
        System.out.println();
    }

    private void carForward(BiFunction<Integer, Integer, Integer> randomFunction) {
        for (Car car : this.cars) {
            car.forward(randomFunction);
        }

    }

    private void printCar() {
        for (Car car : this.cars) {
            System.out.println(car);
        }
    }
}
