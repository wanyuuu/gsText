package com.wanyu.B;

import java.util.ArrayList;

/**
 * Created by wanyu3 on 2018/4/26.
 * 重建二叉树
 */
public class D {
    public static void main(String[] args) {
        Object obj[]={3,1,2,5,7,10,9,20};
        BinTree bin=new BinTree();
        bin.createTree(obj);
        bin.preorder(bin);
    }
}
class BinTree{
    private BinTree leftChild;
    private BinTree rightChild;
    private BinTree root;
    private Object data;
    private ArrayList<BinTree> datas;
    public BinTree(BinTree leftChild,BinTree rightChild,Object data){
        this.leftChild=leftChild;
        this.rightChild=rightChild;
        this.data=data;
    }
    public BinTree(Object data){
        this(null,null,data);
    }
    public BinTree(){
        super();
    }
    public void createTree(Object[] objs){
        datas=new ArrayList<BinTree>();
        for(Object o:objs){
            datas.add(new BinTree(o));
        }
        root=datas.get(0);
        for(int i=0;i<objs.length/2;i++){
            datas.get(i).leftChild=datas.get(i*2+1);
            if(i*2+2<datas.size()){
                datas.get(i).rightChild=datas.get(i*2+2);
            }
        }
    }
    public void preorder(BinTree root){
        if (root != null) {
            System.out.println(root.getData());
            preorder(root.leftChild);
            preorder(root.rightChild);
        }
    }
    public void inorder(BinTree root){
        if(root!=null){
            preorder(root.leftChild);
            System.out.println(root.getData());
            preorder(root.rightChild);
        }
    }
    public void tailorder(BinTree root){
        if(root!=null){
            preorder(root.leftChild);
            preorder(root.rightChild);
            System.out.println(root.getData());
        }
    }
    public Object getData(){
        return this.data;
    }
}