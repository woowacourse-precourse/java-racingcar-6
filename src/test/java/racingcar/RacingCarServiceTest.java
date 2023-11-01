package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.repository.Car;

import static org.assertj.core.api.Assertions.assertThat;


class RacingCarServiceTest extends NsTest  {
    @Test
    void 자동차_이름_길이_제한_테스트() {
        Car car = new Car("pobiasdfasdf");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
