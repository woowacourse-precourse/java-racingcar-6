package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        LinkedHashMap <String, Integer> cars_map= makeCarMap(readLine());

        System.out.println("시도할 회수는 몇회인가요?");
        long number=Integer.parseInt(readLine());
        if(number<=0)
            throw new IllegalArgumentException("0이상이어야 합니다.");

        System.out.println("\n실행 결과");

        winners(numberTimesLoop(cars_map,number));

    }

    //입력받은 자동차명을 해시맵 키값으로 설정
    public static LinkedHashMap<String,Integer> makeCarMap(String names){
        LinkedHashMap <String, Integer> cars_map= new LinkedHashMap<>();
        String[] name_array=names.split(",");

        for(int i=0;i< name_array.length;i++){
            if(name_array[i].length()>5){
                throw new IllegalArgumentException("자동차명을 5자 이하로 작성하세요.");
            }
            if(cars_map.containsKey(name_array[i].trim())){
                throw new IllegalArgumentException("자동차명 중복을 허용하지 않습니다.");
            }
            cars_map.put(name_array[i].trim(),0);
        }

        return cars_map;
    }


    //한번의 루프를 입력받은 수만큼 돌리기 위한 함수
    public static LinkedHashMap numberTimesLoop(LinkedHashMap cars_map, long number){
        for(long i=0;i<number;i++){
            oneTimeLoop(cars_map);
        }

        return cars_map;
    }


    //자동차 전진 수 랜덤값 구하기
    public static LinkedHashMap oneTimeLoop(LinkedHashMap cars_map) {
        Iterator<Map.Entry<String, Integer>> iter = cars_map.entrySet().iterator();
        while (iter.hasNext()) {
            var entry = iter.next();

            int int_distance= Randoms.pickNumberInRange(0,9);
            if(int_distance>3) {//4이상일 경우 전진
                cars_map.put(entry.getKey(), (int) cars_map.get(entry.getKey()) + 1);
            }
            System.out.println(entry.getKey() + " : " +"-".repeat((int)cars_map.get(entry.getKey())));
        }

        System.out.println();
        return cars_map;
    }


    //우승자 출력하기
    public static void winners(LinkedHashMap cars_map){
        String winner_name="";
        long max=0;

        Iterator<Map.Entry<String, Integer>> iter = cars_map.entrySet().iterator();
        while (iter.hasNext()) {
            var entry = iter.next();

            if((int)cars_map.get(entry.getKey())>max){
                winner_name=entry.getKey();
            }else if((int)cars_map.get(entry.getKey())>=max){
                winner_name+=", "+entry.getKey();
            }
        }

        System.out.println("최종 우승자 : "+winner_name);
    }

}