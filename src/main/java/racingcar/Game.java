package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;

public class Game {
	private static String[] userArray;
	private static int count;
	private static int[] moveCount;
	private static ArrayList<Integer> maxIndices = new ArrayList<>();

	public String[] checkUsername(String input) {
		String[] users = input.split(",");

		for (int i = 0; i < users.length; i++) {
			if (users[i].length() > 5) {
				throw new IllegalArgumentException();
			} else {
				users[i] = users[i].replaceAll(" ", ""); // 공백제거
			}
		}

		return users;
	}

	private void setGameUsers() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String userInput = readLine();

		userArray = checkUsername(userInput); // 사용자 등록
	}

	public int intValidator(String userInput) {
		try {
			return Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}

	}

	private void setGameCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		String userInput = readLine();

		count = this.intValidator(userInput);// 이동할 회수 등록
	}

	private void forwardOrStop() {
		String forward = "-";
		moveCount = new int[userArray.length];

		System.out.printf("%n실행 결과%n");
		for (int i = 0; i < count; i++) { // 횟수만큼 반복하여 사용자의 전진상태 출력
			for (int k = 0; k < userArray.length; k++) {
				int randomNumber = pickNumberInRange(0, 9);

				if (randomNumber >= 4) {
					moveCount[k]++;
				}

				System.out.printf("%s : %s %n", userArray[k], forward.repeat(moveCount[k]));
			}
			System.out.println("");
		}
	}

	public ArrayList<Integer> findMaxIndex(int[] count) {
		int max = count[0];

		maxIndices.add(0);

		for (int i = 1; i < count.length; i++) {
			if (count[i] > max) {
				max = count[i];
				maxIndices.clear();
				maxIndices.add(i);
			} else if (count[i] == max) {
				maxIndices.add(i);
			}
		}

		return maxIndices;
	}

	private String pickWinner() {
		String winner = "";

		this.findMaxIndex(moveCount);

		for (int i = 0; i < maxIndices.size(); i++) {
			if (i == maxIndices.size() - 1) {
				winner += userArray[maxIndices.get(i)];
			} else {
				winner += userArray[maxIndices.get(i)] + ", ";
			}
		}

		return winner;
	}

	public void processGame() {
		this.setGameUsers(); // 사용자 등록 
		this.setGameCount(); // 사용자로 부터 이동할 회수 등록
		this.forwardOrStop(); // 입력받은 횟수만큼 전진결과 출력 
		System.out.print("최종 우승자 : " + this.pickWinner()); // 최종 우승자 출력 
	}

}