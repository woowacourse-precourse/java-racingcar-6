package racingcar.model;

public class DataObj {
    private String name;
    private String progress = "";

    public void setProgress (String progress) {
        this.progress += progress;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    public String getProgress () {
        return this.progress;
    }
}
