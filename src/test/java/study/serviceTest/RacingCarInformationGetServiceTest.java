package study.serviceTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dao.RacingCarInformationDao;
import racingcar.service.RacingCarInformationGetService;

public class RacingCarInformationGetServiceTest {

    @Test
    void getTest() {
        RacingCarInformationDao racingCarInformationDao = new RacingCarInformationDao();
        racingCarInformationDao.put("car1", 1);

        RacingCarInformationGetService racingCarInformationGetService = new RacingCarInformationGetService(racingCarInformationDao);
        Assertions.assertThat(racingCarInformationGetService.get("car1")).isEqualTo(1);
    }
}
