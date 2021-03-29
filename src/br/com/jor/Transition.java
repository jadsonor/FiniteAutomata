package br.com.jor;

import java.util.Objects;

public class Transition {

    private final String symbol;
    private final State source;
    private final State next;

    public Transition(String symbol, State source, State next) {
        this.symbol = symbol;
        this.source = source;
        this.next = next;
    }

    public String getSymbol() {
        return symbol;
    }

    public State getSource() {
        return source;
    }

    public State getNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return symbol.equals(that.symbol) &&
                source.equals(that.source) &&
                next.equals(that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, source, next);
    }

    @Override
    public String toString() {
        return "Transition{" +
                "symbol='" + symbol + '\'' +
                ", source=" + source +
                ", next=" + next +
                '}';
    }
}
