package Cell;

public interface Cell {

    void nextState(Neighbors neighbors);
    cellStatus getNextState();
}
