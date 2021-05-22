package de.wbongartz.rr_catfile_parser.rose_model;

import java.util.*;

import de.wbongartz.rr_catfile_parser.attribute_management.AttributeManager;
import de.wbongartz.rr_catfile_parser.attribute_management.IAttributeContainer;

/**
 * @author Wolfgang Bongartz
 *
 */
public class PackageNode extends ModelNode implements IPackageableElement, INamespace, ITemplatableElement, 
IAttributeContainer
{
	@SuppressWarnings("unused")
	private List<Attribute> _attributes;
	
	@SuppressWarnings("unused")
	private PropertyList _properties;
	
	@SuppressWarnings("unused")
	private Defaults _defaults;
	
	@SuppressWarnings("unused")
	private ProcessesObject _processStructure;
	
	private Namespace _namespace;
	private AttributeManager _attributeManager;
	private ArrayList<ExternalDoc> _externalDocsAttribute;
	
	public PackageNode() {
		super();
		_namespace = new Namespace();
		_attributeManager = new AttributeManager();
	}

	public PackageNode(String name, VisibilityKind visibility) {
		_namespace = new Namespace(name, visibility);
		_attributeManager = new AttributeManager();
	}

	public void setAttributes(List<Attribute> attributes)
	{
		_attributes = attributes;
	}
	
	public void setDefaults(Defaults d)
	{
		_defaults = d;
	}
	
	public void setProperties(PropertyList properties)
	{
		_properties = properties;
	}
	
	public void setProcessStructure(ProcessesObject processStructure)
	{
		_processStructure = processStructure; 
	}

	/* (non-Javadoc)
	 * @see uml.INamedElement#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		_namespace.setName(name);
	}

	/* (non-Javadoc)
	 * @see uml.INamedElement#getName()
	 */
	@Override
	public String getName() {
		return _namespace.getName();
	}

	/* (non-Javadoc)
	 * @see uml.INamedElement#setVisibility(uml.VisibilityKind)
	 */
	@Override
	public void setVisibility(VisibilityKind visibility) {
		_namespace.setVisibility(visibility);
	}

	/* (non-Javadoc)
	 * @see uml.INamedElement#getVisibility()
	 */
	@Override
	public VisibilityKind getVisibility() {
		return _namespace.getVisibility();
	}

	/* (non-Javadoc)
	 * @see attributeManagement.IAttributeContainer#addAttribute(java.lang.String, java.lang.Object)
	 */
	@Override
	public void addAttribute(String name, Object value) {
		_attributeManager.addAttribute(name, value);
	}

	/* (non-Javadoc)
	 * @see attributeManagement.IAttributeContainer#getAttribute(java.lang.String)
	 */
	@Override
	public Object getAttribute(String name) {
		return _attributeManager.getAttribute(name);
	}

	/**
	 * 
	 * @param eda
	 */
	public void setExternalDocsAttribute(ArrayList<ExternalDoc> eda) {
		_externalDocsAttribute = eda;
	}

	public ArrayList<ExternalDoc> getExternalDocsAttribute() {
		return _externalDocsAttribute;
	}

}
