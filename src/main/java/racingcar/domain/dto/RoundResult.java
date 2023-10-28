package racingcar.domain.dto;

import java.util.List;

public class RoundResult {

    List<CarRecord> round;

    public RoundResult(List<CarRecord> round){
        this.round = round;
    }

    public List<CarRecord> getRound() {
        return round;
    }
}
