贪心算法：贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法策略。
有关动态规划的问题，大多是让你求最值的，比如最长子序列，最小编辑距离，最长公共子串等等等。这就是规律，因为动态规划本身就是运筹学里的一种求最值的算法。
千万不要看不起暴力解，动态规划问题最困难的就是写出状态转移方程，即这个暴力解。优化方法无非是用备忘录或者 DP table，再无奥妙可言。
递归处理逻辑相似的问题,大化小。
a[i] = a[j]理解为把a[j]这个位置的值挖出来，放在a[i]的位置上。这时a[j]就相当于一个空缺位置了。
index = index % list.size(); 表示某个数字在一个环中的位置。

while(head1 != null && head2 != null) 一般有两个序列都需要轮训的时候用这个方法，很好用
链表问题可以加一个dummyNode这样好处理，最后可以dummy.next() 返回头部节点。

DFS:深度优先算法一般用递归和栈来解决。
BFS:广度优先算法用queue = new LinkedList() 来解决。

类型上界，这里的?可以是T类型或者T的子类类型。 不允许添加
假设List<? extends T>能添加元素，那么需要满足添加的任意元素需要能够直接转化成T的任何一个子类，T的子类A和子类B是不能相互转化的，显然该list是不能添加元素的。

类型下界，这里的?可以是T类型或者T的超类类型。  允许添加
假设List<? super T>能添加元素，那么同样需要满足添加的任意元素能够直接转化成T的任何一个超类。此时添加T的子类元素就能满足该要求，因为T的任意子类可以向上转型成T的任何超类。

我们不能添加任何对象到 List<? extends T> 中, 因为我们不能确定一个 List<? extends T> 对象实际的类型是什么,
因此就不能确定插入的元素的类型是否和这个 List 匹配. List<? extends T> 唯一能保证的是我们从这个 list 中读取的元素一定是一个 T 类型的.

对于 List<? super Integer> l1:

正确的理解: ? super Integer 限定的是泛型参数. 令 l1 的泛型参数是 T, 则 T 是 Integer 或 Integer 的父类, 因此 Integer 或 Integer 的子类的对象就可以添加到 l1 中.
错误的理解: ? super Integer 限定的是插入的元素的类型, 因此只要是 Integer 或 Integer 的父类的对象都可以插入 l1 中

对于 List<? extends Integer> l2:

正确的理解: ? extends Integer 限定的是泛型参数. 令 l2 的泛型参数是 T, 则 T 是 Integer 或 Integer 的子类, 进而我们就不能找到一个类 X, 使得 X 是泛型参数 T 的子类, 因此我们就不可以向 l2 中添加元素. 不过由于我们知道了泛型参数 T 是 Integer 或 Integer 的子类这一点, 因此我们就可以从 l2 中读取到元素(取到的元素类型是 Integer 或 Integer 的子类), 并可以存放到 Integer 中.
错误的理解: ? extends Integer 限定的是插入元素的类型, 因此只要是 Integer 或 Integer 的子类的对象都可以插入 l2 中