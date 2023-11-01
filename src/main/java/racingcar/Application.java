package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

// 유저정보 클래스
final class User {
    public String car;
    public int score;

    public User(String carName) {
        this.car = carName;
        this.score = 0;
    }
}

// 게임
public class Application {
    private static IllegalArgumentException inputError = new IllegalArgumentException("형식에 맞지 않는 입력입니다.");

    // 자동차 움직임: 랜덤넘버를 뽑아 4이상이면 앞방향 나머지 경우 정지.
    public static int move() {
        int n = Randoms.pickNumberInRange(0, 9);
        if (n < 4) {
            return 0;
        }
        return 1;
    }

    // 차량 이름 입력받기: 5자 초과시 인풋에러
    public static ArrayList<User> setCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<User> user = new ArrayList<User>();
        for (String string : Console.readLine().split(",")) {
            if (string.length() > 5)
                throw inputError; // 5자 초과시 인풋에러
            user.add(new User(string));
        }
        return user;
    }

    // 회차 회수 입력받기
    public static int setTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        int res = Integer.parseInt(Console.readLine());
        return res;
    }

    // 차량 위치(거리) 출력
    public static void showCar(int score, String carName) {
        System.out.println(String.format("%s : %s", carName, "-".repeat(score)));
    }

    // 최대 점수 탐색
    public static int maxScore(ArrayList<User> user) {
        int M = 0;
        for (User p : user) {
            if (p.score > M)
                M = p.score;
        }
        return M;
    }

    // 경기 결과 출력
    public static void showRes(ArrayList<User> user) {
        int M = maxScore(user);
        ArrayList<String> winner = new ArrayList<>();
        for (int i = 0; i < user.size(); i++) {
            // 승자판별 후 승자리스트에 추가
            if (user.get(i).score == M)
                winner.add(user.get(i).car);
        }

        System.out.println(String.format("최종 우승자 : %s", String.join(", ", winner)));
    }

    // 경주
    public static void race(ArrayList<User> user, int n) {
        System.out.println("실행 결과");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < user.size(); j++) {
                user.get(j).score += move();
                showCar(user.get(j).score, user.get(j).car);
            }
            System.out.println();
        }
        showRes(user);
    }

    public static void main(String[] args) {
        ArrayList<User> user = setCarName();
        int n = setTime();
        System.out.println();
        race(user, n);
    }
}
