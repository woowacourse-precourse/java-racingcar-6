package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.service.GenerateCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * 전체 게임을 동작시키는 Controller
 */
public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final GenerateCarService generateCarService = new GenerateCarService();
    private final Cars cars = new Cars();
    private int attempCount = 0;

    /**
     * 게임시작 메서드
     */
    public void startGame() {
        initGame();
        run();
        result();
    }


    /**
     * 게임 시작전 이름과 수행횟수 입력받아 세팅하는 메서드
     */
    public void initGame() {
        List<String> names = inputView.inputNames(); //자동차 이름 입력받기
        generateCarService.setCars(names, cars);
        attempCount = inputView.inputAttempCount(); //시도 횟수 입력받기
    }

    /**
     * 게임 시작 attempCount 횟수만큼 게임 진행
     */
    public void run() {
        outputView.printStartGame();
        int current = 1;
        while (current <= attempCount) {
            cars.move();
            outputView.printCurrentGame(cars);
            current++;
        }
    }

    /**
     * 게임 결과를 진행하는 메서드
     */
    private void result() {
        List<String> winners = cars.getWinner();
        outputView.printResult(winners);
    }
}
