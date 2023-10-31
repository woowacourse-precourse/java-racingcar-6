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
     * 메인 함수에서 호출하는 게임 실행 메서드
     * - 사용자 입력을 받아 Racing 게임을 시작한다
     */
    public void start() {
        // 사용자 입력
        carList = Arrays.stream(inputCarList())
                .map(Car::new)
                .collect(Collectors.toList());

        cnt = GameInput.inputRoundToEndCnt();

        play();
    }

    /**
     * 승리한 차량이 나올 때까지 라운드를 반복하는 함수
     * - 매 라운드마다
     */
    private void play() {
        Round round = new Round();
        round.init(carList, cnt);

        while (true) {
            round.play();
            result.add(round.saveResult());

            if (hasVictory(round)) {
                break;
            }
        }
    }

    /**
     * 승리한 차량이 존재하는지 판단하기 위한 메서드
     * @param round
     * @return
     */
    private boolean hasVictory(Round round) {
        if (!round.victory().isEmpty()) {
            printResult(result);
            printVictory(round.victory());
            return true;
        }
        return false;
    }

}
