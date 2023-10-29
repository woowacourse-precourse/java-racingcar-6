package Model;

import java.util.Objects;

public class TryCount {
    private String tryCount;

    public TryCount(String tryCount) {
        this.tryCount = tryCount;
    }

    public boolean isTryCountNumeric() {
        try {
            Integer.parseInt(tryCount);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    public int getTryCount() {
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
