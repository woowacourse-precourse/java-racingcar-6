package racingcar.domain;

import java.util.List;
import racingcar.dto.CarDTO;
import racingcar.dto.RoundDTO;

public class Round {
    private int round;
    private List<CarDTO> result;

    public Round(int round, List<CarDTO> result) {
        this.round = round;
        this.result = result;
    }

    public RoundDTO toDTO() {
        int round = this.round;
        List<CarDTO> states = this.result;

        return new RoundDTO(round, states);
    }

}
