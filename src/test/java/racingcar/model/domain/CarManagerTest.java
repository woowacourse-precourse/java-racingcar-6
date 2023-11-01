package racingcar.model.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;


class CarManagerTest {

    private static final CarManager cm = new CarManager();

    static {
        cm.saveCars("pobi");
    }

    @Test
    void saveCars() {
        cm.saveCars("woni");
        assertThat(cm.size())
                .isEqualTo(2);
    }

    @Test
    void moveCar() {
        cm.moveCar(1);
        assertThat(cm.getLocations()
                .get(0))
                .isEqualTo(1);
    }

    @Test
    void getNames() {
        cm.saveCars("pobi");
        assertThat(cm.getNames()
                .get(0))
                .isEqualTo("pobi");
    }

    @Test
    void getLocations() {
        cm.saveCars("pobi");
        assertThat(cm.getLocations()
                .get(0))
                .isZero();
    }

    @Test
    void getMaxLocation() {
        cm.saveCars("pobi");
        cm.moveCar(0);
        assertThat(cm.getMaxLocation())
                .isEqualTo(1);
    }

    @Test
    void getCarsByLocation() {
        assertThat(cm.getCarsByLocation(0)
                .get(0)
                .getName())
                .isEqualTo("pobi");
    }
}