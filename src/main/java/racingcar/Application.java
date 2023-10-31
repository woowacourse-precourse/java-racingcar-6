package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        HashMap<String, Integer> carName = nameCar();
        int attempt = attempt();
        carName = race(carName,attempt);
        System.out.println("최종 우승자 : " + winner(carName));
    }

    private static HashMap<String, Integer> nameCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        HashMap<String, Integer> raceName = new HashMap<>();
        String input = Console.readLine();
        for (String name : input.split(",")) { //String 타입을 split 통해 분리함.
            if(name.length() > 5) throw new IllegalArgumentException("이름을 5자 이하로 입력하세요.");
            raceName.put(name,0);
        }
        return raceName;
    }

    private static HashMap<String, Integer> racing(HashMap<String, Integer> carName){
        carName.forEach((key, value) -> {
            if(forward(randomCreate())){
                carName.put(key,carName.get(key) + 1);
            }
        });
        return carName;
    }

    // 1~9사이 랜덤 값을 생성해 리턴함.
    private static int randomCreate() {
        return Randoms.pickNumberInRange(0, 9); // 0~9사이의 랜덤 값을 생성. 우테코 제공.
    }

    private static boolean forward(int number){
        // 4보다 클때 전진함.
        return number >= 4;
    }

    private static String hyphen(int number){
        String hyphen = "";
        for(int i = 0; i < number ; i++){
            hyphen = "-" + hyphen;
        }
        return hyphen;
    }

    private  static int attempt(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    private static HashMap<String, Integer> race(HashMap<String, Integer> carName,int number){
        System.out.println("\n실행 결과");
        for(int i=0; i<number; i++){
            carName = racing(carName);
            carName.forEach((key, value) -> System.out.println(key + " : " + hyphen(value)));
            System.out.println();
        }
        return carName;
    }

    private static String winner(HashMap<String, Integer> carName){
        String winner  ="";
        Set<String> keys=carName.keySet();
        Integer maxValue = Collections.max(carName.values());
        for(String key : keys){
            if(maxValue.equals(carName.get(key))) {
                if(!winner.isEmpty()) winner += ", ";
                winner += key;
            }
        }
        return winner;
    }
}
