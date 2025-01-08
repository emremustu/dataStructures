import java.util.LinkedList;
import java.util.Queue;

class QNode<E> {
    E data;
    Queue<QNode<E>> childrenList;
    QNode<E> parent;

    public QNode(E data) {
        this.data=data;
        this.childrenList = new LinkedList<>();
        this.parent=null;
    }

}

public class QTree<E> {
    QNode<E> root;

    public QTree(){
        this.root=null;   
    }

    public QNode<E> find(QNode<E> root, E value){

        if(root==null){
            return null;
        }

        if(root.data.equals(value)){
            return root;
        }

        for(QNode<E> child:root.childrenList){
            QNode<E> result = find(child,value);

            if(result!=null){
                return result;
            }
            
        }
        return null;
    }




    public void deleteNode(QNode<E> root, E deletedValue){
        QNode<E> nodeToDelete = find(root,deletedValue);

        if(nodeToDelete==null){
            System.out.println("Node not found in the tree");
            return;
        }

        if(nodeToDelete.parent!=null){
            QNode<E> parent = nodeToDelete.parent;
            parent.childrenList.remove(nodeToDelete);
        }
        else{
            //if the node to delete is the root, set root null
            this.root=null;
        }
    }


    public void addChild(QNode<E> parent, E value){
        QNode<E> child = new QNode<>(value);
        child.parent=parent;
        parent.childrenList.add(child);
    }

    public void printTree(QNode<E> root){
        if(root==null){
            return;
        }

        Queue<QNode<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            QNode<E> current = queue.poll();
            System.out.print(current.data + " ");
            queue.addAll(current.childrenList);
            }
            System.out.println();
    }


    public static void main(String[] args) {
        //creating the tree 10pt
        QTree<Integer> tree = new QTree<>();
        tree.root = new QNode<>(10);
        // Add children to the root 
        QNode<Integer> node15 = new QNode<>(15);
        QNode<Integer> node25 = new QNode<>(25);
        tree.root.childrenList.add(node15);
        tree.root.childrenList.add(node25);
        node15.parent = tree.root;
        node25.parent = tree.root;
        // Add children to node 15
        QNode<Integer> node2 = new QNode<>(2);
        QNode<Integer> node7 = new QNode<>(7);
        QNode<Integer> node6 = new QNode<>(6);
        node15.childrenList.add(node2);
        node15.childrenList.add(node7);
        node15.childrenList.add(node6);
        tree.addChild(node25, 18);
        node2.parent = node15;
        node7.parent = node15;
        node6.parent = node15;
        // Add children to node 7
        QNode<Integer> node5 = new QNode<>(5);
        QNode<Integer> node12 = new QNode<>(12);
        node7.childrenList.add(node5);
        node7.childrenList.add(node12);
        node5.parent = node7;
        node12.parent = node7;
        // Add children to node 25
        QNode<Integer> node9 = new QNode<>(9);
        node25.childrenList.add(node9);
        node9.parent = node25;
        // Print the tree
        System.out.println("Tree structure:");
        tree.printTree(tree.root);
       
        // Test find method 2 pt
        System.out.println("Finding node with value 7: " + (tree.find(tree.root, 7) != null)); //
       
        System.out.println("Finding node with value 20: " + (tree.find(tree.root, 20) != null)); //
       
        // Test delete method 2pt
        System.out.println("Deleting node with value 15..."); //deletion style may differ, here we
       
        tree.deleteNode(tree.root, 15);
        System.out.println("Tree structure after deletion:");
        tree.printTree(tree.root);
        }
}