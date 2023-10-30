package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CarsFactoryTest {

    CarsFactory carsFactory;

    @BeforeEach
    void setUp() {
        carsFactory = new CarsFactory();
    }

    @Test
    @DisplayName("정상입력시_cars_객체생성성공")
    void create_NormalInput_CreateCarsSuccess() {
        //given
        String normalInput = "a,b,c";
        String expected = "a : \n" +
                "b : \n" +
                "c : \n";

        //when
        Cars cars = carsFactory.create(normalInput);

        //then
        String actual = cars.toString();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("길이5초과시_cars_객체생성실패")
    void create_Over5Length_CreateCarsFail() {
        //given
        String errorInput = "aaaaaa,c";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> carsFactory.create(errorInput));
    }

    @Test
    @DisplayName("list가_비어있다면_cars_객체생성실패")
    void create_ListIsEmpty_CreateCarsFail() {
        //given
        String errorInput = ",";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> carsFactory.create(errorInput));
    }
}