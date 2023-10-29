package domain;

public class Car {

    private String name;
    private String position = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void drive() {
        if (shouldMove()) {
            move();
        }
    }

}
