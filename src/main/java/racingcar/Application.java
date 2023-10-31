package racingcar;
import  camp.nextstep.edu.missionutils.Randoms;
import  camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class RacingCar{
    // 속성
    private String name;             // 레이싱카 이름
    private int loc = 0;             // 레이싱카 현재 위치 : default 0
    
    // 인스턴스 메소드들
    public RacingCar(String input) { // 생성자 : 이름으로 입력 받아 생성
        this.name = input;
    }
    int getLoc(){                    // 현재 위치 반환
        return loc;
    }
    String getName(){                // 이름 반환
        return name;
    }
    void accel(){                    // 확률에 의해 이동
        int prob = Randoms.pickNumberInRange(0,9);
        if(prob>= 4){ loc += 1;}
    }
}

class RacingCenter{
    // 속성
    private List<RacingCar> Cars = new ArrayList<>();

    // 인스턴스 메소드들
    void registCar(RacingCar Car){   // 자동차 객제 등록
        Cars.add(Car);
    }
    void all_accel(){                // 각 객체 별로 accel
        for(RacingCar car : Cars){
            car.accel();
        }
    }
    void print_locs(){               // 형식에 맞게 각 인스턴스들의 loc값 만큼 '-' 출력
        for(RacingCar car : Cars){
            System.out.print(car.getName()+" : ");
            print_bar(car.getLoc());
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    void print_bar(int num){ // '-'를 num개 만큼 출력하는 기능
        for(int i=0;i<num;i++) {
            System.out.print("-");
        }
    }

    Queue<RacingCar> compare(){
        Queue<RacingCar> winners = new LinkedList<>();      // 승리자 목록 Queue
        int maxLoc = find_maxLoc(Cars);                     // 최대 loc지점 찾기
        find_winners(winners, maxLoc);                      // 최대 loc지점에 있는 자동차를 찾아서 winners에 add
        return winners;                                     // winner 반환
    }
    int find_maxLoc(List<RacingCar> Cars){                  // 최대 loc지점 찾기
        int maxLoc = -1;
        for(RacingCar car : Cars)
            maxLoc = New_Vs_Max(car.getLoc(), maxLoc);
        return maxLoc;
    }int New_Vs_Max(int new_num, int max){                   // max 갱신 함수
        if (new_num > max) return new_num;
        return max;
    }

    void find_winners(Queue<RacingCar> winners, int maxLoc){ // 최대 loc지점에 있는 자동차를 찾아서 winners에 add
        for(RacingCar car : Cars)
            if_maxLoc_then_add( car, maxLoc, winners);
    }
    void if_maxLoc_then_add(RacingCar car, int maxLoc, Queue<RacingCar> winners){
        if (car.getLoc() == maxLoc)
            winners.add(car);
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
            under_N_Exception(1, name.length(), "자동차이름은 1자 이상으로 적어주십시오"); // 1미만의 수는 예외발생
            over_N_Exception(5, name.length(), "자동차이름은 5자 이하로 적어주십시오"); // 5초과의 수는 예외발생
        }

        // 시도 횟수 입력
        System.out.print("시도할 회수는 몇회인가요?\n"); // 5
        temp = Console.readLine();
        // 시도 횟수 잘못 입력 시 처리
        try{
            cnt = Integer.parseInt(temp);  // 정수변환이 안되면 예외발생
            under_N_Exception(1, cnt, ""); // 1미만의 수는 예외발생
        }catch(Throwable t){
            throw new IllegalArgumentException("양의 정수를 입력하십시오\n");
        }

        /* 출력부 구현 */
        System.out.print("\n실행 결과\n");
        // 자동차 객체를 이름으로 생성해서 center에 등록
        for (String name : names){
            RacingCar tempRC = new RacingCar(name);
            center.registCar(tempRC);
        }

        // 횟수 만큼 확률적 이동, 이동 시 마다 출력
        for(i=0;i<cnt;i++){
            center.all_accel();
            center.print_locs();
        }

        // 현재 위치를 비교하여 우승자 목록 생성 후 형식에 맞게 출력
        Queue<RacingCar> winners = center.compare();
        System.out.print("최종 우승자 : ");
        while(!winners.isEmpty()){
            System.out.print(winners.poll().getName());
            if(!winners.isEmpty()) {System.out.print(", ");}
        }
    }
    // N초과 혹은 미만 시 예외 발생 시키는 함수들
    private static void over_N_Exception(int n, int compare, String error_message){
        if (n < compare)
            throw new IllegalArgumentException(error_message+"\n");
    }
    private static void under_N_Exception(int n, int compare, String error_message){
        if (n > compare)
            throw new IllegalArgumentException(error_message+"\n");
    }
}