package racingcar.domain;

record Car(String name, int moveCount) {
    Car movedCar() {
        return new Car(name, moveCount + 1);
    }
}
