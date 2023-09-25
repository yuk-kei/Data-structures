package SegmentTree;

class SegmentTree {

    private SegmentTreeNode root = null;

    public SegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length -1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end){
        if (start > end){
            return null;
        }

        SegmentTreeNode curr = new SegmentTreeNode(start, end);
        if (start == end) {
            curr.sum = nums[start];
        } else{
            int mid = start + (end - start) / 2;
            curr.left = buildTree(nums, start, mid);
            curr.right = buildTree(nums, mid + 1, end);
            curr.sum = curr.left.sum + curr.right.sum;
        }

        return curr;
    }
    public void update(int index, int val) {
        update(root, index, val);

    }

    private void update(SegmentTreeNode root, int index, int value){
        if (root.start == root.end){
            root.sum = value;
            return;
        }
        int mid = root.start + (root.end - root.start) /2 ;
        if (index <= mid){
            update(root.left, index, value);
        } else {
            update(root.right, index, value);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int query(int i, int j) {
        return query(root, i, j);
    }

    private int query(SegmentTreeNode root, int start, int end){
        if(root.end == end && root.start == start){
            return root.sum;
        }

        int mid = root.start + (root.end - root.start) /2;

        if(mid >= end){
            return query(root.left, start, end);
        } else if(mid < start){
            return query(root.right, start, end);
        } else {
            return query(root.left, start, mid) + query(root.right, mid + 1, end);
        }
    }
}
