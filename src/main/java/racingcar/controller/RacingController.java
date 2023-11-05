package racingcar.controller;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import java.util.ArrayList;
import java.util.List;

public class RacingController {
    public static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String HOW_MANY_ROUND_INPUT = "시도할 회수는 몇회인가요?";
    public static final String PLAY_RESULT = "실행 결과";
    public static final String WRONG_CAR_NAME_ERROR_MESSAGE = "차량 이름은 5글자 이하이어야 합니다.";
    public static final String NOT_A_INTEGER_NUMBER_ERROR_MESSAGE = "숫자만 입력 가능합니다.";

    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = new RacingService();
    }


    public List<Car> registerPlayer() {
        String userInput = readInput(CAR_NAME_INPUT);
        String[] stringCarArray = userInputToStringCarArray(userInput);

        validateCarNames(stringCarArray);

        return stringCarArrayToCarList(stringCarArray);
    }

    public int registerTotalRound() {
        String userInput = readInput(HOW_MANY_ROUND_INPUT);
        return userInputToInt(userInput);
    }

    public void playRacing(List<Car> carList, int totalRound) {
        List<String> result = new ArrayList<>();

        result.add(PLAY_RESULT);
        result.addAll(racingService.playAllRounds(carList, totalRound));

        printResult(result);
    }

    public void announceWinner(List<Car> carList) {
        String result = racingService.makeFinalResult(carList);
        printResult(result);
    }

    public void play() {
        List<Car> carList = registerPlayer();
        int totalRound = registerTotalRound();

        playRacing(carList, totalRound);

        announceWinner(carList);
    }

    public String[] userInputToStringCarArray(String userInput) {
        return userInput.split(",");
    }

    public int userInputToInt(String userInput) {
        int result;

        try {
            result = Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_A_INTEGER_NUMBER_ERROR_MESSAGE);
        }

        return result;
    }

    public void validateCarNames(String[] carArray) {
        for (String carName : carArray) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(WRONG_CAR_NAME_ERROR_MESSAGE);
            }
        }
    }


    public List<Car> stringCarArrayToCarList(String[] stringCarrArray) {
        List<Car> carList = new ArrayList<>();

        for (String carName : stringCarrArray) {
            carList.add(new Car(carName, 0));
        }

        return carList;
    }


}
