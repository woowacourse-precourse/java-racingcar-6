package racingcar.global;

public enum CharacterSymbol {

    COMMA(","),
    BLANK(" ");

    private final String literal;

    CharacterSymbol(String symbolLiteral) {
        this.literal = symbolLiteral;
    }

    public String getLiteral() {
        return literal;
    }

}
