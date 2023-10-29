package racingcar.domain;

import java.util.Scanner;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    //string list 입력 후 반환
    //대괄호를 사용한 리스트 형식으로 입력, 그외의 값은 예외처리

    public String getCarName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = readLine();
        return str;
    }

    public Integer getCountYouWantTry(){
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scan = new Scanner(System.in);
        String str = readLine();
        return Integer.parseInt(str);
    }

}
