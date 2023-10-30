package racingcar.ModelTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Model.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsModelTest {
    @Test
    void 이름_범위_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Cars.nameValidation("abcdef,javaji"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_리스트변환() {
        List<String> expect = Arrays.asList("kim", "in", "young");
        List<String> result = Cars.split("kim,in,young");
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 이름_빈칸_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Cars.nameValidation(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_쉼표_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Cars.nameValidation(","))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
