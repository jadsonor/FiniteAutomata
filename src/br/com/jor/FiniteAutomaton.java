package br.com.jor;

import java.util.Set;

public abstract class FiniteAutomaton {

    protected final Set<State> states;

    protected final Set<String> alphabet;

    protected final Set<Transition> transitions;

    protected final State initialState;

    protected final Set<State> acceptanceStates;

    public FiniteAutomaton(Set<State> states, Set<String> alphabet, Set<Transition> transitions, State initialState, Set<State> acceptanceStates) {
        this.states = states;
        this.alphabet = alphabet;
        this.transitions = transitions;
        this.initialState = initialState;
        this.acceptanceStates = acceptanceStates;
    }

    public abstract Boolean accept(String word);

    public Set<State> getStates() {
        return states;
    }

    public Set<String> getAlphabet() {
        return alphabet;
    }

    public Set<Transition> getTransitions() {
        return transitions;
    }

    public State getInitialState() {
        return initialState;
    }

    public Set<State> getAcceptanceStates() {
        return acceptanceStates;
    }
}
