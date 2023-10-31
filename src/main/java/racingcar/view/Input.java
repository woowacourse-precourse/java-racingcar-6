package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public void getCarName() {
		String carName = Console.readLine();
		// carName 입력 예외처리 메서드 만들기(예외처리 클래스 따로 필요)
		// ,단위로 split 하기 -> 메서드로 간다
		// 배열에 담기 -> 도메인의 data클래스에 저장
	}
	
	public int getTrialNumber() {
		String strTrialNumber = Console.readLine();
		// 시도횟수 입력 예외처리 메서드 만들기
		int trialNumber = Integer.parseInt(strTrialNumber);
		return trialNumber;
	}
}
