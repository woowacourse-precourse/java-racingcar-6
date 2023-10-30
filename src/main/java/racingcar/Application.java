package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        List<User> users = userCar();
        User.inputCheck(users);
        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = Integer.parseInt(readLine());

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            Game.playGame(users);
        }
        Game.printWinner(users);
    }

    public static List<User> userCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = readLine();

        StringTokenizer st = new StringTokenizer(inputString, ",");
        List<User> users = new ArrayList<>();
        while (st.hasMoreTokens()) {
            users.add(new User(st.nextToken(), 0));
        }

        return users;
    }
}
