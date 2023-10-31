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

    private void checkIllegalInput(String carNames, String tryNumStr) {
        try {
            int tryNum = Integer.parseInt(tryNumStr);
            if (tryNum < 1) {
                throw new IllegalArgumentException();
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }

        List<String> carNameList = List.of(carNames.split(","));
        if (carNameList.size() < 2) throw new IllegalArgumentException();
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

}
