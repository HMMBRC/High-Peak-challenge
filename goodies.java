package chegg;
import java.io.*;
import java.util.*;

public class goodies {
	
	public static int getNumber(String str) {
		int count = 0;
		String[] strArray = new String[2];
		strArray = str.split(":");
		String s = strArray[1];
		s = s.trim();
		count = Integer.parseInt(s);
		return count;
	}
	
	public static String getName(String str) {
		String[] strArray = new String[2];
		strArray = str.split(":");
		String s = strArray[0];
		return s;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		File file = new File("S:\\eclipse-workspace\\problem_statements\\src\\chegg\\input.txt");
		Scanner scan = new Scanner(file);
		
		String str = scan.nextLine();
		
		int noOfEmployees = getNumber(str);
		
		scan.nextLine();scan.nextLine();scan.nextLine();
		
		List<String> list = new ArrayList<String>();
		
		while(scan.hasNext()) {
			list.add(scan.nextLine());
		}
		List<Integer> costList = new ArrayList<Integer>();
		Map<Integer, String> map = new HashMap<>();
		
		for(String s : list) {
			int cost = getNumber(s);
			String name = getName(s);
			costList.add(cost);
			map.put(cost,name);
		}
		
		Collections.sort(costList);
		
		int min = Integer.MAX_VALUE;
		int index = 0;
		
		for(int i = 0; i < costList.size() - noOfEmployees; i++) {
			
			if((costList.get(i+noOfEmployees-1) - costList.get(i)) < min) {
				min = costList.get(i+noOfEmployees-1)- costList.get(i);
				index = i;
			}
		}
		
		int minimum_difference = costList.get(index+noOfEmployees-1)- costList.get(index);
		
		String fileName = "S:\\eclipse-workspace\\problem_statements\\src\\chegg\\output.txt";
		
		File fout = new File(fileName);
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		String write = "The goodies selected for distribution are:";
		bw.write(write);
		bw.newLine();
		bw.newLine();
		for(int i = index; i < index + noOfEmployees ; i++) {
			write = map.get(costList.get(i))+":"+costList.get(i);
			
			bw.write(write);
			bw.newLine();
		}
		bw.newLine();
		write = "And the difference between the chosen goodie with highest price and the lowest price is "+minimum_difference;
		bw.write(write);
		bw.newLine();
		bw.close();	
		
	}

}
