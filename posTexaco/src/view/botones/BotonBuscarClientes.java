package view.botones;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class BotonBuscarClientes extends BotonesApp  {
	
	private ImageIcon imgGuardar;
	
	
	public BotonBuscarClientes(){
			super("F2 Clientes");
			
			/*imgGuardar=new ImageIcon(BotonCancelar.class.getResource("/view/recursos/clientes_2.png"));
			
			 Image image = imgGuardar.getImage();
			    // reduce by 50%
			 image = image.getScaledInstance(image.getWidth(null)/4, image.getHeight(null)/4, Image.SCALE_SMOOTH);
			 imgGuardar.setImage(image);
		
			this.setIcon(imgGuardar);*/
			
			this.setIcon(new ImageIcon(BotonBuscarClientes.class.getResource("/view/recursos/clientes.png")));
			this.setVerticalTextPosition(SwingConstants.BOTTOM);
			this.setHorizontalTextPosition(SwingConstants.CENTER);
				
			
		}

}
