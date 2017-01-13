import java.utils.*;

public class Node {
    private Node leftNode;
    private Node rightNode;
    private Node parentNode;
    private int data;

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public int getData() {
        return data;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }
}
	* For a node at index i
	*
		* Left Child = 2i+1
		* Right Child = 2i+2




	* Insert
	*
		* Find a position to insert O(logn)
		* Start at root



private void addNode(Node pNode, Node newNode) {
   if (newNode.getData() < pNode.getData()) {
      if (pNode.getLeftNode() == null) {
         pNode.setLeftNode(newNode);
         newNode.setParentNode(pNode);
      } else {
         addNode(pNode.getLeftNode(), newNode);
      }
   } else {
      if (pNode.getRightNode() == null) {
         pNode.setRightNode(newNode);
         newNode.setParentNode(pNode);
      } else {
         addNode(pNode.getRightNode(), newNode);
      }
   }
}


	* Deletion
	*
		* No Children
		*
			* Unlink the leaf, and the garbage collector will delete it.
			*
				* public void deleteNode(Node node) {
   // Node is a leaf node //
   if( node.getLeftNode() == null && node.getRightNode() == null){
      if(isRightNode(node.getParentNode(), node)){
         node.getParentNode().setRightNode(null);
      }else{
         node.getParentNode().setLeftNode(null);
      }


		* One Child
		* 
			* Ensure node is not the root of a subtree



	* Left Child
	* // Only left child is there//
   }else if( node.getLeftNode() != null && node.getRightNode() == null){
      if(isRightNode(node.getParentNode(), node)){
         node.getParentNode().setRightNode(node.getLeftNode());
      }else{
         node.getParentNode().setLeftNode(node.getLeftNode());
      }
	* Right Child
	*   // Only Right child is there //
   }else if( node.getLeftNode() == null && node.getRightNode() != null){
      if( isRightNode(node.getParentNode(), node)){
         node.getParentNode().setRightNode(node.getRightNode());
      }else{
         node.getParentNode().setLeftNode(node.getRightNode());
      }




	* Height of a tree O(n)
	*
		* Counting edges
		* When recursion returns a -1 method has reached an empty tree or points to null.
		* Convention states the height of an empty tree is -1
		* returning -1 accounts for the method counting the edge when no nodes exists.



public static int height  (Node node){
   if (node == null) {
      return -1;}
   else{
      return 1 + Math.max(height(node.getLeftNode()),height((node.getRightNode())));

Breadth- first

	* Visit all of a nodes children before visiting its grandchildren
	* Level Order Traversal O(n)

	* Implement with a Queue
	* private void levelOrderTraversal ( Node node){
   if( node == null){
      return;
   }
   Queue<Node> myQueue = new LinkedList<>();
   myQueue.offer(node);
   while (!myQueue.isEmpty()){
      Node thisNode = myQueue.peek();
      Node leftSubTree = thisNode.getLeftNode();
      Node rightSubTree = thisNode.getRightNode();
      myQueue.offer(leftSubTree);
      myQueue.offer(rightSubTree);
      myQueue.poll();
  }
}


	* Depth- first
	* Left sub tree is always visited first
	* The only variance in the methods is when the root is processed
	* 
		* Pre-Order DLR
		*
			* Visit the root
			* Left sub tree recursively
			* Right sub tree recursively

		* In-Order LDR
		*
			* Left sub tree recursively
			* Visit root
			* Right sub tree recursively

		* Post- order LRD
		*
			* Left
			* Right
			* Root





	* Check if a given tree is a BST
	* 
		* //How can we implement with getMax and getMin?
public boolean IsBinarySearchTree (Node root){
   if(root == null){
      return true;
   }
   else if(isSubTreeGreater(root.getRightNode(),root.getData())
           && isSubTreeLesser(root.getLeftNode(),root.getData())
           && isBinarySearchTree(root.getLeftNode())
           && isBinarySearchTree(root.getLeftNode()){
      return true;
   }
      return false;
}
public boolean isSubTreeGreater(Node root, int val){
   if (root == null){
      return true;
   }
   else if( root.getData()<= val
           && isSubTreeGreater(root.getLeftNode(),val)
           && isSubTreeGreater(root.getRightNode(), val)){
      return true;
   }
   return false;
}
public boolean isSubTreeLesser(Node root, int val){
   if (root == null){
      return true;
   }
   else if( root.getData()<= val
           && isSubTreeLesser(root.getLeftNode(),val)
           && isSubTreeLesser(root.getRightNode(), val)){
      return true;
   }
   return false;
}
public Node predessor(Node node) {
    Node pNode = null;
    if (node.getLeftNode() != null) {
        Node newNode = node.getLeftNode();
        while (newNode != null){
        pNode=newNode;
        newNode=newNode.getRightNode();
        }
    }
        else{
        pNode=findLeftParent(node);
        }
        return pNode;
           }
public Node successor (Node node){
    Node sNode = null;
    if(node.getRightNode() != null){
        Node newNode = node.getRightNode();
        while (newNode != null){
        sNode=newNode;
        newNode=newNode.getLeftNode();
        }
        }
    else {
        sNode = findRightParent(node);
        }
        return sNode;
        }
