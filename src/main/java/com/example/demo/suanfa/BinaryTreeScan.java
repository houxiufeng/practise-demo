package com.example.demo.suanfa;

import com.example.demo.vo.TreeNode;

import java.util.*;

/**
 * https://developer.aliyun.com/article/756316
 * 深度优先遍历（Depth First Search, 简称 DFS）一般用递归或栈的方式
 * https://juejin.cn/post/6844904038236962830
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 * 中序遍历：左子树---> 根结点 ---> 右子树
 * 后序遍历：左子树 ---> 右子树 ---> 根结点
 * 前：1 2 4 8 9 5 10 3 6 7
 * 中：8, 4, 9, 2, 10, 5, 1, 6, 3, 7
 * 后：8, 9, 4, 10, 5, 2, 6, 7, 3, 1
 * 怎么样找前中后这里有参考 https://www.bilibili.com/video/BV1Ub4y147Zv/?spm_id_from=333.880.my_history.page.click&vd_source=a829e69232988cd1691360547865a27a
 * 前：画个点在左边，用一根线穿起来。
 * 中：画个点在下边，用一根线穿起来。
 * 后：画个点在右边，用一根线穿起来。
 *
 * 知道条件如何画图： https://www.bilibili.com/video/BV1Xu411d7qf/?vd_source=a829e69232988cd1691360547865a27a
 *
 * 广度优先遍历（Breath First Search）一般用队列
 */
public class BinaryTreeScan {
    public static void main(String[] args) {
        TreeNode<Integer> b1 = new TreeNode<Integer>(1);
        TreeNode<Integer> b2 = new TreeNode<Integer>(2);
        TreeNode<Integer> b3 = new TreeNode<Integer>(3);
        TreeNode<Integer> b4 = new TreeNode<Integer>(4);
        TreeNode<Integer> b5 = new TreeNode<Integer>(5);
        TreeNode<Integer> b6 = new TreeNode<Integer>(6);
        TreeNode<Integer> b7 = new TreeNode<Integer>(7);
        TreeNode<Integer> b8 = new TreeNode<Integer>(8);
        TreeNode<Integer> b9 = new TreeNode<Integer>(9);
        TreeNode<Integer> b10 = new TreeNode<Integer>(10);
        b1.left(b2);
        b1.right(b3);
        b2.left(b4);
        b2.right(b5);
        b3.left(b6);
        b3.right(b7);
        b4.left(b8);
        b4.right(b9);
        b5.left(b10);

//        dfs(b1);
//        System.out.println("--------------");
//        stackDFS(b1);
//        System.out.println(stackMidDFS(b1));
//        System.out.println(inOrderTraversal(b1));
        System.out.println(postOrderTraversalByDeque(b1));

//        bfs(b1);
//        List<List<Integer>> lists = bfsResult(b1);
//        System.out.println(lists);
//        List<List<Integer>> lists2 = bfsResult2(b1);
//        System.out.println(lists2);


    }

