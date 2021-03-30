package br.com.jor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Set;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class FiniteAutomaton {

    @Getter
    protected final Set<State> states;

    @Getter
    protected final Set<String> alphabet;

    @Getter
    protected final Set<Transition> transitions;

    @Getter
    protected final State initialState;

    @Getter
    protected final Set<State> acceptanceStates;

    public abstract Boolean accept(String word);
}
