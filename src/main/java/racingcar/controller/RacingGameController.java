package racingcar.controller;

import racingcar.dto.UserRequestDTO;
import racingcar.service.RacingGameService;

import java.util.List;

public class RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameController() {
        this.racingGameService = new RacingGameService();
    }

    public void gameStart(UserRequestDTO userRequestDTO) {
        checkIllegalInput(userRequestDTO.getCarNames(), userRequestDTO.getTryNum());
        racingGameService.race(userRequestDTO.getCarNames(), userRequestDTO.getTryNum());
    }

    private void checkIllegalInput(String carNames, String tryNum) {
        try {
            checkTryNum(tryNum);
            checkCarNames(carNames);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCarNames(String carNames) {
        List<String> carNameList = List.of(carNames.split(","));
        if (carNameList.size() < 2 || carNameList.stream().anyMatch(carName -> carName.length() > 5))
            throw new IllegalArgumentException();
    }

    private void checkTryNum(String tryNumStr) {
        int tryNum = Integer.parseInt(tryNumStr);
        if (tryNum < 1) {
            throw new IllegalArgumentException();
        }
    }

}
