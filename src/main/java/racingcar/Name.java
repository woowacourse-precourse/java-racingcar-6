package racingcar;

record Name(String name) {

    Name {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
