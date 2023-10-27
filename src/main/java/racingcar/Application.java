package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Randoms;

class Car{
	
	String name;
	int step;
	String show;
	
	public Car(String n) {
		name = n;
		step = 0;
		show = "";
	}

	public void go() {
		int randomNumber = Randoms.pickNumberInRange(1, 9);
		
		if(randomNumber >= 4) {
			step++;
			show = show + "-";
		}
    }
	
	public void print() {
		System.out.printf("%s : %s", name, show);
	}
}

public class Application {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = sc.nextLine();
        sc.close();
        
        ArrayList<String> carNames = new ArrayList<String>();
        Collections.addAll(carNames, input.split(","));
        int N = carNames.size();
        
        Car[] cars = new Car[N];
        for(int i = 0; i < N; i++) {
        	cars[i] = new Car(carNames.get(i));
        }
    }
}
