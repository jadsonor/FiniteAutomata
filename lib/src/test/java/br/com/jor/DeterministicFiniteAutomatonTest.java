package br.com.jor;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DeterministicFiniteAutomatonTest {

    @Test
    public void testDfa() {
        var q0 = new State("q0");
        var q1 = new State("q1");

        var tq00 = new Transition("0", q0, q0);
        var tq01 = new Transition("1", q0, q1);

        var tq10 = new Transition("0", q1, q1);
        var tq11 = new Transition("1", q1, q1);

        var dfa = new DeterministicFiniteAutomaton(
                Set.of(q0, q1),
                Set.of("0", "1"),
                Set.of(tq00, tq01, tq10, tq11),
                q0,
                Set.of(q1)
        );

        assertTrue(dfa.accept("01"));
        assertFalse(dfa.accept("00000"));
    }

    @Test
    public void testDfaAcceptStates() {
        var q0 = new State("q0");
        var q1 = new State("q1");

        var tq00 = new Transition("0", q0, q0);
        var tq01 = new Transition("1", q0, q1);

        var tq10 = new Transition("0", q1, q1);
        var tq11 = new Transition("1", q1, q1);

        var dfa = new DeterministicFiniteAutomaton(
                Set.of(q0, q1),
                Set.of("0", "1"),
                Set.of(tq00, tq01, tq10, tq11),
                q0,
                Set.of(q1)
        );

        assertEquals(dfa.getAcceptanceStates(), Set.of(q1));
    }

    @Test
    public void testIncompleteTransictions() {
        var q0 = new State("q0");
        var q1 = new State("q1");

        var tq00 = new Transition("0", q0, q0);
        var tq01 = new Transition("1", q0, q1);

        var dfa = new DeterministicFiniteAutomaton(
                Set.of(q0, q1),
                Set.of("0", "1"),
                Set.of(tq00, tq01),
                q0,
                Set.of(q1)
        );

        var ex = assertThrows(
                RuntimeException.class,
                () -> dfa.accept("0010101"),
                ""
        );

        assertEquals("no transition defined for state State(name=q1) and symbol 0", ex.getMessage());

    }

}
