package racingcar.controller;

import java.util.List;
import racingcar.domain.CarGroup;
import racingcar.dto.CarGroupDto;
import racingcar.dto.InputCarDto;
import racingcar.dto.WinnersDto;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();

    public void gameTask() {

        CarGroup carGroup = createCarGroup(InputView.printInputCarName());
        int roundNumber = getRoundNumber(InputView.printInputRound());

        outputView.printResultHeader();

        while (roundNumber != 0) {
            CarGroupDto carGroupDto = moveCarGroup(carGroup);
            outputView.printRoundResult(carGroupDto);
            roundNumber--;
        }

        WinnersDto winnersDto = getWinners(carGroup);
        outputView.printWinner(winnersDto);
    }

    public CarGroup createCarGroup(InputCarDto inputCarDto) {

        String carNames = inputCarDto.carName();
        String delimiter = inputCarDto.delimiter();

        return racingCarService.createCarGroup(carNames, delimiter);
    }

    private int getRoundNumber(String round) {
        return racingCarService.getRoundNumber(round);
    }

    private CarGroupDto moveCarGroup(CarGroup carGroup) {
        racingCarService.moveCarGroup(carGroup);

        return new CarGroupDto(carGroup.getCars());
    }

    public WinnersDto getWinners(CarGroup carGroup) {
        List<String> winners = racingCarService.getWinners(carGroup);

        return new WinnersDto(winners);
    }

}
