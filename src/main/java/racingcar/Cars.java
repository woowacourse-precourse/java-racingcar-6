package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Cars {
    
    public String [] enterCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }
    
    public void validateCarsName(String[] carArray) {
        validateCarNameEntered(carArray);
        validateCarNameLength(carArray);
    }
    
    private void validateCarNameEntered(String[] carArray) {
        for (String car : carArray) {
            if (car.isBlank()){
                throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다!");
            }
        }
    }
    
    private void validateCarNameLength(String[] carArray) {
        for (String car : carArray) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("각 자동차 이름은 5자 이하여야 합니다!");
            }
        }
    }
        
    
}
