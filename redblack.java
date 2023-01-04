class RedBlackNode  
{      
    RedBlackNode leftChild, rightChild;  
    int element;  
    int color;  
  
    
    public RedBlackNode(int element)  
    {  
        this( element, null, null );  
    }   
  
    
    public RedBlackNode(int element, RedBlackNode leftChild, RedBlackNode rightChild)  
    {  
        this.element = element;  
        this.leftChild = leftChild;  
        this.rightChild = rightChild;  
        color = 1;  
    }      
}  
  

class CreateRedBlackTree  
{  
    private static RedBlackNode nullNode;   
    private RedBlackNode current;   
    private RedBlackNode parent;    
    private RedBlackNode header;   
    private RedBlackNode grand; 
    private RedBlackNode great; 
  
    
    static final int RED   = 0;  
    static final int BLACK = 1;      
  
    
    static   
    {  
        nullNode = new RedBlackNode(0);  
        nullNode.leftChild = nullNode;  
        nullNode.rightChild = nullNode;  
    }  
  
  
    
    public CreateRedBlackTree(int header)  
    {  
        this.header = new RedBlackNode(header);  
        this.header.leftChild = nullNode;  
        this.header.rightChild = nullNode;  
    }  
  
    
    public void removeAll()  
    {  
        header.rightChild = nullNode;  
    }  
  
    
    public boolean checkEmpty()  
    {  
        return header.rightChild == nullNode;  
    }  
  
    
    public void insertNewNode(int newElement )  
    {  
        current = parent = grand = header;      
        nullNode.element = newElement;          
  
        
        while (current.element != newElement)  
        {              
            great = grand;   
            grand = parent;   
            parent = current;  
  
            
            current = newElement < current.element ? current.leftChild : current.rightChild;   
  
            
            if (current.leftChild.color == RED && current.rightChild.color == RED)  
                handleColors( newElement );  
        }  
              
        
        if (current != nullNode)  
            return;  
  
        
        current = new RedBlackNode(newElement, nullNode, nullNode);  
  
        
        if (newElement < parent.element)  
            parent.leftChild = current;  
        else  
            parent.rightChild = current;          
        handleColors( newElement );  
    }  
  
    
    private void handleColors(int newElement)  
    {  
        
        current.color = RED;    
        current.leftChild.color = BLACK;    
        current.rightChild.color = BLACK;   
  
        
        if (parent.color == RED)     
        {  
            
            grand.color = RED;  
              
            if (newElement < grand.element && grand.element != newElement && newElement < parent.element)  
                parent = performRotation( newElement, grand );  
            current = performRotation(newElement, great );  
            current.color = BLACK;  
        }  
          
        
        header.rightChild.color = BLACK;   
    }  
  
    
    private RedBlackNode performRotation(int newElement, RedBlackNode parent)  
    {  
        
        if(newElement < parent.element)  
            
            return parent.leftChild = newElement < parent.leftChild.element ? rotationWithLeftChild(parent.leftChild) : rotationWithRightChild(parent.leftChild) ;    
        else  
            
            return parent.rightChild = newElement < parent.rightChild.element ? rotationWithLeftChild(parent.rightChild) : rotationWithRightChild(parent.rightChild);    
    }  
  
    
    private RedBlackNode rotationWithLeftChild(RedBlackNode node2)  
    {  
        RedBlackNode node1 = node2.leftChild;  
        node2.leftChild = node1.rightChild;  
        node1.rightChild = node2;  
        return node1;  
    }  
  
    
    private RedBlackNode rotationWithRightChild(RedBlackNode node1)  
    {  
        RedBlackNode node2 = node1.rightChild;  
        node1.rightChild = node2.leftChild;  
        node2.leftChild = node1.leftChild;  
        return node2;  
    }  
  
    
    public int nodesInTree()  
    {  
        return nodesInTree(header.rightChild);  
    }  
    private int nodesInTree(RedBlackNode node)  
    {  
        if (node == nullNode)  
            return 0;  
        else  
        {  
            int size = 1;  
            size = size + nodesInTree(node.leftChild);  
            size = size + nodesInTree(node.rightChild);  
            return size;  
        }  
    }
    public void inorderTraversal()  
    {  
        inorderTraversal(header.rightChild);  
    }  
    private void inorderTraversal(RedBlackNode node)  
    {  
        if (node != nullNode)  
        {  
            inorderTraversal(node.leftChild);  
            char c = 'R';  
            if (node.color == 1)  
                c = 'B';  
            System.out.print(node.element +""+c+" ");  
            inorderTraversal(node.rightChild);  
        }  
    }  
class Main  
{  
    
    public static void main(String[] args)  
    {      
        CreateRedBlackTree obj = new CreateRedBlackTree(Integer.MIN_VALUE); 
        obj.insertNewNode(10);
        obj.insertNewNode(18);
        obj.insertNewNode(7);
        obj.insertNewNode(16);
        obj.insertNewNode(15);
        obj.insertNewNode(16);
        obj.insertNewNode(30);
        obj.insertNewNode(25);
        obj.insertNewNode(40);
        obj.insertNewNode(60);
        obj.insertNewNode(2);
        obj.insertNewNode(1);
        obj.insertNewNode(70);
        obj.inorderTraversal();
    }  
}  
}


  
class RedBlackNode  
{      
    RedBlackNode leftChild, rightChild;  
    int element;  
    int color;  
  
    
    public RedBlackNode(int element)  
    {  
        this( element, null, null );  
    }   
  
    
    public RedBlackNode(int element, RedBlackNode leftChild, RedBlackNode rightChild)  
    {  
        this.element = element;  
        this.leftChild = leftChild;  
        this.rightChild = rightChild;  
        color = 1;  
    }      
}  
  

