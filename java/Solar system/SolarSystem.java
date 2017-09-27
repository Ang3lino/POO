
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class SolarSystem {	
	private BranchGroup group = new BranchGroup();
	private TextureLoader tex;
	private Sphere sun, mercury, venus, earth;
	private Appearance appsun = new Appearance(), 
		appmercury = new Appearance(), 
		appvenus = new Appearance(), 
		appearth = new Appearance();

	// Cargamos las texturas de una imagen rectangular
	private void initTextures() {
		tex = new TextureLoader("SOL.JPG", null);
		appsun.setTexture(tex.getTexture());
		tex = new TextureLoader("MERCURIO.JPG", null);
		appmercury.setTexture(tex.getTexture());
		tex = new TextureLoader("VENUS.JPG", null);
		appvenus.setTexture(tex.getTexture());
		tex = new TextureLoader("TIERRA.JPG", null);
		appearth.setTexture(tex.getTexture());
	}

	// el primer parametro del constructor de los objetos Sphere establece el radio
	private void initSpheres() {
		sun = new Sphere(0.22f, Primitive.GENERATE_NORMALS | 
			Primitive.GENERATE_TEXTURE_COORDS, 32, appsun);
		mercury = new Sphere(0.03f, Primitive.GENERATE_NORMALS | 
			Primitive.GENERATE_TEXTURE_COORDS, 32, appmercury);
		venus = new Sphere(0.04f, Primitive.GENERATE_NORMALS | 
			Primitive.GENERATE_TEXTURE_COORDS, 32, appvenus);
		earth = new Sphere(0.045f, Primitive.GENERATE_NORMALS | 			
			Primitive.GENERATE_TEXTURE_COORDS, 32, appearth);
	}

	public SolarSystem() {	 
		initTextures();
		initSpheres();
		// Se rotan los planetas en su propio eje
		TransformGroup sunRotXformGroup = Posi.rotate(sun, new Alpha(-1, 1250));
		TransformGroup mercuryRotXformGroup = Posi.rotate(mercury, new Alpha(-1, 3000));
		TransformGroup venusRotXformGroup = Posi.rotate(venus, new Alpha(-1, 2600));
		TransformGroup earthRotXformGroup = Posi.rotate(earth, new Alpha(-1, 1250));

		// Posicionamos los planetas en un punto
		TransformGroup mercuryTransXformGroup = Posi.translate(mercuryRotXformGroup, 
			new Vector3f(0.3f, 0, 0));
		TransformGroup venusTransXformGroup = Posi.translate(venusRotXformGroup, 
			new Vector3f(0.5f,.0f,  0));
		TransformGroup earthTransXformGroup = Posi.translate(earthRotXformGroup, 
			new Vector3f(0.7f, 0.0f, 0f));

		// Rotamos los planetas que ya rotan alrededor del origen donde esta el sol
		TransformGroup mercuryRotGroupXformGroup = Posi.rotate(mercuryTransXformGroup,
			new Alpha(-1, 14000));
		TransformGroup venusRotGroupXformGroup = Posi.rotate(venusTransXformGroup,
			new Alpha(-1, 9000));
		TransformGroup earthRotGroupXformGroup = Posi.rotate(earthTransXformGroup, 
			new Alpha(-1, 5000));

		group.addChild(sunRotXformGroup);
		group.addChild(mercuryRotGroupXformGroup);
		group.addChild(venusRotGroupXformGroup);
		group.addChild(earthRotGroupXformGroup);

		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
		Canvas3D canvas = new Canvas3D(config); canvas.setSize(400, 400);
		SimpleUniverse universe = new SimpleUniverse(canvas);
		universe.getViewingPlatform().setNominalViewingTransform();
		universe.addBranchGraph(group);  
		JFrame f = new JFrame("Planetario");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
		f.add(canvas); f.pack(); f.setVisible(true); 
	}

	public static void main(String parameters[]) { 
		new SolarSystem();
	}	
}                                                                         
