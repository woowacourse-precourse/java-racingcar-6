package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {
    private Map<String, Integer> cars;
    private List<String> names;
    private void mapCarNames(){
        cars = new HashMap<>();
        for(String name: names){
            cars.put(name, 0);
        }
    }

    public boolean run(){
        int dice = Randoms.pickNumberInRange(0, 9);

        if(dice >= 4){
            return true;
        }

        return false;
    }

    public void start(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        names = List.of(input.split(","));
        mapCarNames();

        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());

        for(int i =0;i<count;i++){
            for(String name: names) {
                if (run()) {
                    cars.put(name, cars.get(name) + 1);
                }
            }

            System.out.println("실행 결과");
            for(String name:names){
                System.out.println(name+" : "+"-".repeat(cars.get(name)));
            }
            System.out.println();
        }

   }
}
