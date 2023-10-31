package racingcar;
import  camp.nextstep.edu.missionutils.Randoms;
import  camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        int i=0, cnt; // idx용 변수 i, 경주횟수 cnt변수

        /* 입력부 구현 */
        // 자동차 이름 입력
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String temp = Console.readLine();
        List<String> names = Arrays.asList(temp.split(",")); // pobi,woni,jun

        // 자동차 이름 잘못 입력 시 처리
        for (String name : names) {  // 이름 입력 예외 처리
            name = name.trim();      // 좌우 공백 제거, 중간의 공백은 글자수로 포함.
            names.set(i++, name);    // 공백 제거 글자로 원본 변경
            if (name.length() > 5 || name.length() < 1 ) {
                throw new IllegalArgumentException("자동차이름은 1자 이상, 5자 이하로 적어주십시오\n");
            }
        }

        // 시도 횟수 입력
        System.out.print("시도할 회수는 몇회인가요?\n"); // 5
        temp = Console.readLine();

        // 시도 횟수 잘못 입력 시 처리
        try{
            cnt = Integer.parseInt(temp);  // 정수변환이 안되면 예외발생
            if(cnt < 1)                    // 1이상의 양의 정수만 입력 받음
                throw new IllegalArgumentException();
        }catch(Throwable t){
            throw new IllegalArgumentException("양의 정수를 입력하십시오\n");
        }

        // 테스트용 간단 출력문
        for (String name : names){System.out.print(name + "\n");}
        System.out.print(cnt);
    }
}


