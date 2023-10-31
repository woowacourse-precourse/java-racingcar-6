package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String[] startGame(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }
    public Integer inputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.valueOf(Console.readLine());
    }
    public void validTryCount(Integer inputTryCount){
        if (inputTryCount < 1){
            throw new IllegalArgumentException("시도할 회수는 1이상이어야 합니다.");
        }
    }
}
