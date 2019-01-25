/**
 * Kasabury Mobile Phone Class.
 *
 * INFO1103 Assignment 3, Semester 1, 2017.
 *
 * KasaburyMobile
 * In this assignment you will be creating an Kasabury Mobile Phone as part of a simulation.
 * The Mobile phone includes several attributes unique to the phone and has simple functionality.
 * You are to complete 2 classes. KasaburyMobile and KasaburyContact
 *
 * The phone has data
 *  Information about the phone state.
 *    If it is On/Off
 *    Battery level
 *    If it is connected to network.
 *    Signal strength when connected to network
 *  Information about the current owner saved as contact information.
 *    First name
 *    Last name
 *    Phone number
 *  A list of 10 possible contacts.
 *    Each contact stores first name, last name, phone number and chat history up to 40 messages
 *
 * The phone has functionality
 *  Turning on the phone
 *  Charging the phone. Increase battery level
 *  Change battery (set battery level)
 *  Use phone for k units of battery (decreases battery level by k)
 *  Search/add/remove contacts
 *
 * Attribute features
 *  if the phone is off. It is not connected.
 *  if the phone is not connected there is no signal strength
 *  the attribute for battery life has valid range [0,100]. 0 is flat, 100 is full.
 *  the attribute for signal strength has a valid range [0, 5]. 0 is no signal, 5 is best signal.
 *
 * Please implement the methods provided, as some of the marking is
 * making sure that these methods work as specified.
 *
 * @author A INFO1103 tutor.
 * @date April, 2017
 *
 */
public class KasaburyMobile
{
	public static final int MAXIMUM_CONTACTS = 10;


	/* Use this to store contacts. Do not modify. */
	protected KasaburyContact[] contacts;
	private  int battery;
	private  int signal;
	private  int passcode;
	private boolean isphoneon;
	private boolean isconnected;
	private  String fname = "Kasabury";
	private  String lname = "Incorporated";
	private String pnumber = "180076237867";


	/* Every phone manufactured has the following attributes
	 *
	 * the phone is off
	 * the phone has battery life 5
	 * the phone is not connected
	 * the phone has signal strength 0
	 * the phone has factory passcode is 1234
	 * Each of the contacts stored in the array contacts has a null value
	 *
	 * the owner first name "Kasabury"
	 * the owner last name is "Incorporated"
	 * the owner phone number is "180076237867"
	 * the owner chat message should have only one message
	 *         "Thank you for choosing Kasabury products"
	 *
	 */
	public KasaburyMobile() {
		/* given */
		contacts = new KasaburyContact[10];
		this.battery=25;
		this.signal=0;
		this.isphoneon=false;
		this.isconnected=false;
		//disconnectNetwork();
		this.passcode=1234;

	}

	/* returns a copy of the owner contact details
	 * return null if the phone is off
	 */
	public KasaburyContact getCopyOfOwnerContact() {
		KasaburyContact copyowner= new KasaburyContact(fname,lname,pnumber);
    if(isPhoneOn()==false){
			return null;
		}
		else
			copyowner.getFirstName();
		    copyowner.getLastName();
		    copyowner.getPhoneNumber();
		    copyowner.chatHistory[0]="Kasabury: Thank you for choosing Kasabury products";
			return copyowner;
	}


	/* only works if phone is on
	 * will add the contact in the array only if there is space and does not exist
	 * The method will find an element that is null and set it to be the contact
	 */
	public boolean addContact(KasaburyContact contact) {
		
		boolean isaddContact=false;
         if(isPhoneOn()==true){
					 for(int z=0;z<MAXIMUM_CONTACTS;z++){
	/*					if(contacts[z]==null){
							continue;
						}
	 if(contact.getLastName()!=this.contacts[z].getLastName()&&contact.getFirstName()!=this.contacts[z].getFirstName()){
               for(int y=0;y<MAXIMUM_CONTACTS;y++){
								 if(this.contacts[y]==null){
									 this.contacts[y]=contact;
									 isaddContact=true;
									 return isaddContact;
								 } 
							 } 
						 }*/
		if(contacts[z]==null){
			for(int b=0;b<10;b++){
				if(contacts[b]==contact){
					return false;
				}
			}
			this.contacts[z]=contact;
		    isaddContact=true;
			return isaddContact;
		}
					 }
				 }
			if(isPhoneOn()==false){
				 isaddContact=false;
			}
				 return isaddContact;
	}

	/* only works if phone is on
	 * find the object and set the array element to null
	 */
	public boolean removeContact(KasaburyContact contact) {
		boolean isremove=true;
       if(isPhoneOn()==true){
				 for(int x=0;x<MAXIMUM_CONTACTS;++x){
				/*	 if(contacts[x]==null){
						 continue;
					 }*/
			if(contacts[x]==contact){
						 contacts[x]=null;
					 }
				 }
				 isremove=true;
			 }
		if(isPhoneOn()==false){
			 isremove=false;
		}
		return isremove;
	}

	/* only works if phone is on
	 * return the number of contacts, or -1 if phone is off
	 */
	public int getNumberOfContacts() {
		int b=0;
	if(isPhoneOn()==true){
		for(int v=0;v<MAXIMUM_CONTACTS;v++){
			if(contacts[v]!=null){
				b=b+1;
			}
		}
		return b;
	  }
		else
		return -1;
	}

