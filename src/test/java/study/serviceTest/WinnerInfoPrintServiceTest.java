package study.serviceTest;

import org.junit.jupiter.api.Test;
import racingcar.dao.WinnerInformationDao;
import racingcar.service.WinnerInfoPrintService;

public class WinnerInfoPrintServiceTest {

    @Test
    void printTest() {
        WinnerInformationDao winnerInformationDao = new WinnerInformationDao();
        winnerInformationDao.add("car1");
        winnerInformationDao.add("car2");
        winnerInformationDao.add("car3");

        WinnerInfoPrintService winnerInfoPrintService = new WinnerInfoPrintService(winnerInformationDao);
        winnerInfoPrintService.print();
    }
}
