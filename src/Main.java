
package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


	public static void main(String args[]) {

		Customer[] customers;
		Operator[] operators;

		int C, O, N;

		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file
		try {
			PrintStream outstream = new PrintStream(outFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		

		Scanner reader;
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			return;
		}

		C = reader.nextInt();
		O = reader.nextInt();
		N = reader.nextInt();

		customers = new Customer[C];
		operators = new Operator[O];

		
		
		
		PrintStream outstream1;
		try {
		        outstream1 = new PrintStream(outFile);
		}catch(FileNotFoundException e2) {
		        e2.printStackTrace();
		        return;
		}
		
		reader.nextLine();
 		String[] statements = new String[N];
 		int tempOpID = 0 ;
 		int tempCusID = 0 ;
 		for (int i = 0; i < N; i++) {                               //operator creation
 			statements[i] = reader.nextLine();
 			if ("2".equals(statements[i].split(" ")[0])) {					
			     operators[tempOpID]   = new Operator(tempOpID,Double.parseDouble(statements[i].split(" ")[2]) , Double.parseDouble(statements[i].split(" ")[3]), Integer.parseInt(statements[i].split(" ")[4]))   ;
			     operators[tempOpID].setTalkingCharge(Double.parseDouble(statements[i].split(" ")[1]));
			     tempOpID++ ;
			}
 		}
 		for (int i = 0; i < N; i++) {                        //customer creation
 			if ("1".equals(statements[i].split(" ")[0])) {                       
				customers[tempCusID] = new Customer(Integer.parseInt(statements[i].split(" ")[3]),(statements[i].split(" ")[1]) ,Integer.parseInt(statements[i].split(" ")[2]) ,operators[Integer.parseInt(statements[i].split(" ")[3])] , Double.parseDouble(statements[i].split(" ")[4])) ;
				tempCusID++ ;
				}
 			
 		}
		for (int i = 0; i < N; i++) {
			 
	
			if ("3".equals(statements[i].split(" ")[0])) {             //aramalar
				if (!statements[i].split(" ")[1].equals(statements[i].split(" ")[2])) {  //kendi kendini aramamasi icin
					if (customers[Integer.parseInt(statements[i].split(" ")[1])].getBill().check(customers[Integer.parseInt(statements[i].split(" ")[1])].getOperator().calculateTalkingCost(Integer.parseInt(statements[i].split(" ")[3]), customers[Integer.parseInt(statements[i].split(" ")[1])])))   //check for bill limit  
 				{
					customers[Integer.parseInt(statements[i].split(" ")[1])].talk(Integer.parseInt(statements[i].split(" ")[3]), customers[Integer.parseInt(statements[i].split(" ")[2])]);		//talk fonksiyonunu cagirdik
				}
				}
			}
			
			if ("4".equals(statements[i].split(" ")[0])) {        //mesage
				if (!statements[i].split(" ")[1].equals(statements[i].split(" ")[2])) {
					if (customers[Integer.parseInt(statements[i].split(" ")[1])].getBill().check(customers[Integer.parseInt(statements[i].split(" ")[1])].getOperator().calculateMessageCost(Integer.parseInt(statements[i].split(" ")[3]), customers[Integer.parseInt(statements[i].split(" ")[1])], customers[Integer.parseInt(statements[i].split(" ")[2])]))) //check for bill limit  
					{
						customers[Integer.parseInt(statements[i].split(" ")[1])].message(Integer.parseInt(statements[i].split(" ")[3]), customers[Integer.parseInt(statements[i].split(" ")[2])]);
					}
				}
				
			}
			
			if ("5".equals(statements[i].split(" ")[0])) {
				
				if (customers[Integer.parseInt(statements[i].split(" ")[1])].getBill().check(customers[Integer.parseInt(statements[i].split(" ")[1])].getOperator().calculateNetworkCost(Double.parseDouble(statements[i].split(" ")[2])))) //check for bill limit  
				{
					customers[Integer.parseInt(statements[i].split(" ")[1])].connection(Double.parseDouble(statements[i].split(" ")[2]));
				}
				
			}
			if ("6".equals(statements[i].split(" ")[0])) {
				customers[Integer.parseInt(statements[i].split(" ")[1])].getBill().pay(Double.parseDouble(statements[i].split(" ")[2]));
			}
			
			if ("7".equals(statements[i].split(" ")[0])) {
				customers[Integer.parseInt(statements[i].split(" ")[1])].setOperator(operators[Integer.parseInt(statements[i].split(" ")[2])]);
			}
			if ("8".equals(statements[i].split(" ")[0])) {
				if(Double.parseDouble(statements[i].split(" ")[2]) >= customers[Integer.parseInt(statements[i].split(" ")[1])].getBill().getCurrentDebt())
					customers[Integer.parseInt(statements[i].split(" ")[1])].getBill().changeTheLimit(Double.parseDouble(statements[i].split(" ")[2]));
			}
		}
	 
		//yazdirma
		for (int i = 0; i < operators.length; i++) {
			outstream1.printf("Operator "+ i + " : " + operators[i].getTalkingServiceMinutes() + " " + operators[i].getMessageServiceCount() + " %.2f"  ,operators[i].getInternetServiceAmount());
		
				outstream1.print("\n");
				
			

		}
			for (int i = 0; i < customers.length; i++) {
				outstream1.printf("Customer " + i + " : %.2f" + " %.2f"  , customers[i].getBill().getSpentMoney() ,customers[i].getBill().getCurrentDebt());
				
					outstream1.print("\n");
				
			}
			
			int count = -1;
			int id = -1 ;
			for (int i = 0; i < customers.length; i++) {
				if( customers[i].getTalkingMinutes() > count ) {
					count = customers[i].getTalkingMinutes();
					id  = i;
				}
			
			}
			outstream1.print(customers[id].getName() + " : "+ count  + "\n");
			
			
			int messageCount = -1;
			int messageID = -1 ;
			for (int i = 0; i < customers.length; i++) {
				if( customers[i].getMessageCount() > messageCount ) {
					messageCount = customers[i].getMessageCount();
					messageID  = i;
				}
			
			}
			outstream1.print(customers[messageID].getName() + " : "+ messageCount + "\n" );
			
			
			double networkCount = -1;
			int networkID = -1 ;
			for (int i = 0; i < customers.length; i++) {
				if( customers[i].getInternetAmount() > networkCount ) {
					networkCount = customers[i].getInternetAmount();
					networkID  = i;
				}
			
			}
			outstream1.printf(customers[networkID].getName() + " : %.2f" ,networkCount );
			outstream1.print("\n");
	
		
	} 
}

