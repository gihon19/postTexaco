package view.botones;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class BotonBebida extends BotonesApp{

	public BotonBebida() {
		// TODO Auto-generated constructor stub
		super("Bebida");
		setFont(new Font("Arial", Font.PLAIN, 12));
		
		this.setIcon(new ImageIcon(BotonCierreCaja.class.getResource("/view/recursos/bebida.png")));
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
	}
	public BotonBebida(String nombre) {
		super(nombre);
		setFont(new Font("Arial", Font.PLAIN, 12));
		this.setIcon(new ImageIcon(BotonCierreCaja.class.getResource("/view/recursos/bebida.png")));
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
	}

}
