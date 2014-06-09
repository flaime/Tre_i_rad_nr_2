public class textGrafik{

	spelPlan2 sp;
	spelPlan2 spTillfälig;
	private boolean hjälpKordinater = false;

	public textGrafik(spelPlan2 spelplanen) {
		sp = spelplanen;
		spTillfälig = sp;
		
		// spTillfälig = new spelPlan2(sp.bred, sp.höjd);
	}
	
	public void hjälpKordinaterPå(){
		hjälpKordinater = true;
	}
	
	public void hjälpKordinaterAv(){
		hjälpKordinater = false;
	}

	public void skrivUt() { //borde sedan göras om till private och bästtre sätt att uppdataera..
		//if (sp.equals(spTillfälig) == false) {
			String skrivaUt = "";

			for (int i = 0; i < spTillfälig.höjd; i++) {
				for (int j = 0; j < spTillfälig.bred; j++) {
					
					skrivaUt = skrivaUt + "[";
					
					if (spTillfälig.getPlatts(i, j) != null)
						skrivaUt = skrivaUt + sp.getPlatts(j, i).getTecken();//.toString();//x:y
					else{
						if(hjälpKordinater == false)
							skrivaUt = skrivaUt + " ";
						else
							skrivaUt = skrivaUt + (++j) + ":"+ (++i);
						--i;
						--j;
					}
					//System.out.println(spTillfälig.getPlatts(i, j));
					skrivaUt = skrivaUt + "]";
				}
				skrivaUt = skrivaUt + "\n";
			}
			System.out.println(skrivaUt);
		//}
		

		spTillfälig = sp;
	}

	public boolean avsluta() {
		// TODO Auto-generated method stub
		return true;
	}

	public void vinst(Spelare vinnaren) {
		System.out.println("--------||||---------");
		System.out.println("Grattis " + vinnaren + " till vinsten!");
		System.out.println("--------||||---------");
	}

}
