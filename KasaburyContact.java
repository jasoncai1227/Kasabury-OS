
/**
 * Kasabury Mobile Phone Contact Class.
 *
 * INFO1103 Assignment 3, Semester 1, 2017.
 *
 * KasaburyContact
 *
 * == Contact data ==
 * Each KasaburyContact stores the first name, last name and phone number of a person.
 * These can be queried by calling the appropriate get method. They are updated
 * with new values. The phone number can only be a 6 - 14 digit number.
 * The chat history is also stored.
 *
 *
 * == Chat history ==
 * Each KasaburyContact stores the history of chat messages related to this contact.
 * Suppose there is a conversation between Angus and Beatrice:
 *
 * Angus: Man, I'm so hungry! Can you buy me a burrito?
 * Beatrice: I don't have any money to buy you a burrito.
 * Angus: Please? I haven't eaten anything all day.
 *
 * Each time a message is added the name of the person and the message is
 * combined as above and recorded in the sequence it was received.
 *
 * The messages are stored in the instance variable String array chatHistory. Provided for you.
 * Unfortunately there are only 20 messages maximum to store and no more.
 * When there are more than 20 messages, oldest messages from this array are discarded and
 * only the most recent 20 messages remain.
 *
 * The functions for chat history are
 *   addChatMessage
 *   getLastMessage
 *   getOldestMessage
 *   clearChatHistory()
 *
 * Using the above conversation as an example
 *   addChatMessage("Angus", "Man, I'm so hungry! Can you buy me a burrito?");
 *   addChatMessage("Beatrice", "I don't have any money to buy you a burrito.");
 *   addChatMessage("Angus", "Please? I haven't eaten anything all day.");
 *
 *   getLastMessage() returns "Angus: Please? I haven't eaten anything all day."
 *   getOldestMessage() returns "Angus: Man, I'm so hungry! Can you buy me a burrito?"
 *
 *   clearChatHistory()
 *   getLastMessage() returns null
 *   getOldestMessage() returns null
 *
 *
 * == Copy of contact ==
 * It is necessary to make copy of this object that contains exactly the same data.
 * There are many hackers working in other parts of Kasabury, so we cannot trust them
 * changing the data. A copy will have all the private data and chat history included.
 *
 *
 * Please implement the methods provided, as some of the marking is
 * making sure that these methods work as specified.
 *
 * @author A INFO1103 tutor.
 * @date April, 2017
 *
 */
public class KasaburyContact
{
	public static final int MAXIMUM_CHAT_HISTORY = 20;
     private  String fname; //= "Kasabury";
	private  String lname; //= "Incorporated";
	private String pnumber;// = "180076237867";

	//public static int i = 1;

	/* given */
	protected String[] chatHistory;


	public KasaburyContact(String fname, String lname, String pnumber) {
		/* given */
		chatHistory = new String[20];
	   	chatHistory[0]=null;
	/*	for(int q=1;q<20;q++){
			chatHistory[q]=null;
		}*/
		this.fname=fname;
		this.lname=lname;
		this.pnumber=pnumber;
	}

	public String getFirstName() {
      return this.fname;
	}
	public String getLastName() {
  		return this.lname;
	}
	public String getPhoneNumber() {
			return this.pnumber;
	}

	/* if firstName is null the method will do nothing and return
	 */
	public void updateFirstName(String firstName) {
			if(firstName==null){
				return;
			}
			this.fname=firstName;
	}
	/* if lastName is null the method will do nothing and return
	 */
	public void updateLastName(String lastName) {
				if(lastName==null){
					return;
				}
			this.lname=lastName;
	}

	/* only allows integer numbers (long type) between 6 and 14 digits
	 * no spaces allowed, or prefixes of + symbols
	 * leading 0 digits are allowed
	 * return true if successfully updated
	 * if number is null, number is set to an empty string and the method returns false
	 */
	public boolean updatePhoneNumber(String number) {
		boolean isupdate = false;
			if(number==null){
				this.pnumber="";
				isupdate=false;
			}
			else if(number.length()>5&&number.length()<=14){
				for(int digit=0; digit<number.length();digit++){
					if(Character.isDigit(number.charAt(digit))==false){
						isupdate=false;
					}
					else if(Character.isDigit(number.charAt(digit))==true){
					this.pnumber=number;
					isupdate=true;
					}
				}
			}
		   
			return isupdate;
	}

	/* add a new message to the chat
	 * The message will take the form
	 * whoSaidIt + ": " + message
	 *
	 * if the history is full, the oldest message is replaced
	 * Hint: keep track of the position of the oldest or newest message!
	 */
	public void addChatMessage(String whoSaidIt, String message) {
		    
	/*	     this.chatHistory[i]=whoSaidIt + ": " + message;
			
				if(i==20){
					for(int u=0;u<19;u++){
						this.chatHistory[u]=this.chatHistory[u+1];
						i=19;
					}
				}
		        
		        i=i+1;
				*/
		    
	for(int c=0;c<20;c++){
      if(chatHistory[c]==null){
			chatHistory[c]=whoSaidIt+": "+message;
	  }
			
			}
		if (chatHistory[19]!=null){
		chatHistory[19]=whoSaidIt+": "+message;
		for(int b=0;b<19;b++){
		chatHistory[b]=chatHistory[b+1];
								}
						}
	}

	/* after this, both last and oldest message should be referring to index 0
	 * all entries of chatHistory are set to null
	 */
	public void clearChatHistory() {
    for(int a=0;a<20;a++){
			chatHistory[a] = null;
		}
	}

	/* returns the last message this contact sent
	 * if no messages, returns null
	 */
	public String getLastMessage() {
		int k=0;
    for(int j=0;j<20;j++){
			if(chatHistory[j]==null){
				continue;
			}
			else if(chatHistory[j]!=null){
				k=j;
			}
		}
		if(k==0&&chatHistory[0]==null){
			return null;
		}
		
		else
		return chatHistory[k];
	}

	/* returns the oldest message in the chat history
	 * depending on if there was ever MAXIMUM_CHAT_HISTORY messages
	 * 1) less than MAXIMUM_CHAT_HISTORY, returns the first message
	 * 2) more than MAXIMUM_CHAT_HISTORY, returns the oldest
	 * returns null if no messages exist
	 */
	public String getOldestMessage() {
	    for(int n=0;n<20;n++){
		    if(this.chatHistory[n]==null&&n==0){
				return null;
			}
			else if(this.chatHistory[n]==null&&n!=0){
				return chatHistory[0];
			}
			else if(this.chatHistory[n]!=null){
				continue;
			}
		}
		return this.chatHistory[0];
	}


	/* creates a copy of this contact
	 * returns a new KasaburyContact object with all data same as the current object
	 */
public KasaburyContact copy()
	{
		KasaburyContact copy=new KasaburyContact(fname,lname,pnumber);
        copy.getFirstName();
		copy.getLastName();
		copy.getPhoneNumber();
	    

		return copy;
  }

	/* -- NOT TESTED --
	 * You can impelement this to help with debugging when failing ed tests
	 * involving chat history. You can print whatever you like
	 * Implementers notes: the format is printf("%d %s\n", index, line);
	 */
	public void printMessagesOldestToNewest() {
       System.out.printf("%s, %s, %s, %s,", this.fname, this.lname, this.pnumber, chatHistory[0]);
	}
}

