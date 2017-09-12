
/**
 * Write a description of class intTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntTree
{
  /*private class TreeNode<T> 
  {
      private T data;
      private TreeNode<T> left;
      private TreeNode<T> right;
     
      public TreeNode ( T data, TreeNode<T> left, TreeNode<T> right )
      {
          this.data = data;
          this.left = left;
          this.right = right;
      }*/
      public class TreeNode<TBA> { TBA data; TreeNode<TBA> left; TreeNode<TBA> right;
public String toString() {return data.toString();} public TreeNode(TBA d, TreeNode<TBA> l, TreeNode<TBA> r) {
data = d; left = l; right = r;
}
  }
  private TreeNode<Integer> root;
  
  public IntTree ()
  {
      this.root = null;
  }
  
  public void add ( Integer data )
  {
      this.root = insertInIntTree ( data, root );
  }
  
  private  TreeNode<Integer> insertInIntTree ( Integer data, TreeNode<Integer> subtree )
  {
      if ( subtree == null )
         return new TreeNode(data, null, null );
      else if ( data < subtree.data ) {
          subtree.left = insertInIntTree ( data, subtree.left);
          return subtree;
        }
      else {
          subtree.right = insertInIntTree ( data, subtree.right );
          return subtree;
      } 
  }
  
  public String toString ()
  {
      return toString (this.root);
  }
  
  private String toString ( TreeNode<Integer> subtree )
  {
      String retVal = "";
      if ( subtree != null )
      {
      retVal += toString(subtree.left);
      retVal+= subtree.data + " ";
      retVal += toString(subtree.right);
      
    }
    return retVal;
  }
  
  public int getDepth ()
  {
     return getDepth ( this.root); 
  }
  
  private int getDepth ( TreeNode<Integer> subtree )
  {
      if ( subtree == null )
        return 0;
      else
        return 1 + Math.max ( getDepth(subtree.left), getDepth(subtree.right));
  }
  
  
   public TreeNode<Integer> getParent(Integer target)
  {
      if ( target == root.data)
        throw new RuntimeException ("Target has no parent");
      return getParent ( target, root, null);  
  }
  
  private TreeNode<Integer> getParent ( Integer target, TreeNode<Integer> subtree, TreeNode<Integer> parent)
  {
      if (subtree == null)
            return null;
        
      if (!(subtree.data == target) )
      { 
            parent = getParent(target, subtree.left, subtree);
            if (parent == null)
            parent = getParent(target, subtree.right, subtree);
      }
      return parent;     
  }

  public int countNodes ()
  {
      return countNodes ( this.root );
  }  
  
  private int countNodes ( TreeNode<Integer> subtree)
  {
      if ( subtree == null )
        return 0;
      return 1 + countNodes ( subtree.left) + countNodes(subtree.right);
  }
 
  public boolean contains(Integer c)  {
      return isInSubtree(c,root); 
  }
  
  private boolean isInSubtree(Integer c, TreeNode<Integer> subtree)  
  {
      if(subtree == null) {
         return false; } 
     else if(subtree.data == c)
     {
        return true; 
     } else if(subtree.data > c){
        return isInSubtree(c, subtree.left);
     } else { 
        return isInSubtree(c, subtree.right);
     }
  }
  
  
  public  boolean DFS(int target)  
  {
      boolean retVal = false;
      try
      {
        Stack stack = new Stack();
         stack.push(this.root);
        TreeNode<Integer> node =root;
        while(!stack.isEmpty())
         {
             //enter the room (tree node)
             node = (TreeNode<Integer>)stack.pop();
             //record the room entered
            System.out.println(node.data + "\n");
             //Smell to see if the scales are closer
                         //check if hunter reached golden scales. 
            if (node.data == target)
            {
                  
                 return true;
            } 
           
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
           
          
        }
    }catch  (LinkedListException le)
    {
        le.getMessage();
    }
        return retVal;
    }
    
 private static void reverseTree(TreeNode<Integer> root) {
    reverseTreeNode(root);
}

private static void reverseTreeNode(TreeNode<Integer> node) {
    TreeNode<Integer> temp = node.left;
    node.left   = node.right;
    node.right  = temp;

    if(node.left != null)
        reverseTreeNode(node.left);

    if(node.right != null)
        reverseTreeNode(node.right);
}
  
  public static void main(String[] args) {
      IntTree tree = new IntTree();
      tree.add(3); 
      tree.add(5); 
tree.add(6); 
      tree.add(1); 
      tree.add(2); 
      tree.add(4); 
      tree.add(7); 
      System.out.println("Tree nodes");
      System.out.println(tree.toString());   //inorder prints a c t
      System.out.println(tree.getParent(1));
      reverseTreeNode(tree.root);
     System.out.println(tree.toString());
  }
}