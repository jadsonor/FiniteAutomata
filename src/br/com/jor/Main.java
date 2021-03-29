package br.com.jor;

import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        var q0 = new State("q0");
        var q1 = new State("q1");
        var q2 = new State("q2");

        var tq00 = new Transition("0", q0, q1);
        var tq01 = new Transition("1", q0, q0);

        var tq10 = new Transition("0", q1, q2);
        var tq11 = new Transition("1", q1, q1);

        var tq20 = new Transition("0", q2, q2);
        var tq21 = new Transition("1", q2, q2);

        var dfa = new DeterministicFiniteAutomaton(
                Set.of(q0, q1, q2),
                Set.of("0", "1"),
                Set.of(tq00, tq01, tq10, tq11, tq20, tq21),
                q0,
                Set.of(q2)
        );

        var scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("\nenter the word: ");
            var word = scanner.nextLine();
            System.out.printf("result: %s\n", dfa.accept(word));
        }
    }
}
