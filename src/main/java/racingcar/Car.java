package racingcar;

public class Car {
    private static final String STATUS_BAR = "-";
    private static final String EMPTY_COLON = " : ";
    private static final int START_POSITION = 0;
    private static final int STANDARD_NUM = 4;

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

    public String getNowCarPosition() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(EMPTY_COLON).append(createStatusBar());
        return sb.toString();
    }

    private String createStatusBar() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<position; i++) {
            sb.append(STATUS_BAR);
        }
        return sb.toString();
    }

    private boolean isBiggerOrEqualStandard(int num) {
        return STANDARD_NUM <= num;
    }
}
