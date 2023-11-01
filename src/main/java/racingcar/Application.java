package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    static LinkedHashMap<String, Integer> carsMap = new LinkedHashMap<>();
    static int count;
    private static int getRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    private static boolean isForward(){
        int number = getRandomNumber();
        if(number>=4)
            return true;
        else
            return false;
    }

    private static void validateInput(String car) throws IllegalArgumentException {
        if(car.length() > 5)
            throw new IllegalArgumentException();
    }
    private static void initCars() throws IllegalArgumentException {
        String input;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();


        String[] carsArray;
        List<String> carsList;
        try {
            carsArray = input.split(",");
            carsList = Arrays.asList(carsArray);
            for (String car : carsList) {
                validateInput(car);
            }
        }catch (Exception e){
            throw new IllegalArgumentException();
        }

        System.out.println("시도할 회수는 몇회인가요?");
        try{
            count = sc.nextInt();
        }catch (Exception e){
            throw new IllegalArgumentException();
        }

        for(String car : carsList) {
            carsMap.put(car, 0);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}
