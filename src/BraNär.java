

public class BraN�r {
	
	Object attG�ra;
	Object n�r;
	int hurBra = 0;
	
	public BraN�r(Object attG�ra, Object n�r){
		this.attG�ra = attG�ra;
		this.n�r = n�r;
	}
	
	public Object getAttG�ra(){
		return attG�ra;
	}
	
	public Object getN�r(){
		return n�r;
	}
	
	public void �kaBraSkalan(){
		hurBra++;
	}
	
	public void S�nkBraSkalan(){
		hurBra--;
	}

}
