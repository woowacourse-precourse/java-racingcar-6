package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarMovement;
import racingcar.domain.InputCheck;
import racingcar.domain.ResultOutput;

public class MyApplicationTest {

    @Test
    void 이름_오기입_구분시_쉼표_미사용_예외처리() {
        String input = "blank blank blank";
        assertThatThrownBy(() ->
                InputCheck.checkUserInput(input, "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하의 길이로 쉼표(,)를 기준으로 구분해주세요.");
    }

    @Test
    void 이름_오기입_5자리초과_예외처리() {
        String input = "woo,test,overFive1";
        assertThatThrownBy(() ->
                InputCheck.checkUserInput(input, "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하로 입력해주세요.");
    }

    @Test
    void 이름_오기입_중복입력_예외처리() {
        String input = "dup,test,dup";
        assertThatThrownBy(() ->
                InputCheck.checkUserInput(input, "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복없이 설정해주세요.");
    }

    @Test
    void 시도횟수_오기입_숫자가_아닌값_예외처리() {
        String input = "notNumber";
        assertThatThrownBy(() ->
                InputCheck.checkUserInput("t1,t2,t3", input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자로 입력해주세요.");
    }

    @Test
    void 전진_정지() {
        String input = "test1,test2";
        String[] carNames = input.split(",");
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(7);
        randomNumbers.add(2);
        CarMovement.getCarMoveResult(randomNumbers);
        ResultOutput.printRacingResult(carNames, CarMovement.carMoveResult);
//        assertThat().contains("1");
    }

}
