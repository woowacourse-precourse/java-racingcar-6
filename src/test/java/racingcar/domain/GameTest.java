package racingcar.domain;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void moveAllCars와_printCarNameAndPositions는_TryCount만큼_실행된다() {
        Cars mockCars = mock(Cars.class);
        TryCount mockTryCount = mock(TryCount.class);
        Game game = new Game(mockCars, mockTryCount);

        when(mockTryCount.getTryCount()).thenReturn(5);
        when(mockCars.getSize()).thenReturn(3);

        game.play();

        verify(mockCars, times(5)).moveAllCars(anyList());
        verify(mockCars, times(5)).printCarNamesAndPositions();
    }

    @Test
    public void getWinners를_호출하면_findWinner가_정상적으로_호출된다() {
        Cars mockCars = mock(Cars.class);
        TryCount mockTryCount = mock(TryCount.class);
        Game game = new Game(mockCars, mockTryCount);

        game.getWinners();

        verify(mockCars, times(1)).findWinners();
    }
}