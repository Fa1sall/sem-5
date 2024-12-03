from collections import defaultdict

jug1,jug2,target = 4,3,2

visited = defaultdict(lambda: False)

def waterjug_solver(amt1,amt2):
    if((amt1==target and amt2==0) or (amt2==target and amt1==0)):
        print(amt1,amt2)
        return True
    
    if visited[(amt1,amt2)] == False:
        print(amt1,amt2)
        visited[((amt1,amt2))] = True

        return (
            waterjug_solver(amt1,0) or
            waterjug_solver(0,amt2) or
            waterjug_solver(jug1,amt2) or 
            waterjug_solver(amt1,jug2) or 
            waterjug_solver(amt1+min(amt2,(jug1-amt1)),amt2-min(amt2,jug1-amt1)) or
            waterjug_solver(amt1-min(amt1,(jug2-amt2)),amt2+min(amt1,(jug2-amt2)))
        )

    else:
        return False
    
print("Water Jug Solving Steps:")
waterjug_solver(0,0)


