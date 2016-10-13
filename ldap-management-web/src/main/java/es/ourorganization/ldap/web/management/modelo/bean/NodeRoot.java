package es.ourorganization.ldap.web.management.modelo.bean;

public class NodeRoot
{
	private Long id;
	private String title;
	private NodeChildren nodeChildren;	
	
	public NodeRoot(Long id, String title, NodeChildren nodeChildren)
	{
		super();
		this.id = id;
		this.title = title;		
		setNodeChildren(nodeChildren);
	}
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public NodoLDAP getRoot()
	{
		return nodeChildren;
	}
	
//	public NodeChildren getNodeChildren()
//	{
//		return nodeChildren;
//	}

	public void setNodeChildren(NodeChildren nodeChildren)
	{
		this.nodeChildren = nodeChildren;
	}

	@Override
	public String toString()
	{			
		return "{\n\t\"id\" : " + getId() + ",\n\t \"title\" : \"" + getTitle() + "\",\n\t \"root\" : {\n\t\t" + getRoot().toString() + "}\n}";
		
		//ANTIGUO
//		return "\"id\" : " + getId() + ",\n \"title\" : " + getTitle() + ",\n \"root\" : {\n\t" + getRoot().toString() + "}";
	}	
}
