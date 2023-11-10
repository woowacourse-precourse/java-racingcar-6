package racingcar.controller;

import static racingcar.view.ErrorMessage.*;
import static racingcar.view.InputView.*;
import static racingcar.view.OutputMessage.*;
import static racingcar.view.OutputView.*;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = new RacingService();
    }


    public List<Car> registerPlayer() {
        String userInput = readPlayer();
        String[] stringCarArray = userInputToStringCarArray(userInput);

        validateCarNames(stringCarArray);

        return stringCarArrayToCarList(stringCarArray);
    }

    public int registerTotalRound() {
        String userInput = readTotalRound();
        return userInputToInt(userInput);
    }

    public void playRacing(List<Car> carList, int totalRound) {
        List<String> result = new ArrayList<>();

        result.add(PLAY_RESULT.getOutputMessage());
        result.addAll(racingService.playAllRounds(carList, totalRound));

        printResult(result);
    }

    public void announceWinner(List<Car> carList) {
        List<String> winnerList = racingService.generateWinnerList(carList);
        printWinner(winnerList);
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
            throw new IllegalArgumentException(NOT_A_INTEGER_NUMBER_ERROR_MESSAGE.getErrorMessage());
        }

        return result;
    }

    public void validateCarNames(String[] carArray) {
        for (String carName : carArray) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(WRONG_CAR_NAME_ERROR_MESSAGE.getErrorMessage());
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
