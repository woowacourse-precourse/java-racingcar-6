package racingcar;

import racingcar.car.UserInputCarName;

public class Application {
    public static void main(String[] args) {
        UserInputCarName user = new UserInputCarName();
        user.splitByComma(user.inputName());
    }
}
