package racingcar.domain;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        int moveCount = user.howMuchTry();

        while (moveCount>=0){
            moveCount--;
        }

    }
}

