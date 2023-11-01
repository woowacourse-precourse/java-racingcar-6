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
    public void printWinner() {
		System.out.print("최종 우승자 : ");
		for(int i = 0; i < getWinner().size(); i ++) {
			if(i > 0)
				System.out.print(", ");
			System.out.print(getWinner().get(i));
		}
	}
}
