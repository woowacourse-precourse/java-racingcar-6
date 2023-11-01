package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        ArrayList<String> nameList;
        nameList = Input.nameInput();
        Racing racing = new Racing(nameList);
        racing.race();
    }
}
