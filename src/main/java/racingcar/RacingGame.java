package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public void start() {

        List<Car> cars = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarName(cars);

        //TODO: 경주 시도 횟수 입력 받기

        //TODO: 각 차수별 전진 상태 출력 하기

        //TODO: 우승자 출력 하기
    }
    public void inputCarName(List<Car> cars) {
        String[] carNames = Console.readLine().split(",");
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이내로 입력해 주세요");
            }
            if (name.contains(" ")) {
                name = name.replace(" ", "");
            }
            cars.add(new Car(name));
        }
    }
}
