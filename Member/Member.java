package Member;

//Done by Clark Potter

public class Member {
	Boolean paid;                                                    // T/F if Member is paid up
	int userID;                                                      // 9 numbers, assigned userID
	String name;                                                     // 25 chars, User's Name
	Boolean MP;                                                      // TRUE is MEMBER false is PROVIDER
	String State;                                                    // 2 Letters, State ID
	int Zipcode;                                                     // 5 Numbers, Zip Code
	String Address;                                                  // 25 Chars, Street Address
	String City;                                                     // 14 Chars, City
	
	public Member(int userID, String name, Boolean MP,String State,int Zipcode,String Address, String City, Boolean paid) {             // Constructor
		this.userID = userID;                                             // Set USERID
		this.name = name;                                               // Set NAME
		this.MP = MP;                                                 // Set PROVIDER OR MEMBER (MEMBER is TRUE)
		this.State = State;                                              // Set USER STATE
		this.Zipcode = Zipcode;                                            // Set USER ZIPCODE
		this.Address = Address;                                            // Set USER STREET ADDRESS
		this.City = City;                                               // Set USER CITY
		this.paid = paid;                                            // Set USER PAID UP (Default true, on account creation)
	}
	
	public void InvertPaid() {                                       // Change PAID
		this.paid = !this.paid;
	}
	
	public void ChangeName(String name) {                               // Change USER NAME
		this.name = name;
	}
	
	public void ChangeState(String State) {                              // Change USER STATE
		this.State = State;
	}
	
	public void ChangeAddress(String Address) {                            // Change USER ADDRESS
		this.Address = Address;
	}
	
	public void ChangeCity(String City) {                               // Change USER CITY
		this.City = City;
	}
	
	public void MakeProvider() {                                     // Change PROVIDER STATUS
		this.MP = false;
	}
	
	public void MakeMember() {                                       // Change MEMBER STATUS
		this.MP = true;
	}
	
	public void ChangeZip(int Zipcode) {                                   // Change ZIP CODE
		this.Zipcode = Zipcode;
	}
	
	public Boolean GetPaid() {                                       // Return PAID
		return paid;
	}
	
	public int GetZip() {                                            // Return ZIPCODE
		return Zipcode;
	}
	
	public int GetID() {                                             // Return USERID
		return userID;
	}
	
	public String GetState() {                                       // Return STATE
		return State;
	}
	
	public String GetAddress() {                                     // Return ADDRESS
		return Address;
	}
	
	public String GetCity() {                                        // Return CITY
		return City;
	}
	
	public String GetName() {                                        // Return NAME
		return name;
	}
	
	public Boolean GetPM() {                                         // Return PROVIDER/MEMBER STATUS
		return MP;
		};
		
		 @Override
		    public String toString() {
		        return String.format("%-25s%-9s%-25s%-14s%-2s%-5s",paid, userID, name, MP, State,Address, City,paid);
		    }
}