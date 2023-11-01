package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Base_FUNC {

    public static boolean Check_If_Carname_OverLapped(String[] Car_name, int idx) {
        // 중복 계산을 피하기 위해 idx+1부터 비교를 한다.
        for (int i = idx + 1; i < Car_name.length; i++) {
            if (Car_name[idx].equals(Car_name[i])) {
                return true;
            }
        }

        return false;
    }

    public static void Check_Input_Name(String[] Car_name) {
        for (int i = 0; i < Car_name.length; i++) {
            // 자동차 이름의 길이 문제 처리
            if (Car_name[i].length() > 5 || Car_name[i].isEmpty()) {
                throw new IllegalArgumentException();
            }
            // 자동차 이름 중간에 공백이 있을 때
            if (Car_name[i].contains(" ")) {
                throw new IllegalArgumentException();
            }
            //자동차 이름 중복 문제
            if (Check_If_Carname_OverLapped(Car_name, i)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int Input_Move_number() {
        //int move_number = Integer.parseInt(Console.readLine());
        String tmp_input = Console.readLine();

        //입력이 null인 경우
        if (tmp_input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        //입력 문자열 1개씩 검사.
        for (int i = 0; i < tmp_input.length(); i++) {
            //숫자가 아닌 경우 예외 처리.
            if (tmp_input.charAt(i) - '0' < 0 || tmp_input.charAt(i) - '0' > 9) {
                throw new IllegalArgumentException();
            }
        }

        int ret = Integer.parseInt(tmp_input);
        if (ret == 0) {
            throw new IllegalArgumentException();
        }

        return ret;
    }

    public static void Print_Winner(ArrayList<Car> Car_List) {
        int max_num = Car_List.get(0).Get_Car_Forward_Count(); //가장 앞의 자동차가 가장 많이 이동한 자동차 이다.

        System.out.print("최종 우승자 : " + Car_List.get(0).Get_Car_Name());
        //공동 우승자가 있는 경우 ','로 추가 출력해 준다. 현재 내림차순으로 정렬되어 있기 때문에 모든 리스트를 검사할 필요 없다.
        for (int i = 1; i < Car_List.size(); i++) {
            if (Car_List.get(i).Get_Car_Forward_Count() == max_num) {
                System.out.print(", " + Car_List.get(i).Get_Car_Name());
            } else {
                break;
            }
        }
        System.out.println();
    }

}
