package com.example.demo.suanfa;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

/**
 * 	         1
 * 	  2      3       4
 * 	5 6 7  8 9 10  11 12
 *
 * 	还是利用归化思维将无限的问题转化为最后2个元素的问题，与LinkListReverse类似，递归调用
 */
public class OrgTree {
    private static List<OrgNode> list;
    static {
        OrgNode node1 = new OrgNode(1, null, "node1");
        OrgNode node2 = new OrgNode(2, 1, "node2");
        OrgNode node3 = new OrgNode(3, 1, "node3");
        OrgNode node4 = new OrgNode(4, 1, "node4");
        OrgNode node5 = new OrgNode(5, 2, "node5");
        OrgNode node6 = new OrgNode(6, 2, "node6");
        OrgNode node7 = new OrgNode(7, 2, "node7");
        OrgNode node8 = new OrgNode(8, 3, "node8");
        OrgNode node9 = new OrgNode(9, 3, "node9");
        OrgNode node10 = new OrgNode(10, 3, "node10");
        OrgNode node11 = new OrgNode(11, 4, "node11");
        OrgNode node12 = new OrgNode(12, 4, "node12");

        list = Lists.newArrayList(node1, node11, node2, node3, node9, node4, node5, node10, node6, node7, node8, node12);
    }
    public static void main(String[] args) {

        System.out.println(getPath(11));
        System.out.println(getPathList(12));
    }


    /**
     * node1->node4->node11
     * @param id
     * @return
     */
    private static String getPath(Integer id) {
        if (id == null) {
            return "";
        }
        OrgNode orgNode = getOrgNode(id);
        if (orgNode == null) {
            return "";
        }
        //前面都是做异常判断，这里才真正开始。
        if (orgNode.getParentId() == null) {
            return orgNode.getName();
        }
        return getPath(orgNode.getParentId()) + "->" + orgNode.getName();
    }

    /**
     * [node1, node4, node12]
     * @param id
     * @return
     */
    private static List<String> getPathList(Integer id) {
        if (id == null) {
            return null;
        }
        OrgNode orgNode = getOrgNode(id);
        if (orgNode == null) {
            return null;
        }
        //前面都是做异常判断，这里才真正开始。
        if (orgNode.getParentId() == null) {
            return Lists.newArrayList(orgNode.getName());
        }
        List<String> pathList = getPathList(orgNode.getParentId());
        pathList.add(orgNode.getName());
        return pathList;
    }

    private static OrgNode getOrgNode(Integer id) {
        return list.stream().filter(orgNode -> orgNode.getId().equals(id)).findFirst().orElse(null);
    }



    @Data
    @AllArgsConstructor
    private static class OrgNode {
        Integer id;
        Integer parentId;
        String name;
    }
}
