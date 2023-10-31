package racingcar.utill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UtillTest {
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @DisplayName("숫자 변환 테스트")
    @Test
    void parseInteger() {
        // given
        String input = "123";

        // when
        Integer result = Utill.parseInt(input);

        // than
        assertThat(result).isEqualTo(123);
    }

    @DisplayName("string을 regex의 기준으로 구분을 하여 배열로 반환 테스트")
    @Test
    void makeSplitArrFromString() {
        // given
        String str = "one,two,three";
        String regex = ",";

        // when
        String[] resultArr = Utill.makeArrFromString(str, regex);

        // than
        assertThat(resultArr).isEqualTo(new String[]{"one", "two", "three"});
    }

    @DisplayName("print new Line 테스트")
    @Test
    void printNewLine() {
        // when
        Utill.printNewLine();

        // than
        assertThat(outContent.toString()).isEqualTo("\n");
    }

    @DisplayName("print 메서드 테스트")
    @Test
    void print() {
        // given
        String input = "input";

        // when
        Utill.print(input);

        // than
        assertThat(outContent.toString()).isEqualTo("input\n");
    }

    @DisplayName("배열을 리스트로 만들어준다. 테스트")
    @Test
    void makeListFromArr() {
        // given
        Integer[] inputArr = new Integer[]{1, 2, 3};
        List<Integer> targetList = new ArrayList<>();
        targetList.add(1);
        targetList.add(2);
        targetList.add(3);

        // when
        List<Integer> resultList = Utill.makeListFromArr(inputArr);

        // than
        assertThat(resultList).isEqualTo(targetList);

    }

    @DisplayName("num_1 과 num_2의 숫자가 같으면 true 테스트")
    @Test
    void isSameNum() {
        // given
        int num_1 = 1;
        int num_2 = 1;

        // when
        boolean result = Utill.isSameNum(num_1, num_2);

        // than
        assertThat(result).isTrue();
    }

    @DisplayName("num_1 과 num_2의 숫자가 같으면 true 테스트_2")
    @Test
    void isSameNum_2() {
        // given
        int num_1 = 1;
        int num_2 = 2;

        // when
        boolean result = Utill.isSameNum(num_1, num_2);

        // than
        assertThat(result).isFalse();
    }

    @DisplayName("값이 1이상인지 확인한다. 테스트")
    @Test
    void valueGreaterThanEqualOne() {
        // given
        Integer input = 1;

        // when
        boolean result = Utill.isGreaterThanAndEqualOne(input);

        // than
        assertThat(result).isTrue();
    }

    @DisplayName("값이 1이상인지 확인한다. 테스트_2")
    @Test
    void valueGreaterThanEqualOne_2() {
        // given
        Integer input = 0;

        // when
        boolean result = Utill.isGreaterThanAndEqualOne(input);

        // than
        assertThat(result).isFalse();
    }
}