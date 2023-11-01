package racingcar.View;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Domain.CarGroup;

class OutPutViewImplTest {

    @Test
    @DisplayName("라운드 결과 출력 테스트")
    void showRoundResultTest() {
        //given
        List<String> carList = List.of("car1", "car2", "car3");
        String expectedOutput = "car1 : \n"
                + "car2 : \n"
                + "car3 :";
        PrintStream standardOut = System.out;
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        OutPutViewImpl outPutViewImpl = new OutPutViewImpl();

        //when
        CarGroup carGroup = CarGroup.of(carList);
        outPutViewImpl.showRoundResult(carGroup);

        //then
        System.setOut(standardOut);
        String result = captor.toString().trim();

        assertEquals(expectedOutput, result);
    }

    @Test
    @DisplayName("최종 우승자 출력 테스트 - 2명 이상")
    void showFinalWinnerMoreThanTwoTest() {
        //given
        List<String> carList = List.of("car1", "car2");
        String expectedOutput = "최종 우승자 : car1, car2";
        PrintStream standardOut = System.out;
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        OutPutViewImpl outPutViewImpl = new OutPutViewImpl();

        //when
        CarGroup carGroup = CarGroup.of(carList);
        outPutViewImpl.showFinalWinner(carGroup);

        //then
        System.setOut(standardOut);
        String result = captor.toString().trim();

        assertEquals(expectedOutput, result);
    }

    @Test
    @DisplayName("최종 우승자 출력 테스트 - 1명")
    void showFinalWinnerOneTest() {
        //given
        List<String> carList = List.of("car1");
        String expectedOutput = "최종 우승자 : car1";
        PrintStream standardOut = System.out;
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        OutPutViewImpl outPutViewImpl = new OutPutViewImpl();

        //when
        CarGroup carGroup = CarGroup.of(carList);
        outPutViewImpl.showFinalWinner(carGroup);

        //then
        System.setOut(standardOut);
        String result = captor.toString().trim();

        assertEquals(expectedOutput, result);
    }
}