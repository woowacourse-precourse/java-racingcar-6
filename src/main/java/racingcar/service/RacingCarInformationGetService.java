package racingcar.service;

import racingcar.dao.RacingCarInformationDao;

public class RacingCarInformationGetService {
    private RacingCarInformationDao racingCarInformationDao;

    public RacingCarInformationGetService(RacingCarInformationDao racingCarInformationDao) {
        this.racingCarInformationDao = racingCarInformationDao;
    }

    public int get(String name) {
        return racingCarInformationDao.get(name);
    }
}
