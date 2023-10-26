package racingcar;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Map <String, Integer> cars_map= makeMapCars(readLine());

        System.out.println("시도할 회수는 몇회인가요?");
        long N=Integer.parseInt(readLine());

        System.out.println("\n실행 결과");

    }

    //입력받은 자동차명을 해시맵 키값으로 설정
    public static HashMap<String,Integer> makeMapCars(String names){
        HashMap <String, Integer> cars_map= new HashMap<String, Integer>();
        String[] name_array=names.split(",");

        for(int i=0;i< name_array.length;i++){
            cars_map.put(name_array[i].trim(),0);
        }

        return cars_map;
    }
}
