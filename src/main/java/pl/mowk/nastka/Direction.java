package pl.mowk.nastka;


public enum Direction {
    L('L'), R('R'), U('U'), D('D');
    private final char asChar;

    public char getAsChar() { return asChar; }

    Direction(char asChar) { this.asChar = asChar; }
}
