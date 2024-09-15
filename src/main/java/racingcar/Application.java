package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<User> users = userCar();
        User user = new User();

        user.inputCheck(users);
        System.out.println("시도할 회수는 몇회인가요?");

        int gameCount = 0;
        try {
            gameCount = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        Game game = new Game();
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            game.playGame(users);
        }
        game.printWinner(users);
    }

    public static List<User> userCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = readLine();

        List<User> users = new ArrayList<>();
        String[] names = inputString.split(",");
        for (String s : names) {
            users.add(new User(s, 0));
        }

        return users;
    }
}
