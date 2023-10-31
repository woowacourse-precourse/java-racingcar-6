package racingcar;

public class Car {
    private Integer currentLocation;
    private String name;

    public Car(String name) {
        this.name = name;
        this.currentLocation = 0;
    }

    // 앞으로 한칸 전진
    public void movingForward() {
        this.currentLocation++;
    }

    // 현재 위치를 '-'를 사용하여 출력
    public void printCurrentLocation() {
        for (int i = 0; i < currentLocation; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public String getName() {
        return this.name;
    }

    public Integer getCurrentLocation() {
        return this.currentLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

}
