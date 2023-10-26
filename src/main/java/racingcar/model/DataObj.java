package racingcar.model;

public class DataObj {
    private String name;
    private String progress;

    public static void setData (String name, String progress) {
        name = name;
        progress = progress;
    }

    public String getName () {
        return this.name;
    }

    public String getProgress () {
        return this.progress;
    }
}
