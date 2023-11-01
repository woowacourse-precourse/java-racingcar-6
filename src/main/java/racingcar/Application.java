package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private final static int MAX_LENGTH_NAME = 5;
    private final static int RANDOM = 4;

    private static Map<String, Integer> cars = new HashMap<>();

    private static int iter = 0;

    public static void main(String[] args) throws IllegalArgumentException {
        try{
            getCarName();
            getIter();

            System.out.println("실행 결과");
            for(int i=0; i<iter; i++){
                run();
            }

            whoIsWinner();
        }finally {
            Console.close();
        }

    }

    private static void getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");

        while(stringTokenizer.hasMoreTokens()){
            String carName = stringTokenizer.nextToken();
            if(carName.length() > MAX_LENGTH_NAME) {
                throw new IllegalArgumentException("Too long name");
            }
            cars.put(carName, 0);
        }
    }

    private static void getIter() {
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            iter = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not number");
        }
    }

    private static void run(){
        cars.forEach((name, go) -> {
            if(Randoms.pickNumberInRange(0, 9) >= RANDOM){
                cars.replace(name, go + 1);
            }
            System.out.print(name + " : ");
            for(int i=0; i<go; i++){
                System.out.print('-');
            }
            System.out.println();
        });
        System.out.println();
    }

    private static void whoIsWinner(){
        int max = 0;
        Iterator<String> keys = cars.keySet().iterator();
        while(keys.hasNext()){
            int go = cars.get(keys.next());
            if(go > max) max = go;
        }

        int finalMax = max;
        StringBuilder sb = new StringBuilder("최종 우승자 : ");
        cars.forEach((name, go) -> {
            if(go == finalMax){
                sb.append(name).append(", ");
            }
        });

        System.out.print(sb.substring(0, sb.length()-2));
    }
}
