package racingcar;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.model.CarsService;
import racingcar.view.OutputView;

public class OutputViewTest {

	static CarsService carsService = new CarsService();

	ByteArrayOutputStream output;

	@BeforeAll
	//given
	static void create() {

		carsService.make("GinoB, Curry, James");

		List<List<Integer>> randoms = asList(
			asList(9, 9, 9),
			asList(9, 9, 0),
			asList(9, 9, 0)
		);

		for (List<Integer> eachRandoms : randoms) {
			carsService.moveOrStop(eachRandoms);
		}

	}

	@BeforeEach
	void setUpOutput() {

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

	}

	@Test
	void printEachRoundTest() {

		//when
		OutputView.printEachRound(carsService);

		String actualMessage = output.toString();

		//then
		final String EXPECTED_GINOB = "GinoB : ---";
		final String EXPECTED_CURRY = "Curry : ---";
		final String EXPECTED_JAMES = "James : -";

		assertThat(actualMessage)
			.contains(EXPECTED_GINOB)
			.contains(EXPECTED_CURRY)
			.contains(EXPECTED_JAMES);

	}

	@Test
	void printWinnerTest() {

		//given
		String winner = carsService.findWinner();

		//when
		OutputView.printWinner(winner);

		String actualMessage = output.toString();

		//then
		final String EXPECTED_WINNER = "GinoB, Curry";

		assertThat(actualMessage).contains(EXPECTED_WINNER);

	}

}
