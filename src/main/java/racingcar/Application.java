package racingcar;

import java.util.List;

import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public class Car {
        String Name = "";
        int Location = 0;

        public void Move(int moveDistance) {
            Location = Location + moveDistance;
        }
    }

    public static Car[] isCarNameValid(String inp) {
        Car[] cars;

        // 입력에 컴마가 없는 경우
        if (inp.contains(",")) {
            throw new IllegalArgumentException();
        } else {
            String CarName;
            String[] ArraysInp = inp.split(",");
            cars = new Car[ArraysInp.length];

            for (int i = 0; i < ArraysInp.length; i++) {
                CarName = ArraysInp[i];

                // 입력이 빈칸인 경우
                if ((CarName.length() > 5) || (CarName == "" )) {
                    throw new IllegalArgumentException();
                }

                // 입력이 유효하면 cars 클래스에 자동차 이름 입력
                cars[i].Name = CarName;
            }
        }

        return cars;
    }

    public static int isRacingCountValid(String inp) {
        int racingCount;

        // 입력이 숫자가 아닌 경우
        try {
            racingCount = Integer.parseInt(inp);
        }
        catch (NumberFormatException exp){
            throw new IllegalArgumentException();
        }

        // 입력된 숫자가 0보다 작은 경우
        if (racingCount < 0) {
            throw new IllegalArgumentException();
        }

        return racingCount;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inp;
        
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inp = camp.nextstep.edu.missionutils.Console.readLine();
        Car[] cars = isCarNameValid(inp);

        System.out.println("시도할 회수는 몇회인가요?");
        inp = camp.nextstep.edu.missionutils.Console.readLine();
        int racingCount = isRacingCountValid(inp);

        System.out.println("\n실행 결과");
        
    }
}