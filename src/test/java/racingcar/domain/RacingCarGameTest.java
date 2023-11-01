package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;

class RacingCarGameTest {
	RacingCarGame racingCarGame;
	String inputForName;
	String inputForAttempts;

	@BeforeEach
	public void setUp() {
		Console.close();
		racingCarGame = new RacingCarGame();
		inputForName = "pobi,woni,jun\n";
		inputForAttempts = "5\n";
	}

	@Test
	public void testStartGameWithNameZeroLength() {
		inputForName = "\n";
		System.setIn(new ByteArrayInputStream((inputForName).getBytes()));

		assertThatThrownBy(racingCarGame::startGame).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름을 입력하여 주십시오.");
	}

	@Test
	public void testStartGameWithNameOverFiveLength() {
		inputForName = "pobiwoni,jun\n";
		System.setIn(new ByteArrayInputStream((inputForName).getBytes()));


		assertThatThrownBy(racingCarGame::startGame).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능합니다.");
	}

	@Test
	public void testStartGameWithNameContinuousDelimiter() {
		inputForName = "pobi,,woni,jun\n";
		System.setIn(new ByteArrayInputStream((inputForName).getBytes()));

		assertThatThrownBy(racingCarGame::startGame).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능합니다.");
	}

	@Test
	public void testStartGameWithDuplicatedName() {
		inputForName = "pobi,woni,jun,pobi\n";
		System.setIn(new ByteArrayInputStream((inputForName).getBytes()));

		assertThatThrownBy(racingCarGame::startGame).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름이 중복되었습니다.");
	}
}
