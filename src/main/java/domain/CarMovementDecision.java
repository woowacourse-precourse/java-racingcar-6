package domain;

public class CarMovementDecision {
    public boolean isCarMoving() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int randomNumber = numberGenerator.createRandomNumber();

        boolean result = false;
        if (randomNumber >= 4) {
            result = true;
        }
        return result;
    }
}
