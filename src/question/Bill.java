
package question;

public class Bill {

	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private double limitingAmount;
	private double currentDebt;
	private double spentMoney ;
	
 	public Bill(double limitingAmount) {
 		this.limitingAmount = limitingAmount;
 		currentDebt = 0;
 		spentMoney = 0;
 		
 	}
 	
 	public boolean check(double amount) {
 		return((amount + currentDebt) <= limitingAmount) ; 
 	}
 	public void add(double amount) {
 		currentDebt += amount ;
 	}
 	public void pay(double amount) {
 		if (amount> currentDebt)
 			{spentMoney += currentDebt ;
 			currentDebt = 0;
 			
 			}
 		else {
 			currentDebt  -= amount ;
 			spentMoney+= amount ;
 			}
 	}
 	public double getSpentMoney() {
		return spentMoney;
	}

	public void changeTheLimit(double amount) {
 		this.limitingAmount = amount ;
 	}
 	
 	

	public double getLimitingAmount() {
		return limitingAmount;
	}

	public double getCurrentDebt() {
		return currentDebt;
	}

	public void setLimitingAmount(double limitingAmount) {
		this.limitingAmount = limitingAmount;
	}

 	

	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

