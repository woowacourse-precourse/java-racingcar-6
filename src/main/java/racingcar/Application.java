package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
	public static void main(String[] args) {
		Race race = new Race();
		race.start();
	}
}

class Race {
	public void start() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		raceReady();
	}

	public void raceReady() {
		String carName = inputCarNames();
		String[] carNamesArray = convertToCarNameArray(carName);

		askMoveCount();
		int movementLimit = stringToIntMoveCount(inputMoveCount());

		Map<String, String> forwardStatusMap = makeForwardStatus(carNamesArray);

		Racing race = new Racing();
		race.race(carNamesArray, movementLimit, forwardStatusMap);
	}

	public String inputCarNames() {
		String inputCarNames = Console.readLine();
		return inputCarNames;
	}

	public String[] convertToCarNameArray(String carName) {
		String[] carNamesArray = carName.split(",");

		validateinputCarNames(carNamesArray);

		containsNonStringElement(carNamesArray);

		return carNamesArray;
	}

	public void validateinputCarNames(String[] carNamesArray) {

		for (int i = 0; i < carNamesArray.length; i++) {

			if (carNamesArray[i].contains(" ")) {
				throw new IllegalArgumentException("유효하지 않은 자동차 이름을 입력하셨습니다.");
			}
		}
	}

	public void containsNonStringElement(String[] carNamesArray) {

		for (String carName : carNamesArray) {

			if (carName.length() > 5) {
				throw new IllegalArgumentException("5글자 이하의 자동차 이름을 입력해주세요.");
			}
		}
	}

	public void askMoveCount() {
		System.out.println("시도할 횟수는 몇회인가요?");
	}

	public String inputMoveCount() {

		String inputMoveCount = Console.readLine();

		try {
			validateNumeric(inputMoveCount);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}

		return inputMoveCount;
	}

	public static void validateNumeric(String inputMoveCount) throws NumberFormatException {

		if (!inputMoveCount.matches("-?\\d+(\\.\\d+)?")) {
			throw new NumberFormatException("입력값이 숫자가 아닙니다\n");
		}
	}

	public int stringToIntMoveCount(String moveCount) {
		return Integer.parseInt(moveCount);
	}

	public Map<String, String> makeForwardStatus(String[] carNamesArray) {

		Map<String, String> forwardStatusMap = new HashMap<>();

		for (String carName : carNamesArray) {
			forwardStatusMap.put(carName, "");
		}

		return forwardStatusMap;
	}
}

class Racing {
	public void race(String[] carNamesArray, int movementLimit, Map<String, String> forwardStatusMap) {

		for (int i = 0; i < movementLimit; i++) {

			if (i == 0) {
				System.out.println("실행 결과");
			}

			forward(carNamesArray, forwardStatusMap);
			printResult(forwardStatusMap);
		}

		RaceEnd raceEnd = new RaceEnd();
		raceEnd.end(forwardStatusMap, carNamesArray);
	}

	public void forward(String[] carNamesArray, Map<String, String> forwardStatusMap) {

		for (String carName : carNamesArray) {

			int moveDecision = Randoms.pickNumberInRange(0, 9);
			if (moveDecision >= 4) {
				String forwardStatus = forwardStatusMap.get(carName);
				forwardStatus += "-";
				forwardStatusMap.put(carName, forwardStatus);
			}
		}
	}

	public void printResult(Map<String, String> forwardStatusMap) {

		for (Map.Entry<String, String> entry : forwardStatusMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		System.out.println();
	}
}

class RaceEnd {

	public void end(Map<String, String> forwardStatusMap, String[] carNamesArray) {
		ArrayList<Integer> forwardCountArrayList = makeForwardCountArrayList(forwardStatusMap);
		Winner winner = new Winner();
		winner.findWinners(forwardCountArrayList, carNamesArray);
	}

	public ArrayList<Integer> makeForwardCountArrayList(Map<String, String> forwardStatusMap) {
		return forwardStatusMap.values().stream().map(String::length).collect(Collectors.toCollection(ArrayList::new));
	}
}

class Winner {
	public void findWinners(ArrayList<Integer> forwardCountArrayList, String[] carNamesArray) {

		int winnerScore = Collections.max(forwardCountArrayList);

		ArrayList<String> winnerNameArrayList = composeWinnerNameArrayList(forwardCountArrayList, winnerScore,
			carNamesArray);

		decisionWinner(winnerNameArrayList);
	}

	public ArrayList<String> composeWinnerNameArrayList(ArrayList<Integer> forwardCountArrayList, int winnerScore,
		String[] carNamesArray) {

		ArrayList<String> winnerNameArrayList = new ArrayList<>();

		for (int i = 0; i < forwardCountArrayList.size(); i++) {
			int forwardCount = forwardCountArrayList.get(i);
			if (forwardCount == winnerScore) {
				winnerNameArrayList.add(carNamesArray[i]);
			}
		}

		return winnerNameArrayList;
	}

	public void decisionWinner(ArrayList<String> winnerNameArrayList) {

		StringBuilder gameResult = new StringBuilder("최종 우승자 : ");

		if (winnerNameArrayList.size() > 1) {
			pluralWinnerDecision(winnerNameArrayList, gameResult);
		} else if (winnerNameArrayList.size() == 1) {
			singleWinnerDecision(winnerNameArrayList.get(0), gameResult);
		}

		displayGameResult(gameResult.toString());
	}

	public void pluralWinnerDecision(ArrayList<String> winnerNameArrayList, StringBuilder gameResult) {

		for (int i = 0; i < winnerNameArrayList.size(); i++) {
			gameResult.append(winnerNameArrayList.get(i));

			if (i < winnerNameArrayList.size() - 1) {
				gameResult.append(", ");
			}
		}
	}

	public void singleWinnerDecision(String winnerName, StringBuilder gameResult) {
		gameResult.append(winnerName);
	}

	public void displayGameResult(String gameResult) {
		System.out.println(gameResult);
	}
}