

public class BraNär {
	
	Object attGöra;
	Object när;
	int hurBra = 0;
	
	public BraNär(Object attGöra, Object när){
		this.attGöra = attGöra;
		this.när = när;
	}
	
	public Object getAttGöra(){
		return attGöra;
	}
	
	public Object getNär(){
		return när;
	}
	
	public void ökaBraSkalan(){
		hurBra++;
	}
	
	public void SänkBraSkalan(){
		hurBra--;
	}

}
