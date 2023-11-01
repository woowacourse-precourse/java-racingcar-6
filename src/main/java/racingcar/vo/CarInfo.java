package racingcar.vo;

public class CarInfo {
    private final String name;
    private Integer moveCnt=0;

    public CarInfo(String name) {
        this.name = name;
    }

    public void increaseMoveCnt(){
        this.moveCnt++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCnt(){
        return this.moveCnt;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, moveCnt));
    }
}
