package racingcar.dto;

import java.util.List;

public class RoundDTO {
    private int round;
    private List<CarDTO> states;

    public RoundDTO(int round, List<CarDTO> states) {
        this.round = round;
        this.states = states;
    }


    public List<CarDTO> getStates() {
        return this.states;
    }

}
