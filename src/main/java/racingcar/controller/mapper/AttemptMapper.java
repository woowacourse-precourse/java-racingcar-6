package racingcar.controller.mapper;

import racingcar.model.vo.Attempt;

public class AttemptMapper {
    public Attempt toAttempt(String attempt) {
        return new Attempt(Integer.parseInt(attempt));
    }
}
