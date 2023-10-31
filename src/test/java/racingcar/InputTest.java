package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    void setRacingCarLineup_메소드로_이름을_입력하면_쉼표로_이름들을_구분() {
        String input = "test1,test2";

        String[] result = Input.setRacingCarLineup(input);

        assertThat(result).contains("test1", "test2");
    }

    @Test
    void setRacingCarLineup_메소드로_공백이_포함된_이름을_입력한_경우_공백_제거() {
        String input = "te st1,t es t2";

        String[] result = Input.setRacingCarLineup(input);

        assertThat(result).contains("test1", "test2");
    }

    @Test
    void setRacingCarLineup_메소드로_공백을_입력히면_예외_발생() {
        String input = " ";

        assertThatThrownBy(() -> Input.setRacingCarLineup(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 입력되지 않았습니다.");
    }

    @Test
    void setRacingCarLineup_메소드로_쉼표만_입력하면_예외_발생() {
        String input = ",";

        assertThatThrownBy(() -> Input.setRacingCarLineup(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 입력되지 않았습니다.");
    }

    @Test
    void setRacingCarLineup_메소드로_5자_이상의_이름을_입력하면_예외_발생() {
        String input = "test1,test11";

        assertThatThrownBy(() -> Input.setRacingCarLineup(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력되는 이름은 5자 이하여야 합니다.");
    }

    @Test
    void inputNumberOfGame_메소드로_반복_횟수_입력() {
        String input = "12";

        int result = Input.inputNumberOfGame(input);

        assertThat(result).isEqualTo(12);
    }

    @Test
    void inputNumberOfGame_메소드로_공백이_포함된_횟수_입력시_공백_제거() {
        String input = "1 2";

        int result = Input.inputNumberOfGame(input);

        assertThat(result).isEqualTo(12);
    }

    @Test
    void inputNumberOfGame_메소드_사용시_공백만_입력할_경우_예외_발생() {
        String input = " ";

        assertThatThrownBy(() -> Input.inputNumberOfGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상의 숫자만 입력해야 합니다.");
    }

    @Test
    void inputNumberOfGame_메소드_사용시_0_이하의_숫자를_입력할_경우_예외_발생() {
        String input = "0";

        assertThatThrownBy(() -> Input.inputNumberOfGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상의 숫자만 입력해야 합니다.");
    }
}