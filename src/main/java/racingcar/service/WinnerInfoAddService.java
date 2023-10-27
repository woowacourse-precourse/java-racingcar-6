package racingcar.service;

import java.util.Collections;
import java.util.Map.Entry;
import racingcar.dao.RacingCarInformationDao;
import racingcar.dao.WinnerInformationDao;

public class WinnerInfoAddService {
    private WinnerInformationDao winnerInformationDao;
    private RacingCarInformationDao racingCarInformationDao;

    public WinnerInfoAddService(WinnerInformationDao winnerInformationDao, RacingCarInformationDao racingCarInformationDao) {
        this.winnerInformationDao = winnerInformationDao;
        this.racingCarInformationDao = racingCarInformationDao;
    }

    public void add() {
        int maxValue = Collections.max(racingCarInformationDao.getAll().values());
        for (Entry<String, Integer> entry : racingCarInformationDao.getAll().entrySet()) {
            if (entry.getValue() == maxValue) {
                winnerInformationDao.add(entry.getKey());
            }
        }
    }
}
