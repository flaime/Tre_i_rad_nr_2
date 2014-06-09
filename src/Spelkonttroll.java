import java.util.ArrayList;
import java.util.Scanner;


public class Spelkonttroll {

	//variabler man ska kunna ställa in
		boolean grafik = false;
		boolean textGrafik = true;
		private int hurMångaIRad = 0;
		
		//grafikinställningar
		boolean grafikV = false;
		boolean textGrafikV = false;
		
		//grafikobjekten
		grafik g;
		textGrafik tg;
		
		private spelPlan2 spelplanen;
		
		ArrayList<Spelare> spelare = new ArrayList<>(); //den spelare som är på patts 0 är dens tur
		int vilkenSpelareSpelade = 0; //andvänds för att hålla på vems tur det är
		
		public Spelkonttroll(int höjd, int bredd, int antalIrad){
			görIorningFörSpelande(höjd, bredd, antalIrad);
		}
		
		public Spelkonttroll (){
			görIorningFörSpelande(3,3,3);
		}
		
		public Spelare getVilkenSpelaresTur(){
			return (Spelare) spelare.get(vilkenSpelareSpelade);
			
		}
		
		public Spelare getVilkenSpelaresTurSamtBytTillNästa(){
			vilkenSpelareSpelade++;
			return (Spelare) spelare.get(vilkenSpelareSpelade - 1);
			
		}
		
		public void nästaSpelaresTur(){
			if(vilkenSpelareSpelade < spelare.size()-1)
				vilkenSpelareSpelade++;
			else //if(vilkenSpelareSpelade >= spelare.size())
				vilkenSpelareSpelade = 0;
			
		}

		private void görIorningFörSpelande(int höjd, int bredd, int antalIrad){
			spelplanen = new spelPlan2(höjd, bredd);
			hurMångaIRad = antalIrad;
			
			//tillfäligt för att ha spelare
			läggTillSpelare(new TextSpelare("spelare 1", 3,3));
			//läggTillSpelare(new TextSpelare("spelare 2", 3,3));
			läggTillSpelare(new DatorSpelare("spelare 2", 3,3));
			
			if(grafik == true){
				//gör något
			}
			if(textGrafik == true){
				startaTextGrafik();
			}
			//ta bort och gör annat med sedan 
			tg.hjälpKordinaterPå();
			Speldelare();
			
		}
		
		public boolean läggTillSpelare(Spelare p){
			if(spelare.size() <= 1){
				spelare.add(p);
				return true;
			}
			else if(spelare.size() > 1){
				return false;
			}
			
			return false; //bör aldrig andvändas för att de ska fastna innan
		}

		private void Speldelare(){
			Scanner s = new Scanner(System.in);
			
			while(true){
				//en lopp för att få spelet att rulla på
				
				//lägg till kontroll för att det inte ska gå att lägga på redan lagd ruta
				
				System.out.println("hej3");
				spelplanen.setDrag(spelaNuvarandeSpelare());
				//lop för att lopa igeon alla osm 
				nästaSpelaresTur();
				
				//tänk på att uppdatera grafik om det finns någon
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
			System.out.println("det är spelare" + spelare.get(vilkenSpelareSpelade).namn + " " + spelare.get(vilkenSpelareSpelade).teken);
			EttDrag d = spelare.get(vilkenSpelareSpelade).görDrag(spelplanen); //la till här
			System.out.println("draget för spelare: " + d.getX());
			return d;
		}
		
		public Spelare tittaEfterVinst(){ //måste svara med något
			
			//denna är statisk och fungerar inte om det inte är en 3*3 spelplan
			
			//titta de "nedåtgående"
			if(spelplanen.getPlatts(0,0) == spelplanen.getPlatts(1,0) &&  spelplanen.getPlatts(1,0) == spelplanen.getPlatts(2,0) && spelplanen.getPlatts(0,0) != null){
				return spelplanen.getPlatts(0,0);
			} else if(spelplanen.getPlatts(0,1) == spelplanen.getPlatts(1,1) && spelplanen.getPlatts(1,1) == spelplanen.getPlatts(2,1)&& spelplanen.getPlatts(0,1) != null){
				return spelplanen.getPlatts(0,1);
			}else if(spelplanen.getPlatts(0,2) == spelplanen.getPlatts(1,2) && spelplanen.getPlatts(1,2) == spelplanen.getPlatts(2,2)&& spelplanen.getPlatts(0,2) != null){
				return spelplanen.getPlatts(0,2);
				//titta de "rakgående"
			}else if(spelplanen.getPlatts(0,0) == spelplanen.getPlatts(0,1) &&  spelplanen.getPlatts(0,1) == spelplanen.getPlatts(0,2) && spelplanen.getPlatts(0,0) != null){
				return spelplanen.getPlatts(0,0);
			} else if(spelplanen.getPlatts(1,0) == spelplanen.getPlatts(1,1) && spelplanen.getPlatts(1,1) == spelplanen.getPlatts(1,2)&& spelplanen.getPlatts(1,0) != null){
				return spelplanen.getPlatts(1,0);
			}else if(spelplanen.getPlatts(2,0) == spelplanen.getPlatts(2,1) && spelplanen.getPlatts(2,1) == spelplanen.getPlatts(2,2)&& spelplanen.getPlatts(2,0) != null){
				return spelplanen.getPlatts(2,0);
			} //de tvärgående
			else if(spelplanen.getPlatts(0,0) == spelplanen.getPlatts(1,1) &&spelplanen.getPlatts(1,1) == spelplanen.getPlatts(2,2)&& spelplanen.getPlatts(0,0) != null){
				return spelplanen.getPlatts(0,0);
			} else if(spelplanen.getPlatts(2,0) == spelplanen.getPlatts(1,1)&&spelplanen.getPlatts(1,1)  == spelplanen.getPlatts(2,0)&& spelplanen.getPlatts(2,0) != null){
				return spelplanen.getPlatts(2,0);
			}else{ //om ingen har vunnit
				return null;
			}
		}
		
		public boolean SättaUtDrag(int x, int y, Spelare s){
			if(ärPlattsTom(x, y) == true){
				spelplanen.setDrag(x, y, s);
				return true;
			}else 
				return false;
		}
		
		public boolean ärPlattsTom(int x, int y){
			if(spelplanen.getPlatts(x, y) == null){
				return true;
			}else
				return false;
		}
		
		public boolean omintegöraDrag(){
			return spelplanen.omintegöraDrag();
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
