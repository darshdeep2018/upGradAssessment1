import java.time.LocalDate;
import java.util.Date;

public class SavingsAccount implements XYZBank{

	private String ownerName;
	private Address address;
	private int balanceAmount;
	private LocalDate createdDate;
	private String status;
	
	public SavingsAccount(String ownerName, Address address) {
		super();
		this.ownerName = ownerName;
		this.address = address;
		this.balanceAmount=0;
		this.createdDate=(java.time.LocalDate.now());
		this.status="ACTIVE";
		System.out.println("SavingsAccount Created");
	}

	@Override
	public void depositMoney(int money) {
		if(status=="INACTIVE") {
			System.err.println("Account is inactive can't process the request");
			return;
		}else if(status=="CLOSED") {
			System.err.println("Account is closed can't process the request");
			return;
		}
		balanceAmount+=money;
		System.out.println("Money Deposited Successfully");
	}

	@Override
	public void withdrawMoney(int money) {
		if(status=="INACTIVE") {
			System.err.println("Account is inactive can't process the request");
			return;
		}else if(status=="CLOSED") {
			System.err.println("Account is closed can't process the request");
			return;
		}
		if(money>balanceAmount) {
			System.err.println("Money exceeds balance");
			return;
		}
		balanceAmount-=money;
		System.out.println("Transaction Done Successfully");
	}
	
	@Override
	public int getBalance() {
		return balanceAmount;
	}

	@Override
	public void showDetails() {
		System.out.println("Owner : "+ownerName);
		System.out.println("Adress : "+address.city+" "+address.state+" "+address.pin);
		System.out.println("Account created on : "+createdDate);
		System.out.println("Current Balance : "+balanceAmount);
	}	
}

