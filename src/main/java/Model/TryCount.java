package Model;

import java.util.Objects;

public class TryCount {
    private String tryCount;

    public TryCount(String tryCount) {
        this.tryCount = tryCount;
    }

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
