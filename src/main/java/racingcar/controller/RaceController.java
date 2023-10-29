package racingcar.controller;

import java.util.List;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final RaceService raceService;
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(RaceService raceService, InputView inputView, OutputView outputView) {
        this.raceService = raceService;
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void race() {
        int tryCount = setupRace();
        raceWholeRound(tryCount);
        printFinalWinner();
    }

    private int setupRace() {
        inputView.printAskName();

        List<String> carNames = inputView.getCarNames();
        raceService.init(carNames);

        inputView.printAskCount();
        return inputView.getTryCount();
    }


    private void raceWholeRound(int tryCount) {
        while (tryCount-- > 0) {
            //TODO: raceService.경주차 이동()을 통해 HashMap의 값 갱신 및 DTO 반환

            //TODO: outputView에 DTO를 전달하여 라운드 진행 상황을 출력
        }
    }

    private void printFinalWinner() {
        //TODO: raceService.getResult()를 통해 최종 우승자 결과를 전달받음 List<String>

        //TODO: outputView.printResult()를 통해 최종 우승자 결과를 출력
    }
}
