package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Input_car {
    public static Map<String, Integer> car_map = new LinkedHashMap<>();
    public static Integer excute_count = 0;
    public static void input_car() {
        car_map = new LinkedHashMap<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] input_split = input.split(",");
        for(int i = 0; i<input_split.length; i++){
            if ( 5 < input_split[i].length()) { //예외 1: 차 이름이 5글자를 넘을 경우
                throw new IllegalArgumentException();
            }
            car_map.put(input_split[i], car_map.getOrDefault(input_split[i], -1) + 1);
            if(0<car_map.get(input_split[i])){ //예외 2 : 중복된 차 이름을 넣은 경우
                throw new IllegalArgumentException();
            }
        }
        System.out.println("시도할 회수는 몇회인가요?");
        input = Console.readLine();
        if (input.matches("[+-]?\\d*(\\.\\d+)?") == false) {//예외 3 : 숫자 이외의 문자가 포함되어 있을 경우
            throw new IllegalArgumentException();
        }
        excute_count = Integer.parseInt(input);


        //System.out.println("MAP : " + car_map.toString() + "count : " + excute_count);


    }

}
