package racingcar.model;

public class DataObj {
    private String name;
    private String progress = "";

    public void setData (String name, String progress) {
        this.name = name;
        this.progress += progress;
    }

    public String getName () {
        return this.name;
    }

    public String getProgress () {
        return this.progress;
    }
}
