class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def bfs(root):
    if not root:
        return
    
    queue = [root]
    
    while queue:
        current = queue.pop(0)
        print(current.val, end=" ")
        
        if current.left:
            queue.append(current.left)
        if current.right:
            queue.append(current.right)

# Example usage:
# Constructing a simple binary tree
#         1
#        / \
#       2   3
#      / \
#     4   5

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)

bfs(root)
