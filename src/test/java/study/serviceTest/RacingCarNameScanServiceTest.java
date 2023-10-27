package study.serviceTest;



import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingCarNameScanService;

public class RacingCarNameScanServiceTest {

    @Test
    void readRacingCarNamesTest() {
        RacingCarNameScanService racingCarNameScanService = new RacingCarNameScanService();
        String example = "cars";    // 사용자가 입력한 값을 "cars" 라고 하자.
        System.setIn(new ByteArrayInputStream(example.getBytes()));
        racingCarNameScanService.readRacingCarNames();

        // 입력값인 "cars"와 getRacingCarNames() 메소드를 통해 입력받은 값을 가져온 값이 같으면 테스트 통과.
        Assertions.assertThat(racingCarNameScanService.getRacingCarNames()).isEqualTo("cars");
    }

    @Test
    void getRacingCarNamesTest() {
        RacingCarNameScanService racingCarNameScanService = new RacingCarNameScanService();
        Assertions.assertThat(racingCarNameScanService.getRacingCarNames()).isEqualTo(null) ;
    }
}
