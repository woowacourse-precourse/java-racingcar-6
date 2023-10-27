package racingcar.service;

import racingcar.domain.CarPark;
import racingcar.vo.RoundCount;

public interface InputConvertService {

    CarPark inputConvertCarPark(String input);

    RoundCount inputConvertRoundCount(String input);
}
