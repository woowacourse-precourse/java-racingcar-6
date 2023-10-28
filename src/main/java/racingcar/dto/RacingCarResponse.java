package racingcar.dto;

import racingcar.model.Name;
import racingcar.model.Position;

public class RacingCarResponse {

    private Name name;
    private Position position;

    public RacingCarResponse(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
