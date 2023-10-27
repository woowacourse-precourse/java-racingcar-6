package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

class Car{
	
	public static String name;
	public static int step;
	public static String show;
	
	public Car(String n) {
		name = n;
		step = 0;
		show = "";
	}

	public static void go() {
		int randomNumber = Randoms.pickNumberInRange(1, 9);
		
		if(randomNumber >= 4) {
			step++;
			show = show + "-";
		}
    }
	
	public static void print() {
		System.out.printf("%s : %s", name, show);
	}
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
