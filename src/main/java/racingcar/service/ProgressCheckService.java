package racingcar.service;

import racingcar.dao.RacingCarInformationDao;

public class ProgressCheckService {
    private RacingCarInformationDao racingCarInformationDao;

    public ProgressCheckService(RacingCarInformationDao racingCarInformationDao) {
        this.racingCarInformationDao = racingCarInformationDao;
    }

    public void execute() {
        int count = 0;
        while(count != TryNumberStringToIntService.tryNumber) {
            RacingCarForwardService racingCarForwardService = new RacingCarForwardService(racingCarInformationDao);
            racingCarForwardService.forward();

            RacingCarInformationPrintService racingCarInformationPrintService = new RacingCarInformationPrintService(racingCarInformationDao);
            racingCarInformationPrintService.print();

            count ++;
        }

    }
}
