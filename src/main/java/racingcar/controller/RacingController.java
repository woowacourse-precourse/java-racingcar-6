package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.utils.RandomUtils;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RoundCountValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RacingController {

    private Game game;
    private Car[] car;
    private List<String> carsName = new ArrayList<>();
    private int carCount;
    private StringBuilder[] builder;


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
        RoundCountValidator roundCountValidator = new RoundCountValidator();
        String inputRound = inputGameRound();
        if(roundCountValidator.validateInputGameRound(inputRound)) {
            int round = Integer.parseInt(inputRound);
            game = new Game(carCount, round);
        }
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
        List<String> winner = new ArrayList<>();
        int max =0;
        for (int i = 0; i < carCount; i++) {
            if(car[i].getPosition() > max) {
                winner.clear();
                winner.add(car[i].getCarName());
                max = car[i].getPosition();
            }else if(car[i].getPosition() == max) {
                winner.add(car[i].getCarName());
            }
        }
        System.out.print("최종 우승자 : ");
        showWinner(winner);
    }

    public void showWinner(List<String> winner) {
        String result = winner.stream()
                .collect(Collectors.joining(","));

        System.out.print(result);
    }

}
