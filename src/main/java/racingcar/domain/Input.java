package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    //string list 입력 후 반환
    //대괄호를 사용한 리스트 형식으로 입력, 그외의 값은 예외처리

    public List<String> getCarName() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();
        List<String> list = Arrays.asList(carNames.split(","));

        for(String str : list){
            if(str.length() >= 5){
                throw new IllegalArgumentException("5자 이하의 이름만 가능합니다!");
            }
        }

        return list;
    }

    //단위 test용으로 overloading 한 함수, 사용자 입력을 넣어주기위해 작성, 실제로는 사용하지 않음
    public List<String> getCarName(String carNames) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        //String carNames = readLine();
        List<String> list = Arrays.asList(carNames.split(","));

        for(String str : list){
            if(str.length() >= 5){
                throw new IllegalArgumentException("5자 이하의 이름만 가능합니다!");
            }
        }

        return list;
    }

    public Integer getCountYouWantTry(){
        System.out.println("시도할 회수는 몇회인가요?");
        String str = readLine();
        return Integer.parseInt(str);
    }

    //단위 test용으로 overloading 한 함수, 사용자 입력을 넣어주기위해 작성, 실제로는 사용하지 않음
    public Integer getCountYouWantTry(String CountYouWantTry){
        System.out.println("시도할 회수는 몇회인가요?");
       //String str = readLine();
        return Integer.parseInt(CountYouWantTry);
    }

}
