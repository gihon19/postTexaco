package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import controlador.CtlCambioPago;
import controlador.CtlCambioPagoTouch;
import view.botones.BotonCancelar;
import view.botones.BotonCobrar;

public class ViewCambioPagoTouch extends JDialog {
	
	private JTextField txtEfectivo;
	private JTextField txtCambio;
	//private final ToggleGroup grupo;
	private ButtonGroup grupoOpciones;
	
	private JToggleButton tglbtnEfectivo;
	private JToggleButton tglbtnTarjetaCredito;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField txtReferenciatarjeta;
	private BotonCobrar btnCobrar;
	private BotonCancelar btnCerrar;
	private JPanel panel_2;
	
	private ViewTecladoNumerico tecladoNumerio;

	public ViewCambioPagoTouch(Window v) {
		
		super(v,"Forma de pago",Dialog.ModalityType.DOCUMENT_MODAL);
		//setUndecorated(true);
		Font myFont=new Font("OCR A Extended", Font.PLAIN, 45);
		 grupoOpciones = new ButtonGroup(); // crea ButtonGroup//para el grupo de la forma de pago
		 //Color color1 =Color.decode("#0009999");
		 Color color1 =Color.decode("#d4f4ff");
		 this.getContentPane().setBackground(color1);
		//this.setSize(317, 304);
		//this.setPreferredSize(new Dimension(588, 316));
		this.setSize(696, 596);
		this.setResizable(false);
		//setUndecorated(true);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(223, 6, 445, 161);
		panel.setBackground(color1);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPagaCon = new JLabel("Paga con:");
		lblPagaCon.setFont(new Font("Georgia", Font.BOLD, 13));
		lblPagaCon.setForeground(Color.BLACK);
		lblPagaCon.setBounds(6, 6, 77, 14);
		panel.add(lblPagaCon);
		
		txtEfectivo = new JTextField();
		txtEfectivo.setBounds(6, 26, 433, 54);
		txtEfectivo.setFont(myFont);
		panel.add(txtEfectivo);
		txtEfectivo.setColumns(10);
		
		JLabel lblCambio = new JLabel("Cambio:");
		lblCambio.setFont(new Font("Georgia", Font.BOLD, 13));
		lblCambio.setForeground(Color.BLACK);
		lblCambio.setBounds(6, 92, 77, 14);
		panel.add(lblCambio);
		
		txtCambio = new JTextField();
		txtCambio.setEditable(false);
		txtCambio.setFont(myFont);
		txtCambio.setBounds(6, 106, 433, 49);
		panel.add(txtCambio);
		txtCambio.setColumns(10);
		
		//imagen para el boton efectivo
		ImageIcon imgEfectivo=new ImageIcon(BotonCancelar.class.getResource("/view/recursos/icono_pago_efectivo.png"));
		
		Image image = imgEfectivo.getImage();
		    // reduce by 50%
		image = image.getScaledInstance(image.getWidth(null)/2, image.getHeight(null)/2, Image.SCALE_SMOOTH);
		imgEfectivo.setImage(image);
		
		//imagen para el boton tarjeta de credito
		ImageIcon imgTarjeta=new ImageIcon(BotonCancelar.class.getResource("/view/recursos/credit-card-icon.png"));
		
		image = imgTarjeta.getImage();
		    // reduce by 50%
		image = image.getScaledInstance(image.getWidth(null)/6, image.getHeight(null)/6, Image.SCALE_SMOOTH);
		imgTarjeta.setImage(image);
		
		panel_1 = new JPanel();
		panel_1.setBackground(color1);
		panel_1.setBounds(223, 6, 445, 161);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblReferencia = new JLabel("Referencia:");
		lblReferencia.setForeground(Color.BLACK);
		lblReferencia.setFont(new Font("Georgia", Font.BOLD, 13));
		lblReferencia.setBounds(6, 6, 102, 14);
		panel_1.add(lblReferencia);
		
		txtReferenciatarjeta = new JTextField();
		txtReferenciatarjeta.setBounds(6, 26, 433, 54);
		panel_1.add(txtReferenciatarjeta);
		txtReferenciatarjeta.setColumns(10);
		txtReferenciatarjeta.setFont(myFont);
		panel_1.setVisible(false);
		
		btnCobrar = new BotonCobrar();
		btnCobrar.setFont(new Font("Georgia", Font.BOLD, 13));
		btnCobrar.setForeground(Color.BLACK);
		btnCobrar.setBackground(color1);
		btnCobrar.setText("F2 Cobrar");
		btnCobrar.setBounds(482, 491, 186, 82);
		getContentPane().add(btnCobrar);
		
		btnCerrar = new BotonCancelar();
		btnCerrar.setFont(new Font("Georgia", Font.BOLD, 13));
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setBackground(color1);
		btnCerrar.setText("Esc Cerrar");
		btnCerrar.setBounds(231, 491, 186, 82);
		getContentPane().add(btnCerrar);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(60, 179, 113));
		panel_2.setBounds(0, 0, 219, 573);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		tglbtnTarjetaCredito = new JToggleButton("Tarjeta Credito");
		tglbtnTarjetaCredito.setBounds(10, 73, 194, 39);
		panel_2.add(tglbtnTarjetaCredito);
		tglbtnTarjetaCredito.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnTarjetaCredito.setIcon(imgTarjeta);
		grupoOpciones.add(tglbtnTarjetaCredito);
		
		tglbtnEfectivo = new JToggleButton("Efectivo");
		tglbtnEfectivo.setBounds(10, 27, 194, 39);
		panel_2.add(tglbtnEfectivo);
		
