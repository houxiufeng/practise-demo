package com.example.demo.suanfa;

// 公司里有 n 名员工，每个员工的 ID 都是独一无二的，编号从 0 到 n - 1。公司的总负责人通过 headID 进行标识。
// 在 manager 数组中，每个员工都有一个直属负责人，其中 manager[i] 是第 i 名员工的直属负责人。对于总负责人，manager[headID] = -1。题目保证从属关系可以用树结构显示。
// 公司总负责人想要向公司所有员工通告一条紧急消息。他将会首先通知他的直属下属们，然后由这些下属通知他们的下属，直到所有的员工都得知这条紧急消息。
// 第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属（也就是说在 informTime[i] 分钟后，他的所有直属下属都可以开始传播这一消息）。
// Example:
// 输入：n = 6, headID = 2, manager = [1, 2, -1, 1, 2, 4], informTime = [0, 2, 1, 0, 3, 0]
// 输出：4

/**
 * 这题难点在于理解关系。关键点是如何画出来这个树，然后再想计算。
 * 这里有点绕的地方是：员工和manager这个表的关系。
 * 请这么理解：n = 6 表示有6个员工，他们的编号分别是0 1 2 3 4 5
 * manager[0] = x 编号0的上级的编号x,
 * 可以推算出 manager[2] = -1 意思是说2号员工是root
 * manager[1] = 2 意思是编号1的员工上级是编号为2的员工。一次类推。
 * informTime[1] = 2, 意思是1号员工通知它下属用的时间是2.
 * informTime[0] = 0, 意思是0号员工通知下属时间是0.也就是说它是叶子节点。
 *
 * https://leetcode.cn/problems/time-needed-to-inform-all-employees/description/
 *
 */
public class NoticeSumMax {

    public static void main(String[] args) {

        int[] manager = {1, 2, -1, 1, 2, 4};
        int[] informTime = {0, 2, 1, 0, 3, 0};
        System.out.println(numOfMinutes(6, manager, informTime));
    }


    public static int numOfMinutes(int n, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 过滤非叶子节点
            if (informTime[i] != 0) continue;
            // 自下而上从叶子节点员工出发
            int sum = 0, cur = i;
            //员工manager不是Root
            //cur 这个员工
            //manager[cur] 这个员工的上级编号
            //informTime[manager[cur]] 这个员工上级通知到这个员工需要时间
            while (manager[cur] != -1) {
                sum += informTime[manager[cur]];
                cur = manager[cur];
            }
            res = Math.max(res, sum);
        }
        return res;
    }


}
