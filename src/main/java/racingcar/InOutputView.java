package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InOutputView {
    public List<String> inputCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        return List.of(cars.split(","));
    }
    public int inputRound(){
        System.out.println("시도할 회수는 몇회인가요?");
        return convertNumber(Console.readLine());
    }

    public int convertNumber(String s){
        try {
            return Integer.parseInt(s);
        }catch (Exception e){
            throw new IllegalArgumentException("숫자로 입력해주세요");
        }
    }
    public void printResult(){
        System.out.println("실행 결과");
    }

    public void printCarsState(Cars cars){
        System.out.println(cars.getCarStates());
    }
    public void printWinner(Cars cars){
        System.out.println("최종 우승자 : "+String.join(",",cars.getWinner()));
    }
}
