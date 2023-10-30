package racingcar;

public class Car {
    private static final String STATUS_BAR = "-";
    private static final int START_POSITION = 0;
    private static final int STANDARD_NUM = 3;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moving(int random) {
        if (isBiggerOrEqualStandard(random)) {
            position++;
        }
    }

    public String displayMoving() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");

        for (int i=0; i<position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    private boolean isBiggerOrEqualStandard(int num) {
        return STANDARD_NUM <= num;
    }
}
