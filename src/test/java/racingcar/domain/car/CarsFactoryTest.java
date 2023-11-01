package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.Constant.*;


class CarsFactoryTest {

    CarsFactory carsFactory;
    private static final String CAR_NAME = "test";
    private static final String LENGTH_ONE_STRING = "t";
    private static final String EMPTY_NAME = "";

    @BeforeEach
    void setUp() {
        carsFactory = new CarsFactory();
    }

    @Test
    @DisplayName("정상입력시_cars_객체생성성공")
    void create_NormalInput_CreateCarsSuccess() {
        //given
        String normalInput = CAR_NAME + INPUT_DELIM + CAR_NAME;
        String expected = CAR_NAME + IS + "\n" +
                CAR_NAME + IS + "\n";

        //when
        Cars cars = carsFactory.create(normalInput);

        //then
        String actual = cars.toString();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("list가_비어있다면_cars_객체생성실패")
    void create_ListIsEmpty_CreateCarsFail() {
        //given
        String errorInput = EMPTY_NAME;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> carsFactory.create(errorInput));
    }

    @Test
    @DisplayName("차이름_길이_초과시_car_객체생성실패")
    void create_OverLength_CreateCarFail() {
        //given
        int overLength = MAX_NAME_LENGTH + 1;
        String errorInput = LENGTH_ONE_STRING.repeat(overLength);

        //when & then
        assertThrows(IllegalArgumentException.class, () -> carsFactory.create(errorInput));
    }

    @Test
    @DisplayName("차이름_빈스트링이면__car_객체생성실패")
    public void create_emptyString_CreateCarFail() {
        //given
        String errorInput = EMPTY_NAME + INPUT_DELIM + EMPTY_NAME;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> carsFactory.create(errorInput));
    }
}