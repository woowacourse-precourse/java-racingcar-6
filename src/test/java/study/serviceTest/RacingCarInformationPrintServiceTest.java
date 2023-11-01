package study.serviceTest;

import org.junit.jupiter.api.Test;
import racingcar.dao.RacingCarInformationDao;
import racingcar.service.RacingCarInformationPrintService;

public class RacingCarInformationPrintServiceTest {

    @Test
    void printTest() {
        RacingCarInformationDao racingCarInformationDao = new RacingCarInformationDao();
        racingCarInformationDao.put("car1", 1);
        racingCarInformationDao.put("car2", 3);
        racingCarInformationDao.put("car3", 2);

        RacingCarInformationPrintService racingCarInfoGetService = new RacingCarInformationPrintService(racingCarInformationDao);
        racingCarInfoGetService.print();
    }
}
