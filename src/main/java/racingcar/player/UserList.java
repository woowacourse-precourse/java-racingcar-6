package racingcar.player;

import java.util.ArrayList;
import java.util.List;
import racingcar.View.Input;

public class UserList {
    private final List<User> UserList = new ArrayList<>();// 리스트 변수 재할당 방지를 위해 final로 선언

    public List<User> inputUser() {

        String[] names = inputUserName();

        for (String name : names) {
            User user = new User(name);
            UserList.add(user);
        }
        return UserList;
    }

    private static String[] inputUserName() {
        Input input = new Input();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputName = input.inputString();
        String[] names = inputName.split(",");
        input.verifyUserName(names);
        return names;
    }


}
