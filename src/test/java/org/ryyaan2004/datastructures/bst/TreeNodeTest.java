package org.ryyaan2004.datastructures.bst;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.ryyaan2004.datastructures.bst.TreeNode;

public class TreeNodeTest {
	@Test
	public void compareEqualTreeNodes()
	{
		TreeNode p = new TreeNode(1);
		TreeNode r = new TreeNode(1);
		int result = p.compareTo(r);
		Assert.assertEquals("TreeNodes constructed with the same value are not comparing as equal",0,result);
	}
	
	@Test
	public void compareSmallerTreeNodeToGreaterTreeNode()
	{
		TreeNode p = new TreeNode(1);
		TreeNode r = new TreeNode(5);
		int result = p.compareTo(r);
		Assert.assertNotEquals("Calling compare on p and passing r does not result in a non-0 value",0, result);
	}
	
	@Test
	public void compareGreaterTreeNodeToSmallerTreeNode()
	{
		TreeNode p = new TreeNode(1);
		TreeNode r = new TreeNode(5);
		int result = r.compareTo(p);
		Assert.assertNotEquals("Calling compare on r and passing p does not result in a non-0 value",0, result);
	}
	
	@Test
	public void nodeEqualsItself()
	{
		TreeNode p = new TreeNode(1);
		boolean result = p.equals(p);
		Assert.assertTrue("Calling equals and passing a node to itself does not result in equality",result);
	}
	
	@Test
	public void smallerTreeNodeDoesNotEqualGreaterTreeNode()
	{
		TreeNode p = new TreeNode(1);
		TreeNode r = new TreeNode(5);
		boolean result = p.equals(r);
		Assert.assertFalse("Calling equals on non-equal nodes results in equality",result);
	}
	
	@Test
	public void nodesSortInList()
	{
		TreeNode p = new TreeNode(1);
		TreeNode q = new TreeNode(2);
		TreeNode r = new TreeNode(3);
		
		TreeNode[] nodeArr = { q, r, p }; // Out of sequences
		List<TreeNode> nodeList = Arrays.asList(nodeArr);
		Assert.assertEquals("The list of nodes was not created in the expected sequence", q, nodeList.get(0));
		
		Collections.sort(nodeList);
		Assert.assertEquals("The expected node at the 0th position was p", p, nodeList.get(0));
		Assert.assertEquals("The last node was expected to be r", r, nodeList.get(2));
	}
}
