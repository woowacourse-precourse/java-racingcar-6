package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.domain.Message.RESULT;

public class GameController {

    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void run() throws IllegalArgumentException{
        //자동차 이름 받기, 시도 횟수 정하기
        List<Car> cars = new ArrayList<>();
        int times = 0;
        try {
            cars = InputView.inputCarName();
            times = InputView.inputTimes();
        }catch(IllegalArgumentException e) {
            e.printStackTrace();
            return;
        }

        //실행결과
        System.out.println("\n" + RESULT);

        //게임
        for(int i = 0; i< times; i++){
            cars = gameService.racing(cars);
            OutputView.printRoundResult(cars); //경기 결과 보여주기
            gameService.setRacingResult(cars); //실제 경기 결과 반영
            //OutputView.printRoundResult( gameService.setRacingResult(cars)); //바뀐 숫자
        }

        //최종 승자 보여주기
        OutputView.printFinalWinner(gameService.getFinalWinner(cars));
    }

}
