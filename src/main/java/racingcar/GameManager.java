package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameManager {
    private int game;
    private User user;
    final String start ="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public  GameManager(){
        user = new User();
    }
    public void Race(int game, Map<String, Integer> cars){
        for(int i=0;i<game;i++){
            for(String car : cars.keySet()){
                String go_num;
                int go = Randoms.pickNumberInRange(0,9);
                if(go>=4){
                    int value = cars.get(car);
                    value += 1;
                    cars.put(car, value);
                }
                go_num="-".repeat(cars.get(car));
                System.out.println(car +" : "+go_num);
            }
            System.out.println();
        }
    }

    public void RacingGame(){
        System.out.println(start);
        user.inputCar();
        System.out.println("시도할 회수는 몇회인가요?");
        String num = Console.readLine();
        try {
            game = Integer.parseInt(num);
            System.out.println("실행 결과");
            // 게임 실행 코드 작성
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
        System.out.println("실행 결과");
        Race(this.game,user.getCars_map());
        int max = Integer.MIN_VALUE;
        for (int value : user.getCars_map().values()) {
            if (value > max) {
                max = value;
            }
        }
        List<String> maxCars = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : user.getCars_map().entrySet()) {
            if (entry.getValue() == max) {
                maxCars.add(entry.getKey());
            }
        }
        // 가장 많이 이동한 자동차들의 이름을 한 줄에 출력
        System.out.println("최종 우승자 : " + String.join(", ", maxCars));
    }
}
