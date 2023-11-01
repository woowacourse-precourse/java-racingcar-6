package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    private Race race;
    private String nameInput = "dawin,woowa,han,tech";

    @BeforeEach
    void setUp() {
        race = new Race();
        race.setCarList(nameInput);
    }

    @Test
    void setCarList_여러_개의_이름으로_초기화된_자동차_객체_리스트_생성() {
        //given
        Race race1 = new Race();
        String nameInput1 = "dawin,woowa,han,tech";

        //when
        race1.setCarList(nameInput1);

        //then
        assertThat(race1.getCarNames()).isEqualTo(List.of("dawin", "woowa", "han", "tech"));
        assertThat(race1.getRoundResult()).isEqualTo(List.of(0, 0, 0, 0));
    }

    @Test
    void setCarList_더_많은_이름으로_초기화된_자동차_객체_리스트_생성() {
        //given
        Race race1 = new Race();
        String nameInput1 = "dawin,woowa,han,tech,pre,cours";

        //when
        race1.setCarList(nameInput1);

        //then
        assertThat(race1.getCarNames()).isEqualTo(List.of("dawin", "woowa", "han", "tech", "pre", "cours"));
        assertThat(race1.getRoundResult()).isEqualTo(List.of(0, 0, 0, 0, 0, 0));
    }

    @Test
    void getCarNames_자동차_객체의_이름_리스트로_반환() {
        //given
        // setUp()의 코드 실행

        //when
        List<String> actualCarNames = race.getCarNames();

        //then
        assertThat(actualCarNames).isEqualTo(List.of("dawin", "woowa", "han", "tech"));
    }

    @Test
    void getCarListSize_자동차_객체_리스트의_크기_반환() {
        //given
        // setUp()의 코드 실행

        //when
        int actualListSize = race.getCarListSize();

        //then
        assertThat(actualListSize).isEqualTo(4);
    }

    @Test
    void moveCars_입력된_랜덤_숫자가_4_미만일_경우_자동차_전진하지_않음() {
        //given
        List<Integer> randomNumbers = List.of(0, 1, 2, 3);

        //when
        race.moveCars(randomNumbers);

        //then
        assertThat(race.getRoundResult()).isEqualTo(List.of(0, 0, 0, 0));
    }

    @Test
    void moveCars_입력된_랜덤_숫자가_4_이상일_경우_자동차_전진() {
        //given
        List<Integer> randomNumbers = List.of(4, 5, 6, 9);

        //when
        race.moveCars(randomNumbers);

        //then
        assertThat(race.getRoundResult()).isEqualTo(List.of(1, 1, 1, 1));
    }

    @Test
    void getRoundResult_각_자동차의_이동_결과를_리스트로_반환() {
        //given
        race.moveCars(List.of(3, 3, 3, 4));
        race.moveCars(List.of(3, 3, 4, 4));
        race.moveCars(List.of(3, 4, 4, 4));

        //when
        List<Integer> roundResult = race.getRoundResult();

        //then
        assertThat(roundResult).isEqualTo(List.of(0, 1, 2, 3));
    }

    @Test
    void getWinners_이동_거리가_가장_큰_자동차의_이름_반환() {
        //given
        race.moveCars(List.of(0, 0, 0, 4));
        race.moveCars(List.of(0, 0, 4, 4));
        race.moveCars(List.of(0, 4, 4, 4));

        //when
        List<String> winner = race.getWinners();

        //then
        assertThat(winner).isEqualTo(List.of("tech"));
    }

    @Test
    void getWinners_우승자가_1명인_경우_우승자의_이름만_반환() {
        //given
        race.moveCars(List.of(0, 4, 0, 0));

        //when
        List<String> winner = race.getWinners();

        //then
        assertThat(winner).isEqualTo(List.of("woowa"));
    }

    @Test
    void getWinners_우승자가_여러명인_경우_여러명의_우승자_이름을_반환() {
        //given
        race.moveCars(List.of(4, 0, 4, 4));

        //when
        List<String> winner = race.getWinners();

        //then
        assertThat(winner).isEqualTo(List.of("dawin", "han", "tech"));
    }
}