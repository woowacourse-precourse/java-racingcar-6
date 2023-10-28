package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Race;

public class ResultViewTest {

	private final ByteArrayOutputStream outputResult = new ByteArrayOutputStream();
	private ResultView resultView;
	private Race race;

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outputResult));
		resultView = new ResultView();

		String[] carNames = {"car1", "car2", "car3"};
		race = new Race(carNames);
		// car1
		race.getCars().get(0).move(8);
		race.getCars().get(0).move(7);
		// car2
		race.getCars().get(1).move(6);
		// car3
		race.getCars().get(2).move(1);
	}

	@AfterEach
	public void restoreStreams() {
		System.setOut(System.out);
	}

	@Test
	public void getResult() {
		resultView.getResult(race);
		String expectedOutput = "car1 : --\n" +
			"car2 : -\n" +
			"car3 : \n";

		assertThat(expectedOutput.trim()).isEqualTo(outputResult.toString().trim());
	}

	@Test
	public void getFinalWinner() {
		resultView.getFinalWinner(race);
		String expectedOutput = "최종 우승자 : car1";

		assertThat(expectedOutput).isEqualTo(outputResult.toString());
	}

	@Test
	public void getFinalWinner_two_people() {
		// car2
		race.getCars().get(1).move(5);

		resultView.getFinalWinner(race);
		String expectedOutput = "최종 우승자 : car1, car2";

		assertThat(expectedOutput).isEqualTo(outputResult.toString());
	}
}