package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.RaceParticipants;
import racingcar.domain.Round;
import racingcar.service.RacingService;
import racingcar.utils.InputReader;
import racingcar.utils.PrintUtils;

public class RacingController {
    private final RacingService racingService;
    private final InputReader inputReader;

    public RacingController(RacingService racingService, InputReader inputReader) {
        this.racingService = racingService;
        this.inputReader = inputReader;
    }

    public void start() {
        String carNamesInput = inputReader.readLine();
        RaceParticipants raceParticipants = settingParticipants(carNamesInput);

        String roundInput = inputReader.readLine();
        Round round = settingRound(roundInput);

        racingService.startRound(raceParticipants, round);
        finishAndGetWinner(raceParticipants);
    }

    public Round settingRound(String roundInput) {
        return new Round(roundInput);
    }

    public RaceParticipants settingParticipants(String carNamesInput) {
        List<String> inputCarNames = Arrays.stream(carNamesInput.split(","))
                .map(String::trim).toList();
        return new RaceParticipants(inputCarNames);
    }

    public void finishAndGetWinner(RaceParticipants raceParticipants){
        List<String> winnerList = racingService.getWinner(raceParticipants);
        PrintUtils.printOutputWinner(winnerList);
    }
}
