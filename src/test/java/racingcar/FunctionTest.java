package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Application.*;

public class FunctionTest {

    @Test
    @DisplayName("splitCarName_메서드로_주어진_값을_구분")
    void splitCarNameTests(){
        String input = "abc,cdef,ghi";
        String[] result = splitCarName(input);

        assertThat(result).contains("abc","ghi","cdef");
        assertThat(result).containsExactly("abc","cdef","ghi");
    }

    @Test
    @DisplayName("carMoveTests_메서드로_무작위값이_4이상이면_1을반환")
    void carMoveTests(){
        int randomNumber = carMove(4);

        assertThat(randomNumber).isEqualTo(1);
    }

    @Test
    @DisplayName("finalWinnersTests_메서드로_우승자가_2명일때,이름옆에 ,와 띄어쓰기를 붙여 우승자를 보여주기 ")
    void finalWinnersTests(){
        List<String> input = new ArrayList<String>();
        input.add("abc");
        input.add("bcd");

        String result = finalWinners(input);

        assertThat(result).isEqualTo("abc, bcd");
    }

    @Test
    @DisplayName("carNameUpperThenFiveTests_메서드로_주어진_문자열의_길이가_5보다_크면_IllegalArgumentException_발생")
    void carNameUpperThenFiveTests(){
       String[] input = {"abc", "bcdefg", "wws"};

       assertThatThrownBy(() -> carNameUpperThenFive(input)).
               isInstanceOf(IllegalArgumentException.class).
               hasMessage("이름의 길이가 5보다 크다.");
    }

    @Test
    @DisplayName("잘못된 값을 입력하면 IllegalArgumentException 발생")
    void illegalExceptionTests(){
        String input = "-1";

        assertThatThrownBy(()-> getTryNumber(input)).isInstanceOf(IllegalArgumentException.class);

    }

}
