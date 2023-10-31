package racingcar;

import camp.nextstep.edu.missionutils.Console;


public class UserInput {
    //사용자 입력 클래스
    public String[] InputCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        String[] carNames = cars.split(",");
        ErrorOccur errorOccur = new ErrorOccur();

        return errorOccur.ReturnCarName(carNames);
    }
    public int InputNum(){
        System.out.println("시도할 회수는 몇회인가요");
        return Integer.parseInt(Console.readLine());
    }



}
