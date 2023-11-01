package study.serviceTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dao.RacingCarInformationDao;
import racingcar.service.RacingCarForwardService;

public class RacingCarForwardServiceTest {

    @Test
    void forwardTest() {
        RacingCarInformationDao racingCarInformationDao = new RacingCarInformationDao();
        racingCarInformationDao.put("car1", 1);
        RacingCarForwardService racingCarForwardService = new RacingCarForwardService(racingCarInformationDao);
        racingCarForwardService.forward();
        Assertions.assertThat(racingCarInformationDao.get("car1")).isLessThan(3);

    }
}
