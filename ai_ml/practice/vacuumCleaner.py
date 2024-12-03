grid = [
    [1,0,0],
    [0,1,1],
    [1,0,0]
]

def printGrid(grid):
    for row in grid:
        print(row)

def cleanGrid(grid):
    for x in range(len(grid)):
        for y in range(len(grid[0])):
            if(grid[x][y]==1):
                grid[x][y] = 0
                print(f"Position ({x},{y}) cleaned.")

print("Initial Grid:")
printGrid(grid)
print("\n")

print("Cleaning Grid: ")
cleanGrid(grid)
print("\n")

print("Final Grid:")
printGrid(grid)