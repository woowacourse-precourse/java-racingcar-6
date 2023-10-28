package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) throws IOException {
        LinkedHashMap<String, Integer> racingCars = new LinkedHashMap<String,Integer>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = in.readLine().split(",");
        for(int i=0; i<cars.length; i++){
            racingCars.put(cars[i],0);
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = Integer.parseInt(in.readLine());
        System.out.println("실행 결과");
        while(gameCount-->0){
            for(Map.Entry<String, Integer> car : racingCars.entrySet()){
                int moveCount = moveCountInit();

                String move = concatMove("-", moveCount);
                System.out.println(String.format("%s : %s", car.getKey(), move));
                car.setValue(car.getValue()+moveCount);
            }
                System.out.println();
        }
        System.out.println(racingCars);
        int max = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> car : racingCars.entrySet()){
            max = Math.max(max, car.getValue());
        }
        String answer = "";
        for(Map.Entry<String, Integer> car : racingCars.entrySet()){
            if(max == car.getValue()){
                answer = String.join(",",car.getKey());
            }
        }
        System.out.println("최종 우승자 : "+answer);
    }

    public static int moveCountInit(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static String concatMove(String move, int moveCount){
        StringBuilder sb = new StringBuilder(move.length() * moveCount);

        for(int i=1; i<=moveCount; i++){
            sb.append(move);
        }

        return sb.toString();
    }
}
