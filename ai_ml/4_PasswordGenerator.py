import random
import string

length = int(input("Enter length of the password: "))
print('''Choose character set for password from these : 
         1. Digits
         2. Alphabets
         3. Special characters
         4. Exit''')
characterChoice = ""

while(True):
    choice = int(input("Enter a choice: "))
    
    if(choice==1):
        characterChoice += string.digits
    elif(choice==2):
        characterChoice += string.ascii_letters
    elif(choice==3):
        characterChoice += string.punctuation
    elif(choice==4):
        break
    else:
        print("Invalid Choice")
    
password = ""
for i in range(length):
    rand = random.choice(characterChoice)
    password += rand            

print("Generated Password: " + password)