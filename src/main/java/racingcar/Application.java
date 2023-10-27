package racingcar;

import java.util.ArrayList;
import java.util.List;

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
    
    //차 이름 유효성 검사
    public static void checkCarNameValidation(String carName) {
    	Validator.validateCarName(carName);
    }
    
    //입력받은 차 이름 분리하기(쉼표로 구분하기)
    public static List<String> separateCarNameInput(String carNames){
    	List<String> carList = new ArrayList<>();
    	String[] carNamesArr = carNames.split(",");
    	for(int i=0;i<carNamesArr.length;i++) {
    		checkCarNameValidation(carNamesArr[i]);
    		carList.add(carNamesArr[i]);
    	}
    	return carList;
    }
    
    //차 이동횟수 유효성 검사
    public static void checkNumberValidation(String movingNumberStr) {
    	Validator.valdateMovingNumber(movingNumberStr);
    }
    
}
