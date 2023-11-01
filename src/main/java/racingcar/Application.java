package racingcar;

import java.util.*;
import java.lang.String;
import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.TypeCache.Sort;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        ArrayList<Car> Car_List;

        // 자동차 이름 입력받아서 ArrayList로 Car객체 저장
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input_car_names = Console.readLine();
        if (input_car_names.isEmpty()) { //입력이 null인 경우 바로 예외처리.
            throw new IllegalArgumentException();
        }
        String[] Car_name = input_car_names.split(",");

        Base_FUNC.Check_Input_Name(Car_name);   // 자동차 이름에 대한 Error를 모두 체크하는 함수

        Car_List = new ArrayList<Car>();
        for (String s : Car_name) {
            Car tmp = new Car(s);
            Car_List.add(tmp);
        }

        // 시도 횟수 입력받기. Base_FUNC의 함수를 통해 오류 검증된 숫자를 가져온다.
        System.out.println("시도할 회수는 몇회인가요?");
        int move_number = Base_FUNC.Input_Move_number();
        System.out.println();

        System.out.println("실행 결과");
        // 입력받은 시도횟수만큼 for루프 진행.
        for (int num = 0; num < move_number; num++) {
            for (int car_idx = 0; car_idx < Car_List.size(); car_idx++) // 입력 받은 자동차 종류만큼.
            {
                Car_List.get(car_idx).Forward_Or_Not();
                Car_List.get(car_idx).Print_Car_Data();
            }
            System.out.println();
        }

        Collections.sort(Car_List); // 움직인 거리에 따라, 내림차순 정렬.
        Base_FUNC.Print_Winner(Car_List); // 우승자를 출력하고 프로그램 종료.
    }
}

