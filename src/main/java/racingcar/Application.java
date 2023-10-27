package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	
    }
    
	//게임 시작전 안내문 출력
    public static void startGame() {
    	System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    
    //차 이름(쉼표로 구분된 여러 이름) 입력받기
    public static String inputCarName(){
    	String carNames = Console.readLine();
    	return carNames;
    }
    
}
