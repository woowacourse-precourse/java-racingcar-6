package racingcar.controller;

import static racingcar.constant.AllConstants.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.Rounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing { // 자동차 경주 진행 관련 기능

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
        startRacing();
        Map<String, Integer> carNameList = car.createCarNameList(inputView.inputCarName());
        int counts = rounds.getRounds(inputView.inputRounds());
        outputView.printTotalResult();
        playAllRounds(carNameList, counts);
        outputView.printWinnerList(getWinnerList(carNameList));
        finishRacing(carNameList);
    }

    private void startRacing() {
        outputView.printRaceStart();
    }

    public void playAllRounds(Map<String, Integer> carNameList, int rounds) { // 지정된 라운드수만큼 경기 진행
        for (int i = 0; i < rounds; i++) {
            Map<String, Integer> oneRoundResult = playOneRound(carNameList);
            outputView.printAllCarProgress(oneRoundResult);
        }
    }

    public Map<String, Integer> playOneRound(Map<String, Integer> carNameList) { // 한 라운드에서의 경기진행
        for (String carName : carNameList.keySet()) {
            int moves = carNameList.get(carName);
            int randomNum = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX); // 0~9 사이 임의의 숫자 선택
            carNameList.put(carName, progressOrNot(moves, randomNum));
        }
        return carNameList;
    }

    public Integer progressOrNot(int currentMoves, int randomNum) { // 임의의 숫자값에 따른 전진 여부 결정
        if (randomNum >= RANDOM_FOUR) {
            currentMoves += MOVE_FORWARD;
        }
        return currentMoves;
    }

    public List<String> getWinnerList(Map<String, Integer> carNameList) { // 최종 우승자 명단 생성
        List<String> result = new ArrayList<>();
        Integer maxValue = Collections.max(carNameList.values()); // 전진 횟수의 최대값 구하기
        for (String carName : carNameList.keySet()) {
            if (maxValue.equals(carNameList.get(carName))) {      // 최대값을 갖는 자동차 이름만 최종 우승자 명단에 저장
                result.add(carName);
            }
        }
        return result;
    }

    private void finishRacing(Map<String, Integer> carNameList) {
        outputView.printRaceFinish();
        carNameList.clear();
        Console.close();
    }
}