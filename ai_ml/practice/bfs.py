graph = {
    'A': ['B','C'],
    'B': ['D','E'],
    'C': ['F'],
    'D':[],
    'E':['F'],
    'F':[]
}

visited = []
queue = []

def bfs(graph,node,visited):
    if node not in visited:
        visited.append(node)
        queue.append(node)

    while(queue):
        m = queue.pop(0)
        print(m,end=" ")

        for next in graph[m]:
            if next not in visited:
                visited.append(next)
                queue.append(next)

print("BFS Traversal:")
bfs(graph,'A',visited)