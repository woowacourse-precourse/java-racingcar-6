package data;

public class Car {
    private String name;
    private StringBuilder track;

    public Car(String name) throws IllegalArgumentException{
        if(name.length() > 5)
            throw new IllegalArgumentException();
        this.name = name;
        this.track = new StringBuilder();
    }

    public void add(){
        track.append("-");
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(this.name)
                .append(" : ")
                .append(this.track);
        return info.toString();
    }
}
