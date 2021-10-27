
package question;

import org.junit.validator.PublicClassValidator;

public class Customer {
	
	
	private int ID;
	private String name;
	private int age;
	private Operator operator;
	private Bill bill;
	private int talkingMinutes ;
	private int messageCount;
	private double internetAmount ;
	
	public Customer(int ID, String name, int age , Operator operator, double limitingAmount) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.operator = operator;  
		this.talkingMinutes = 0;
		this.messageCount = 0;
		this.internetAmount = 0;
		bill  = new Bill(limitingAmount);
		
	}
	public void talk(int minute, Customer other) {
		this.talkingMinutes += minute; 
		other.talkingMinutes += minute;
		operator.setTalkingServiceMinutes(operator.getTalkingServiceMinutes()+minute);
		other.operator.setTalkingServiceMinutes(other.operator.getTalkingServiceMinutes()+minute);
		this.bill.add(this.operator.calculateTalkingCost(minute, this));
	}
	public void message(int quantity, Customer other) {
		this.messageCount += quantity ;
		operator.setMessageServiceCount(operator.getMessageServiceCount()+quantity);
		this.bill.add(this.operator.calculateMessageCost(quantity, this, other));
	}
	
	public void connection(double amount) {
		this.internetAmount += amount;
		this.operator.setInternetServiceAmount(operator.getInternetServiceAmount()+amount);
		this.bill.add(this.operator.calculateNetworkCost(amount));
	}
	
	
	public int getAge() {
		return age;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Bill getBill() {
		return bill;
	}
	
	public int getTalkingMinutes() {
		return talkingMinutes;
	}
	
	public int getMessageCount() {
		return messageCount;
	}
	
	public String getName() {
		return name;
	}
	public double getInternetAmount() {
		return internetAmount;
	}
	
	
	
	



	
}

