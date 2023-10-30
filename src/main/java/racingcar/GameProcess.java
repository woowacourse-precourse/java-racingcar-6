package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

//게임 진행 클래스
public class GameProcess {
	private static final int START_RANGE = 0;
	private static final int END_RANGE = 9;
	private static final int STANDARD = 4;

	public GameProcess() {

	}

	public void playGame(List<InformationOfCar> carList, int moveCount) {
		System.out.println();
		System.out.println("실행 결과");
		for (int j = 0; j < moveCount; j++) {
			for (InformationOfCar car : carList) {
				moveOrNot(car);
			}
			System.out.println();
		}
		int maxDistance = calculateMaxDistance(carList);
		printFinalString(maxDistance, carList);
	}

	public void moveOrNot(InformationOfCar car) {
		int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
		if (judgeMoveOrNot(randomNumber)) {
			car.setDistance("-");
		}
		System.out.println(car.getCarName() + " : " + car.getDistance());
	}

	public boolean judgeMoveOrNot(int randomNumber) {
		return randomNumber >= STANDARD;
	}

	public int calculateMaxDistance(List<InformationOfCar> carList) {
		carList.sort((car1, car2) -> car2.getDistance().length() - car1.getDistance().length());
		return carList.get(0).getDistance().length();
	}

	public void printFinalString(int maxDistance, List<InformationOfCar> carList) {
		StringBuilder result = new StringBuilder(carList.get(0).getCarName());
		for (int i = 1; i < carList.size(); i++) {
			InformationOfCar car = carList.get(i);
			if (car.getDistance().length() == maxDistance) {
				result.append(", ").append(car.getCarName());
			}
		}
		System.out.println("최종 우승자 : " + result);
	}

}
