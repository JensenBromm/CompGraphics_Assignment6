package assignment6;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.applet.MainFrame;

public class Assignment6 
{
	public Assignment6()
	{
		//Basically just the scene that we are building
		SimpleUniverse universe=new SimpleUniverse();
		
		//Node in tree data structure that can have child nodes
		//Seems Similar to Vertical or Horizontal Boxes in javafx
		BranchGroup group=new BranchGroup();
		
		//Adds a cube to the scene
		//group.addChild(new Sphere(0.5f));
		
		//Setting up the font
		Appearance ap=new Appearance();
		ap.setMaterial(new Material());
		Font3D font=new Font3D(new Font("Helvetica",Font.PLAIN,1), new FontExtrusion());
		
		//Creating name text
			//Creating First Name
			Text3D first=new Text3D(font,"Jensen");
			Shape3D firstShape=new Shape3D(first,ap);
			
			//Create Last Name
			Text3D last=new Text3D(font,"Bromm");
			Shape3D lastShape=new Shape3D(last,ap);
			
			//Scale down the First name
			Transform3D tr=new Transform3D();
			tr.setScale(0.2);
			tr.setTranslation(new Vector3d(-0.35,0,0.75));
			
			//Scale Down the Last Name
			Transform3D tr2=new Transform3D();
			tr2.setScale(0.3);
			tr2.setTranslation(new Vector3d(-0.5,-0.3,0.75));
		//Create Transform Group to apply the transform to multiple objects
			TransformGroup tg=new TransformGroup(tr);
			TransformGroup tg2=new TransformGroup(tr2);
		//Add transform group to scene
			group.addChild(tg);
			group.addChild(tg2);
			
		//Add names to transform group
			tg.addChild(firstShape);
				
			tg2.addChild(lastShape);
		
		//Create the blue background
		Background background = new Background(new Color3f(0,0,1f));
		BoundingSphere sphere = new BoundingSphere(new Point3d(0,0,0), 100000); //background is inside this sphere
		background.setApplicationBounds(sphere);
		group.addChild(background); //add to the scene
		
		//Create a color that shines on object
			Color3f lightColor=new Color3f(.75f,.75f,.75f);
			//Light is 100m away from origin
			BoundingSphere bounds=new BoundingSphere(new Point3d(0,0,0),100);
			//Create a vector for lights direction
			Vector3f direction=new Vector3f(4.0f,-7.0f,-12.0f);
			//Actually create the light
			DirectionalLight light=new DirectionalLight(lightColor,direction);
			light.setInfluencingBounds(bounds);
			//add to group
			group.addChild(light);
		//Set viewing distance bases it off FOV
		universe.getViewingPlatform().setNominalViewingTransform();
		//Add the group of objects to the scene
		universe.addBranchGraph(group); 
	}
	
	public static void main(String args[]) 
	{
		System.setProperty("sun.awt.noerasebackground", "true");
		new Assignment6();
	}
  
  
}