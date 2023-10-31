package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingController;
import racingcar.service.RacingService;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    RacingService racingService = new RacingService();
    RacingController racingController = new RacingController();

    @Test
    void 자동차_이름에_공백만_있는_경우() {
        String input = "pobi,woni, ";

        assertThatThrownBy(() ->
                racingService.stringToList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값이_쉼표로_끝나는_경우() {
        String input = "pobi,woni,jun,";

        assertThatThrownBy(() ->
                Validator.validateNameEndsWithComma(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값이_쉼표로_시작하는_경우() {
        String input = ",pobi,woni,jun";

        assertThatThrownBy(() ->
                Validator.validateNameStartsWithComma(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_5자_이상인_경우() {
        String[] names = {"pobipobi", "woni", "jun"};
        int DIGIT = 5;

        assertThatThrownBy(() ->
                Validator.validateNameLength(names, DIGIT))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
