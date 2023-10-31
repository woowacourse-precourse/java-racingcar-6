package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedHashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

public class CarTest {

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

    @Test
    void getFinalWinner_동점시_최종우승자_테스트() {
        //given
        final String cars = "povi1,povi2,povi3";
        final LinkedHashMap<String, String> carList = T2.createCarList(cars);
        T.setCarList(carList);
        String tmpMoveValue = "-";
        for (Map.Entry<String, String> entry : T.getCarList().entrySet()) {
            String key = entry.getKey();
            carList.put(key, tmpMoveValue);
        }

        //when
        String result = T.getFinalWinner();

        //then
        Assertions.assertThat(result).isEqualTo("povi1, povi2, povi3");
    }

    @Test
    void getFinalWinner_동점X_최종우승자_테스트() {
        //given
        final String cars = "povi1,povi2,povi3";
        final LinkedHashMap<String, String> carList = T2.createCarList(cars);
        T.setCarList(carList);
        String tmpMoveValue = "-";
        for (Map.Entry<String, String> entry : T.getCarList().entrySet()) {
            String key = entry.getKey();
            String moveValue = T.getCarList().get(key);
            carList.put(key, tmpMoveValue + moveValue);
            tmpMoveValue = tmpMoveValue + "-";
        }

        //when
        String result = T.getFinalWinner();

        //then
        Assertions.assertThat(result).isEqualTo("povi3");
    }

    @Test
    void checkCarNameLength_이름길이_5자초과_테스트() {
        //given
        final String cars = "세글자,일곱글자입니다";
        final LinkedHashMap<String, String> carList = T2.createCarList(cars);
        T.setCarList(carList);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            //when
            T.checkCarNameLength();
        });
    }

    @Test
    void checkCarNameFirstLetterIsSpace_이름첫글자_스페이스_테스트() {
        //given
        final String cars = " 첫글자 공백, 첫글자 공백2";
        final LinkedHashMap<String, String> carList = T2.createCarList(cars);
        T.setCarList(carList);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            //when
            T.checkCarNameFirstLetterIsSpace();
        });
    }

    @Test
    void checkCarNameLastLetterIsSpace_이름마지막글자_스페이스_테스트() {
        //given
        final String cars = "마지막글자 공백 ,마지막글자 공백2 ";
        final LinkedHashMap<String, String> carList = T2.createCarList(cars);
        T.setCarList(carList);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            //when
            T.checkCarNameLastLetterIsSpace();
        });
    }

    @Test
    void checkContainsConsecutiveCommas_입력값_쉼표_연속성_테스트1() {
        //given
        final String cars = ",,포비,포비2,포비3";
        T.setStringCarList(cars);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            //when
            T.checkInputStringContainsConsecutiveCommas();
        });
    }

    @Test
    void checkContainsConsecutiveCommas_입력값_쉼표_연속성_테스트2() {
        //given
        final String cars = "포비,,포비2,포비3";
        T.setStringCarList(cars);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            //when
            T.checkInputStringContainsConsecutiveCommas();
        });
    }

    @Test
    void checkContainsConsecutiveCommas_입력값_쉼표_연속성_테스트3() {
        //given
        final String cars = "포비,포비2,,포비3";
        T.setStringCarList(cars);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            //when
            T.checkInputStringContainsConsecutiveCommas();
        });
    }

    @Test
    void checkContainsConsecutiveCommas_입력값_쉼표_연속성_테스트4() {
        //given
        final String cars = "포비,포비2,포비3,,";
        T.setStringCarList(cars);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            //when
            T.checkInputStringContainsConsecutiveCommas();
        });
    }

    @Test
    void checkContainsConsecutiveCommas_입력값_쉼표_연속성_테스트5() {
        //given
        final String cars = ",,,,,,,,";
        T.setStringCarList(cars);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            //when
            T.checkInputStringContainsConsecutiveCommas();
        });
    }


    @Test
    void checkInputStringFirstLetterContainsCommas_입력값_첫글자_쉼표_테스트() {
        //given
        final String cars = ",포비1,포비2";
        T.setStringCarList(cars);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            //when
            T.checkInputStringFirstLetterContainsCommas();
        });
    }

    @Test
    void checkInputStringLastLetterContainsCommas_입력값_마지막글자_쉼표_테스트() {
        final String cars = "포비1,포비2,";
        T.setStringCarList(cars);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            //when
            T.checkInputStringLastLetterContainsCommas();
        });
    }
}
