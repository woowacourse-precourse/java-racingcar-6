package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CarListFactoryTest {

    CarListFactory carListFactory;

    @BeforeEach
    void setUp() {
        carListFactory = new CarListFactory();
    }

    @Test
    @DisplayName("정상입력시_carList_객체_생성")
    void createCarList() {
        //given
        String normalInput = "a,b,c";
        String expected = "a : \n" +
                "b : \n" +
                "c : \n";

        //when
        CarList carList = carListFactory.create(normalInput);

        //then
        String actual = carList.toString();
        assertThat(actual).isEqualTo(expected);
    }
}