import java.util.Scanner;


public class TextSpelare extends Spelare{


	private static Scanner tangentbord = new Scanner(System.in);
	public TextSpelare(String namn,int höjd, int bred) {
		super(namn, höjd, bred);
		// TODO Auto-generated constructor stub
	}
	
	Scanner s = new Scanner(System.in);
	public EttDrag görDrag(spelPlan2 sp){
		
		System.out.println("Spelare " + namn + " tur");
		int x = speldataInmatning("skrv in x kordinaten:");
		
		int y = speldataInmatning("skrv in y kordinaten:");
		
		return new EttDrag(y, x, this);
	}
	
	private int speldataInmatning(String vadAttSkrivaUt){
		int x = 0;
		System.out.println(vadAttSkrivaUt);
		boolean skrivUtHälptext = false;
		do{
			if(skrivUtHälptext == true){
				System.out.println("Y talet får endast vara mellan 0 och " +(höjd+1) + " och x talet mellan 0 och " + (bred+1));
			}
			
			x = readInt("") - 1;
			skrivUtHälptext = true;
		}while((x <= -1 ) || (x >= bred+1) || ( x >= höjd+1)); //något för att kontrplera att det är inom de plattserna som finns 
		return x;
	}
	
	public static int readInt(String prompt) {
		System.out.print(prompt);
		int i = -50;
		boolean ärEnInt = false;
		while (ärEnInt == false) {
			try {
				String s = tangentbord.nextLine();

				i = Integer.parseInt(s);
				ärEnInt = true;

			} catch (NumberFormatException e) {
				System.out.print("Det är inte ett heltal, försök igen: ");
			}
		}
		return i;

	}

}
