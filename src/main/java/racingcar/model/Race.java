package racingcar.model;

public class Race {

    private Round roundLeft;
    private Entry entry;

    public static int getMinEntrySize() {
        final int MIN_ENTRY_SIZE = 2;
        return MIN_ENTRY_SIZE;
    }

    /**
     * 명시된 라운드 수와 엔트리를 이용하여 경주(Race) 객체를 생성한다.
     * @param totalRound 진행할 총 라운드 수
     * @param entry 참가자 엔트리
     * @throws IllegalArgumentException 참가자 엔트리의 크기가 Race.getMinEntrySize() 보다 작은 경우
     */
    public Race(Round totalRound, Entry entry) throws IllegalArgumentException {
        if (entry.size() < Race.getMinEntrySize()) {
            throw new IllegalArgumentException("경주를 진행하기 위해서는 최소 크기가 2인 엔트리가 필요합니다.");
        }

        this.roundLeft = totalRound;
        this.entry = entry;
    }

    public boolean isFinished() {
        return roundLeft.equals(new Round(0));
    }
}
