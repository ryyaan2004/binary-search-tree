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
}
