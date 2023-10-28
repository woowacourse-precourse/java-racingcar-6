package racingcar.service;

import java.util.Map.Entry;
import racingcar.dao.RacingCarInformationDao;

public class RacingCarInformationPrintService {
    private RacingCarInformationDao racingCarInformationDao;

    public RacingCarInformationPrintService(RacingCarInformationDao racingCarInformationDao) {
        this.racingCarInformationDao = racingCarInformationDao;
    }

    public void print() {
        for(Entry<String, Integer> entry : racingCarInformationDao.getAll().entrySet()) {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
        System.out.println();
    }
}
