import random 
import string

length = int(input("Enter length of password: "))
print('''Choose which characters should be included:
      1.Numbers
      2.Alphabets
      3.Special Characters
      4.Exit
      ''')

characterChoice = ""

while(True):
    choice = int(input("Enter choice: "))

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

for i in range (length):
    rand = random.choice(characterChoice)
    password+= rand

print("Password Generated: ", password)