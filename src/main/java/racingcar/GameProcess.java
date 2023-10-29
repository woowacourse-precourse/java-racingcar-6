package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class GameProcess {

	public GameProcess() {

	}

	public void playGame(ArrayList<InformationOfCar> carList, int moveCount) {
		System.out.println();
		System.out.println("실행 결과");
		for (int j = 0; j < moveCount; j++) {
			for (InformationOfCar car : carList) {
				moveOrNot(car);
			}
			System.out.println();
		}
		judgeWinnerDistance(carList);
	}

	private void moveOrNot(InformationOfCar car) {
		int randomNumber = Randoms.pickNumberInRange(0, 9);
		if (judgeMoveOrNot(randomNumber)) {
			car.setDistance("-");
		}
		System.out.println(car.getCarName() + " : " + car.getDistance());
	}

	private boolean judgeMoveOrNot(int randomNumber) {
		return randomNumber >= 4;
	}

	private void judgeWinnerDistance(ArrayList<InformationOfCar> carList) {
		carList.sort((car1, car2) -> car2.getDistance().length() - car1.getDistance().length());
		int maxDistance = carList.get(0).getDistance().length();
		makeFinalString(maxDistance, carList);
	}

	private void makeFinalString(int maxDistance, ArrayList<InformationOfCar> carList) {
		StringBuilder result = new StringBuilder(carList.get(0).getCarName());
		for (int i = 1; i < carList.size()-1; i++) {
			InformationOfCar car = carList.get(i);
			if (car.getDistance().length() == maxDistance) {
				result.append(", ").append(car.getCarName());
			}
		}
		System.out.println("최종 우승자 : " + result.toString());
	}

}
