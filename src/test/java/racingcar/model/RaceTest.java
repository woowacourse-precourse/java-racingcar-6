package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    private Race race;
    @BeforeEach
    void setUp() {
        race = new Race();
    }

    @Test
    void setCarList_여러_개의_이름으로_초기화된_자동차_객체_리스트_생성() {
        //given
        Race race1 = new Race();
        String nameInput = "aaa,bbb,ccc,ddd";

        //when
        race1.setCarList(nameInput);

        //then
        assertThat(race1.getCarNames()).isEqualTo(List.of("aaa", "bbb", "ccc", "ddd"));
        assertThat(race1.getRoundResult()).isEqualTo(List.of(0, 0, 0, 0));
    }

    @Test
    void setCarList_한_개의_이름으로_초기화된_자동차_객체_리스트_생성() {
        //given
        Race race1 = new Race();
        String nameInput = "aaa";

        //when
        race1.setCarList(nameInput);

        //then
        assertThat(race1.getCarNames()).isEqualTo(List.of("aaa"));
        assertThat(race1.getRoundResult()).isEqualTo(List.of(0));
    }

    @Test
    void getCarNames() {
        //given
        String nameInput = "aaa,bbb,ccc,ddd";

        //when

        //then

    }

    @Test
    void getCarListSize() {
        //given

        //when

        //then

    }

    @Test
    void moveCars() {
        //given

        //when

        //then

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