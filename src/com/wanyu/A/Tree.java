package com.wanyu.A;

import org.junit.Test;

import java.util.*;

/**
 * Created by wanyu3 on 2018/7/30.
 */
public class Tree {
    @Test
    public void test(){
        /*
                    1
                  / \
                2   3
              / \  / \
             4  5 6  7
          / \ /
        8  9 10
         */
        Object tree[]={1,2,3,4,5,6,7,8,9,10};
        BinTree binTree = new BinTree();
        binTree.createBinTree(tree);
        binTree.preOut(binTree.root);
        System.out.println();
        binTree.inOut(binTree.root);
        System.out.println();
        binTree.tailOut(binTree.root);
        System.out.println();
        binTree.levelOut(binTree.root);
        System.out.println();
        binTree.deepOut(binTree.root);
    }
    public class BinTree{
        BinTree leftNode;
        BinTree rightNode;
        Object data;
        BinTree root;
        public BinTree(){

        }
        public BinTree(Object data){
            this.data = data;
        }
        public void initBinTree(BinTree leftNode,BinTree rightNode,int data){
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.data = data;
        }
        public void createBinTree(Object[] tree){
            ArrayList<BinTree> treeList = new ArrayList();
            for (Object o:tree) {
                treeList.add(new BinTree(o));
            }
            root = treeList.get(0);//头结点
            for(int i = 0;i < treeList.size()/2;i++){
                treeList.get(i).leftNode = treeList.get(i*2+1);
                if(i*2+2<treeList.size()){
                    treeList.get(i).rightNode = treeList.get(i*2+2);
                }
            }
        }
        //前序遍历
        public void preOut(BinTree tree){
            if(tree != null){
                System.out.print(tree.data+" ");
                preOut(tree.leftNode);
                preOut(tree.rightNode);
            }
        }
        //中序遍历
        public void inOut(BinTree tree){
            if(tree != null){
                inOut(tree.leftNode);
                System.out.print(tree.data+" ");
                inOut(tree.rightNode);
            }
        }
        //后序遍历
        public void tailOut(BinTree tree){
            if(tree != null){
                tailOut(tree.leftNode);
                tailOut(tree.rightNode);
                System.out.print(tree.data+" ");
            }
        }
        //广度遍历
        public void levelOut(BinTree tree){
            ArrayDeque<BinTree> deque = new ArrayDeque<BinTree>();
            if(tree == null){
                System.out.print("没有根节点");
                return;
            }
            deque.add(tree);
            while(deque.size()>0){
                BinTree delTree = deque.remove();
                System.out.print(delTree.data+" ");
                if(delTree.leftNode != null){
                    deque.add(delTree.leftNode);
                }
                if(delTree.rightNode != null){
                    deque.add(delTree.rightNode);
                }
            }
        }
        //深度遍历
        public void deepOut(BinTree tree){
            Stack<BinTree> stack = new Stack<BinTree>();
            stack.push(tree);
            while(!stack.isEmpty()){
                BinTree delTree = stack.pop();
                System.out.print(delTree.data+" ");
                if(delTree.rightNode != null ){
                    stack.push(delTree.rightNode);
                }
                if(delTree.leftNode != null){
                    stack.push(delTree.leftNode);
                }
            }
        }
    }
}
