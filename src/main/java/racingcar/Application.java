package racingcar;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        
    	System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    	String carNameInput = Console.readLine();
    	String[] cars = carNameInput.split(",");
    	for(int i = 0; i < cars.length; i++) {
    		cars[i] = cars[i].trim();
    	}
    	System.out.println(Arrays.toString(cars));
    }
}
