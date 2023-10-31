package racingcar.ServiceTest;

import org.junit.jupiter.api.Test;
import racingcar.Service.CarName;
import racingcar.domain.CarList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsModelTest {
    @Test
    void 레이싱카_생성() {
        String name = "레이싱카";

        CarList car = new CarList(name);

        assertThat(car).isNotNull();
    }

    @Test
    void 이름_범위_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> CarName.nameValidation("abcdef,javaji"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_리스트변환() {
        List<String> expect = Arrays.asList("kim", "in", "young");
        List<String> result = CarName.split("kim,in,young");
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 이름_빈칸_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> CarName.nameValidation(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_쉼표_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> CarName.nameValidation(","))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