    /**
     * DFS
     * @param treeNode
     */
    public static void dfs(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.value());
        dfs(treeNode.left());
        dfs(treeNode.right());

    }

    /**
     * DFS
     * 用栈的方式先序遍历 root->left->right
     * @param root
     */
    public static void stackDFS(TreeNode<Integer> root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode element = stack.pop();
            System.out.println(element.value());
            if (element.right()!= null) {
                stack.push(element.right());
            }
            if (element.left()!= null) {
                stack.push(element.left());
            }
        }
    }

    /**
     * DFS
     * 用栈的方式中序遍历 left->root->right
     * 重点理解：先所有左节点入栈。后面pop 出来的就是 root
     * @param root
     */
    public static List<Integer> stackMidDFS(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode<Integer> currentNode = root;
        while(!stack.isEmpty() || currentNode != null) {
            while (currentNode!= null) {
                stack.push(currentNode);
                currentNode = currentNode.left();
            }
            if (!stack.isEmpty()) {
                currentNode = stack.pop();
//                System.out.println(currentNode.value());
                list.add(currentNode.value());
                currentNode = currentNode.right();
            }
        }
        return list;
    }

    /**
     * 官方例子，中序遍历
     * @param root
     * @return
     */
    public static List<Integer> inOrderTraversal(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode<Integer> curNode = root;
        while(!stack.isEmpty() || curNode != null) {

            //这一部分实现了递归添加左节点的作用。
            //首先遍历左子节点，包括根节点都入栈，由于是中序遍历，所以根节点在左子树全部
            //节点出栈完毕之后跟着出栈，然后根节点的右子树再走一遍这个相同循环流程
            while(curNode != null) {
                stack.push(curNode);
                curNode = curNode.left();
            }

            //这一部分实现了对根节点的遍历，同时将指针指向了右子树，在下轮中遍历右子树。
            //每次出栈即遍历完一个节点，需要把当前节点的指针移动到右子节点，不管当前节点
            //的右子节点是否为null。如果是null，下次循环就直接走到出栈流程，把当前节点的
            //根节点弹出（此处以左子节点为例：根节点早于左子节点入栈），此时该
            //根节点刚好有右子节点，指针移动到右子节点，接着继续执行相同的循环。直到当前
            //节点和栈都为空，表明遍历结束。
            if(!stack.isEmpty()) {
                curNode = stack.pop();
                list.add(curNode.value());
                curNode = curNode.right();
            }
        }
        return list;
    }

    /**
     * 双向队列法和先序遍历迭代的区别只是使用了 Deque 这种链表数据结构，每次都
     * 从链表头插入新节点。由于 LinkedList 本身已经实现了 Deque 接口和List接口，因此
     * LinkedList 可以作为一个双向队列来使用，同时本身也是List的实现类。可以很方便地
     * 实现将新节点插入到表头的需求。
     */
    public static List<Integer> postOrderTraversalByDeque(TreeNode root) {
        LinkedList<Integer> resultList = new LinkedList<>();
        if (root == null) return resultList;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode<Integer> curNode;
        while(!stack.isEmpty()) {
            curNode = stack.pop();
            resultList.addFirst(curNode.value());
            if (curNode.left() != null) {
                stack.push(curNode.left());
            }
            if (curNode.right() != null) {
                stack.push(curNode.right());
            }

        }
        return resultList;
    }

    /**
     * bfs广度优先
     * 广度遍历即我们平常所说的层次遍历
     * @param treeNode
     */
    public static void bfs(TreeNode<Integer> treeNode) {
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode<Integer> element = queue.poll();
            System.out.println(element.value());
            if (element.left() != null) {
                queue.add(element.left());
            }
            if (element.right()!= null) {
                queue.add(element.right());
            }
        }
    }

    /**
     * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
     * 102. 二叉树的层序遍历 [中等]
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
     * 重点: for循环是说你当前放到queue里面的数据，我一次性给你处理完，至于处理中又放进queue的数据就是下一层的数据了。
     */
    public static List<List<Integer>> bfsResult(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode<Integer> node = queue.poll();
                if (node.value() != null) {
                    layer.add(node.value());
                }
                if (node.left() != null) {
                    queue.add(node.left());
                }
                if (node.right() != null) {
                    queue.add(node.right());
                }
            }
            result.add(layer);
        }
        return result;
    }

    /**
     * 上面问题的变种，稍微改下，思路就是用一个n表示层级,当是偶数行的就正常list.add(); 奇数行就list.add(0,value);
     * @param root
     * @return
     */
    public static List<List<Integer>> bfsResult2(TreeNode<Integer> root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        int n = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> poll = queue.poll();
                if (poll.value()!= null) {
                    if (n % 2 == 0) {
                        layer.add(poll.value());
                    } else {
                        layer.add(0, poll.value());
                    }
                }
                if (poll.left() != null) {
                    queue.add(poll.left());
                }
                if (poll.right() != null) {
                    queue.add(poll.right());
                }
            }
            result.add(layer);
            n++;
        }
        return result;
    }
}
