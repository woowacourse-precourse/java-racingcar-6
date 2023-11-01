package racingcar.domain.controller;

import racingcar.domain.GameNumber;
import racingcar.domain.Names;
import racingcar.domain.service.CreateListService;
import racingcar.domain.service.OutputService;
import racingcar.global.constant.OutputType;
import racingcar.global.utils.ConsoleUtil;
import racingcar.global.utils.generator.InputNamesGenerator;
import racingcar.global.utils.generator.InputNumberOfGames;

import java.util.List;

public class RacingCarController {

    private final CreateListService createListService;
    private final OutputService outputService;

    public RacingCarController(CreateListService createListService, OutputService outputService) {

        this.createListService = createListService;
        this.outputService = outputService;
    }

    public void run() {
        ConsoleUtil.commonOutputLine(OutputType.INPUT_NAMES.getComment());
        Names names = new Names(new InputNamesGenerator());

        ConsoleUtil.commonOutputLine(OutputType.INPUT_NUMBER_OF_GAMES.getComment());
        GameNumber gameNumber = new GameNumber(new InputNumberOfGames());

        List<List<Integer>> transposeAndDistanceList = createListService.transposeAndDistanceList(names, gameNumber);
        outputService.outputDistance(transposeAndDistanceList, names, gameNumber);
        outputService.outputWinner(transposeAndDistanceList, names, gameNumber);
    }
}

