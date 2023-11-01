package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input= Console.readLine();
        String[] carNames=input.split(",");
        List<String> cars=new ArrayList<>();
        Collections.addAll(cars, carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount=Integer.parseInt(Console.readLine());

        for (int i=1;i<tryCount+1;i++){
            for (String car : cars){
                // 자동차 생성
                // 자동차 이동
            }
        }




    }
}
