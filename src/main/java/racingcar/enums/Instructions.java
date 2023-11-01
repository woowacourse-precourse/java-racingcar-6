package racingcar.enums;

public enum Instructions {

    private final String instruction;

    private Instructions(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }
}
