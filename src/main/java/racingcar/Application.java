package racingcar;

import racingcar.view.InputFormView;

public class Application {
    public static void main(String[] args) {
        User user = new User();

        InputFormView.viewCarInputForm();
        user.readCarInput();

        InputFormView.viewTryNumInputForm();
        user.readTryNumInput();
    }
}
