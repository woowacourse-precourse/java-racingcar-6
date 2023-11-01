package racingcar.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import racingcar.utils.TestFixtureUtils;
import racingcar.vo.CarCollection;
import racingcar.vo.CarInfo;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CarCollectionUserInputTest {

    @Mock
    private ConsoleUserInput consoleUserInput = mock(ConsoleUserInput.class);

    private CarCollectionUserInput carCollectionUserInput;

    @BeforeEach
    void setUp() {
        carCollectionUserInput = new CarCollectionUserInput(consoleUserInput);
    }

    @Test
    @DisplayName("입력받은 자동차 이름을 쉼표(,) 기준으로 분리하여 CarCollection 객체를 생성한다.")
    void input(){
        //given
        final CarCollection expected = TestFixtureUtils.generateCarCollection(4);
        given(consoleUserInput.input()).willReturn(convertCarCollectionToString(expected));
        //when
        final CarCollection actual = carCollectionUserInput.input();
        //then
        Assertions.assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    @DisplayName("입력받은 자동차 이름이 5자를 초과하면 IllegalArgumentException을 발생시킨다.")
    void input_WhenNameLengthIsOver5_ThrowIllegalArgumentException(){
        //given
        final CarCollection expected = TestFixtureUtils.generateCarCollection(4);
        given(consoleUserInput.input()).willReturn(convertCarCollectionToString(expected) + "123");
        //when
        //then
        Assertions.assertThatThrownBy(() -> carCollectionUserInput.input())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private String convertCarCollectionToString(CarCollection carCollection){
        return carCollection.getCarList().stream()
                .map(CarInfo::getName)
                .reduce((name1, name2) -> name1 + "," + name2)
                .orElseThrow(IllegalArgumentException::new);
    }



}