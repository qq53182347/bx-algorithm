package com.banxian.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liughl on 2020/10/29.
 */
public class Test101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        root.left=left1;
        TreeNode left2 = new TreeNode(3);
        left1.left=left2;
        TreeNode left3 = new TreeNode(4);
        left1.right=left3;

        TreeNode right1 = new TreeNode(2);
        root.right=right1;
        TreeNode right2 = new TreeNode(3);
        TreeNode right3 = new TreeNode(4);
        right1.right=right2;
        right1.left=right3;
        System.out.println( isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return cmp(root.left, root.right);
    }

    private static boolean cmp(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return cmp(node1.left, node2.right) && cmp(node1.right, node2.left);
    }



    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

}
