package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Constant.*;

public class Game {
    private String inputString;
    private final Validator validator = new Validator();
    int n;
    private Car[] cars;
    private int count;
    private int winnerDistance;

    /*
    자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
    사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
     */
    void play() {
        init();
        start();
        printWinner();
    }

    private void init() {
        System.out.println(GAME_INIT_MSG);
        inputString = Console.readLine();
        initCars();

        System.out.println(GET_COUNT_MSG);
        inputString = Console.readLine();
        initCount();
        System.out.println();
        winnerDistance = 0;

    }

    private void initCars() {
        validator.validateGivenCarNames(inputString);
        String[] names = inputString.split(",");
        n = names.length;
        cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(names[i]);
        }


    }

    private void initCount() {
        validator.validateCount(inputString);
        count = Integer.parseInt(inputString);
    }

    private void start() {
        System.out.println(GAME_START_MSG);
        for (int i = 0; i < count; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
            System.out.println(car);
            if (car.moved.length() > winnerDistance) {
                winnerDistance = car.moved.length();
            }
        }
        System.out.println();
    }

    private void printWinner() {
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.moved.length() == winnerDistance) {
                winner.add(car.name);
            }
        }
        System.out.println(GAME_RESULT_MSG + String.join(", ", winner));
    }
}
