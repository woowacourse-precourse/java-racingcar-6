package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RacingCarControllerTest {

	private static final String SUCCESS_CAR_NAME_AND_NUMBER = "aaa,bbb,ccc" + "\n" + "6" +"\n";
	private static final String FAIL_LENGTH_CAR_NAME = "aaaaaa,bbb,cc" +"\n";
	private static final String FAIL_SPACE_CAR_NAME = "aa aa,bb,cc" + "\n";
	private static final String FAIL_DUPLICATE_CAR_NAME = "aa,aa,cc" + "\n";

	private static final String FAIL_NUMBER_IS_NUMBER = "aa,bb" + "\n" + "notNumber"+ "\n";

	private static final String FAIL_NUMBER_IS_POSITIVE = "aa,bb" + "\n" + "0"+ "\n";
	private static final String SUCCESS_GAME_CASE = "pobi,woni,jun" + "\n" + "5"+ "\n";

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@BeforeAll
	static void setUp() {
		String testText = SUCCESS_CAR_NAME_AND_NUMBER + FAIL_LENGTH_CAR_NAME + FAIL_SPACE_CAR_NAME +
			FAIL_DUPLICATE_CAR_NAME + FAIL_NUMBER_IS_NUMBER + FAIL_NUMBER_IS_POSITIVE +
			SUCCESS_GAME_CASE;
		System.setIn(new ByteArrayInputStream(testText.getBytes()));
	}
	@org.junit.jupiter.api.Order(1)
	@Test
	void testSaveCarName_Success() {
		RacingCarController controller = new RacingCarController();
		assertThatCode(() -> controller.startGame())
			.doesNotThrowAnyException();
	}

	@org.junit.jupiter.api.Order(2)
	@Test
	void testSaveCarName_Fail_Length() {
		RacingCarController controller = new RacingCarController();
		assertThatThrownBy(() -> controller.startGame())
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효하지 않은 이름이 포함되어 있습니다.");
	}

	@org.junit.jupiter.api.Order(3)
	@Test
	void testSaveCarName_Fail_Whitespace() {
		RacingCarController controller = new RacingCarController();
		assertThatThrownBy(() -> controller.startGame())
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효하지 않은 이름이 포함되어 있습니다.");
	}

	@org.junit.jupiter.api.Order(4)
	@Test
	void testSaveCarName_Fail_Duplicate_Name() {
		RacingCarController controller = new RacingCarController();
		assertThatThrownBy(() -> controller.startGame())
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("중복된 이름이 포함되어 있습니다.");
	}

	@org.junit.jupiter.api.Order(4)
	@Test
	void testSaveTryNumber_Fail_Is_Number() {
		RacingCarController controller = new RacingCarController();
		assertThatThrownBy(() -> controller.startGame())
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("입력값은 숫자여야 합니다.");
	}

	@org.junit.jupiter.api.Order(5)
	@Test
	void testSaveTryNumber_Fail_Is_Positive() {
		RacingCarController controller = new RacingCarController();
		assertThatThrownBy(() -> controller.startGame())
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("입력값은 0보다 커야 합니다.");
	}

	@org.junit.jupiter.api.Order(6)
	@Test
	void testResult_Cases() {
		RacingCarController controller = new RacingCarController();
		System.setOut(new PrintStream(outContent));
		controller.startGame();

		String result = outContent.toString();
		assertThat(result).contains("최종 우승자 : ");
		assertTrue(result.contains("pobi"));
		assertTrue(result.contains("woni"));
		assertTrue(result.contains("jun"));
		System.setOut(originalOut);
	}






}