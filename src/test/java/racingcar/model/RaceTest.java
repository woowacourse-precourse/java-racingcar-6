package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
//    private Race race;
//    @BeforeEach
//    void setUp() {
//        race = new Race();
//    }

    @Test
    void setCarList_여러_개의_이름으로_초기화된_자동차_객체_리스트_생성() {
        //given
        String nameInput = "dawin,suji,son,blue";

        Race race = new Race();

        //when
        race.setCarList(nameInput);

        //then
        assertThat(race.getCarNames()).isEqualTo(List.of("dawin", "suji", "son", "blue"));
        assertThat(race.getRoundResult()).isEqualTo(List.of(0, 0, 0, 0));
    }

    @Test
    void getCarNames_자동차_객체의_이름_리스트로_반환() {
        //given
        String nameInput = "dawin,suji,blue";

        Race race = new Race();
        race.setCarList(nameInput);

        //when
        List<String> actualCarNames = race.getCarNames();

        //then
        assertThat(actualCarNames).isEqualTo(List.of("dawin", "suji", "blue"));
    }

    @Test
    void getCarListSize_자동차_객체_리스트의_크기_반환() {
        //given
        String nameInput = "dawin,suji,blue";

        Race race = new Race();
        race.setCarList(nameInput);

        //when
        int actualListSize = race.getCarListSize();

        //then
        assertThat(actualListSize).isEqualTo(3);
    }

    @Test
    void moveCars_입력된_랜덤_숫자가_4_미만일_경우_자동차_전진하지_않음() {
        //given
        String nameInput = "a,b,c,d";
        List<Integer> randomNumbers = List.of(0, 1, 2, 3);

        Race race = new Race();
        race.setCarList(nameInput);

        //when
        race.moveCars(randomNumbers);

        //then
        assertThat(race.getRoundResult()).isEqualTo(List.of(0, 0, 0, 0));
    }

    @Test
    void moveCars_입력된_랜덤_숫자가_4_이상일_경우_자동차_전진() {
        //given
        String nameInput = "a,b,c,d,e,f";
        List<Integer> randomNumbers = List.of(4, 5, 6, 7, 8, 9);

        Race race = new Race();
        race.setCarList(nameInput);

        //when
        race.moveCars(randomNumbers);

        //then
        assertThat(race.getRoundResult()).isEqualTo(List.of(1, 1, 1, 1, 1, 1));
    }

    @Test
    void getRoundResult_각_자동차의_이동_결과를_리스트로_반환() {
        //given
        String nameInput = "a,b,c,d";

        Race race = new Race();
        race.setCarList(nameInput);

        race.moveCars(List.of(3,3,3,4));
        race.moveCars(List.of(3,3,4,4));
        race.moveCars(List.of(3,4,4,4));

        //when
        List<Integer> roundResult = race.getRoundResult();

        //then
        assertThat(roundResult).isEqualTo(List.of(0,1,2,3));
    }

    @Test
    void getWinners() {
        //given

        //when

        //then

    }
}