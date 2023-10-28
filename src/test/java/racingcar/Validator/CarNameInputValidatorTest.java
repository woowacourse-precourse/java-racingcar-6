package racingcar.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class CarNameInputValidatorTest extends NsTest {
    private final String ASK_MORE_THAN_TWO = "2개 이상의 차 이름을 입력하세요";
    private final String ASK_NO_DUPLICATION = "중복된 이름을 입력 불가합니다";
    private final String ASK_VALID_NAME_LENGTH = "차 이름은 5자 이하로 입력해주세요";

    @Test
    @DisplayName("차 이름 리스트 생성 테스트")
    void 차_이름_리스트_생성_테스트() {
        List<String> carNameExpected = List.of("pobi", "woni");

        CarNameInputValidator carNameInputValidator = new CarNameInputValidator("pobi,woni");
        assertThat(carNameInputValidator.getCarNameInputList())
                .isEqualTo(carNameExpected);
    }

    @Test
    @DisplayName("이름 중복 예외 처리 테스트")
    void 이름에_대한_중복_예외_처리() {

        CarNameInputValidator carNameInputValidator = new CarNameInputValidator("pobi,pobi");

        assertThatThrownBy(
                () -> {
                    carNameInputValidator.validate();
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NO_DUPLICATION);
    }

    @Test
    @DisplayName("이름 1개 이하 입력 예외 처리 테스트")
    void 이름이_1개_이하_예외_처리() {

        CarNameInputValidator carNameInputValidator = new CarNameInputValidator("pobi");

        assertThatThrownBy(
                () -> {
                    carNameInputValidator.validate();
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_MORE_THAN_TWO);
    }

    @Test
    @DisplayName("6자 이상의 이름 예외 처리 테스트")
    void 이름이_6자_이상_예외_처리() {

        CarNameInputValidator carNameInputValidator = new CarNameInputValidator("pobiisgreat, woniisgreat");

        assertThatThrownBy(
                () -> {
                    carNameInputValidator.validate();
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_VALID_NAME_LENGTH);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
