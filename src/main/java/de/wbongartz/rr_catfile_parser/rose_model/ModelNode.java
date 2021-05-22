/**
 * 
 */
package de.wbongartz.rr_catfile_parser.rose_model;

import java.util.*;

import javax.swing.tree.*;

/**
 * @author Wolfgang Bongartz
 *
 */
public abstract class ModelNode extends ModelObject implements MutableTreeNode
{
	private MutableTreeNode _parent;
	private Vector<MutableTreeNode> _children;
	
	/**
	 * 
	 */
	public ModelNode()
	{
		_parent   = null;
		_versatileReference = null;
		_children = new Vector<MutableTreeNode>();
	}
	
	/**
	 * 
	 * @param parent
	 */
	public ModelNode(ModelNode parent)
	{
		this();
		_parent   = parent;
		_versatileReference = null;
	}
	
	/**
	 * Erm�glicht es, beliebige Referenzen abzulegen. Bspw. auf ein View-Objekt, dass das Rose-Element darstellt.
	 */
	private Object _versatileReference;

	public Object getVersatileReference()
	{
		return _versatileReference;
	}

	public void setVersatileReference(Object versatileReference)
	{
		_versatileReference = versatileReference;
	}

	/**
	 * Returns the children of the receiver as an Enumeration. 
	 */
	@SuppressWarnings("rawtypes")
	public Enumeration children()
	{
		return _children.elements();
	}
	
	/**
	 * Returns true if the receiver allows children. 
	 */
	public boolean	getAllowsChildren()
	{
		return true;
	}

	/**
	 * Returns the child TreeNode at index childIndex.
	 */
	public TreeNode	getChildAt(int childIndex)
	{
		return _children.elementAt(childIndex);
	}

	/**
	 * Returns the number of children TreeNodes the receiver contains.
	 */
	public int getChildCount()
	{
		int retVal = 0;
		if(_children!=null)
		{
			retVal = _children.size();
		}
		return retVal;
	}

	/**
	 * Returns the index of node in the receivers children.
	 */
	public int	getIndex(TreeNode node)
	{
		return _children.indexOf(node);
	}
	
	/**
	 * Returns the parent TreeNode of the receiver.
	 */
	public TreeNode	getParent()
	{
		return _parent;
	}
	
	/**
	 * Returns true if the receiver is a leaf.	
	 */
	public boolean	isLeaf()
	{
		return _children==null || _children.size()==0;
	}
	
	/**
	 * Adds child to the receiver at index.
	 */
	public void	insert(MutableTreeNode child, int index)
	{
		if( ! this.getAllowsChildren() )
		{
			throw new IllegalStateException("Node does not allow children!");
		}
		
		if(child==null)
		{
			throw new IllegalArgumentException("Child is null!");
		}
		
		if(_children!=null && _children.contains(child))
		{
			throw new IllegalArgumentException("Child is already there!");
		}

		if(child.getParent()!=null)
		{
			child.removeFromParent();
		}
		
		if(_children==null)
		{
			_children=new Vector<MutableTreeNode>();
		}
		_children.insertElementAt(child, index);
		child.setParent(this);
	}
	
	/**
	 * Adds child to the receiver as last element.
	 */
	public void	append(MutableTreeNode child)
	{
		this.insert(child, _children.size());
	}
	
	/**
	 * Adds a list of children to the receiver as last elements.
	 */
	public void	append(ArrayList<ModelNode> children)
	{
		for(ModelNode child: children)
		this.insert(child, _children.size());
	}
	
	/**
	 * Removes the child at index from the receiver.
	 */
	public void	remove(int index)
	{
		MutableTreeNode node = _children.get(index);
		this.remove(node);
	}
	
	/**
	 * Removes node from the receiver.
	 */
	public void	remove(MutableTreeNode node)
	{
		if(node!=null && _children!=null && _children.contains(node))
		{
			//_children.remove(node);
			//node.setParent(null);
			node.removeFromParent();
		}
	}
	
	/**
	 * Removes the receiver from its parent.
	 */
	public void	removeFromParent()
	{
		_parent.remove(this);
		_parent = null;
	}
	
	/**
	 * Sets the parent of the receiver to newParent.
	 */
	public void	setParent(MutableTreeNode newParent)
	{
		_parent = newParent;
	}
	
	/**
	 * Resets the user object of the receiver to object.
	 */
	public void	setUserObject(Object object)
	{
		
	}
	
//	public boolean equals(Object obj)
//	{
//	}
}
