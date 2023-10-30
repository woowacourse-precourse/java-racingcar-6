package racingcar.service;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.view.InputView;

public class GameService {
    private List<Car> cars = new ArrayList<>();
    private Integer tryCount = 0;
    private static final Integer MAX_CAR_NAME_LENGTH = 5;

    public void initGame() {
        // carNames를 입력받아 cars를 초기화
        String rawInputStringCarNames = InputView.requestInputCarNames();
        Set<String> carNames = convertInputToCarNameSet(rawInputStringCarNames);
        for(String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void playGame() {
        // TODO: 게임을 진행하는 메소드
    }

    public void endGame() {
        // TODO: 게임을 종료하는 메소드
    }

    private Set<String> convertInputToCarNameSet(String rawInputString) {
        Set<String> carNameSet = new HashSet<>();
        String[] splitedInputString = rawInputString.split(",");

        // 올바른 입력인지 검증
        for(String carName : splitedInputString) {
            if(carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }

            if(carNameSet.contains(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
            }

            carNameSet.add(carName);
        }

        return carNameSet;
    }
}
