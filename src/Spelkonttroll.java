import java.util.ArrayList;
import java.util.Scanner;


public class Spelkonttroll {

	//variabler man ska kunna st�lla in
		boolean grafik = false;
		boolean textGrafik = true;
		private int hurM�ngaIRad = 0;
		
		//grafikinst�llningar
		boolean grafikV = false;
		boolean textGrafikV = false;
		
		//grafikobjekten
		grafik g;
		textGrafik tg;
		
		private spelPlan2 spelplanen;
		
		ArrayList<Spelare> spelare = new ArrayList<>(); //den spelare som �r p� patts 0 �r dens tur
		int vilkenSpelareSpelade = 0; //andv�nds f�r att h�lla p� vems tur det �r
		
		public Spelkonttroll(int h�jd, int bredd, int antalIrad){
			g�rIorningF�rSpelande(h�jd, bredd, antalIrad);
		}
		
		public Spelkonttroll (){
			g�rIorningF�rSpelande(3,3,3);
		}
		
		public Spelare getVilkenSpelaresTur(){
			return (Spelare) spelare.get(vilkenSpelareSpelade);
			
		}
		
		public Spelare getVilkenSpelaresTurSamtBytTillN�sta(){
			vilkenSpelareSpelade++;
			return (Spelare) spelare.get(vilkenSpelareSpelade - 1);
			
		}
		
		public void n�staSpelaresTur(){
			if(vilkenSpelareSpelade < spelare.size()-1)
				vilkenSpelareSpelade++;
			else //if(vilkenSpelareSpelade >= spelare.size())
				vilkenSpelareSpelade = 0;
			
		}

		private void g�rIorningF�rSpelande(int h�jd, int bredd, int antalIrad){
			spelplanen = new spelPlan2(h�jd, bredd);
			hurM�ngaIRad = antalIrad;
			
			//tillf�ligt f�r att ha spelare
			l�ggTillSpelare(new TextSpelare("spelare 1", 3,3));
			//l�ggTillSpelare(new TextSpelare("spelare 2", 3,3));
			l�ggTillSpelare(new DatorSpelare("spelare 2", 3,3));
			
			if(grafik == true){
				//g�r n�got
			}
			if(textGrafik == true){
				startaTextGrafik();
			}
			//ta bort och g�r annat med sedan 
			tg.hj�lpKordinaterP�();
			Speldelare();
			
		}
		
		public boolean l�ggTillSpelare(Spelare p){
			if(spelare.size() <= 1){
				spelare.add(p);
				return true;
			}
			else if(spelare.size() > 1){
				return false;
			}
			
			return false; //b�r aldrig andv�ndas f�r att de ska fastna innan
		}

		private void Speldelare(){
			Scanner s = new Scanner(System.in);
			
			while(true){
				//en lopp f�r att f� spelet att rulla p�
				
				//l�gg till kontroll f�r att det inte ska g� att l�gga p� redan lagd ruta
				
				System.out.println("hej3");
				spelplanen.setDrag(spelaNuvarandeSpelare());
				//lop f�r att lopa igeon alla osm 
				n�staSpelaresTur();
				
				//t�nk p� att uppdatera grafik om det finns n�gon
				if(textGrafik == true){
					tg.skrivUt();
				}
				
				//tita efter vinst
				if(tittaEfterVinst() != null){
					tg.vinst(tittaEfterVinst());
					System.out.println(tittaEfterVinst() + "har vunnit");
				}
			}
		}

		private EttDrag spelaNuvarandeSpelare(){
			System.out.println("det �r spelare" + spelare.get(vilkenSpelareSpelade).namn + " " + spelare.get(vilkenSpelareSpelade).teken);
			EttDrag d = spelare.get(vilkenSpelareSpelade).g�rDrag(spelplanen); //la till h�r
			System.out.println("draget f�r spelare: " + d.getX());
			return d;
		}
		
		public Spelare tittaEfterVinst(){ //m�ste svara med n�got
			
			//denna �r statisk och fungerar inte om det inte �r en 3*3 spelplan
			
			//titta de "ned�tg�ende"
			if(spelplanen.getPlatts(0,0) == spelplanen.getPlatts(1,0) &&  spelplanen.getPlatts(1,0) == spelplanen.getPlatts(2,0) && spelplanen.getPlatts(0,0) != null){
				return spelplanen.getPlatts(0,0);
			} else if(spelplanen.getPlatts(0,1) == spelplanen.getPlatts(1,1) && spelplanen.getPlatts(1,1) == spelplanen.getPlatts(2,1)&& spelplanen.getPlatts(0,1) != null){
				return spelplanen.getPlatts(0,1);
			}else if(spelplanen.getPlatts(0,2) == spelplanen.getPlatts(1,2) && spelplanen.getPlatts(1,2) == spelplanen.getPlatts(2,2)&& spelplanen.getPlatts(0,2) != null){
				return spelplanen.getPlatts(0,2);
				//titta de "rakg�ende"
			}else if(spelplanen.getPlatts(0,0) == spelplanen.getPlatts(0,1) &&  spelplanen.getPlatts(0,1) == spelplanen.getPlatts(0,2) && spelplanen.getPlatts(0,0) != null){
				return spelplanen.getPlatts(0,0);
			} else if(spelplanen.getPlatts(1,0) == spelplanen.getPlatts(1,1) && spelplanen.getPlatts(1,1) == spelplanen.getPlatts(1,2)&& spelplanen.getPlatts(1,0) != null){
				return spelplanen.getPlatts(1,0);
			}else if(spelplanen.getPlatts(2,0) == spelplanen.getPlatts(2,1) && spelplanen.getPlatts(2,1) == spelplanen.getPlatts(2,2)&& spelplanen.getPlatts(2,0) != null){
				return spelplanen.getPlatts(2,0);
			} //de tv�rg�ende
			else if(spelplanen.getPlatts(0,0) == spelplanen.getPlatts(1,1) &&spelplanen.getPlatts(1,1) == spelplanen.getPlatts(2,2)&& spelplanen.getPlatts(0,0) != null){
				return spelplanen.getPlatts(0,0);
			} else if(spelplanen.getPlatts(2,0) == spelplanen.getPlatts(1,1)&&spelplanen.getPlatts(1,1)  == spelplanen.getPlatts(2,0)&& spelplanen.getPlatts(2,0) != null){
				return spelplanen.getPlatts(2,0);
			}else{ //om ingen har vunnit
				return null;
			}
		}
		
		public boolean S�ttaUtDrag(int x, int y, Spelare s){
			if(�rPlattsTom(x, y) == true){
				spelplanen.setDrag(x, y, s);
				return true;
			}else 
				return false;
		}
		
		public boolean �rPlattsTom(int x, int y){
			if(spelplanen.getPlatts(x, y) == null){
				return true;
			}else
				return false;
		}
		
		public boolean ominteg�raDrag(){
			return spelplanen.ominteg�raDrag();
		}

		public void startaGrafik() {
			g = new grafik(spelplanen);
		}
		
		public boolean avslutaGrafik(){
			if(g.avsluta() == true){
				g = null;
				return true;
			}else 
				return false;
		}

		public void startaTextGrafik() {
			tg = new textGrafik(spelplanen);
		}
		
		public boolean avslutaTextGrafik(){
			if(tg.avsluta() == true){
				tg = null;
				return true;
			}else 
				return false;
		}
}
