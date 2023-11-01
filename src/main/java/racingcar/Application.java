package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    static ArrayList<Car> car_list = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요,(이름은 쉽표(,) 기준으로 구분)");
        for(String st : Console.readLine().split(",")){
            if(st.length()>5){
                throw new IllegalArgumentException("5글자 이하로 입력하세요.");
            }
            Car c = new Car(st);
            car_list.add(c);
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int loop_num = Integer.parseInt(Console.readLine());
        System.out.println("\n실행결과");
        for(int i=0; i<loop_num ; i++){
            for(int j=0; j<car_list.size(); j++){
                if(Randoms.pickNumberInRange(0,9) >=4){
                    car_list.get(j).push_forward();
                }
            }
            print_state();
        }
        int bigger=0;

        for(int i=0; i<car_list.size(); i++){
            if(bigger < car_list.get(i).get_distance()){
                bigger = car_list.get(i).get_distance();
            }
        }
        ArrayList<Integer> winner_list = new ArrayList<>();
        for(int i=0; i<car_list.size(); i++){
            if(bigger == car_list.get(i).get_distance()){
                winner_list.add(i);
            }
        }
        System.out.print("최종 우승자 : ");
        for(int i=0; i<winner_list.size(); i++){
            int idx = winner_list.get(i);
            System.out.print(car_list.get(idx).get_name());
            if(i+1 < winner_list.size()){
                System.out.print(", ");
            }else{
                System.out.println("");
            }
        }



    }

    static void print_state(){
        for(int i=0; i<car_list.size(); i++){
            Car c = car_list.get(i);
            System.out.println(c.get_name()+" : "+c.get_state());
        }
        System.out.println();
    }
}
