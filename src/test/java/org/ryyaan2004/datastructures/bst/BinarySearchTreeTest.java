package org.ryyaan2004.datastructures.bst;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void inorderTreeWalk()
	{
	}
	
	@Test
	public void insertNodeInEmptyTree()
	{
		int expectedValue = 5;
		BinarySearchTree bst = new BinarySearchTree();
		bst.insertNodeWithValue(expectedValue);
		int actualValue = bst.getRootNode().getValue();
		Assert.assertEquals( "The root node was expected to have a different value: "
						   , 5
						   , actualValue );
	}
	
	@Test
	public void insertLargerNodeInNonEmptyTree()
	{
		int expectedValue = 5;
		BinarySearchTree bst = new BinarySearchTree(2);
		bst.insertNodeWithValue(expectedValue);
		int actualValue = bst.getRootNode().getRight().getValue();
		Assert.assertEquals( "The right node of the root node has the wrong value: "
						   , expectedValue
						   , actualValue );
	}
	
	@Test
	public void insertSmallerNodeInNonEmptyTree()
	{
		int expectedValue = 2;
		BinarySearchTree bst = new BinarySearchTree(5);
		bst.insertNodeWithValue(expectedValue);
		int actualValue = bst.getRootNode().getLeft().getValue();
		Assert.assertEquals( "The left node of the root node has the wrong value: "
						   , expectedValue
						   , actualValue );
	}
	
	@Test
	public void deleteSingleNode()
	{
	}
	
	@Test
	public void treeSearch()
	{
	}
	
	@Test 
	public void findTreeMinimum()
	{
	}
	
	@Test
	public void findTreeMaximum()
	{
	}
	
	@Test
	public void findNodeSuccessor()
	{
	}
	
	@Test
	public void findNodePredecessor()
	{
	}
}
