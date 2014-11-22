import java.util.ArrayList;
import java.util.List;

public class Cell {

	private List<Cell> neighbours = new ArrayList<Cell>();
	private CellState cellState;

	public Cell(CellState state) {
		cellState = state;
	}

	public CellState getState() {
		return cellState;
	}

	public void checkNeighbours() {
		int alive = 0;
		for (Cell neighbour : neighbours) {
			if (neighbour.getState().equals(CellState.ALIVE)) {
				alive++;
			}
		}
		applyRules(alive);
	}

	private void applyRules(int alive) {
		if (cellState.equals(CellState.ALIVE)) {
			if (alive < 2 || alive > 3) {
				cellState = CellState.DEAD;
			}
		} else {
			if (alive == 3) {
				cellState = CellState.ALIVE;
			}
		}
	}
	
	public void setNeighbour(Cell neighbour) {
		neighbours.add(neighbour);
	}

}
