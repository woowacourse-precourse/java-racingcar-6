package view;

import java.util.ArrayList;
import java.util.List;

import model.Car;

public class OutView {

	private static final String OUT_RESULT_MESSAGE = "실행결과";
	private static final String OUT_WINNER = "최종 우승자 : ";
		
	public void showResult(List<Car> carList) {
		System.out.println(OUT_RESULT_MESSAGE);

		for(Car car : carList) {
			System.out.print(car.getName() + " : ");
			for(int i = 1; i <= car.getForword(); i++) {
				System.out.print("-");
			}
			System.out.println();
		}
		showWinner(carList);
	}
	
	private void showWinner(List<Car> carList) {
		System.out.println();
		System.out.print(OUT_WINNER);
		
		List<String> winnerList = new ArrayList<>();
		int max = 0;
		for(int i = 0; i < carList.size() - 1; i++) {
			int j = carList.get(i).getForword();
			int k = carList.get(i + 1).getForword();
			
			if(j < k) {
				max = k;
			} else {
				max = j;
			}
		}
		
		for(Car car : carList) {
			if(car.getForword() == max) {
				winnerList.add(car.getName());
			}
		}
		
		for(int i = 0; i < winnerList.size(); i++) {
			if(i == winnerList.size() - 1) {
				System.out.println(winnerList.get(i));
				return;
			}
			System.out.print(winnerList.get(i) + ", ");
		}
	}
}
