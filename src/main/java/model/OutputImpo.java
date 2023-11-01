package model;

import java.util.List;

public class OutputImpo {
	
	private List<String> winnerList;

	public OutputImpo(List<String> winnerList) {
		this.winnerList = winnerList;
	}

	public static void showMovingProcess(Car car, int i) {
		System.out.print(car.getName() + " : ");
		if(car.getNumberList().get(i) >= 4) {
			car.plusForword();
		}
		
		for(int j = 1; j <= car.getForword(); j++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public static int WinnerValue(List<Car> carList) {
		int max = carList.get(0).getForword();
		for(int i = 0; i < carList.size() - 1; i++) {
			int k = carList.get(i + 1).getForword();
			
			if(max < k) {
				max = k;
			}
		}
		return max;
	}

	public List<String> addWinner(Car car, int max) {
		if(car.getForword() == max) {
			winnerList.add(car.getName());
		}
		
		return winnerList;
	}
}
