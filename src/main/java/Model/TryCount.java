package Model;

import java.util.Objects;

public class TryCount {
    private String tryCount;

    public TryCount(String tryCount) {
        this.tryCount = tryCount;
    }

    public boolean isTryCountNumeric() {
        return tryCount.matches("\\d+");
    }

    public int changeToInteger() {
        return Integer.parseInt(tryCount);
    }

    /**
     * 테스트용 메서드
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        TryCount other = (TryCount) obj;
        return tryCount.equals(other.tryCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }
}
