package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


// 유저들의 정보에 대한 클래스
final class Users{
    private static IllegalArgumentException inputError =  new IllegalArgumentException("형식에 맞지 않는 입력입니다.");
    String[] car;
    int[] score;
    int n;
    public Users(){
        this.car = setCarName();
        this.score = new int[this.car.length];
        this.n = setTime();
        System.out.println();
    }

    // 차량 이름 입력받기: 5자 초과시 인풋에러
    public static String[] setCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] res = Console.readLine().split(",");
        for (String string : res) {
            if (string.length() > 5) throw inputError; //5자 초과시 인풋에러
        }
        return res;
    }

    //회차 입력받기
    public static int setTime(){
        System.out.println("시도할 회수는 몇회인가요?");
        int res = Integer.parseInt(Console.readLine());        
        return res;
    }    
}

//게임 
public class Application {
    // 자동차 움직임: 랜덤넘버를 뽑아 4이상이면 앞방향 나머지 경우 정지.
    public static int move(){
        int n = Randoms.pickNumberInRange(0, 9);
        if (n < 4){
            return 0;
        }
        return 1;
    }

    // 회차 결과 출력
    public static void showCar(int score, String carName){
        System.out.println(String.format("%s : ", carName) + "-".repeat(score));
    }

    // 경기 결과 출력
    public static void showRes(Users user){
        int maxDis = Arrays.stream(user.score).max().getAsInt(); //점수의 최대값
        ArrayList<String> winner = new ArrayList<>();
        for (int i = 0; i < user.car.length; i++) {
            // 승자판별 후 승자리스트에 추가
            if (user.score[i] == maxDis) winner.add(user.car[i]); 
        }

        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }

    // 경주
    public static void race(Users user){
        System.out.println("실행 결과");
        for (int i = 0; i < user.n; i++) {
            for (int j = 0; j < user.car.length; j++) {
                user.score[j] += move();
                showCar(user.score[j], user.car[j]);
            }
            System.out.println();
        }
        showRes(user);
    }

    public static void main(String[] args) {
        Users user = new Users();
        race(user);
    }
}
