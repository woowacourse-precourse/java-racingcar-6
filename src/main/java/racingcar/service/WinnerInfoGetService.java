package racingcar.service;

import racingcar.dao.WinnerInformationDao;

public class WinnerInfoGetService {
    private WinnerInformationDao winnerInformationDao;

    public WinnerInfoGetService(WinnerInformationDao winnerInformationDao) {
        this.winnerInformationDao = winnerInformationDao;
    }

    public String get(int index) {
        return winnerInformationDao.get(index);
    }
}
