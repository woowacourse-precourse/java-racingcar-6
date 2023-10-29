package racingcar.model;

public class Car {
    private static final int FORWARD_STEP = 1;
    private static final int INITIAL_FORWARD_COUNT = 0;
    private static final int MIN_FORWARD_NUMBER = 4;
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_FORWARD_COUNT;
    }

    public String getName() {
        return name;
    }

    public int updateCar(int randomNumber) {
        goOrStayForwardCount(randomNumber);

        return position;
    }

    public String getCurrentPosition() {
        String result = "";

        for (int i = 0; i < position; i++) {
            result += "-";
        }

        return name + " : " + result;
    }

    public String getCarNameAtMaxPosition(int maxPosition) {
        if (position == maxPosition) return name;
        return "";
    }

    private void goOrStayForwardCount(int randomNumber) {
        if (randomNumber >= MIN_FORWARD_NUMBER) {
            position += FORWARD_STEP;
        }
    }

}
