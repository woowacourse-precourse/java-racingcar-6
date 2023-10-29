package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CarTest {

    private Car T;
    private CarGenerator T2;

    @BeforeEach
    void setUp() {
        T = new Car();
        T2 = new CarGenerator();
    }

    @Test
    void getCurrentRacingResult_매턴_현재_출력_테스트() {
        //given
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        final PrintStream originalOut = System.out;
        final String cars = "povi1,povi2,povi3";
        final LinkedHashMap<String, String> carList = T2.createCarList(cars);
        T.setCarList(carList);

        //when
        T.getCurrentRacingResult();
        String consoleOutPut = outContent.toString();
        String[] lines = consoleOutPut.split(System.lineSeparator());

        //then
        Assertions.assertThat(lines[0]).isEqualTo("povi1 : ");
        System.setOut(originalOut);
        Assertions.assertThat(lines[1]).isEqualTo("povi2 : ");
        System.setOut(originalOut);
        Assertions.assertThat(lines[2]).isEqualTo("povi3 : ");
        System.setOut(originalOut);
    }

}