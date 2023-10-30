package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int FORWARD_NUMBER = 4;
    private static final int INITIAL_MAX_VALUE = -1;

    // 쉼표(,)를 기준으로 입력된 자동차 이름 분해 후 List에 저장
    public List<String> parseCarName(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public void play(Game game) {
        moveForwardOfGame(game);
        game.increaseTriedNum();
    }

    public List<String> getWinner(Game game) {
        List<Car> cars = game.getCars();
        // maxPosition 뽑기
        int maxPosition = getMaxPosition(cars);
        return getMaxPositionCars(cars, maxPosition);
    }

    private void moveForwardOfGame(Game game) {
        for (Car car : game.getCars()) {
            moveForwardByRandomNumber(car);
        }
    }

    // 무작위 값이 4 이상일 때 전진
    private void moveForwardByRandomNumber(Car car) {
        if (pickRandomNumber() >= FORWARD_NUMBER) {
            car.moveForward(1);
        }
    }

    // 자동차 별 무작위 값을 구함
    private Integer pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    // position이 가장 큰 자동차의 이름 배열에 저장
    private List<String> getMaxPositionCars(List<Car> cars, int maxPosition) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                carNames.add(car.getName());
            }
        }
        return carNames;
    }

    // 가장 큰 position 값 구하기
    private int getMaxPosition(List<Car> cars) {
        int max = INITIAL_MAX_VALUE;
        for (Car car : cars) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        return max;
    }
}
