package racingcar;

import java.util.ArrayList;

public class Winner {
	public static ArrayList<String> resultWinner(ArrayList<Car> carList, String[] location){
		ArrayList<String> winner = new ArrayList<>();
		int max = 0;
		for(String str : location) {
			max = Math.max(max, str.length());
		}
		for(int i=0; i<carList.size(); i++) {
			if(location[i].length() == max) {
				winner.add(carList.get(i).name);
			}
		}
		return winner;
	}
}
