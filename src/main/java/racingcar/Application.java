package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Application {
    private final static int MAX_LENGTH_NAME = 5;

    private static Map<String, Integer> cars = new HashMap<>();

    private static int iter = 0;

    public static void main(String[] args) throws IllegalArgumentException {
        try{
            getCarName();
            getIter();
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
            cars.put(stringTokenizer.nextToken(), 0);
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
}
