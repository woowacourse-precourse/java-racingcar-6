package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {

    //문자를 반복해주는 함수
    public static String repeatCharacter(char character, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input=Console.readLine();
        //사용자 이름 입력
        String[] splited=input.split(",");

        Cars cars=new Cars();

        cars.setCars(splited);

        System.out.println("시도할 회수는 몇회인가요?");
        input=Console.readLine();
        final int count=Integer.parseInt(input);

        //결과창 구현
        System.out.println("실행 결과");
        cars.printLabs(count);



        //최종 결과 구현
        System.out.print("최종 우승자 : ");
        cars.getWinners();
    }
}
