package br.com.jor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Transition {
    @Getter
    private final String symbol;

    @Getter
    private final State source;

    @Getter
    private final State next;
}
