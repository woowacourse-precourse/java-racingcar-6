package racingcar.entity;

public class Result {
    private String name;
    private int index;

    public Result(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResult() {
        return index;
    }

    public void setResult(int index) {
        this.index = index;
    }
}
