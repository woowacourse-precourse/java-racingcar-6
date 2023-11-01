package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcarFP.Application;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingOutputTest extends NsTest
{
    RacingOutput ro = new RacingOutput();

    @Test
    public void getResultOfWinner_단일_해답() {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("car1"));
        carList.add(new Car("car2"));
        carList.add(new Car("car3"));
        carList.get(0).setDistance(1);

        List<String> ans = ro.getResultOfWinner(carList);
        assertThat(ans).contains("car1");
    }

    @Test
    public void getResultOfWinner_복수_해답() {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("car1"));
        carList.add(new Car("car2"));
        carList.add(new Car("car3"));

        List<String> ans = ro.getResultOfWinner(carList);
        assertThat(ans).contains("car1", "car2", "car3");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
