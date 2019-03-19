package calculation.automat;

public class NeighbourhoodIterator {

	public NeighbourhoodIterator(boolean[] statesArray, int neighbours) {
		this.states = statesArray;
		this.width = statesArray.length;
		this.neighbours = neighbours;
		this.position = 0;
	}

	public boolean hasNext(){
		return position < width;
	}

	public int getNext(){
		int index = 0;
		for(int i = -neighbours; i <= neighbours; ++i)	{
			boolean state;
			if( position + i < 0){
				state = states[width+i];
			}
			else if ( position + i >= width){
				state = states[position+i-width];
			}
			else{
				state = states[position+i];
			}

			if(state)
				index |= (1<<(neighbours-i));
		}

		position++;
		return index;
	}

	private boolean[] states;
	private int width;
	private int neighbours;
	private int position;
}