	/* only works if phone is on
	 * returns all contacts that match firstname OR lastname
	 * if phone is off, or no results, null is returned
	 */
	public KasaburyContact[] searchContact(String name) {
		KasaburyContact[] search; //= new KasaburyContact[MAXIMUM_CONTACTS];
		int h=0;
		int f=0;
		 if(isPhoneOn()==true){
			 for(int w=0;w<10;w++){
				 if(contacts[w]==null){
					 continue;
				 }
		 if(contacts[w].getLastName()==name||contacts[w].getFirstName()==name){
			 f=w;
			 h=h+1;
		 }
	  }
			
		if(h==0){
			return null;
		}
		else
			search=new KasaburyContact[h];
			 search[0]=contacts[f];
		return search;
	 }
	 else
		 return null;

	}

	/* returns true if phone is on
	 */
	public boolean isPhoneOn() {
		if(isphoneon==true){
		return true;
		}
		else
		return false;
	}

	/* when phone turns on, it costs 5 battery for startup. network is initially disconnected
	 * when phone turns off it costs 0 battery, network is disconnected
	 * always return true if turning off
	 * return true if can successfully turned on and have at least battery level 1
	 * return false if do not have enough battery level
	 */
	 public boolean setPhoneOn(boolean on) {
		if(on==true){
			if(this.battery>5){
				this.isphoneon=true;
				this.battery=this.battery-5;
				this.isconnected=false;
				return true;
			}
			if(this.battery<6){
				//this.isphoneon=false;
				return false;
			}
		}
		 if(on==false){
			 this.isphoneon=false;
			 this.isconnected=false;
			 return true;
		 }
		 return true;
	}

	/* Return the battery life leve. if the phone is off, zero is returned.
	 */
	public int getBatteryLife() {
		if(isPhoneOn()==false){
			return 0;
		}
          return this.battery;
	}

	/* Change battery of phone.
	 * On success. The phone is off and new battery level adjusted and returns true
	 * If newBatteryLevel is outside manufacturer specification of [0,100], then
	 * no changes occur and returns false.
	 */
	public boolean changeBattery(int newBatteryLevel) {
		//this.isphoneon=false;
         if(newBatteryLevel<=100&&newBatteryLevel>=0){
			         isphoneon=false;
			         this.battery=newBatteryLevel;
					 return true;
				 }
				 else 
				  
				  return false;
				 
		
	}

	/* only works if phone is on.
	 * returns true if the phone is connected to the network
	 */
	public boolean isConnectedNetwork() {
      if(isPhoneOn()==true){
		  
		if(this.signal>0){
			    //isconnected=true;
				return true;
			}
		 else 
			return false;
	  }
	   return false;
	}

	/* only works if phone is on.
	 * when disconnecting, the signal strength becomes zero
	 */
	public void disconnectNetwork() {
        if(isPhoneOn()==true){
					this.signal=0;
				}
	}

	/* only works if phone is on.
	 * Connect to network
	 * if already connected do nothing
	 * if connecting:
	 *  1) signal strength is set to 1 if it was 0
	 *  2) it will cost 2 battery life to do so
	 * returns the network connected status
	 */
	public boolean connectNetwork() {
		if(isPhoneOn()==false){
			return false;
		}
		if(this.isconnected==false&&this.signal>0){
			this.isconnected=true;
			return true;
		}
		if(this.battery<=2){
							this.battery=0;
				            //isconnected=true;
							isphoneon=false;
							return false;
						}
		if(this.isconnected==false&&this.signal==0){
			this.signal=1;
			this.battery=this.battery-2;
			/*if(this.battery<=2){
							this.battery=0;
				            //isconnected=true;
							isphoneon=false;
							return false;
						}*/
			//else
			this.isconnected=true;
			return true;
		}
		//this.isconnected=true;
		return true;
       /* if(isPhoneOn()==true) {
					if(this.signal==0){
						this.signal=1;
						this.battery=this.battery-2;
						if(this.battery<=2){
							this.battery=0;
							isphoneon=false;
							return false;
						}
						else
						return true;
					}
			       
			else if(this.signal>0&&this.signal<=5){
				
					return true;
				 }
				}
        
		  return false;*/
	}

	/* only works if phone is on.
	 * returns a value in range [1,5] if connected to network
	 * otherwise returns 0
	 */
	public int getSignalStrength() {
     if(isPhoneOn()==true){
			if(isConnectedNetwork()==true){
				return this.signal;
			}
		}

			return 0;

	}

	/* only works if phone is on.
	 * sets the signal strength and may change the network connection status to on or off
	 * signal of 0 disconnects network
	 * signal [1,5] can connect to network if not already connected
	 * if the signal is set outside the range [0,5], nothing will occur and will return false
	 */
	public boolean setSignalStrength(int x) {
         if(isPhoneOn()==true){

					 if(x<0||x>5){
						 return false;
					 }
					 else if(x==0){
						 disconnectNetwork();
						 return true;
					 }
					 else
					    this.signal=x;
					    return true;
				 }
		  return false;
    }

	/* each charge increases battery by 10
	 * the phone has overcharge protection and cannot exceed 100
	 * returns true if the phone was charged by 10
	 */
	public boolean chargePhone() {
            this.battery= this.battery+10;
						if(this.battery<=100){
							return true;
						}
						else
						this.battery=100;
						return false;
	}

	/* Use the phone which costs k units of battery life.
	 * if the activity exceeds the battery life, the battery automatically
	 * becomes zero and the phone turns off.
	 */
	public void usePhone(int k) {
        if(k>this.battery){
					this.battery=0;
			        this.isphoneon=false;
				}
				else
				this.battery=this.battery-k;
	}
}

