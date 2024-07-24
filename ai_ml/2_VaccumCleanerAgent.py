def main():
    floor = []
    m = int(input("Enter No. of Rows: "))
    n = int(input("Enter No. of Columns: "))
    print("Enter status of each block (1 => dirty, 0 => clean)")

    for i in range(m):
        f = list(map(int,input().split(" ")))
        floor.append(f)
        
    clean(floor)

def print_Floor(floor,row,column):
    print("The Floor Status:")
    for i in range(len(floor)):
        for j in range(len(floor[i])):
            if(i==row & j==column):
                print(f" >{floor[i][j]}< ",end='')
            else:
                print(f"  {floor[i][j]}  ",end='')
        print(end='\n')
    print(end='\n')

def clean(floor):
    for i in range (len(floor)):
        for j in range (len(floor[i])):
            print_Floor(floor,i,j)
            if(floor[i][j]==1):
                floor[i][j]=0
                print_Floor(floor,i,j)

main()
