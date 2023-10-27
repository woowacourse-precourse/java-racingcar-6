package racingcar.service;

import racingcar.dao.WinnerInformationDao;

public class WinnerInfoPrintService {
    private WinnerInformationDao winnerInformationDao;

    public WinnerInfoPrintService(WinnerInformationDao winnerInformationDao) {
        this.winnerInformationDao = winnerInformationDao;
    }

    public void print() {

        for (String name : winnerInformationDao.getAll()) {
            System.out.print(name);
            if (winnerInformationDao.getAll().indexOf(name) != winnerInformationDao.size() - 1) {
                System.out.print(", ");
            }
        }


    }
}
