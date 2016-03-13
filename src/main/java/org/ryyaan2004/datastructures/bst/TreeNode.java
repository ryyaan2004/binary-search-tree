package org.ryyaan2004.datastructures.bst;

public class TreeNode implements Comparable<TreeNode> {
	
	private Integer value;
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;

	public TreeNode(int i)
	{
		this.setValue(Integer.valueOf(i));
	}
	
	public Integer getValue() {
		return value;
	}

	/*
	 * TreeNode values are immutable
	 */
	private void setValue(Integer value) {
		this.value = value;
	}
	
	public TreeNode getLeft() {
		return this.left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return this.right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getParent() {
		return this.parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public int compareTo(TreeNode otherNode) {
		return this.value.compareTo(otherNode.getValue());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.left == null) ? 0 : this.left.hashCode());
		result = prime * result + ((this.parent == null) ? 0 : this.parent.hashCode());
		result = prime * result + ((this.right == null) ? 0 : this.right.hashCode());
		result = prime * result + ((this.value == null) ? 0 : this.value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TreeNode other = (TreeNode) obj;
		if (this.left == null) {
			if (other.left != null) {
				return false;
			}
		} else if (!this.left.equals(other.left)) {
			return false;
		}
		if (this.parent == null) {
			if (other.parent != null) {
				return false;
			}
		} else if (!this.parent.equals(other.parent)) {
			return false;
		}
		if (this.right == null) {
			if (other.right != null) {
				return false;
			}
		} else if (!this.right.equals(other.right)) {
			return false;
		}
		if (this.value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!this.value.equals(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TreeNode [value=").append(this.value).append(", left=").append(this.left).append(", right=")
				.append(this.right).append(", parent=").append(this.parent).append("]");
		return builder.toString();
	}
}