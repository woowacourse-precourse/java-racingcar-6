package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameParserTest {
    CarNameParser carNameParser;
    @BeforeEach
    public void setUp() {
        carNameParser = new CarNameParser();
    }

    @Test
    void 이름_파싱_검증_예외_테스트1() {
        String failInputNames = "dave";

        assertThatThrownBy(()-> carNameParser.parse(failInputNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_파싱_검증_예외_테스트2() {
        String failInputNames = "david,pobi";

        assertThatThrownBy(()->carNameParser.parse(failInputNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_파싱_검증_성공_테스트() {
        String successInputNames = "상현,자바지기";
        List<CarName> names = new ArrayList<>();

        names.add(new CarName("상현"));
        names.add(new CarName("자바지기"));

        assertThat(carNameParser.parse(successInputNames)).isEqualTo(names);
    }
}
