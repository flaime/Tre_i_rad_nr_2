import java.util.Scanner;


public class TextSpelare extends Spelare{


	private static Scanner tangentbord = new Scanner(System.in);
	public TextSpelare(String namn,int h�jd, int bred) {
		super(namn, h�jd, bred);
		// TODO Auto-generated constructor stub
	}
	
	Scanner s = new Scanner(System.in);
	public EttDrag g�rDrag(spelPlan2 sp){
		
		System.out.println("Spelare " + namn + " tur");
		int x = speldataInmatning("skrv in x kordinaten:");
		
		int y = speldataInmatning("skrv in y kordinaten:");
		
		return new EttDrag(y, x, this);
	}
	
	private int speldataInmatning(String vadAttSkrivaUt){
		int x = 0;
		System.out.println(vadAttSkrivaUt);
		boolean skrivUtH�lptext = false;
		do{
			if(skrivUtH�lptext == true){
				System.out.println("Y talet f�r endast vara mellan 0 och " +(h�jd+1) + " och x talet mellan 0 och " + (bred+1));
			}
			
			x = readInt("") - 1;
			skrivUtH�lptext = true;
		}while((x <= -1 ) || (x >= bred+1) || ( x >= h�jd+1)); //n�got f�r att kontrplera att det �r inom de plattserna som finns 
		return x;
	}
	
	public static int readInt(String prompt) {
		System.out.print(prompt);
		int i = -50;
		boolean �rEnInt = false;
		while (�rEnInt == false) {
			try {
				String s = tangentbord.nextLine();

				i = Integer.parseInt(s);
				�rEnInt = true;

			} catch (NumberFormatException e) {
				System.out.print("Det �r inte ett heltal, f�rs�k igen: ");
			}
		}
		return i;

	}

}
