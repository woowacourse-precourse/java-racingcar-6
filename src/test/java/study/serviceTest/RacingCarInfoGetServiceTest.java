package study.serviceTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dao.RacingCarInformationDao;
import racingcar.service.RacingCarInfoGetService;

public class RacingCarInfoGetServiceTest {

    @Test
    void getTest() {
        RacingCarInformationDao racingCarInformationDao = new RacingCarInformationDao();
        racingCarInformationDao.put("car1", 1);

        RacingCarInfoGetService racingCarInfoGetService = new RacingCarInfoGetService(racingCarInformationDao);
        Assertions.assertThat(racingCarInfoGetService.get("car1")).isEqualTo(1);
    }
}
