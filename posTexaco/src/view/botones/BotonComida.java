package view.botones;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class BotonComida extends BotonesApp  {

	public BotonComida() {
		// TODO Auto-generated constructor stub
		super("Comida");
		setFont(new Font("Arial", Font.PLAIN, 12));
		
		this.setIcon(new ImageIcon(BotonCierreCaja.class.getResource("/view/recursos/comida.png")));
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
	}
	public BotonComida(String nombre) {
		super(nombre);
		
		setFont(new Font("Arial", Font.PLAIN, 12));
		this.setIcon(new ImageIcon(BotonCierreCaja.class.getResource("/view/recursos/comida.png")));
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
	}

}
