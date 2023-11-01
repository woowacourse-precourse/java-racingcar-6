package racingcar.service;

import racingcar.dao.WinnerInformationDao;

public class WinnerInformationGetService {
    private WinnerInformationDao winnerInformationDao;

    public WinnerInformationGetService(WinnerInformationDao winnerInformationDao) {
        this.winnerInformationDao = winnerInformationDao;
    }

    public String get(int index) {
        return winnerInformationDao.get(index);
    }
}
