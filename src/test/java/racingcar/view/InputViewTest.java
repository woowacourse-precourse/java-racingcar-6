package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarNameValidator;
import racingcar.domain.RoundNumberValidator;

public class InputViewTest {
    InputView inputView = new InputView();

    @Test
    void 입력된_자동차_이름을_list로_변환() {
        //given
        String name = ("pobi,woni,jun");
        //when
        List<String> names = inputView.toStringList(name);
        //then
        assertThat(List.of("pobi", "woni", "jun")).isEqualTo(names);
    }

    @Test
    void 자동차_이름이_하나_입력되었을_때() {
        //given
        String name = ("pobi");
        //when
        List<String> names = inputView.toStringList(name);
        //then
        assertThat(List.of("pobi")).isEqualTo(names);
    }

    @Test
    void 입력된_자동차_이름이_5자보다_많으면_예외() {
        //given
        String names = "pobi,woni,jun,jieung";
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new CarNameValidator(names));
        //then
        assertThat(e.getMessage()).isEqualTo("자동차 이름은 5자 이내로 입력해주세요.");
    }

    @Test
    void 입력된_자동차_이름이_쉼표로_시작할_때() {
        //given
        String names = ",pobi,woni,jun,jieung";
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new CarNameValidator(names));
        //then
        assertThat(e.getMessage()).isEqualTo("자동차 이름은 '이름,이름' 형식의 패턴을 지켜주세요.");
    }

    @Test
    void 입력된_자동차_이름이_쉼표로_끝날_때() {
        //given
        String names = "pobi,woni,jun,jieung,";
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new CarNameValidator(names));
        //then
        assertThat(e.getMessage()).isEqualTo("자동차 이름은 '이름,이름' 형식의 패턴을 지켜주세요.");
    }

    @Test
    void 자동차_이름_입력에서_쉼표가_두_번_나올_때() {
        //given
        String names = "pobi,woni,,jun";
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new CarNameValidator(names));
        //then
        assertThat(e.getMessage()).isEqualTo("자동차 이름은 5자 이내로 입력해주세요.");
    }

    @Test
    void 입력된_자동차_이름이_공백일_때() {
        //given
        String names = " ";
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new CarNameValidator(names));
        //then
        assertThat(e.getMessage()).isEqualTo("자동차 이름은 '이름,이름' 형식의 패턴을 지켜주세요.");
    }

    @Test
    void 입력된_자동차_이름이_중복일_때() {
        //given
        String names = "pobi,pobi";
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new CarNameValidator(names));
        //then
        assertThat(e.getMessage()).isEqualTo("자동차 이름은 모두 다르게 입력해주세요.");
    }

    @Test
    void 시도_횟수를_숫자로_변환() {
        //given
        String input = "5";
        //when
        int number = inputView.convertToNumber(input);
        //then
        assertThat(5).isEqualTo(number);
    }

    @Test
    void 입력된_시도_횟수가_숫자가_아닐_때() {
        //given
        String input = "다섯번";
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new RoundNumberValidator(input));
        //then
        assertThat(e.getMessage()).isEqualTo("숫자를 입력해주세요.");
    }

}
