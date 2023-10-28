package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
	public static void main(String[] args) {
		Game racingcar = new Game();
	}
}

class Game {
	private static String[] userArray;

	Game() {
		this.setGameUsers();
	}

	private void checkUsername() {
		for (int i = 0; i < userArray.length; i++) {
			if (userArray[i].length() > 5) {
				throw new IllegalArgumentException();
			} else {
				userArray[i] = userArray[i].replaceAll(" ", ""); // 공백제거
			}
		}
	}

	private String[] setGameUsers() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String userInput = readLine();

		userArray = userInput.split(","); // 사용자 등록
		this.checkUsername(); //유효성 검사

		return userArray;
	}

	
}