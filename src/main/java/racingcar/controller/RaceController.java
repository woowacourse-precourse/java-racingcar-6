package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.constant.RaceConstant;
import racingcar.domain.Game;
import racingcar.domain.RacingCar;
import racingcar.dto.RaceResultResponse;
import racingcar.dto.WinnerResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void race(){
        RacingCar racingCar = setUp();
        outputView.printRaceResultMessage();
        for (int i = RaceConstant.START_INDEX; i < racingCar.getRaceCount(); i++) {
            Game game = new Game();
            List<Integer> raceResult = game.updateRaceResult(racingCar);
            RaceResultResponse response = new RaceResultResponse(racingCar.getCars(), raceResult);
            outputView.printRaceResult(response);
            checkWinner(racingCar, i, response);
        }
    }

    private void checkWinner(RacingCar racingCar, int i, RaceResultResponse response) {
        if (isFinalRound(racingCar, i)) {
            List<Integer> finalResult = response.getRaceResult();
            List<String> winner = IntStream.range(RaceConstant.START_INDEX, finalResult.size())
                    .filter(k -> finalResult.get(k) == searchMax(finalResult))
                    .mapToObj(response.getCars()::get)
                    .collect(Collectors.toList());
            WinnerResponse winnerResponse = new WinnerResponse(winner);
            outputView.printWinner(winnerResponse);
        }
    }

    private static boolean isFinalRound(RacingCar racingCar, int i) {
        return i == racingCar.getRaceCount() - 1;
    }

    private static int searchMax(List<Integer> finalResult) {
        return finalResult.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    private RacingCar setUp(){
        RacingCar racingCar = new RacingCar();
        racingCar.updateCars(inputView.getCars());
        racingCar.updateRaceCount(inputView.getRaceCount());
        return racingCar;
    }
}