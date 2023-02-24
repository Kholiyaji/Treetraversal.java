import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarTreesYT {
    static class Node{
        int data;
        Node left;
        Node Right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.Right=null;
        }

    }
    static class BinaryTree{
        static int indx=-1;
        public static Node buildTree(int nodes[]){
            indx++;
            if(nodes[indx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[indx]);
            newNode.left=buildTree(nodes);
            newNode.Right=buildTree(nodes);
            return newNode;
        }
    }
public static void preorder(Node root){
        if(root==null){
            return ;
        }
    System.out.println("preorder="+root.data+"");
    preorder(root.left);
    preorder(root.Right);
}
public static void inorder(Node root){
        if(root==null)
            return ;
        inorder(root.left);
    System.out.println("inorder="+root.data);
    inorder(root.Right);
}
public static void postorder(Node root){
        if(root==null)
            return ;
        postorder(root.left);
        postorder(root.Right);
    System.out.println("postorder"+root.data);
}
public static void levelOrder(Node root){
    Queue<Node>q=new LinkedList<>();
    q.add(root);
    q.add(null);
    while(!q.isEmpty()){
        Node currnode=q.remove();
        if(currnode==null){
            System.out.println();
            if(q.isEmpty()){
                break;
            }
            else{
                q.add(null);
            }
        }
        else{
            System.out.println(currnode.data);
            if(currnode.left!=null){
                q.add(currnode.left);
            }
            if(currnode.Right!=null){
                q.add(currnode.Right);
            }
        }

    }

}



    public static void main(String[]args){
    int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    BinaryTree tree=new BinaryTree();
 Node root= tree.buildTree(nodes);
 preorder( root);
 inorder(root);
 postorder(root);
 levelOrder(root);


}
}