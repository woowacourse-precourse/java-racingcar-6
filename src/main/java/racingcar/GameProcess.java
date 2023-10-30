package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameProcess {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int FORWARD_NUMBER = 4;

    public void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        List<String> carList = parseCarName(carName);

        System.out.println("시도할 회수는 몇회인가요?");
        String countTrial = Console.readLine();

        System.out.println(carList);
    }

    // 쉼표(,)를 기준으로 입력된 자동차 이름 분해 후 List에 저장
    public List<String> parseCarName(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    // 자동차 별 무작위 값을 구함
    private Integer pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    // 무작위 값이 4 이상일 때 전진
    private void moveForwardByRandomNumber(Car car) {
        if (pickRandomNumber() >= FORWARD_NUMBER) {
            car.moveForward(1);
        }
    }
}
