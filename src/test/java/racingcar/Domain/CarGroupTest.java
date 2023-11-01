package racingcar.Domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarGroupTest {

    @Test
    void 자동차_그룹_생성하기() {
        //given
        List<String> testCarNames = List.of("testCar1", "testCar2", "testCar3");

        //when
        CarGroup testInstance = CarGroup.of(testCarNames);

        //then
        assertThat(testInstance).isNotNull();
    }

    @Test
    void 자동차_그룹의_크기_구하기() {
        //given
        List<String> testCarNames = List.of("testCar1", "testCar2", "testCar3");

        //when
        CarGroup testInstance = CarGroup.of(testCarNames);

        //then
        assertThat(testInstance.findSize()).isEqualTo(testCarNames.size());
    }

    @Test
    void 순서로_자동차_검색하기() {
        //given
        List<String> testCarNames = List.of("testCar1", "testCar2", "testCar3");

        //when
        CarGroup testInstance = CarGroup.of(testCarNames);

        //then
        assertThat(testInstance.findCarByOrder(1).findName()).isEqualTo(testCarNames.get(0));
        assertThat(testInstance.findCarByOrder(2).findName()).isEqualTo(testCarNames.get(1));
        assertThat(testInstance.findCarByOrder(3).findName()).isEqualTo(testCarNames.get(2));
    }

    @Test
    @DisplayName("최종 우승자 검색하기")
    void findFinalWinnerTest(){
        //given
        List<String> testCarNames = List.of("testCar1", "testCar2", "testCar3");
        CarGroup testInstance = CarGroup.of(testCarNames);

        //when
        CarGroup finalWinner = testInstance.findFinalWinner();

        //then
        assertThat(finalWinner.findSize()).isEqualTo(testCarNames.size());
    }

    @Test
    @DisplayName("그룹에 속한 자동차 이름들 조회하기 톄스트")
    void findCarNamesTest(){
        //given
        List<String> testCarNames = List.of("testCar1", "testCar2", "testCar3");
        CarGroup testInstance = CarGroup.of(testCarNames);

        //when
        List<String> carNames = testInstance.findCarNames();

        //then
        assertThat(carNames).isEqualTo(testCarNames);
    }
}