package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input=Console.readLine();
        String[] splited=input.split(",");
        ArrayList<Car> cars=new ArrayList<>();
        for (int i=0;i<splited.length;i++){
            cars.add(new Car(splited[i]));
        }
        System.out.println("시도할 회수는 몇회인가요?");
        input=Console.readLine();
        final int count=Integer.parseInt(input);

        //결과창 구현
        System.out.println("실행 결과");
        for (int i=0;i<count;i++){
            for(int j=0;j<cars.size();j++){
                System.out.println(cars.get(j).name+" : "+cars.get(j).drive_random());
            }
            System.out.println();
        }
    }
}
