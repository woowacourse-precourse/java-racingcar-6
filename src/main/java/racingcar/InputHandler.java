package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    static Racer[] createRacerFromInput(String input) {

        String[] names = input.split(",");

        validateInputForRacerCreation(names);

        Racer[] racers = new Racer[names.length];

        for(int i=0; i< names.length; i++){
            racers[i] = new Racer(names[i]);
        }

        return racers;
    }

    static boolean validateInputForRacerCreation(String[] names){

        String regex = "^[a-zA-Z가-힣]+$";

        for(String name : names) {
            if (name.length()>5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            if (!name.matches(regex)) {
                throw new IllegalArgumentException("입력은 한글, 알파벳, 쉼표만 포함해야 합니다.");
            }
        }

        return true;
    }

    static int setAttemptCountFromInput(String input){
        try {
            int attemptCount = Integer.parseInt(input);
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수형 입력이 필요합니다.");
        }
    }
}
