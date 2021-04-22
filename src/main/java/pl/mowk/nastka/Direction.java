package pl.mowk.nastka;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
public enum Direction {
    L('L'), R('R'), U('U'), D('D');
    private final char asChar;

    Direction(char asChar) { this.asChar = asChar; }
}
