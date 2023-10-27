package racingcar;

record Car(Name name) {
    Car {
        if (name == null) throw new IllegalArgumentException();
    }
}
