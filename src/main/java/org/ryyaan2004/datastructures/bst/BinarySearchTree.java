package org.ryyaan2004.datastructures.bst;

public class BinarySearchTree {
	
	TreeNode rootNode;
	
	BinarySearchTree(int i)
	{
		setRootNode(i);
	}
	
	BinarySearchTree()
	{
		// zero args is ok
	}
	
	private void setRootNode(int i)
	{
		this.rootNode = new TreeNode(i);
	}
	
	private void setRootNode(TreeNode r)
	{
		this.rootNode = r;
	}
	
	/**
	 * Returns a reference to our root node
	 * @return TreeNode
	 */
	TreeNode getRootNode()
	{
		return this.rootNode;
	}
	
	void insertNodeWithValue(int valueToInsert)
	{
		insertNode(new TreeNode(valueToInsert));
	}
	
	/**
	 * TREE-INSERT(T,z) algorithm, where T is this and z is a value
	 * that is used to create a new node.
	 * @param valueToInsert
	 */
	void insertNode(TreeNode nodeToInsert)
	{
		TreeNode y = null;
		TreeNode x = getRootNode();
		TreeNode z = nodeToInsert;
		
		while ( x != null )
		{ // find which node should be the parent of the new node
			y = x;
			if ( z.getValue() < x.getValue() ) 
			{
				x = x.getLeft();
			}
			else
			{
				x = x.getRight();
			}
		}
		z.setParent(y);
		if ( y == null )
		{
			this.setRootNode(z); // tree was empty
		}
		else if ( z.getValue() < y.getValue() )
		{
			y.setLeft(z);
		}
		else
		{
			y.setRight(z);
		}
	}
	
	TreeNode search(int valueToSearch)
	{
		return search(getRootNode(), valueToSearch);
	}
	
	TreeNode search(TreeNode searchNode, int valueToSearch)
	{
		if ( searchNode == null || valueToSearch == searchNode.getValue() )
		{
			return searchNode;
		}
		
		if ( valueToSearch < searchNode.getValue() )
		{
			return search(searchNode.getLeft(), valueToSearch);
		}
		else
		{
			return search(searchNode.getRight(), valueToSearch);
		}
	}
	
	TreeNode getTreeMinimum()
	{
		return treeMinimum(getRootNode());
	}
	
	/**
	 * Recursive implementation of TREE-MINIMUM(x) algorithm
	 * @param x
	 * @return
	 */
	private TreeNode treeMinimum(TreeNode x)
	{
		TreeNode y = x;
		if ( y.getLeft() != null )
		{
			y = treeMinimum(y.getLeft());
		}
		return y;
	}
	
	TreeNode getTreeMaximum()
	{
		return treeMaximum(getRootNode());
	}
	
	/**
	 * Recursive implementation of TREE-MAXIMUM(x) algorithm
	 * @param x
	 * @return
	 */
	private TreeNode treeMaximum(TreeNode x)
	{
		TreeNode y = x;
		if ( y.getRight() != null )
		{
			y = treeMaximum(y.getRight());
		}
		return y;
	}
	
	String inOrderTreeWalk()
	{
		String str = "";
		str += inOrderTreeWalk(getRootNode());
		str = str.trim();
		return str;
	}
	
	/**
	 * INORDER-TREE-WALK(x) algorithm
	 * @param x
	 * @return
	 */
	private String inOrderTreeWalk(TreeNode x)
	{
		String str = "";
		if ( x != null )
		{
			str += inOrderTreeWalk(x.getLeft());
			str += x.getValue().toString() + " ";
			str += inOrderTreeWalk(x.getRight());
		}
		return str;
	}
	
	/**
	 * TRANSPLANT(T,u,v) algorithm, where T is replaced by this
	 * @param u
	 * @param v
	 */
	private void transplant(TreeNode u, TreeNode v)
	{
		if ( u.getParent() == null )
		{ // if u is the root node, replace it with v
			this.setRootNode(v);
		}
		else if ( u == u.getParent().getLeft() )
		{ // if u is the left child, set v as the new left child
			u.getParent().setLeft(v);
		}
		else
		{ // or the right child
			u.getParent().setRight(v);
		}
		if ( v != null )
		{ // point v to u's parent
			v.setParent(u.getParent());
		}
	}
	
	/**
	 * Find a node by it's wrapped value and delete that jive sucka
	 * @param valueToFindNodeFor
	 */
	void deleteNode(int valueToFindNodeFor)
	{
		deleteNode(search(valueToFindNodeFor));
	}
	
	/**
	 * TREE-DELETE(T,z) where T is replaced by this
	 * 
	 * Given a TreeNode, this method will delete it
	 * @param z
	 */
	void deleteNode(TreeNode z)
	{
		if ( z.getLeft() == null )
		{
			transplant(z, z.getRight());
		}
		else if ( z.getRight() == null )
		{
			transplant(z, z.getLeft());
		}
		else
		{
			TreeNode y = treeMinimum(z.getRight());
			if ( y.getParent() != z )
			{
				transplant(y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			transplant(z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
		}
	}
	
	TreeNode findSuccessor(int val)
	{
		return findSuccessor(search(val));
	}
	
	/**
	 * TREE-SUCCESSOR(x)
	 * @param x
	 * @return
	 */
	TreeNode findSuccessor(TreeNode x)
	{
		if ( x.getRight() != null )
		{
			return treeMinimum(x.getRight());
		}
		TreeNode y = x.getParent();
		while ( y != null && x == y.getRight() )
		{
			x = y;
			y = y.getParent();
		}
		return y;
	}
	
	TreeNode findPredecessor(int val)
	{
		return findPredecessor(search(val));
	}
	
	TreeNode findPredecessor(TreeNode x)
	{
		if ( x.getLeft() != null )
		{
			return treeMinimum(x.getLeft());
		}
		TreeNode y = x.getParent();
		while ( y != null && x == y.getLeft() )
		{
			x = y;
			y = y.getParent();
		}
		return y;
	}
}
