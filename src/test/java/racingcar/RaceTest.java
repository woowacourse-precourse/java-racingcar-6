package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTest {
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() {
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	@DisplayName("inputCarNames 메서드 테스트")
	void inputCarNamesTest() {
		Race race = new Race();
		String input = "pobi,woni";
		System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
		assertThat(race.inputCarNames()).isEqualTo(input);
	}

	@Test
	@DisplayName("convertToCarNameArray 메서드 테스트")
	void convertToCarNameArrayTest() {
		Race race = new Race();
		String input = "pobi,woni";
		String[] expectedArray = {"pobi", "woni"};
		assertThat(race.convertToCarNameArray(input)).isEqualTo(expectedArray);
	}

	@Test
	@DisplayName("convertToCarNameArray 메서드에서 유효하지 않은 이름 테스트")
	void convertToCarNameArrayInvalidNamesTest() {
		Race race = new Race();
		String input = "pobi, woni with space";
		assertThatThrownBy(() -> race.convertToCarNameArray(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효하지 않은 자동차 이름을 입력하셨습니다.");
	}

	@Test
	@DisplayName("containsNonStringElement 메서드 테스트")
	void containsNonStringElementTest() {
		Race race = new Race();
		String[] validCarNames = {"pobi", "woni"};
		race.containsNonStringElement(validCarNames);
	}

	@Test
	@DisplayName("containsNonStringElement 메서드에서 긴 이름 테스트")
	void containsNonStringElementInvalidLengthTest() {
		Race race = new Race();
		String[] invalidCarNames = {"pobi", "woni with a long name"};
		assertThatThrownBy(() -> race.containsNonStringElement(invalidCarNames))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("5글자 이하의 자동차 이름을 입력해주세요.");
	}

	@Test
	@DisplayName("stringToIntMoveCount 메서드 테스트")
	void stringToIntMoveCountTest() {
		Race race = new Race();
		assertThat(race.stringToIntMoveCount("5")).isEqualTo(5);
	}

	@Test
	@DisplayName("makeForwardStatus 메서드 테스트")
	void makeForwardStatusTest() {
		Race race = new Race();
		String[] carNamesArray = {"pobi", "woni"};
		assertThat(race.makeForwardStatus(carNamesArray)).containsKeys("pobi", "woni").containsValues("");
	}

	@Test
	@DisplayName("RaceEnd 클래스의 end 메서드 테스트")
	void raceEndTest() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;

		try {

			System.setOut(new PrintStream(outputStream));

			RaceEnd raceEnd = new RaceEnd();
			Map<String, String> forwardStatusMap = new HashMap<>();
			forwardStatusMap.put("pobi", "-");
			forwardStatusMap.put("woni", "-");
			String[] carNamesArray = {"pobi", "woni"};
			raceEnd.end(forwardStatusMap, carNamesArray);

			String expectedOutput = "최종 우승자 : pobi, woni";
			assertThat(outputStream.toString().trim()).isEqualTo(expectedOutput);
		} finally {

			System.setOut(originalOut);
		}
	}
}