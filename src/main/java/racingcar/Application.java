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
        String tryCount;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = readLine();
        if(iv.isBlank(userInput)) throw new IllegalArgumentException("공백을 입력하실 수 없습니다.");
        String[] splitInput = userInput.split(",");
        for(String i : splitInput){
            userCars.add(new Car(i));
        }


        System.out.println("시도할 회수는 몇 회인가요?");
        tryCount = readLine();
        if(iv.isNumber(tryCount)) throw new IllegalArgumentException("공백을 입력하실 수 없습니다.");
        System.out.println();

    }
}

