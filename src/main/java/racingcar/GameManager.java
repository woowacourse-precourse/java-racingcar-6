package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameManager {
    private int game;
    private User user;
    private List<String> victory;
    private int maxvalue;

    final String start ="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public  GameManager()
    {
        user = new User();
        victory = new ArrayList<>();
        maxvalue = Integer.MIN_VALUE;
    }
    public void Race(int game, Map<String, Integer> cars){
        for(int i=0;i<game;i++){
            //Map에 들어있는 원소 만큼 반복
            for(String car : cars.keySet()){
                String go_num;
                int go = Randoms.pickNumberInRange(0,9);
                //go가 4 이상이면 전진(Map의 value증가)
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
    public List<String> Winner(User user, int maxvalue, List<String> victory){
        //가장큰 벨류값 찾기
        for (int value : user.getCars_map().values()) {
            if (value > maxvalue) {
                maxvalue = value;
            }
        }
        // 가장 큰 값과 일치하는 벨류값이 있으면 그 것의 Key값을 리스트에 저장
        for (Map.Entry<String, Integer> entry : user.getCars_map().entrySet()) {
            if (entry.getValue() == maxvalue) {
                victory.add(entry.getKey());
            }
        }
        return victory;
    }

    public void RacingGame(){
        System.out.println(start);
        user.inputCar();
        System.out.println("시도할 회수는 몇회인가요?");
        String num = Console.readLine();
        try {
            game = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
        System.out.println("실행 결과");
        Race(this.game,user.getCars_map());
        victory = Winner(user,maxvalue,victory);
        // 가장 많이 이동한 자동차들의 이름을 한 줄에 출력
        System.out.println("최종 우승자 : " + String.join(", ", victory));
    }
}
