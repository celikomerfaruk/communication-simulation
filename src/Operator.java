
package question;

public class Operator {
	
	private int ID;
	private double talkingCharge; 
	private double messageCost;
	private double networkCharge;
 	private int discountRate;
 	private int talkingServiceMinutes;
 	private int messageServiceCount ; 
 	private double internetServiceAmount ;

 	public Operator(int ID,double messageCost,double networkCharge,int discountRate) {
 		this.ID = ID;
 		this.messageCost =messageCost ;
 		this.networkCharge= networkCharge ;
 		this.discountRate = discountRate ;
 		this.talkingServiceMinutes = 0;
 		this.messageServiceCount = 0;
 		this.internetServiceAmount = 0;
 		
 	}
 	public double calculateTalkingCost(int minute, Customer customer) { 
 		
 	if(customer.getAge()<18 || customer.getAge()>65) 
 		return  minute*talkingCharge*(1-(double)discountRate/100);
 	else 
		return minute*talkingCharge;
	
 	}
 	
 	public double calculateMessageCost(int quantity, Customer customer, Customer other) {
 		if (customer.getOperator() == other.getOperator()) 
 			return quantity*messageCost*(1-(double)discountRate/100);
 		else 
 			return quantity*messageCost;
 	}
 	public double calculateNetworkCost(double amount) {
 		
 		return amount * networkCharge ;
 	}
 	
 	
 	

	
	
	public void setTalkingCharge(double talkingCharge) {
		this.talkingCharge = talkingCharge;
	}
	public int getTalkingServiceMinutes() {
		return talkingServiceMinutes;
	}
	public void setTalkingServiceMinutes(int talkingServiceMinutes) {
		this.talkingServiceMinutes = talkingServiceMinutes;
	}
	public int getMessageServiceCount() {
		return messageServiceCount;
	}
	public void setMessageServiceCount(int messageServiceCount) {
		this.messageServiceCount = messageServiceCount;
	}
	public double getInternetServiceAmount() {
		return internetServiceAmount;
	}
	public void setInternetServiceAmount(double internetServiceAmount) {
		this.internetServiceAmount = internetServiceAmount;
	}
 	
 	

	
}

