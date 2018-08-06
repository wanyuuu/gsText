package com.wanyu.B;

import com.wanyu.A.Tree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wanyu3 on 2018/8/6.
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
/*
             8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 */
public class Q {

    public class TreeNode{
        TreeNode leftNode;
        TreeNode rightNode;
        Object data;
        public TreeNode(){

        }
        public TreeNode(Object data){
            this.data = data;
        }
    }
     TreeNode root;
    @Test
    public void test(){
        root = new TreeNode();
        Object arr[] = {8,6,10,5,7,9,11};
        createTree(arr);
        Mirror(root);
        System.out.println(root.leftNode.data);
        System.out.println(root.rightNode.data);
    }
    public  void createTree(Object arr[]){
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        for (Object a:arr) {
            list.add(new TreeNode(a));
        }
        root = list.get(0);
        for(int i = 0; i < list.size()/2; i++){
            list.get(i).leftNode = list.get(i*2+1);
            if(i*2+2<list.size()){
                list.get(i).rightNode = list.get(i*2+2);
            }
        }
    }
    public void Mirror(TreeNode root) {
        if(root == null){
            return ;
        }
        if(root.leftNode == null && root.rightNode == null){
            return ;
        }
        //左右子节点交换
        TreeNode tmp = root.leftNode;
        root.leftNode = root.rightNode;
        root.rightNode = tmp;

        if(root.leftNode != null){
            Mirror(root.leftNode);
        }
        if(root.rightNode != null){
            Mirror(root.rightNode);
        }
    }
}
