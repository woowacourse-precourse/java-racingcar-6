package racingcar;

import racingcar.domain.Stadium;
import racingcar.utils.InputManager;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String > userNames = (List<String>) InputManager.INPUT_NAME.input();
        System.out.println("시도할 회수는 몇회인가요?");
        Integer moveCount = (Integer)InputManager.INPUT_MOVE_COUNT.input();
        Stadium stadium= Stadium.of(moveCount, userNames);
        stadium.startRace();
        stadium.confirmWinner();
    }
}
