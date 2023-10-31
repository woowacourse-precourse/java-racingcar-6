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
        Race race = new Race();
        String nameInput = "dawin,suji,son,blue";

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
    void moveCars_입력된_랜덤_숫자가_4_미만일_경우_전진하지_않음() {

    }

    @Test
    void getRoundResult() {
        //given

        //when

        //then

    }

    @Test
    void getWinners() {
        //given

        //when

        //then

    }
}