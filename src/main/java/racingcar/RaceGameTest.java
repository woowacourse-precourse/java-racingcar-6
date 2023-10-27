package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceGameTest {

	@Test
	@DisplayName("자동차 이름 입력 기능 테스트")
	void getNamesInputTest() {
		String[] nameArray = {"kim", "lee", "park"};
		Pair[] tmpArray = new Pair[3];
		
		for (int i = 0; i < 3; i++) {
			tmpArray[i] = new Pair();
			tmpArray[i].setName(nameArray[i]);
			tmpArray[i].setLocation(0);
		}
		
		List<Pair> tmpList = Arrays.asList(tmpArray);
		
		RaceGame game = new RaceGame();
		List<Pair> testList = game.getNamesInput();
		
		assertThat(testList.get(0).getName()).isEqualTo(tmpList.get(0).getName());
		assertThat(testList.get(0).getLocation()).isEqualTo(tmpList.get(0).getLocation());
		assertThat(testList.get(1).getName()).isEqualTo(tmpList.get(1).getName());
		assertThat(testList.get(1).getLocation()).isEqualTo(tmpList.get(1).getLocation());
		assertThat(testList.get(2).getName()).isEqualTo(tmpList.get(2).getName());
		assertThat(testList.get(2).getLocation()).isEqualTo(tmpList.get(2).getLocation());
	}
	
	@Test
	@DisplayName("6자 이상 이름에 대하여 익셉션 발생 기능 테스트")
	void getNamesInputExceptionTest() {
		RaceGame game = new RaceGame();
		
		assertThatThrownBy(() -> game.getNamesInput())
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("시도 회수 입력 기능 테스트")
	void getTrialInputTest() {
		RaceGame game = new RaceGame();
		
		assertThat(game.getTrialInput()).isEqualTo(5);
	}
	
	@Test
	@DisplayName("정수가 아닌 이름에 대하여 익셉션 발생 기능 테스트")
	void getTrialInputExceptionTest() {
		RaceGame game = new RaceGame();
		
		assertThatThrownBy(() -> game.getTrialInput())
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("승자를 정하는 기능 테스트")
	void getWinnerTest() {
		String[] nameArray = {"kim", "lee", "park", "choi"};
		String[] winnerArray = {"park", "choi"};
		Pair[] tmpArray = new Pair[4];
		
		for (int i = 0; i < 4; i++) {
			tmpArray[i] = new Pair();
			tmpArray[i].setName(nameArray[i]);
			tmpArray[i].setLocation(i + 1);
		}
		tmpArray[2].move();
		
		List<Pair> tmpList = Arrays.asList(tmpArray);
		List<String> winnerList = Arrays.asList(winnerArray);
		
		RaceGame game = new RaceGame();
		
		assertThat(game.getWinner(tmpList)).isEqualTo(winnerList);
	}
}
