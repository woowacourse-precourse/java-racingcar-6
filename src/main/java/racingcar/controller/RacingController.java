package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.service.GameService;
import racingcar.utils.RandomUtils;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RoundCountValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RacingController {

    private Car[] car;
    private Game game;
    private List<String> carsName = new ArrayList<>();
    private StringBuilder[] builder;
    private final GameService gameService = new GameService();


    private int carCount;


    public void setGame() {
        initGame();
        gameStart();
    }

    public void initGame() {
        initInputCarName();
        initGameRound();
        initCar();
        initStringBuilder();
    }

    public void initInputCarName() {
        String carName = inputCarName();
        CarNameValidator carNameValidator = new CarNameValidator();

        for (String word : carName.split(",")) {
            if(carNameValidator.validateInputCarName(word)) {
                carsName.add(word);
            }
        }
        carCount = carsName.size();
    }

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public void initGameRound() {
        String inputRound = inputGameRound();
        game = gameService.initGameRound(inputRound, carCount);
    }


    public String inputGameRound() {
        System.out.println("게임 횟수 입력: ");
        return Console.readLine();
    }

    public void initCar() {
        int carsCount = game.getCarsCount();
        car = new Car[carsCount];

        for (int i=0; i<carsCount; i++) {
            car[i] = new Car(carsName.get(i),0);
        }
    }

    public void initStringBuilder() {
        builder = new StringBuilder[carCount];
        for (int stringBuilderIndex = 0; stringBuilderIndex < carCount; stringBuilderIndex++) {
            builder[stringBuilderIndex] = new StringBuilder(carsName.get(stringBuilderIndex)).append(" : ");
        }
    }

    public void gameStart() {
        int roundCount = game.getRoundCount();

        for (int roundIndex = 0; roundIndex < roundCount; roundIndex++) {
            updateCarPosition();
        }
        getWinner();
    }

    public void updateCarPosition() {
        for (int carIndex = 0; carIndex < carCount ; carIndex++) {
            String position = RandomUtils.detarminPostionByRandomNumber();
            if(car[carIndex].increasePosition(position)) {
                stringBuilderToCarPosition(carIndex);
            };
        }
        showGameStatus();
    }

    public void stringBuilderToCarPosition(int carIndex) {
        builder[carIndex].append("-");
    }

    public void showGameStatus() {
        for (int i = 0; i < carCount; i++) {
            System.out.println(builder[i].toString());
        }
        System.out.println();
    }

    public void getWinner() {
        List<String> winner = this.gameService.getWinner(carCount, car);
        System.out.print("최종 우승자 : ");
        showWinner(winner);
    }

    public void showWinner(List<String> winner) {
        String result = winner.stream()
                .collect(Collectors.joining(","));

        System.out.print(result);
    }

}
