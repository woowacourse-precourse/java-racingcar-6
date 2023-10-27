package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

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

	@Test
	@DisplayName("게임 시작 출력 테스트")
	void printStartTest() {
		GamePrint.printStart();
		assertEquals("\n실행 결과\n", output.toString());
	}
	
	@Test
	@DisplayName("레이싱 진행 과정 출력 테스트")
	void printRaceTest() {
		String[] nameArray = {"kim", "lee", "park"};
		Pair[] tmpArray = new Pair[3];
		
		for (int i = 0; i < 3; i++) {
			tmpArray[i] = new Pair();
			tmpArray[i].setName(nameArray[i]);
			tmpArray[i].setLocation(i + 1);
		}
		
		List<Pair> tmpList = Arrays.asList(tmpArray);
		
		GamePrint.printRace(tmpList);
		assertEquals("kim : -\nlee : --\npark : ---\n\n", output.toString());
	}
	
	@Test
	@DisplayName("게임 승자 출력 테스트")
	void printWinnerTest() {
		String[] tmpArray = {"kim", "lee", "park"};
		List<String> winners = Arrays.asList(tmpArray);
		
		GamePrint.printWinner(winners);
		assertEquals("최종 우승자 : kim, lee, park\n", output.toString());
	}
}
