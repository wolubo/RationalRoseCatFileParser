package de.wbongartz.rr_catfile_parser.gui;

import java.awt.GridLayout;
//import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import de.wbongartz.rr_catfile_parser.rose_model.ModelNode;
import de.wbongartz.rr_catfile_parser.rose_model.PackageNode;
import de.wbongartz.rr_catfile_parser.events.EventBase;
import de.wbongartz.rr_catfile_parser.events.NewModelEvent;

/**
 * @author Wolfgang Bongartz
 *
 */
public class ModelTree extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8836556490579676056L;
	
	private JTree _tree;
	private DefaultTreeModel _treeModel;
	private DefaultMutableTreeNode _root;


	/**
	 * 
	 */
	public ModelTree() {
		//super();
		super(new GridLayout(1,0));
		
		EventBase.addListener(NewModelEvent.class, this, "receiveNewModelEvent");

		_root = new DefaultMutableTreeNode("<empty>");
		_treeModel = new DefaultTreeModel(_root);
		//_treeModel.addTreeModelListener(new MyTreeModelListener());
		_tree = new JTree(_treeModel);
		_tree.setEditable(true);
		_tree.getSelectionModel().setSelectionMode (TreeSelectionModel.SINGLE_TREE_SELECTION);
		_tree.setShowsRootHandles(true);

		JScrollPane scrollPane = new JScrollPane(_tree);
		add(scrollPane);

		//		setBorder(new EmptyBorder(5, 5, 5, 5));
		//		setLayout(new BorderLayout(0, 0));
		setOpaque(true);
	}

	public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
			ModelNode child, 
			boolean shouldBeVisible) {
		DefaultMutableTreeNode childNode = 
				new DefaultMutableTreeNode(child);

		if (parent == null) {
			parent = _root;
		}

		// It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
		_treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

		child.setVersatileReference(childNode);
		
		// Make sure the user can see the lovely new node.
		if (shouldBeVisible) {
			_tree.scrollPathToVisible(new TreePath(childNode.getPath()));
		}
		
		// Kind-Knoten rekursiv hinzuf�gen.
		for(int i=0; i<child.getChildCount(); i++)
		{
			Object o = child.getChildAt(i);
			ModelNode c = (ModelNode) o;
			addObject(childNode, c, false);
		}
		
		return childNode;
	}

	public void receiveNewModelEvent(NewModelEvent event) {
		Object o = event.getModel();
		ModelNode node = (ModelNode) o;
		addObject(null, node, true);
	}


}
