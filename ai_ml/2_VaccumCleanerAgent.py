def initialize_grid():
    rows = int(input("Enter number of rows: "))
    cols = int(input("Enter number of columns: "))
    
    grid = []
    print("Enter the grid values row by row (separate values with spaces):")
    for _ in range(rows):
        row = list(map(int, input().strip().split()))
        grid.append(row)
    
    return grid

def print_grid(grid):
    for row in grid:
        print(row)

def clean_all(grid):
    for x in range(len(grid)):
        for y in range(len(grid[0])):
            if grid[x][y] == 1:
                grid[x][y] = 0
                print(f"Position ({x}, {y}) cleaned.")

def vacuum_cleaner_problem():
    grid = initialize_grid()
    print("\nInitial grid:")
    print_grid(grid)
    
    print("\nCleaning process:")
    clean_all(grid)
    
    print("\nFinal grid:")
    print_grid(grid)

vacuum_cleaner_problem()
