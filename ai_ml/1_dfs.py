graph = {
    'A' : ['B','C'],
    'B' : ['D','E'],
    'C' : ['F'],
    'D' : [],
    'E' : ['F'],
    'F' : []
}

visited = set() 

def dfs(visited, graph, node): 
    if node not in visited:
        print (node)
        visited.add(node)
        for next in graph[node]:
            if next not in visited:
                dfs(visited, graph, next)

print("DFS Traversal:")
dfs(visited, graph, 'A')