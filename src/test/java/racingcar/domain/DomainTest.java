package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.NumberAssert;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.common.exception.ConfirmException;
import racingcar.domain.db.CarsData;
import racingcar.domain.entity.CarEntity;
import racingcar.service.GameService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DomainTest extends NsTest {
    String inputString = "juch,jayo,hi";
    String[] result = inputString.split(",");

    CarEntity[] arrayExCars = {new CarEntity("one", 4),
                               new CarEntity("two", 6),
                               new CarEntity("thr", 7)};
    List<CarEntity> exCars = new ArrayList<>(List.of(arrayExCars));

    @Test
    void Max_Score_반환() {
        assertThat(FindMaxScore.FindMax(exCars)).isEqualTo(7);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
