package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.view.InputView;

class RaceTest {

	@Test
	void createRace() {
		InputView inputView = Mockito.spy(new InputView());
		Mockito.doReturn("car1,car2,car3").when(inputView).userInput();

		Race race = new Race(inputView.getCarsName());

		Assertions.assertThat(race.getCars().size()).isEqualTo(3);
		Assertions.assertThat(race.getCars().get(0)).isInstanceOf(Car.class);
		Assertions.assertThat(race.getCars().get(1)).isInstanceOf(Car.class);
		Assertions.assertThat(race.getCars().get(2)).isInstanceOf(Car.class);
	}
}