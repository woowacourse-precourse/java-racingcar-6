package racingcar.controller;

import static racingcar.constant.AllConstants.*;
import static racingcar.constant.RaceIOMessage.RACE_RESULT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.Rounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {
    private final InputView inputView;
    private final OutputView outputView;
    private final Car car;
    private final Rounds rounds;

    public Racing() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.car = new Car();
        this.rounds = new Rounds();
    }

    public void play() {
        // 자동차 경주 준비 및 진행 단계
        Map<String, Integer> carNameList = car.createCarNameList(inputView.inputCarName());
        int counts = rounds.getRounds(inputView.inputRounds());
        System.out.println(RACE_RESULT);
        for (int i = 0; i < counts; i++) {
            for (String carName : carNameList.keySet()) {
                // 현재 자동차의 전진/정지 여부 결정
                int randomNum = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
                int moves = carNameList.get(carName);
                if (randomNum >= RANDOM_FOUR) {
                    moves += MOVE_FORWARD;
                    carNameList.put(carName, moves);
                }
                // 해당 차수의 실행 결과 출력
                outputView.printRoundResult(carName, moves);
            }
            System.out.println();
        }

        // 자동차 경주 종료 단계
        // 가장 많이 전진한 자동차 명단 추리기
        Integer maxValue = Collections.max(carNameList.values());
        List<String> winnerList = new ArrayList<>();
        for (String carName : carNameList.keySet()) {
            if (maxValue.equals(carNameList.get(carName))) {
                winnerList.add(carName);
            }
        }

        // 최종 우승자 출력
        outputView.printWinnerList(winnerList);
    }
}