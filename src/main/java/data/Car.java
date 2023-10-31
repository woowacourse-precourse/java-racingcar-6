package data;

public class Car implements Comparable<Car>{
    private String name;
    private StringBuilder track;

    public Car(String name) throws IllegalArgumentException{
        if(name.length() > 5)
            throw new IllegalArgumentException("Name can be longer than 5");
        this.name = name;
        this.track = new StringBuilder();
    }

    public void add(){
        track.append("-");
    }

    public String getName(){
        return this.name;
    }

    public int getTrackLength(){
        return this.track.length();
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(this.name)
                .append(" : ")
                .append(this.track);
        return info.toString();
    }

    @Override
    public int compareTo(Car car) {
        int thisCarLength = this.getTrackLength();
        int otherCarLength = car.getTrackLength();
        return thisCarLength - otherCarLength;
    }
}
