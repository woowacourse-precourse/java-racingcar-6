package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputValidator iv = new inputValidator();
        ArrayList<Car> userCars = new ArrayList<Car>();
        int tryCount;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = readLine();

        if(iv.isBlank(userInput)) throw new IllegalArgumentException("공백을 입력하실 수 없습니다.");

        String[] splitInput = userInput.split(",");

        for(String i : splitInput){
            userCars.add(new Car(i));
        }

        System.out.println("시도할 회수는 몇 회인가요?");

        tryCount = Integer.parseInt(readLine());

        System.out.println();
        System.out.println("실행 결과");

        for(int i=0;i<tryCount;i++){
            for(Car c : userCars){
                RandomDice dice = new RandomDice();
                dice.setNum();
                if(dice.getNum()>=4){
                    c.addProgress();
                }
                System.out.println(c.showProgress());
            }
            System.out.println();
        }
        System.out.println();
    }
}

