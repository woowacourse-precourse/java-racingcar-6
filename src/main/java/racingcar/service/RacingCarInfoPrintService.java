package racingcar.service;

import java.util.Map.Entry;
import racingcar.dao.RacingCarInformationDao;

public class RacingCarInfoPrintService {
    private RacingCarInformationDao racingCarInformationDao;

    public RacingCarInfoPrintService(RacingCarInformationDao racingCarInformationDao) {
        this.racingCarInformationDao = racingCarInformationDao;
    }

    public void print() {
        for(Entry<String, Integer> entry : racingCarInformationDao.getAll().entrySet()) {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
        System.out.println();
    }
}
