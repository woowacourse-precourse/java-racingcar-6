package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodTest {

    private ByteArrayOutputStream output;

    @BeforeEach
    void setUpStreams() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    void split_메서드로_자동차_입력값_구분(){
        String input = "pobi,woni,jun";
        String[] carList = Application.getUserCarList(input);

        assertArrayEquals(new String[]{"pobi", "woni", "jun"}, carList);
    }

    @Test
    void 자동차_이름_길이가_5보다_큰_입력값이_존재하는_경우_예외_발생(){
        String[] input = {"pobiiiii","woni"};

        assertThatThrownBy(() -> Application.checkError(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 회수별_출력_확인(){
        String[] carList = {"pobi", "woni", "jun"};
        int[] raceResult = {3, 5, 2};

        Application.printRaceResult(carList, raceResult);

        String expectedOutput = "pobi : ---\nwoni : -----\njun : --\n\n";
        assertEquals(expectedOutput,output.toString());

    }

    @Test
    void 올바른_최댓값을_찾았는지_확인(){
        int[] input = {1,2,3,4,5};
        int max = Application.findMax(input);
        assertThat(max).isEqualTo(5);
    }

    @Test
    void 우승자_출력_확인(){
        String[] carList = {"pobi", "woni", "jun"};
        int[] raceResult = {3, 5, 2};
        int max = 5;

        Application.printWinner(max,carList,raceResult);
        String expectedOutput = "최종 우승자 : woni";
        assertEquals(expectedOutput,output.toString());

    }
}
