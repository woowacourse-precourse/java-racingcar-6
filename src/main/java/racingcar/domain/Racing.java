package racingcar.domain;

public class Racing {

    public int getNumberForForward() {
        NumberGenerator numberGenerator = new NumberGenerator();
        return numberGenerator.createRandomNumber();
    }

    public String moveForward(int number) {
        String result = "";
        if(number>3) {
            return result += "_";
        }
        return result;
    }
}
