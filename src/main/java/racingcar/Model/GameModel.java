package racingcar.Model;

import racingcar.Domain.CarGroup;

public interface GameModel {
    CarGroup playGameRound(CarGroup carGroup);

    Boolean determineMove();
}
