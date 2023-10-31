package racingcar;
import  camp.nextstep.edu.missionutils.Randoms;
import  camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class RacingCar{ 
    private String name; // 레이싱카 이름
    private int loc = 0; // 레이싱카 현재 위치 : default 0
    
    // 생성자 : 이름으로 입력 받아 생성할 수 있도록
    public RacingCar(String input) {
        this.name = input;
    }
    int getLoc(){ return loc; } // 현재 위치 반환
    String getName(){ return name; } // 현재 위치 반환
    void reset(){ loc = 0;}     // 현재 위치 출발점 초기화
    void accel(){               // 확률에 의해 이동
        int prob = Randoms.pickNumberInRange(0,9);
        if(prob>= 4){ loc += 1;}
    }
}

class RacingCenter{
    private List<RacingCar> Cars = new ArrayList<>();

    void registCar(RacingCar Car){ Cars.add(Car);}  // 자동차 객제 등록
    void all_accel(){
        for(RacingCar car : Cars){ car.accel(); }   // 각 객체 별로 accel
    }
    void print_locs(){
        for(RacingCar car : Cars){
            System.out.print(car.getName()+" : ");
            for(int i=0;i<car.getLoc();i++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    Queue<RacingCar> compare(){
        int large_n = -1;

        Queue<RacingCar> winners = new LinkedList<>();
        for(RacingCar car : Cars) {
            if (car.getLoc() > large_n)
                large_n = car.getLoc();
        }
        for(RacingCar car : Cars) {
            if (car.getLoc() == large_n)
                winners.add(car);
        }
        return winners;
    }
}

public class Application {
    public static void main(String[] args) {

        int i=0, cnt; // idx용 변수 i, 경주횟수 cnt변수
        RacingCenter center = new RacingCenter();

        /* 입력부 구현 */
        // 자동차 이름 입력
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String temp = Console.readLine();
        List<String> names = Arrays.asList(temp.split(",")); // pobi,woni,jun

        // 자동차 이름 잘못 입력 시 처리
        for (String name : names) {  // 이름 입력 예외 처리
            name = name.trim();      // 좌우 공백 제거, 중간의 공백은 글자수로 포함.
            names.set(i++, name);    // 공백 제거 글자로 원본 변경
            if (name.length() > 5 || name.length() < 1 ) {
                throw new IllegalArgumentException("자동차이름은 1자 이상, 5자 이하로 적어주십시오\n");
            }
        }

        // 시도 횟수 입력
        System.out.print("시도할 회수는 몇회인가요?\n"); // 5
        temp = Console.readLine();

        // 시도 횟수 잘못 입력 시 처리
        try{
            cnt = Integer.parseInt(temp);  // 정수변환이 안되면 예외발생
            if(cnt < 1)                    // 1이상의 양의 정수만 입력 받음
                throw new IllegalArgumentException();
        }catch(Throwable t){
            throw new IllegalArgumentException("양의 정수를 입력하십시오\n");
        }


        // 출력문
        System.out.print("\n실행 결과\n");
        for (String name : names){
            RacingCar tempRC = new RacingCar(name);
            center.registCar(tempRC);
        }
        for(i=0;i<cnt;i++){
            center.all_accel();
            center.print_locs();
        }
        Queue<RacingCar> winners = center.compare();
        System.out.print("최종 우승자 : ");
        while(!winners.isEmpty()){
            System.out.print(winners.poll().getName());
            if(!winners.isEmpty()) {System.out.print(", ");}
        }
    }
}