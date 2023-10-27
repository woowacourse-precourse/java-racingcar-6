package racingcar;
import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        String[] cars = input_car_names(userInput);

        // 시도할 횟수 입력
        System.out.println("시도할 횟수는 몇 회인가요?");
        String str = Console.readLine();
        int n_moves = Integer.parseInt(str);

        // 경기
        System.out.println("\n실행 결과");
        int[] locations = new int[cars.length];
        for(int i=0; i<n_moves; i++){
            // 한 번 경기 후 결과 출력
            race_once(cars, locations);
            System.out.println();
        }

        // 최종 우승자 출력
        print_winner_names(cars, locations);
    }

    public static String[] input_car_names(String userInput){
        String[] cars = userInput.split(",");
        for(String name: cars){
            check_car_names(name);
        }
        return cars;
    }
    public static void check_car_names(String name) {
        int s_len = name.length();
        if (s_len > 5) {
            throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요.");
        }
    }
    public static Integer move_a_car(Integer location){
        int randomNbr = Randoms.pickNumberInRange(0, 9);
        if(randomNbr >= 4){
            location += 1;
        }
        return location;
    }

    public static void race_once(String[] cars, int[] locations){
        for(int i=0; i<locations.length; i++){
            locations[i] = move_a_car(locations[i]);
        }
        for(int i=0; i<locations.length; i++){
            System.out.println(cars[i] + " : " + "-".repeat(locations[i]));
        }
    }
    public static void print_winner_names(String[] cars, int[] locations){
        int max_value = 0;
        ArrayList<Integer> winner_idx = new ArrayList<>();
        // 최댓값 찾기
        for (int location : locations) {
            if (location > max_value){
                max_value = location;
            }
        }
        // 최종 우승자 찾기
        for (int i=0; i<locations.length; i++){
            if (locations[i] == max_value){
                winner_idx.add(i);
            }
        }
        // 최종 우승자 출력
        System.out.print("최종 우승자 : ");
        for (int i=0; i<winner_idx.size(); i++){
            if (i != 0){
                System.out.print(", ");
            }
            System.out.print(cars[i]);
        }

    }

}
