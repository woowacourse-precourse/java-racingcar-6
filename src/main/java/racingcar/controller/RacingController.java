package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
        RaceParticipants raceParticipants = settingParticipants();
        Round round = settingRound();
        racingService.startRound(raceParticipants, round);
    }

    private Round settingRound() {
        PrintUtils.printInputRacingNumber();
        return new Round(inputReader.readLine());
    }

    private RaceParticipants settingParticipants() {
        PrintUtils.printInputCarName();
        List<String> inputCarNames = Arrays.stream(inputReader.readLine().split(","))
                .map(String::trim).collect(Collectors.toList());
        return new RaceParticipants(inputCarNames);
    }

}
