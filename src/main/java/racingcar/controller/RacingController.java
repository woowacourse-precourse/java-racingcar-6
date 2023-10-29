package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Game;
import racingcar.service.CarService;
import racingcar.service.GameService;
import java.util.List;
import java.util.stream.Collectors;


public class RacingController {

    private final GameService gameService = new GameService();
    private final CarService carService = new CarService();

    public void run() {
        initGame();
        gameStart();
    }

    public void initGame() {
        initInputCarAndRound();
        initCar();
        initBuilder();
    }

    public void initInputCarAndRound() {
        String carName = inputCarName();
        int carCount = this.carService.initInputCarName(carName);

        String inputRound = inputGameRound();
        int round = this.gameService.initGameRound(inputRound);

        this.gameService.initGame(carCount,round);
    }

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String inputGameRound() {
        System.out.println("게임 횟수 입력: ");
        return Console.readLine();
    }

    public void initCar() {
        this.carService.initCar();
    }

    public void initBuilder() {
        this.carService.initBuilder();
    }

    public void gameStart() {

        int roundCount = this.gameService.setGameRound();

        for (int roundIndex = 0; roundIndex < roundCount; roundIndex++) {
            this.carService.updateCarPosition();
        }
        getWinner();
    }

    public void getWinner() {
        List<String> winner = this.carService.getWinner();
        System.out.print("최종 우승자 : ");
        showWinner(winner);
    }

    public void showWinner(List<String> winner) {
        String result = winner.stream()
                .collect(Collectors.joining(","));

        System.out.print(result);
    }

}
