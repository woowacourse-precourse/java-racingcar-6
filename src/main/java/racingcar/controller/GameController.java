package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.domain.Message.RESULT;

public class GameController {

    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void run(){
        //자동차 이름 받기, 시도 횟수 정하기
        List<Car> cars = InputView.inputCarName();
        int times = InputView.inputTimes();

        //실행결과
        System.out.println("\n" + RESULT);

        //시도 횟수 for문
        for(int i = 0; i< times; i++){
            OutputView.printResult(gameService.racing(cars));
        }

        //최종 승자 보여주기

        OutputView.printFinalWinner(gameService.getFinalWinner(cars));

    }

}
