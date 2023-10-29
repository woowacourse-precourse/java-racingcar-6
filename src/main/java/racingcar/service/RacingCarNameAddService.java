package racingcar.service;

import racingcar.dao.RacingCarInformationDao;
import racingcar.verify.RacingCarNameVerify;

public class RacingCarNameAddService {
    private RacingCarNameScanService racingCarNameScanService;
    private RacingCarInformationDao racingCarInformationDao;

    public RacingCarNameAddService(RacingCarNameScanService racingCarNameScanService,
                                   RacingCarInformationDao racingCarInformationDao) {
        this.racingCarNameScanService = racingCarNameScanService;
        this.racingCarInformationDao = racingCarInformationDao;
    }

    public void add() {
        String names = racingCarNameScanService.getRacingCarNames();
        String[] carNames = names.split(",");

        RacingCarNameVerify racingCarNameVerify = new RacingCarNameVerify(racingCarNameScanService);
        if (racingCarNameVerify.verify()) {
            for(String carName : carNames) {
                racingCarInformationDao.put(carName, 0);
            }
        }
    }
}
