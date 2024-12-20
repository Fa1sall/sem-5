from collections import deque

class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val = val
        self.left = left
        self.right = right

def bfs(root):
    if not root:
        return
    
    queue = deque([root])
    while(queue):
        node=queue.popleft()
        print(node.val,end=" ")

        if(node.left):
            queue.append(node.left)
        if(node.right):
            queue.append(node.right)

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)

bfs(root)