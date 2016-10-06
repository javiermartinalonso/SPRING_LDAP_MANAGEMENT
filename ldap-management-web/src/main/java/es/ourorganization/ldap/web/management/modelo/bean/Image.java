package es.ourorganization.ldap.web.management.modelo.bean;

public class Image
{
	private String image;
	private ImagePosition image_position;
	
	public Image(String image, ImagePosition image_position)
	{
		super();
		this.image = image;
		this.image_position = image_position;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public ImagePosition getImage_position()
	{
		return image_position;
	}

	public void setImage_position(ImagePosition image_position)
	{
		this.image_position = image_position;
	}

	@Override
	public String toString()
	{
		return "Image [image=" + image + ", image_position=" + image_position + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
