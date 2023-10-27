package study.serviceTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dao.WinnerInformationDao;
import racingcar.service.WinnerInfoGetService;

public class WinnerInfoGetServiceTest {

    @Test
    void getTest() {
        WinnerInformationDao winnerInformationDao = new WinnerInformationDao();
        winnerInformationDao.add("car1");

        WinnerInfoGetService winnerInfoGetService = new WinnerInfoGetService(winnerInformationDao);
        Assertions.assertThat(winnerInfoGetService.get(0)).isEqualTo("car1");
    }
}
