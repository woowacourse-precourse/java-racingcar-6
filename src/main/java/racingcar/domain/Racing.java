package racingcar.domain;

public class Racing extends IndexModel {
    private Participations participations;
    private int tryCount;
    private Winners winners;

    public Participations getParticipations() {
        return participations;
    }

    public int getTryCount() {
        return tryCount;
    }

    public Winners getWinners() {
        return winners;
    }

    private Racing(Builder builder) {
        this.participations = builder.participations;
        this.tryCount = builder.tryCount;
        this.winners = builder.winners;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Participations participations;
        private int tryCount;
        private Winners winners;

        public Builder participations(Participations participations) {
            this.participations = participations;
            return this;
        }

        public Builder tryCount(int tryCount) {
            this.tryCount = tryCount;
            return this;
        }

        public Builder winners(Winners winners) {
            this.winners = winners;
            return this;
        }

        public Racing build() {
            return new Racing(this);
        }
    }
}
