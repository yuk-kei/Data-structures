class SegmentTreeNode:
    def __init__(self, L, R, sum=0):
        self.L = L
        self.R = R
        self.left = None
        self.right = None
        self.sum = sum


class SegmentTree:

    def __init__(self, nums):
        self.nums = nums
        self.root = self.build_tree(0, len(nums) - 1)

    def build_tree(self, L, R):
        if (L == R):
            return SegmentTreeNode(L, R, self.nums[L])
        M = (L + R) // 2
        curr = SegmentTreeNode(L, R)
        curr.left = self.build_tree(L, M)
        curr.right = self.build_tree(M + 1, R)
        curr.sum = curr.left.sum + curr.right.sum

        return curr

    def update(self, index: int, val: int) -> None:
        self.update_for(self.root, index, val)

    def update_for(self, root, index, val):
        if root.L == root.R:
            root.sum = val
            return

        M = (root.L + root.R) // 2
        if index <= M:
            self.update_for(root.left, index, val)
        else:
            self.update_for(root.right, index, val)

        root.sum = root.left.sum + root.right.sum

    def query(self, L: int, R: int) -> int:
        return self.query_for(self.root, L, R)

    def query_for(self, root, L, R):
        if root.L == L and root.R == R:
            return root.sum

        M = (root.L + root.R) // 2
        if R <= M:
            return self.query_for(root.left, L, R)
        elif L > M:
            return self.query_for(root.right, L, R)
        else:
            return self.query_for(root.left, L, M) + self.query_for(root.right, M + 1, R)
