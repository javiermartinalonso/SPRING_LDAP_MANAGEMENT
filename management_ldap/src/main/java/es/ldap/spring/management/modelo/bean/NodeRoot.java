package es.ldap.spring.management.modelo.bean;

public class NodeRoot
{
	private Long id;
	private String title;
	private NodeChildren root;	
	
	public NodeRoot(Long id, String title, NodeChildren nodoLDAP)
	{
		super();
		this.id = id;
		this.title = title;		
		setRoot(nodoLDAP);
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
		return root;
	}

	public void setRoot(NodeChildren root)
	{
		this.root = root;
	}

	@Override
	public String toString()
	{	
//		return "NodoLDAP [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";v
		
		return "\"id\" : " + getId() + ",\n \"title\" : " + getTitle() + ",\n \"root\" : {\n\t" + getRoot().toString() + "}";
	}	
}
