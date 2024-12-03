class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val = val
        self.right = right
        self.left = left

def printInorder(root):
    if root:
        printInorder(root.left)
        print(root.val)
        printInorder(root.right)

def printPreorder(root):
    if root:
        print(root.val)
        printPreorder(root.left)
        printPreorder(root.right)

def printPostOrder(root):
    if root:
        printPostOrder(root.left)
        printPostOrder(root.right)
        print(root.val)

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)

print("Inorder: ")
printInorder(root)
print("Preorder: ")
printPreorder(root)
print("PostOrder: ")
printPostOrder(root)
