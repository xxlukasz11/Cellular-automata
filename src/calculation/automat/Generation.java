package calculation.automat;

public class Generation extends BaseRowImpl {

	public Generation(int width, int id) {
		super(width);
		this.id = id;
	}

	public boolean[] getCells(){
		return statesArray;
	}

	public int getId() {
		return id;
	}

	// numer danej generacji
	protected final int id;
}
