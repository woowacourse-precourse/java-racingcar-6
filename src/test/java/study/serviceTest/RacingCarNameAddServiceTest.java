package study.serviceTest;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dao.RacingCarInformationDao;
import racingcar.service.RacingCarNameAddService;
import racingcar.service.RacingCarNameScanService;

public class RacingCarNameAddServiceTest {

    @Test
    void addTest() {
        RacingCarNameScanService racingCarNameScanService = new RacingCarNameScanService();
        RacingCarInformationDao racingCarInformationDao = new RacingCarInformationDao();

        String example = "cars1,cars2";    // 사용자가 입력한 값을 "cars" 라고 하자.
        System.setIn(new ByteArrayInputStream(example.getBytes()));
        Console.close();    // static 으로 정적 영역에 올라와 있는 Console.scanner 에 값이 있는 경우 null 로 바꾼다.
        racingCarNameScanService.readRacingCarNames();

        RacingCarNameAddService racingCarNameAddService = new RacingCarNameAddService(racingCarNameScanService, racingCarInformationDao);
        racingCarNameAddService.add();

        Assertions.assertThat(racingCarInformationDao.get("cars1")).isEqualTo(0);

    }
}
