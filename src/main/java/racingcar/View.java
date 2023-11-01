package racingcar;

import java.util.ArrayList;
import java.util.List;

public class View {
    public void printStartInfo(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }
    public void printSelectLoop(){
        System.out.println("시도할 횟수는 몇회인가요?");
    }
    public void printRunning(){
        System.out.println("실행 결과");
        System.out.println();
    }

    public static void printResult(List<Car> cars){
        List<String> winners = Functions.getWinner(cars);
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }

}
