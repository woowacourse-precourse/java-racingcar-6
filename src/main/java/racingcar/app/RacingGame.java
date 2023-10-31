package racingcar.app;

import static racingcar.global.util.GameInput.inputCarList;
import static racingcar.global.util.GameOutput.printResult;
import static racingcar.global.util.GameOutput.printVictory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.global.util.GameInput;

public class RacingGame {

    private int cnt;
    private List<Car> carList;
    private List<Map<String, String>> result = new ArrayList<>();

    /**
     * 메인 함수에서 호출하는 메서드
     */
    public void start() {
        // 사용자 입력
        carList = Arrays.stream(inputCarList())
                .map(Car::new)
                .collect(Collectors.toList());

        cnt = GameInput.inputRoundCnt();

        play();
    }

    private void play() {
        while (true) {
            Round round = new Round();
            round.init(carList, cnt);
            round.play();

            result.add(round.saveResult());

            if (hasVictory(round)) {
                break;
            }
        }
    }

    private boolean hasVictory(Round round) {
        if (!round.victory().isEmpty()) {
            printResult(result);
            printVictory(round.victory());
            return true;
        }
        return false;
    }

}
