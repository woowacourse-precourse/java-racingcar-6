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

    // 쉼표(,)를 기준으로 입력된 자동차 이름 분해 후 List에 저장
    public List<String> parseCarName(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public void play(Game game) {
        moveForwardOfGame(game);
        game.increaseTriedNum();
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
}
