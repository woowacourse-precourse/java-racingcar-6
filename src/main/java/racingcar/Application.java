package racingcar;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현

        String[] carNames = readLine().split(",");
        if (!isNameValid(carNames)){
            throw new IllegalArgumentException();
        }
    }

    public static boolean isNameValid(String[] names){
        for (String name: names){
            if (name.length() > 5){
                return false;
            }
        }
        return true;
    }
}