class CreateRedBlackTree  
{  
    private static RedBlackNode nullNode;   
    private RedBlackNode current;   
    private RedBlackNode parent;    
    private RedBlackNode header;   
    private RedBlackNode grand; 
    private RedBlackNode great; 
  
    
    static final int RED   = 0;  
    static final int BLACK = 1;      
  
    
    static   
    {  
        nullNode = new RedBlackNode(0);  
        nullNode.leftChild = nullNode;  
        nullNode.rightChild = nullNode;  
    }  
  
  
    
    public CreateRedBlackTree(int header)  
    {  
        this.header = new RedBlackNode(header);  
        this.header.leftChild = nullNode;  
        this.header.rightChild = nullNode;  
    }  
  
    
    public void removeAll()  
    {  
        header.rightChild = nullNode;  
    }  
  
    
    public boolean checkEmpty()  
    {  
        return header.rightChild == nullNode;  
    }  
  
    
    public void insertNewNode(int newElement )  
    {  
        current = parent = grand = header;      
        nullNode.element = newElement;          
  
        
        while (current.element != newElement)  
        {              
            great = grand;   
            grand = parent;   
            parent = current;  
  
            
            current = newElement < current.element ? current.leftChild : current.rightChild;   
  
            
            if (current.leftChild.color == RED && current.rightChild.color == RED)  
                handleColors( newElement );  
        }  
              
        
        if (current != nullNode)  
            return;  
  
        
        current = new RedBlackNode(newElement, nullNode, nullNode);  
  
        
        if (newElement < parent.element)  
            parent.leftChild = current;  
        else  
            parent.rightChild = current;          
        handleColors( newElement );  
    }  
  
    
    private void handleColors(int newElement)  
    {  
        
        current.color = RED;    
        current.leftChild.color = BLACK;    
        current.rightChild.color = BLACK;   
  
        
        if (parent.color == RED)     
        {  
            
            grand.color = RED;  
              
            if (newElement < grand.element && grand.element != newElement && newElement < parent.element)  
                parent = performRotation( newElement, grand );  
            current = performRotation(newElement, great );  
            current.color = BLACK;  
        }  
          
        
        header.rightChild.color = BLACK;   
    }  
  
    
    private RedBlackNode performRotation(int newElement, RedBlackNode parent)  
    {  
        
        if(newElement < parent.element)  
            
            return parent.leftChild = newElement < parent.leftChild.element ? rotationWithLeftChild(parent.leftChild) : rotationWithRightChild(parent.leftChild) ;    
        else  
            
            return parent.rightChild = newElement < parent.rightChild.element ? rotationWithLeftChild(parent.rightChild) : rotationWithRightChild(parent.rightChild);    
    }  
  
    
    private RedBlackNode rotationWithLeftChild(RedBlackNode node2)  
    {  
        RedBlackNode node1 = node2.leftChild;  
        node2.leftChild = node1.rightChild;  
        node1.rightChild = node2;  
        return node1;  
    }  
  
    
    private RedBlackNode rotationWithRightChild(RedBlackNode node1)  
    {  
        RedBlackNode node2 = node1.rightChild;  
        node1.rightChild = node2.leftChild;  
        node2.leftChild = node1.leftChild;  
        return node2;  
    }  
  
    
    public int nodesInTree()  
    {  
        return nodesInTree(header.rightChild);  
    }  
    private int nodesInTree(RedBlackNode node)  
    {  
        if (node == nullNode)  
            return 0;  
        else  
        {  
            int size = 1;  
            size = size + nodesInTree(node.leftChild);  
            size = size + nodesInTree(node.rightChild);  
            return size;  
        }  
    }
    public void inorderTraversal()  
    {  
        inorderTraversal(header.rightChild);  
    }  
    private void inorderTraversal(RedBlackNode node)  
    {  
        if (node != nullNode)  
        {  
            inorderTraversal(node.leftChild);  
            char c = 'R';  
            if (node.color == 1)  
                c = 'B';  
            System.out.print(node.element +""+c+" ");  
            inorderTraversal(node.rightChild);  
        }  
    }  
class Main  
{  
    
    public static void main(String[] args)  
    {      
        CreateRedBlackTree obj = new CreateRedBlackTree(Integer.MIN_VALUE); 
        obj.insertNewNode(10);
        obj.insertNewNode(18);
        obj.insertNewNode(7);
        obj.insertNewNode(16);
        obj.insertNewNode(15);
        obj.insertNewNode(16);
        obj.insertNewNode(30);
        obj.insertNewNode(25);
        obj.insertNewNode(40);
        obj.insertNewNode(60);
        obj.insertNewNode(2);
        obj.insertNewNode(1);
        obj.insertNewNode(70);
        obj.inorderTraversal();
    }  
}  
}
