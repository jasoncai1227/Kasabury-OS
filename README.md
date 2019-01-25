# Kasabury-OS

You are tasked with writing a phone OS for Kasabury Mobile that will be installed on their products. You are required to write the software using the Java programming language. Kasabury OS must support the following features:

Battery life
Network connection
Signal Strength
Charging a phone
Manage contact data
Being able to copy contacts
Delete contacts
Add contacts
Update contact details
Copy contacts
Manage messages
Add messages
Clear messages
Get latest and oldest messages
The given properties of the class cannot be removed and their data type and modifiers cannot be changed. You are not allowed to use any collection classes from the Java standard library besides array.

You are provided with a scaffold and comments that describe the methods required to implement. Each method's comments desribes the process necessary to implement.

# Factory Defaults

Every phone manufactured and installed with Kasabury OS. The default factory settings are:

Phone is off
Phone has battery life (25)
Not connected to a network
No Signal (signal strength is 0)
Owner contact factory default on the device:

First Name: Kasabury
Last Name: Incorporated
Phone Number: 180076237867
One message should be included under this contact: "Kasabury" says "Thank you for choosing Kasabury products".
Stored as "Kasabury: Thank you for choosing Kasabury products"
The contact list should not contain ANY other contacts on first boot.
If the factory defaults do not match it can be suspected that the hardware contains a fault and requires inspection. By ensuring the software clearly adheres to the correctness of what is specified, this can be ruled out.

# Battery and Charging

The OS needs to keep track of the battery level and implement functions related to battery changing, charging and status. The battery level is represented as an integer between 0 and 100 inclusive. [0, 100]

isPhoneOn
getBatteryLife
changeBattery
chargePhone
usePhone
setPhoneOn
isPhoneOn

This method checks if the phone is on or not

# getBatteryLife

Retrieves the battery life which is represented as value between 0 and 100.

# changeBattery

Changes the battery and therefore changing the battery level. The phone is switched to the off state after this operation and the battery life is updated. If the new battery’s level is outside of the range accepted (n < 0 OR n > 100) then it should be rejected and no update should occur.

# chargePhone

The phone is charged and battery life increases by 10. In the event that the battery life exceeds 100, the charge becomes 100. A charge would not occur and the method should return false in the event that nothing has changed.

# usePhone

will reduce the battery level by k units of battery level. The phone will turn off if the use causes the battery level to reach 0.

# setPhoneOn

Turning the phone on will reduce the battery level by 5, if the battery level is < 6 the phone should not power on.

Network Connectivity and Signal

A baseline feature to a phone is determining the network connectivity status and updating it.

The network status has two parts. Network is connected and Signal strength. Signal strength is represented as a range between 0 and 5 inclusive [0,5]. 0 representing that the phone is not connected to a network while all numbers > 0 infer that the phone is connected to a network.

isConnectedNetwork
disconnectNetwork
connectNetwork
getSignalStrength
setSignalStrength
isConnectedNetwork

Reports if the phone is connected to a network

# connectNetwork

Connects to a network if needed otherwise does nothing. When connecting to network, sets the signal strength to 1 if the signal strength is currently set to 0. Sets the signal strength to the last known value of signal strength if it is not currently set to 0. If the network needs to connect, this process will reduce the battery life by 2.

# disconnectNetwork

Disconnects from a network and sets the signal strength to 0

# getSignalStrength

Returns an integer value between 0 and 5 [0,5], that represents the signalStrength

# setSignalStrength

Sets the signal strength to n, where n must be in the range of [0,5]. If n is inside of the range of [0,5] the method will be successful.

If the phone is not connected to a network and n > 0, it will connect to a network and reduce the battery life by 2.

If the network is connected to a network, the signal strength value is updated. If the signal strength is zero, it will disconnect the network, while a signal strength of > 0 will not change the network connected status.

If n is outside of the range of [0,5], or the phone is off, this method should not affect the mobile and specify that it did not successfully update.

# Contact Management

The OS allows for the user to manage contacts by being able to search, remove and add contacts. The maximum number of contacts that can be stored on the device is 10 plus the owner contact.

The following methods require to be implemented:

searchContact
addContact
removeContact
getCopyOfOwnerContact
getNumberOfContacts
searchContact

A user would want to find contacts that are stored on their phone. Given a name a user could use an input, the OS should check to see if the contact’s first name or last name match the given input.

The method can return more than one result if the string is matched multiple times. If the phone is off, the method should not proceed to execute and instead return no entries.

# addContact

Given a KasaburyContact, the OS should add this contact to the contact list. Only when there is enough space to do so. If phone is off, the method should not add a contact and return that adding the contact failed.

# removeContact

Given a KasaburyContact, the OS should remove this contact from the contact list. It is successful if the contact was found and removed. Otherwise failed. If phone is off, the method should not remove a contact and return that adding the contact failed. Invalid contact, such as null, will result in fail.

# getNumberOfContacts

Return the number of active contacts. This is possibly less than the maximum.

# Contacts

A baseline feature that is required to be implemented is contact management. Each contact has a:

First name
Last Name
Phone Number, cannot be less than 6 digits or greater than 14 digits.
and Chat History
The fields First Name, Last Name and Phone Number can be updated by the user. A first and last name can be of any length and cannot be set to null. Each contact will have these methods associated with it:

getFirstName
getLastName
getPhoneNumber
updateFirstName
updateLastName
updatePhoneNumber
copy
# getFirstName, getLastName, getPhoneNumber

Retrieves the respective properties associated with the method name.

# updateFirstName, updateLastName, updatePhoneNumber

Allows updating/changing the properties associated with the method name.

# copy

This method allows a contact to be duplicated, this would be used if a contact has two phone numbers and the user would like to duplicate the user and update the phone number on one of them. This method should create a copy of KasaburyContact object.

# Messaging

Messages are stored for each contact on the phone. Each contact can contain a maximum of 20 messages and once messages exceed that limit it will overwrite existing messages.

There are 5 methods that are required to be implemented:

addChatMessage
getLastMessage
getOldestMessage
clearChatHistory
addChatMessage

When a message is sent to the phone, the Kasabury OS needs to store it and be able to retrieve it based on the contact.

The message format of a chat message when stored in the chat history is  whoSaidIt + ": " + message. When two contacts communicate, the first name is whoSaidIt.

# getLastMessage

This method should retrieve the last message from a contact, if this contact has no messages, the method should return null.

# getOldestMessage

This method should retrieve the oldest message in the chat history for a contact.
