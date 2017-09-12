
/**
 * Write a description of class charTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharTree
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
  private TreeNode<Character> root;
  
  public CharTree ()
  {
      this.root = null;
  }
  
  public void add ( Character data )
  {
      this.root = insertInCharTree ( data, root );
  }
  
  private  TreeNode<Character> insertInCharTree ( Character data, TreeNode<Character> subtree )
  {
      if ( subtree == null )
         return new TreeNode(data, null, null );
      else if ( data < subtree.data ) {
          subtree.left = insertInCharTree ( data, subtree.left);
          return subtree;
        }
      else {
          subtree.right = insertInCharTree ( data, subtree.right );
          return subtree;
      } 
  }
  
  public String toString ()
  {
      return toString (this.root);
  }
  
  private String toString ( TreeNode<Character> subtree )
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
  
  private int getDepth ( TreeNode<Character> subtree )
  {
      if ( subtree == null )
        return 0;
      else
        return 1 + Math.max ( getDepth(subtree.left), getDepth(subtree.right));
  }
  
  
   public TreeNode<Character> getParent(Character target)
  {
      if ( target == root.data)
        throw new RuntimeException ("Target has no parent");
      return getParent ( target, root, null);  
  }
  
  private TreeNode<Character> getParent ( Character target, TreeNode<Character> subtree, TreeNode<Character> parent)
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
  
  private int countNodes ( TreeNode<Character> subtree)
  {
      if ( subtree == null )
        return 0;
      return 1 + countNodes ( subtree.left) + countNodes(subtree.right);
  }
 
  public boolean contains(Character c)  {
      return isInSubtree(c,root); 
  }
  
  private boolean isInSubtree(Character c, TreeNode<Character> subtree)  
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
  
  
  public  boolean DFS(char target)  
  {
      boolean retVal = false;
      try
      {
        Stack stack = new Stack();
         stack.push(this.root);
        TreeNode<Character> node =root;
        while(!stack.isEmpty())
         {
             //enter the room (tree node)
             node = (TreeNode<Character>)stack.pop();
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
    
 
  
  public static void main(String[] args) {
      CharTree tree = new CharTree();
      tree.add('c'); 
      tree.add('a'); 
      tree.add('b');
      tree.add('x');
      tree.add('y');
      tree.add('t');
      
      System.out.println("Tree nodes");
      System.out.println(tree.toString());   //inorder prints a c t
      System.out.println(tree.DFS('t'));
      System.out.println("tree count");
      System.out.println(tree.countNodes());
      System.out.println("tree depth");
      System.out.println(tree.getDepth()); //
      System.out.println("get parent of a,b,c");
     // System.out.println(tree.getParent('c'));  //?    c 
       System.out.println(tree.getParent('a'));  //
        System.out.println(tree.getParent('b'));  //
         System.out.println(tree.getParent('x'));  //
          System.out.println(tree.getParent('y'));  //
           System.out.println(tree.getParent('t'));  //
      
      
      
      
      System.out.println(tree.contains('t'));  //?    c //System.out.println(tree.getParent('s'));  //?   (t) //System.out.println(tree.getParent('c'));  //excepts on root
      System.out.println("tree contains c, z");
      System.out.println(tree.contains('c')); //
      System.out.println(tree.contains('z'));
  }
}