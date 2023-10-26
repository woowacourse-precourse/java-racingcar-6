package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {

    public static Object[] getUserInput(){

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String user_input = Console.readLine();

        System.out.println("시도할 회수는 몇회 인가요?");
        int try_cnt = Integer.parseInt(Console.readLine());

        //System.out.println(user_input + " " + try_cnt);
        return new Object[]{user_input, try_cnt};
    }

    public static int[] carMovingOnce(int[] cars_moved) {
        //cars_moved 이용

        //조건에 따른 자동차 이동
        for(int i=0; i<cars_moved.length; i++) {
            int random_num = Randoms.pickNumberInRange(0, 9);
            if(random_num >= 4){
                cars_moved[i]+=random_num;
                //System.out.println(i+"번 차 이동 : "+random_num+" -> "+cars_moved[i]);
            }
        }
        return cars_moved;
    }

    public static void playGame(Object[] user_input){
        //cars, try_cnt, car_moved : 차량 목록, 시도 횟수, 차량 이동 횟수
        String[] cars = String.valueOf(user_input[0]).split(",");
        int try_cnt = (Integer)user_input[1];
        int[] cars_moved = new int[cars.length]; //차량 이동 횟수
        Arrays.fill(cars_moved, 0); // 모든 요소를 0으로 초기화

        for(int i=0; i<try_cnt; i++) {
            cars_moved = carMovingOnce(cars_moved);
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Object[] user_input = getUserInput();
        playGame(user_input);

        //Randoms.pickNumberInRange(0,9);
    }
}
