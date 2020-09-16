import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;




/**
 * This code uses League champions.txt as its database.
 * If you want to add or remove a champion from a certain role, you can do so by modifying the database
 * 
 * @author Ben Ungar
 * 
 * @date 4/28/20
 *
 */
public class TeamBuilder {

	
	public static void main(String[] args) {
		
		ArrayList<String> topChamps = new ArrayList<>();
		ArrayList<String> jungleChamps = new ArrayList<>();
		ArrayList<String> midChamps = new ArrayList<>();
		ArrayList<String> adcChamps = new ArrayList<>();
		ArrayList<String> supportChamps = new ArrayList<>();
		/*
		 * 0 = top
		 * 1 = jg
		 * 2 = mid
		 * 3 = adc
		 * 4 = support
		 */
		
		Scanner fileReader;
		
		
		try {
			fileReader = new Scanner(new File("League champions.txt"));
			 int i = 1;
			
			while(fileReader.hasNextLine()) {
				String champion = fileReader.nextLine();
				if(champion.length() > 0) {
					switch(i) {
					case 1:
						topChamps.add(champion);
						break;
					case 2:
						jungleChamps.add(champion);
						break;
					case 3:
						midChamps.add(champion);
						break;
					case 4:
						adcChamps.add(champion);
						break;
					case 5:
						supportChamps.add(champion);
						break;
					default:
						break;
					}
				}
				else {
					i++;
				}
			}	
		}catch (Exception e){
			System.out.println("League champions.txt is not found");
		}
		
		/*
		for(int i = 0; i < topChamps.size();i++) {
			System.out.println("Top: " + topChamps.get(i));
		}
		
		for(int i = 0; i < jungleChamps.size();i++) {
			System.out.println("Jungle: " + jungleChamps.get(i));
		}
		
		for(int i = 0; i < midChamps.size(); i++) {
			System.out.println("Mid: " + midChamps.get(i));
		}
		
		for(int i = 0; i < adcChamps.size();i++) {
			System.out.println("Adc: " + adcChamps.get(i));
		}
		
		for(int i = 0; i < supportChamps.size();i++) {
			System.out.println("Support: " + supportChamps.get(i));
		}
		*/
		
		String top = topChamps.get((int) (Math.random() * topChamps.size()));
		String jungle = jungleChamps.get((int) (Math.random() * jungleChamps.size()));
		String mid = midChamps.get((int) (Math.random() * midChamps.size()));
		String adc = adcChamps.get((int) (Math.random() * adcChamps.size()));
		String support = supportChamps.get((int) (Math.random() * supportChamps.size()));
		
		System.out.println("\n\n---------------------------");
		System.out.println("----Champions Selected----\n");
		System.out.println("Top: " + top);
		System.out.println("Jungle: " + jungle);
		System.out.println("Mid: " + mid);
		System.out.println("Bot: " + adc);
		System.out.println("Support: " + support);
		System.out.println("\n------------------------------\nGood luck in your game!\n\nPROGRAM ENDED");
		
	}
}
