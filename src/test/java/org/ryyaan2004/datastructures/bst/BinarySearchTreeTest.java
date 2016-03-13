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
		int valueToFind = 7;
		TreeNode nodeToFind = new TreeNode(valueToFind);
		BinarySearchTree bst = new BinarySearchTree();
		bst.insertNodeWithValue(10);
		bst.insertNodeWithValue(5);
		bst.insertNodeWithValue(8);
		bst.insertNode(nodeToFind);
		bst.insertNodeWithValue(2);
		bst.insertNodeWithValue(90);
		bst.insertNodeWithValue(1);
		Assert.assertEquals( "The node that was found was not expected: "
						   , nodeToFind
						   , bst.search(valueToFind) );

		int valueNotInTree = 100;
		Assert.assertNull(bst.search(valueNotInTree));
	}
	
	@Test 
	public void findTreeMinimum()
	{
		int minValue = 2;
		TreeNode minNode = new TreeNode(minValue);
		BinarySearchTree bst = new BinarySearchTree();
		bst.insertNodeWithValue(10);
		bst.insertNodeWithValue(5);
		bst.insertNodeWithValue(8);
		bst.insertNode(minNode);
		bst.insertNodeWithValue(90);
		bst.insertNodeWithValue(4);
		Assert.assertEquals( "The returned node wasn't the expected minimum: "
						   , minNode
						   , bst.getTreeMinimum() );
	}
	
	@Test
	public void findTreeMaximum()
	{
		int maxValue = 100;
		TreeNode maxNode = new TreeNode(maxValue);
		BinarySearchTree bst = new BinarySearchTree();
		bst.insertNodeWithValue(10);
		bst.insertNodeWithValue(5);
		bst.insertNodeWithValue(8);
		bst.insertNode(maxNode);
		bst.insertNodeWithValue(90);
		bst.insertNodeWithValue(4);
		Assert.assertEquals( "The returned node wasn't the expected maximum: "
						   , maxNode
						   , bst.getTreeMaximum() );
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
