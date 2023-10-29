package racingcar;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class PrintResult {
//	- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. viewRaceCar()
	public void viewRaceCar(int totalCar, List<Integer> racingRecord, List<String> carName) {
		int i = 0;
		while(i < totalCar) {
			System.out.print(carName.get(i) + " : ");
			for(int j = 0; j < racingRecord.get(i); j++) {
				System.out.print("-");
			}
			System.out.println();
			i++;
		}
		
	}
	
//	- 시도 횟수가 끝나면 경주 게임에서 우승자를 알려준다. (우승자는 한 명 이상일 수 있다, 쉼표로 구분) racingWinner()
	public void racingWinner(List<Integer> racingResult, List<String> name) {
		int win = Collections.max(racingResult);
		
//		while(computer.size() < 3) {
//    		int randomNumber = Randoms.pickNumberInRange(1, 9);
//    		if(!computer.contains(randomNumber)) {
//    			computer.add(randomNumber);
//    		}
//    	}
		for(int i=0; i<totalCar) {
			if(racingResult.contains(win)) {
				
			}
		}
		
		System.out.print("최종 우승자 : "+winner);
	}
	
} //end of class
