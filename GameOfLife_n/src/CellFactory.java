import java.util.HashMap;
import java.util.Map;

public class CellFactory {
    private final Map<cellStatus, Cell> flyweights = new HashMap<>();

    public Cell getCell(cellStatus cellStatus) {
        if (!flyweights.containsKey(cellStatus)) {

        }
    }
}
