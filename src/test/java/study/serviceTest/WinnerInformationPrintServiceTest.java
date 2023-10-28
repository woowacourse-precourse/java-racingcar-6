package study.serviceTest;

import org.junit.jupiter.api.Test;
import racingcar.dao.WinnerInformationDao;
import racingcar.service.WinnerInformationPrintService;

public class WinnerInformationPrintServiceTest {

    @Test
    void printTest() {
        WinnerInformationDao winnerInformationDao = new WinnerInformationDao();
        winnerInformationDao.add("car1");
        winnerInformationDao.add("car2");
        winnerInformationDao.add("car3");

        WinnerInformationPrintService winnerInformationPrintService = new WinnerInformationPrintService(winnerInformationDao);
        winnerInformationPrintService.print();
    }
}
