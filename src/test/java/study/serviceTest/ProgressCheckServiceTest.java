package study.serviceTest;

import org.junit.jupiter.api.Test;
import racingcar.dao.RacingCarInformationDao;
import racingcar.service.ProgressCheckService;

public class ProgressCheckServiceTest {

    @Test
    void executeTest() {
        RacingCarInformationDao racingCarInformationDao = new RacingCarInformationDao();
        racingCarInformationDao.put("car1", 1);
        racingCarInformationDao.put("car2", 2);
        racingCarInformationDao.put("car3", 3);

        ProgressCheckService progressCheckService = new ProgressCheckService(racingCarInformationDao);
        progressCheckService.execute();
    }
}
