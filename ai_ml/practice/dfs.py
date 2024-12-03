graph = {
    'A': ['B','C'],
    'B': ['D','E'],
    'C': ['F'],
    'D':[],
    'E':['F'],
    'F':[]
}

def dfs(graph,node,visited=None):
    if visited is None:
        visited = set()
    visited.add(node)
    print(node,end=' ')

    for next in graph[node]:
        if next not in visited:
            dfs(graph,next,visited)

print('DFS Traversal:')
dfs(graph,'A')
