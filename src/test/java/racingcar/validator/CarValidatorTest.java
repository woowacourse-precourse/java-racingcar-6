package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarValidatorTest {

    private CarNameValidator carNameValidator;
    private RoundValidator roundValidator;
    private final static String NAME_NULL_ERROR_MESSAGE = "차 이름을 적어주세요.";
    private final static String NAME_ERROR_MESSAGE = "차 이름은 문자로만 구성되어야 합니다.";
    private final static String NAME_RANGE_ERROR_MESSAGE = "차 이름은 1자 이상 5자 이하로 적어주세요.";
    private final static String ONE_CAR_ERROR_MESSAGE = "두 대 이상의 차를 입력하세요.";
    private final static String NAME_DUPLICATE_ERROR_MESSAGE = "중복된 이름을 적으면 안 됩니다.";

    @Test()
    void 차_이름_안_적음_예외_처리() {
        assertThatThrownBy(() -> carNameValidator = new CarNameValidator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_NULL_ERROR_MESSAGE);
    }

    @Test()
    void 문자_외_입력_예외_처리() {
        assertThatThrownBy(() -> carNameValidator = new CarNameValidator("hy un,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_ERROR_MESSAGE);
    }
    @Test()
    void 차_이름_1자_미만_예외_처리() {
        assertThatThrownBy(() -> carNameValidator = new CarNameValidator(",pobi,woote"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_RANGE_ERROR_MESSAGE);
    }

    @Test()
    void 차_이름_5자_초과_예외_처리() {
        assertThatThrownBy(() -> carNameValidator = new CarNameValidator("hyun,pobi,wooteco"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_RANGE_ERROR_MESSAGE);
    }

    @Test()
    void 차_한_대_입력_예외_처리() {
        assertThatThrownBy(() -> carNameValidator = new CarNameValidator("hyun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ONE_CAR_ERROR_MESSAGE);
    }

    @Test()
    void 중복_이름_예외_처리() {
        assertThatThrownBy(() -> carNameValidator = new CarNameValidator("hyun,hyun,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_DUPLICATE_ERROR_MESSAGE);
    }
}
