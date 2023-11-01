package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.model.Driver;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DriverServiceTest {

    private final DriverService driverService = new DriverService();

    @Test
    void move_전진() {
        Driver driver = new Driver("pobi", 0);

        driverService.move(5, driver);

        assertThat(driver.getMoveCount()).isEqualTo(1);
    }

    @Test
    void move_그대로() {
        Driver driver = new Driver("pobi", 0);

        driverService.move(0, driver);

        assertThat(driver.getMoveCount()).isEqualTo(0);
    }

    @Test
    void 우승자체크_1명() {
        Driver driver1 = new Driver("pobi", 0);
        Driver driver2 = new Driver("woni", 1);
        Driver driver3 = new Driver("jun", 2);

        List<Driver> driverList = new ArrayList<>();
        driverList.add(driver1);
        driverList.add(driver2);
        driverList.add(driver3);

        List<String> winnerList = driverService.getWinnerList(driverList);

        assertThat(winnerList.size()).isEqualTo(1);
        assertThat(winnerList.get(0)).isEqualTo("jun");
    }

    @Test
    void 우승자체크_여러명() {
        Driver driver1 = new Driver("pobi", 2);
        Driver driver2 = new Driver("woni", 2);
        Driver driver3 = new Driver("jun", 2);

        List<Driver> driverList = new ArrayList<>();
        driverList.add(driver1);
        driverList.add(driver2);
        driverList.add(driver3);

        List<String> winnerList = driverService.getWinnerList(driverList);

        assertThat(winnerList.size()).isEqualTo(3);
        assertThat(winnerList.get(0)).isEqualTo("pobi");
        assertThat(winnerList.get(1)).isEqualTo("woni");
        assertThat(winnerList.get(2)).isEqualTo("jun");
    }
}
