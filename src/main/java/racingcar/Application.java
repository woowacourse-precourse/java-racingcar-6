package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

    }
    public static String[] validateCarName(){
        String carInput = readLine();
        if (carInput == null || carInput.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] carNames = carInput.split(",", -1);

        if (carNames.length == 0) {
            throw new IllegalArgumentException();
        } else if (carNames.length >= 5) {
            throw new IllegalArgumentException();
        }

        for (String name : carNames){
            if (name.trim().isEmpty()){
                throw new IllegalArgumentException();
            }
            if (name.length() > 5){
                throw new IllegalArgumentException();
            }
            if (name.matches("\\d+")){
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }
}
