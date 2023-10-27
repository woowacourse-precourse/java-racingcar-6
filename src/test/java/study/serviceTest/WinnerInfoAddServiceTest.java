package study.serviceTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dao.RacingCarInformationDao;
import racingcar.dao.WinnerInformationDao;
import racingcar.service.WinnerInfoAddService;

public class WinnerInfoAddServiceTest {

    @Test
    void addTest() {
        WinnerInformationDao winnerInformationDao = new WinnerInformationDao();
        RacingCarInformationDao racingCarInformationDao = new RacingCarInformationDao();
        racingCarInformationDao.put("car1", 3);
        racingCarInformationDao.put("car2", 2);
        racingCarInformationDao.put("car3", 5);

        WinnerInfoAddService winnerInfoAddService = new WinnerInfoAddService(winnerInformationDao, racingCarInformationDao);
        winnerInfoAddService.add();
        String[] example = {"car3"};

        Assertions.assertThat(winnerInformationDao.getAll().toArray()).isEqualTo(example);

    }
}
