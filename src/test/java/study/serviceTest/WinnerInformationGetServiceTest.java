package study.serviceTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dao.WinnerInformationDao;
import racingcar.service.WinnerInformationGetService;

public class WinnerInformationGetServiceTest {

    @Test
    void getTest() {
        WinnerInformationDao winnerInformationDao = new WinnerInformationDao();
        winnerInformationDao.add("car1");

        WinnerInformationGetService winnerInformationGetService = new WinnerInformationGetService(winnerInformationDao);
        Assertions.assertThat(winnerInformationGetService.get(0)).isEqualTo("car1");
    }
}
