package racingcar.util;

public class Car {
    private static final int START_POSITION = 0;
    private int position;
    private final String name;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    /* 이름만 정해 놔서 오류남. 기능 만들고 주석 제거 해 볼것.
    public void Position_Move(Go_Stop_Selector go_stop_selector) {
        if(go_stop_selector.Go_or_Stop()) {
            position++;
        }
    }
     */

    //위치가 다른 위치보다 크면 1 아니면 0
    public boolean Position_Comparator(Car other) {
        return position > other.position;
    }

    //위치가 다른 위치와 같은지 비교
    public boolean Same_Position_Check(Car other) {
        return position==other.position;
    }

    public String Get_Name() {
        return name;
    }

    public int Get_Position() {
        return position;
    }
}
