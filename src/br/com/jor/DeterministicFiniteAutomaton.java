package br.com.jor;

import java.util.Set;

public class DeterministicFiniteAutomaton extends FiniteAutomaton {
    public DeterministicFiniteAutomaton(Set<State> states, Set<String> alphabet, Set<Transition> transitions, State initialState, Set<State> acceptanceStates) {
        super(states, alphabet, transitions, initialState, acceptanceStates);
    }

    @Override
    public Boolean accept(String word) {
        var currentState = getInitialState();
        for (var c : word.toCharArray()) {
            currentState = getNextState(c + "", currentState);
        }

        var acceptanceStates = getAcceptanceStates();

        return acceptanceStates != null
                && acceptanceStates.contains(currentState);
    }

    private State getNextState(String symbol, State currentState) {
        for (var t : getTransitions()) {
            if (t.getSource().equals(currentState) && t.getSymbol().equals(symbol)) {
                return t.getNext();
            }
        }

        throw new RuntimeException("no transition defined for state " + currentState + " and symbol " + symbol);

    }
}
