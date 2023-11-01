package racingcar;

import java.util.Vector;

public class Winner {
    Vector<String> winner = new Vector<String>();
	
	public Vector<String> getWinner() {
		return winner;
	}
    public void findWinner(Car[] car) {
		int temp = 0;
		for(int i = 0; i < car.length; i ++) {
			if(car[i].getAdvance() > temp) {
				getWinner().removeAllElements();
				temp = car[i].getAdvance();
				getWinner().add(car[i].getName());
			}
			else if(car[i].getAdvance() == temp) {
				getWinner().add(car[i].getName());
			}
		}
	}
}
