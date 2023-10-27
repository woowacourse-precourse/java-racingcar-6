package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class GamePrintTest {
	
	private static ByteArrayOutputStream output;
	
	@BeforeEach
	void setStream() {
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
	}
	
	@AfterEach
	void restoreStream() {
		System.setOut(System.out);
	}
	

	@Test
	@DisplayName("경주할 자동차 이름 안내 출력 테스트")
	void printGetNamesTest() {
		GamePrint.printGetNames();
		assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n", output.toString());
	}
	
	@Test
	@DisplayName("시도 회수 입력 안내 출력 테스트")
	void printGetTrialTest() {
		GamePrint.printGetTrial();
		assertEquals("시도할 회수는 몇회인가요?\n", output.toString());
	}

}
