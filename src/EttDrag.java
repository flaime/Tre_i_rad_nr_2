
public class EttDrag {

	private int x;
	private int y;
	private Spelare somVarDärInnan = null;
	
	public EttDrag(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public EttDrag(int x, int y, Spelare SomVarDärInnan){
		this.x = x;
		this.y = y;
		this.somVarDärInnan = SomVarDärInnan;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public Spelare getSpelare(){
		return somVarDärInnan;
	}
	
	public String toString(){
		return "denreturnerar saker" ; //X = " + x + " Y = " + y + " spelare = " + somVarDärInnan;
	}
}
