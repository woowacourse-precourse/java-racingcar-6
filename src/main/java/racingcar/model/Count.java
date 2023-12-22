package racingcar.model;

import racingcar.repository.Track;

public class Count {

    private final int count;

    public Count(int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("[ERROR] 1이상의 숫자를 입력해주세요.");
        }
    }

    public String moveByCount(Track track, Cars cars) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++) {
            sb.append(cars.run(track));
        }
        return sb.toString();
    }
}
