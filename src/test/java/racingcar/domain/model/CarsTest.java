package racingcar.domain.model;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.domain.service.RandomMoveJudge;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    private Car carMock1;
    private Car carMock2;
    private Cars cars;

    @BeforeEach
    void setUp() {
        carMock1 = Mockito.mock(Car.class);
        carMock2 = Mockito.mock(Car.class);
        cars = new Cars(Arrays.asList(carMock1, carMock2));
    }

    @Test
    void RandomMoveJudicator가_true일_시_move가_호출_되는지() {
        RandomMoveJudge judicatorMock = Mockito.mock(RandomMoveJudge.class);
        when(judicatorMock.canMove()).thenReturn(true);

        cars.moveAll(judicatorMock);

        verify(carMock1).move();
        verify(carMock2).move();
    }

}
