package es.ourorganization.ldap.web.management.modelo.bean;

import java.util.List;

public class NodeChildren extends NodoLDAP
{
	private List <NodoLDAP> children;
	
	public NodeChildren(String id, String title, TypeNode type, String subtitle, String image,String image_position, String box_color, SubTypeNode subtype, List <NodoLDAP> listNodoLDAP)
	{
		super(id, title, type, subtitle, image, image_position, box_color, subtype);
		
		setChildren(listNodoLDAP);
	}
	
	public List<NodoLDAP> getChildren()
	{
		return children;
	}

	public void setChildren(List<NodoLDAP> children)
	{
		this.children = children;
	}

	@Override
	public String toString()
	{			
		StringBuffer strb = 
				new StringBuffer("\"id\" : \"" + getId() + "\"")
				.append(", \"title\" : \"" + getTitle() + "\"")
				.append(", \"type\" : \"" + getType().getDescripcion()+ "\"");
				
		if (children != null)
		{
			strb.append(", \"children\" : [");
			boolean primeraVez = true;
			
			for (NodoLDAP nodoLDAP : children)
			{
				if (!primeraVez)
				{
					strb.append(", ");
				}
				else
				{
					primeraVez = false;
				}		
				
				strb.append("{" + nodoLDAP.toString() + "}");
			}
			
			strb.append("]");
		}
		
		
		//ANTIGUO
//		StringBuffer strb = new StringBuffer("\"id\" : " + getId())
//				.append(", \"title\" : " + getTitle())
//				.append(", \"type\" : " + getType().getDescripcion());
//		
//		if (getChildren().size()>0)
//		{
//			strb.append(", \"children\" : " + getChildren().toString());
//		}
				
		return strb.toString();
	}	
}
