public class textGrafik{

	spelPlan2 sp;
	spelPlan2 spTillf�lig;
	private boolean hj�lpKordinater = false;

	public textGrafik(spelPlan2 spelplanen) {
		sp = spelplanen;
		spTillf�lig = sp;
		
		// spTillf�lig = new spelPlan2(sp.bred, sp.h�jd);
	}
	
	public void hj�lpKordinaterP�(){
		hj�lpKordinater = true;
	}
	
	public void hj�lpKordinaterAv(){
		hj�lpKordinater = false;
	}

	public void skrivUt() { //borde sedan g�ras om till private och b�sttre s�tt att uppdataera..
		//if (sp.equals(spTillf�lig) == false) {
			String skrivaUt = "";

			for (int i = 0; i < spTillf�lig.h�jd; i++) {
				for (int j = 0; j < spTillf�lig.bred; j++) {
					
					skrivaUt = skrivaUt + "[";
					
					if (spTillf�lig.getPlatts(i, j) != null)
						skrivaUt = skrivaUt + sp.getPlatts(j, i).getTecken();//.toString();//x:y
					else{
						if(hj�lpKordinater == false)
							skrivaUt = skrivaUt + " ";
						else
							skrivaUt = skrivaUt + (++j) + ":"+ (++i);
						--i;
						--j;
					}
					//System.out.println(spTillf�lig.getPlatts(i, j));
					skrivaUt = skrivaUt + "]";
				}
				skrivaUt = skrivaUt + "\n";
			}
			System.out.println(skrivaUt);
		//}
		

		spTillf�lig = sp;
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
