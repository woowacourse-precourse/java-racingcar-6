package racingcar.service;

import racingcar.dao.RacingCarInformationDao;

public class RacingCarInfoGetService {
    private RacingCarInformationDao racingCarInformationDao;

    public RacingCarInfoGetService(RacingCarInformationDao racingCarInformationDao) {
        this.racingCarInformationDao = racingCarInformationDao;
    }

    public int get(String name) {
        return racingCarInformationDao.get(name);
    }
}