		this.tecladoNumerio=new ViewTecladoNumerico();
		tecladoNumerio.setBounds(233,179, 435, 300);
		getContentPane().add(tecladoNumerio);
		
		EventoTeclado eventoTeclado=new EventoTeclado();
		tecladoNumerio.conectarCtl(eventoTeclado);
		
		tglbtnEfectivo.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnEfectivo.setIcon(imgEfectivo);
		grupoOpciones.add(tglbtnEfectivo);
		tglbtnEfectivo.setSelected(true);
		this.setResizable(false);
		//centrar la ventana en la pantalla
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		//this.pack();
	}
	
	public JPanel getPanelEfectivo(){
		return panel_1;
	}
	public JPanel getPanelTarjeta(){
		return panel;
	}
	public JTextField getTxtCambio(){
		return txtCambio;
	}
	public JTextField getTxtEfectivo(){
		return txtEfectivo;
	}
	public JTextField getTxtReferencia(){
		return txtReferenciatarjeta;
	}
	public JToggleButton getTglbtnEfectivo(){
		return tglbtnEfectivo;
	}
	public  JToggleButton getTglbtnTarjetaCredito(){
		return tglbtnTarjetaCredito;
	}
	public JButton getBtnCobrar(){
		return btnCobrar;
	}
	public void conectarCtl(CtlCambioPagoTouch c) {
		// TODO Auto-generated method stub
		
		//tglbtnEfectivo.addActionListener(c);
		
		tglbtnEfectivo.addItemListener(c);
		tglbtnTarjetaCredito.addItemListener(c);
		txtEfectivo.addActionListener(c);
		txtEfectivo.addKeyListener(c);
		
		txtEfectivo.setActionCommand("CAMBIO");
		txtReferenciatarjeta.addKeyListener(c);
		
		
		tglbtnEfectivo.addKeyListener(c);
		tglbtnTarjetaCredito.addKeyListener(c);
		
		btnCerrar.addActionListener(c);
		btnCerrar.setActionCommand("CERRAR");
		this.btnCerrar.addKeyListener(c);
		
		btnCobrar.addActionListener(c);
		btnCobrar.setActionCommand("COBRAR");
		this.btnCobrar.addKeyListener(c);
		this.addWindowListener(c);
		
		txtCambio.addActionListener(c);
		txtCambio.setActionCommand("IMPRIMIR");
		
		this.tecladoNumerio.getBtnEnter().addActionListener(c);
		this.tecladoNumerio.getBtnEnter().setActionCommand("ENTER");
		
		txtCambio.addKeyListener(c);
		
	}
	
	private class EventoTeclado implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String comando=e.getActionCommand();
			
			JTextField resultado;
			
			if(tglbtnEfectivo.isSelected()){
				switch(comando){
				case "UNO":
					txtEfectivo.setText(txtEfectivo.getText()+"1");
					break;
				case "DOS":
					txtEfectivo.setText(txtEfectivo.getText()+"2");
					break;
				case "TRES":
					txtEfectivo.setText(txtEfectivo.getText()+"3");
					break;
				case "CUATRO":
					txtEfectivo.setText(txtEfectivo.getText()+"4");
					break;
				case "CINCO":
					txtEfectivo.setText(txtEfectivo.getText()+"5");
					break;
				case "SEIS":
					txtEfectivo.setText(txtEfectivo.getText()+"6");
					break;
				case "SIETE":
					txtEfectivo.setText(txtEfectivo.getText()+"7");
					break;
				case "OCHO":
					txtEfectivo.setText(txtEfectivo.getText()+"8");
					break;
				case "NUEVE":
					txtEfectivo.setText(txtEfectivo.getText()+"9");
					break;
				case "PUNTO":
					txtEfectivo.setText(txtEfectivo.getText()+".");
					break;
				case "CERO":
					txtEfectivo.setText(txtEfectivo.getText()+"0");
					break;
					
				case "BORRAR":
					String total=txtEfectivo.getText();
					total = total.substring(0, total.length() - 1);
					txtEfectivo.setText(total);
					break;
				case "ENTER":
					
					break;
				}
			}
			if(tglbtnTarjetaCredito.isSelected()){
				switch(comando){
				case "UNO":
					txtReferenciatarjeta.setText(txtReferenciatarjeta.getText()+"1");
					break;
				case "DOS":
					txtReferenciatarjeta.setText(txtReferenciatarjeta.getText()+"2");
					break;
				case "TRES":
					txtReferenciatarjeta.setText(txtReferenciatarjeta.getText()+"3");
					break;
				case "CUATRO":
					txtReferenciatarjeta.setText(txtReferenciatarjeta.getText()+"4");
					break;
				case "CINCO":
					txtReferenciatarjeta.setText(txtReferenciatarjeta.getText()+"5");
					break;
				case "SEIS":
					txtReferenciatarjeta.setText(txtReferenciatarjeta.getText()+"6");
					break;
				case "SIETE":
					txtReferenciatarjeta.setText(txtReferenciatarjeta.getText()+"7");
					break;
				case "OCHO":
					txtReferenciatarjeta.setText(txtReferenciatarjeta.getText()+"8");
					break;
				case "NUEVE":
					txtReferenciatarjeta.setText(txtReferenciatarjeta.getText()+"9");
					break;
				case "PUNTO":
					txtReferenciatarjeta.setText(txtReferenciatarjeta.getText()+".");
					break;
				case "CERO":
					txtReferenciatarjeta.setText(txtReferenciatarjeta.getText()+"0");
					break;
					
				case "BORRAR":
					String total=txtReferenciatarjeta.getText();
					total = total.substring(0, total.length() - 1);
					txtReferenciatarjeta.setText(total);
					break;

				}
			}
			
			
			
		}
	}

}
