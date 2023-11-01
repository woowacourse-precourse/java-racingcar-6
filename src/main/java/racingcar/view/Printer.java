package racingcar.view;

import java.util.List;

import racingcar.domain.GameData;

public class Printer {
	public void displayMessage(String message) {
		System.out.print(message);
	}
	
	public void displayResult(GameData data) {
		for (int i = 0; i < data.getCarList().size(); i++) {
			String carName = data.getCarList().get(i);
            int position = data.getPositionList().get(i);
            
            StringBuilder result = new StringBuilder(carName + " : ");
            for (int j = 0; j < position; j++) {
                result.append("-");
            }
            System.out.println(result.toString());
        }
		System.out.println();
    }
	

}
