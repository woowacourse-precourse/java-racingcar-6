package racingcar.domain.service.receptionDesk.Impl;

import racingcar.domain.exception.Checker;
import racingcar.domain.reception.ReceptionDesk;
import racingcar.domain.service.receptionDesk.ReceptionDeskService;

import java.util.HashMap;

public class ReceptionDeskServiceImpl implements ReceptionDeskService {

    @Override
    public HashMap<String, Integer> registering(String lineUpStr) {
        String[] lineUpArr = Checker.hasCommasWithoutSurroundingValues(lineUpStr);
        Checker.lenCheck(lineUpArr);

        return ReceptionDesk.registering(lineUpArr);
    }
}
