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
}
