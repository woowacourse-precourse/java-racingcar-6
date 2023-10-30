package racingcar.domain.car;

public class Distance {
    private int distance = 0;

    protected Distance() {

    }

    public void add(int number) {
        this.distance += number;
    }

    protected int getDistance() {
        return distance;
    }

    public String toString() {
        return "-".repeat(distance);
    }
}

/*

부분부분 trouble shooting이나 설계하면서 고민했던 부분들을 짧게 노션에 메모해서 나중에 소감문이나 블로그에 포스팅해보자... 허허

 */