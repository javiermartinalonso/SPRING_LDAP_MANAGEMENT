package es.ldap.spring.management.modelo.bean;

public class NodoLDAP
{
	private String id;
	private String title;
	
	private String subtitle;

	private String image;
	private String image_position;

	private TypeNode type;
	
	private String box_color;
		
	private SubTypeNode subtype;
	
	
	public NodoLDAP(String id, String title, TypeNode type, String subtitle, String image, String image_position, String box_color, SubTypeNode subtype)
	{
		super();
		setId(id);
		setTitle(title);

		setSubtitle(subtitle);
		setImage(image);
		setImage_position(image_position);
		setType(type);
		
		setBox_color(box_color);
		setSubtype(subtype);
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
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

	public String getSubtitle()
	{
		return subtitle;
	}

	public void setSubtitle(String subtitle)
	{
		this.subtitle = subtitle;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}
	
	public String getImage_position()
	{
		return image_position;
	}

	public void setImage_position(String image_position)
	{
		this.image_position = image_position;
	}

	public TypeNode getType()
	{
		return type;
	}
	
	public void setType(TypeNode type)
	{
		this.type = type;
	}
	
	public String getBox_color()
	{
		return box_color;
	}

	public void setBox_color(String box_color)
	{
		this.box_color = box_color;
	}

	public SubTypeNode getSubtype()
	{
		return subtype;
	}

	public void setSubtype(SubTypeNode subtype)
	{
		this.subtype = subtype;
	}

	@Override
	public String toString()
	{	       
		StringBuffer strb = new StringBuffer("\"id\" : " + getId() 
		+ ", \"title\" : " + getTitle());
		
		return strb.toString();
				
	}	
}
