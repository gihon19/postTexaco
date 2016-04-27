package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controlador.CtlFacturar;
import controlador.CtlFacturarTouch;
import modelo.DetalleFactura;
import view.botones.BotonActualizar;
import view.botones.BotonAgregar;
import view.botones.BotonArticulo;
import view.botones.BotonBuscar1;
import view.botones.BotonBuscarClientes;
import view.botones.BotonCancelar;
import view.botones.BotonCierreCaja;
import view.botones.BotonCobrar;
import view.botones.BotonEliminar;
import view.botones.BotonGuardar;
import view.botones.BotonMenos;
import view.botones.BotonPendientes;
import view.botones.BotonesApp;
import view.rendes.PanelPadre;
import view.rendes.RenderizadorTablaFactura;
import view.tablemodel.CbxTmEmpleado;
import view.tablemodel.TablaModeloFactura;
import view.tablemodel.TmFacturarTouch;

import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JToggleButton;

public class ViewFacturarTouch extends JDialog {
	
	protected BorderLayout miEsquema;
	protected JTable tableDetalle;
	protected TmFacturarTouch modeloTabla;
	
	protected JPanel panelAcciones;
	protected JPanel panelDatosFactura;
	protected JPanel panelNorte;
	protected JPanel panel_1;
	protected JLabel lblFecha;
	protected JTextField txtFechafactura;
	protected JLabel lblCodigoCliente;
	protected JTextField txtIdcliente;
	protected JTextField txtNombrecliente;
	
	protected ButtonGroup grupoOpciones;
	protected JRadioButton rdbtnCredito;
	protected JRadioButton rdbtnContado;
	
	protected JTextField txtSubtotal;
	protected JLabel lblSubtotal;
	protected JTextField txtImpuesto;
	protected JLabel lblImpuesto;
	protected JTextField txtTotal;
	protected JLabel lblTotal;
	protected JLabel lblNombreCliente;
	protected JLabel lblContado;
	protected JLabel lblCredito;
	
	protected BotonGuardar btnGuardar;
	protected BotonCancelar btnCerrar;
	protected BotonBuscar1 btnBuscar;
	protected BotonBuscarClientes btnCliente;
	protected BotonCobrar btnCobrar;
	protected JButton btnCierreCaja;
	
	protected JTextField txtDescuento;
	
	protected BotonActualizar btnActualizar;
	protected JTextField txtImpuesto18;
	protected BotonPendientes btnPendientes;
	
	protected JTextField txtRtn;
	//se crea el modelo de la lista de los impuestos
	protected CbxTmEmpleado modeloEmpleado;//=new ComboBoxImpuesto();
	protected JPanel panel;
	protected JLabel lblBuscar;
	private JPanel panel_2;
	private JLabel lblLogo;
	private JPanel jpArticulos;
	private JToolBar toolBar;
	
	private List<BotonArticulo> btnArticulos=new ArrayList<BotonArticulo>();
	private JPanel jpBtnsArticulos;
	private JPanel jpBtnNavegacion;
	private JButton btnCombo;
	
	private JButton btnAtras;
	private JButton btnSiguiente;
	
	protected ButtonGroup grupoOpcionesArt;
	private JToggleButton tglbtnComida;
	private JToggleButton tglbtnBebida;
	private JPanel panelBuscar;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnMenos;

	public ViewFacturarTouch(Window view) {
		// TODO Auto-generated constructor stub

		
		

		
		super(view,"Facturar",Dialog.ModalityType.DOCUMENT_MODAL);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewFacturar.class.getResource("/view/recursos/logo-admin-tool1.png")));
		//getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		grupoOpciones = new ButtonGroup();
		grupoOpcionesArt = new ButtonGroup();
		modeloEmpleado=new CbxTmEmpleado();
		modeloTabla=new TmFacturarTouch();
		RenderizadorTablaFactura renderizador = new RenderizadorTablaFactura();
		miEsquema=new BorderLayout();
		//Color color1 =Color.decode("#0009999");
		Color color1 =new Color(60, 179, 113);
		Color color2 =Color.decode("#33cccc");
		Color color3 =Color.decode("#d4f4ff");
		Color color4 =Color.decode("#f4fbfe");
		
		panelNorte=new JPanel();
	
		this.getContentPane().setBackground(color3);
		
		//this.setTitle("Articulos");
		getContentPane().setLayout(miEsquema);
		panelAcciones=new JPanel();
		panelAcciones.setPreferredSize(new Dimension(140,128));
		panelAcciones.setBackground(color3);
		//panelAcciones.setBounds(20, 11, 178, 459);
		//panelAcciones.setLayout(null);
		//panelAcciones.setVisible(false);
		JPanel panelNorte=new JPanel();
		panelNorte.setBackground(color1);
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(0, 0));
				
		
		
		
		
		
		
		
		
		tableDetalle = new JTable();
		tableDetalle.setModel(modeloTabla);
		/*tableDetalle.getTableHeader().setBackground(color1);
		tableDetalle.getTableHeader().setForeground(Color.WHITE);*/
	    
		
		//tableDetalle.setBackground(color4);
		tableDetalle.setDefaultRenderer(String.class, renderizador);
		//tableDetalle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);     //Tama�o de las columnas de las tablas
		tableDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);	//
		tableDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);	//
		tableDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);	//
		
		tableDetalle.setRowHeight(50);
		//registerEnterKey( );
		
		JScrollPane scrollPane = new JScrollPane(tableDetalle);
		
		scrollPane.setBackground(color3);
		scrollPane.getViewport().setBackground(color3);
		
		panel_2 = new JPanel();
		panel_2.setBackground(color3);
		panelNorte.add(panel_2, BorderLayout.WEST);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ViewFacturar.class.getResource("/view/recursos/logo_facturar.png")));
		panel_2.add(lblLogo);
		
		panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout(0, 0));
		panelNorte.add(panel_1, BorderLayout.CENTER);
		
		
		
		
		panelDatosFactura=new JPanel();
		panel_1.add(panelDatosFactura, BorderLayout.CENTER);
		panelDatosFactura.setBackground(color3);
		
		//panelDatosFactura.setBackground(Color.WHITE);
		panelDatosFactura.setBorder(new TitledBorder(new LineBorder(new Color(130, 135, 144)), "Datos Generales", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		//panelDatosFactura.setBounds(196, 11, 802, 84);
		//panelDatosFactura.setVisible(false);
		panelDatosFactura.setLayout(new GridLayout(0, 6, 10, 0));
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Georgia", Font.BOLD, 13));
		panelDatosFactura.add(lblFecha);
		
		lblCodigoCliente = new JLabel("Id Cliente");
		lblCodigoCliente.setFont(new Font("Georgia", Font.BOLD, 13));
		panelDatosFactura.add(lblCodigoCliente);
		
		lblNombreCliente = new JLabel("Nombre Cliente");
		lblNombreCliente.setFont(new Font("Georgia", Font.BOLD, 13));
		panelDatosFactura.add(lblNombreCliente);
		
		
		JLabel lblRtn = new JLabel("R:T:N");
		lblRtn.setFont(new Font("Georgia", Font.BOLD, 13));
		panelDatosFactura.add(lblRtn);
		
		lblContado = new JLabel("Contado");
		lblContado.setFont(new Font("Georgia", Font.BOLD, 13));
		lblContado.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatosFactura.add(lblContado);
		
		lblCredito = new JLabel("Credito");
		lblCredito.setFont(new Font("Georgia", Font.BOLD, 13));
		lblCredito.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatosFactura.add(lblCredito);
		
		txtFechafactura = new JTextField();
		txtFechafactura.setBackground(color4);
		txtFechafactura.setEditable(false);
		panelDatosFactura.add(txtFechafactura);
		txtFechafactura.setColumns(10);
		
		txtIdcliente = new JTextField();
		txtIdcliente.setBackground(color4);
		panelDatosFactura.add(txtIdcliente);
		txtIdcliente.setColumns(10);
		
		txtNombrecliente = new JTextField();
		txtNombrecliente.setBackground(color4);
		txtNombrecliente.setToolTipText("Nombre Cliente");
		panelDatosFactura.add(txtNombrecliente);
		txtNombrecliente.setColumns(10);
		
		txtRtn = new JTextField();
		txtRtn.setBackground(color4);
		panelDatosFactura.add(txtRtn);
		txtRtn.setColumns(10);
		
		rdbtnContado = new JRadioButton("");
		rdbtnContado.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnContado.setSelected(true);
		grupoOpciones.add(rdbtnContado);
		panelDatosFactura.add(rdbtnContado);
		rdbtnCredito = new JRadioButton("");
		rdbtnCredito.setHorizontalAlignment(SwingConstants.CENTER);
		grupoOpciones.add(rdbtnCredito);
		panelDatosFactura.add(rdbtnCredito);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		//panelNorte.add(scrollPane);
		//scrollPane.setBounds(196, 144, 802, 326);
		//panelNorte
		
		//this.setTitle("Facturar");
		getContentPane().add(panelAcciones, BorderLayout.WEST);
		panelAcciones.setLayout(new GridLayout(8, 1, 0, 0));
		
		panelBuscar= new JPanel();
		panelBuscar.setBackground(color3);
		panel_1.add(panelBuscar, BorderLayout.SOUTH);
		panelBuscar.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnAgregar = new BotonAgregar();
		btnAgregar.setPreferredSize(new Dimension(80,50));
		panelBuscar.add(btnAgregar);
		
		btnMenos = new BotonMenos();
		btnMenos.setPreferredSize(new Dimension(80,50));
		panelBuscar.add(btnMenos);
		
		btnEliminar = new BotonEliminar();
		btnEliminar.setPreferredSize(new Dimension(80,50));
		panelBuscar.add(btnEliminar);
		
		btnBuscar = new BotonBuscar1();
		btnBuscar.setBackground(color1);
		panelAcciones.add(btnBuscar);
		
		btnCobrar = new BotonCobrar();
		btnCobrar.setBackground(color1);
		btnCobrar.setText("F2 Cobrar");
		panelAcciones.add(btnCobrar);
		
		btnCliente = new BotonBuscarClientes();
		btnCliente.setBackground(color1);
		btnCliente.setText("F3 Clientes");
		panelAcciones.add(btnCliente);
		
		btnGuardar = new BotonGuardar();
		btnGuardar.setBackground(color1);
		btnGuardar.setText("F4 Guardar");
		panelAcciones.add(btnGuardar);
		
		btnPendientes = new BotonPendientes();// new JButton("F5 Pendientes");
		btnPendientes.setBackground(color1);
		btnPendientes.setText("F5 Pendientes");
		panelAcciones.add(btnPendientes);
		
		btnCierreCaja = new BotonCierreCaja();// JButton("F6 Cierre");
		btnCierreCaja.setBackground(color1);
		btnCierreCaja.setText("F6 Cierre");
		btnCierreCaja.setHorizontalTextPosition(SwingConstants.CENTER);
		panelAcciones.add(btnCierreCaja);
		
		btnActualizar=new BotonActualizar();
		btnActualizar.setEnabled(false);
		btnActualizar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnActualizar.setBackground(color1);
		btnActualizar.setText("F7 Actualizar");
		panelAcciones.add(btnActualizar);
		//btnActualizar.setVisible(false);
		
		btnCerrar = new BotonCancelar();
		btnCerrar.setBackground(color1);
		btnCerrar.setText("Esc Cerrar");
		panelAcciones.add(btnCerrar);
		
		
		
		
		
		
		//getContentPane().setLayout(null);
		
		Font myFont=new Font("OCR A Extended", Font.PLAIN, 45);
		
		/*panel = new JPanel();
		panel.setBackground(color3);
		getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(10, 1, 0, 0));
		//lblImpuesto_1.setBounds(424, 490, 82, 14);
		
		lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Georgia", Font.BOLD, 13));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBackground(color4);
		panel.add(txtTotal);
		txtTotal.setForeground(Color.RED);
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotal.setFont(myFont);
		txtTotal.setText("00");
		txtTotal.setEditable(false);
		//txtTotal.setBounds(778, 506, 220, 44);
		txtTotal.setColumns(8);
		//lblImpuesto.setBounds(237, 490, 92, 14);
		
		JLabel lblImpuesto_1 = new JLabel("Impuesto 18");
		lblImpuesto_1.setFont(new Font("Georgia", Font.BOLD, 13));
		lblImpuesto_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblImpuesto_1);
		
		txtImpuesto18 = new JTextField();
		txtImpuesto18.setBackground(color4);
		panel.add(txtImpuesto18);
		txtImpuesto18.setText("00");
		txtImpuesto18.setHorizontalAlignment(SwingConstants.RIGHT);
		txtImpuesto18.setFont(myFont);
		txtImpuesto18.setEditable(false);
		//txtImpuesto18.setBounds(424, 506, 171, 44);
		//txtImpuesto18.setColumns(10);
		//lblDescuento.setBounds(605, 490, 92, 14);
		
		lblImpuesto = new JLabel("Impuesto 15");
		lblImpuesto.setFont(new Font("Georgia", Font.BOLD, 13));
		lblImpuesto.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblImpuesto);
		
		txtImpuesto = new JTextField();
		txtImpuesto.setBackground(color4);
		panel.add(txtImpuesto);
		txtImpuesto.setHorizontalAlignment(SwingConstants.RIGHT);
		txtImpuesto.setFont(myFont);
		txtImpuesto.setText("00");
		txtImpuesto.setEditable(false);
		//txtImpuesto.setBounds(237, 506, 177, 44);
		//txtImpuesto.setColumns(10);
		//lblSubtotal.setBounds(20, 490, 59, 14);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setFont(new Font("Georgia", Font.BOLD, 13));
		lblDescuento.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDescuento);
		
		txtDescuento = new JTextField();
		txtDescuento.setBackground(color4);
		panel.add(txtDescuento);
		txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDescuento.setEditable(false);
		txtDescuento.setText("00");
		txtDescuento.setFont(myFont);
		//txtDescuento.setBounds(605, 506, 163, 44);
		//txtDescuento.setColumns(10);
		
		lblSubtotal = new JLabel("SubTotal");
		lblSubtotal.setFont(new Font("Georgia", Font.BOLD, 13));
		lblSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSubtotal);
		//lblTotal.setBounds(780, 490, 46, 14);
		
		
		
		
		txtSubtotal = new JTextField();
		txtSubtotal.setBackground(color4);
		panel.add(txtSubtotal);
		txtSubtotal.setFont(myFont);
		txtSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSubtotal.setText("00");
		
		txtSubtotal.setEditable(false);
		//txtSubtotal.setBounds(20, 506, 207, 44);
		//txtSubtotal.setColumns(10);*/
		
		panel = new JPanel();
		panel.setBackground(color3);
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(2, 10, -20, -20));
		//lblImpuesto_1.setBounds(424, 490, 82, 14);
		
		lblSubtotal = new JLabel("SubTotal");
		lblSubtotal.setFont(new Font("Georgia", Font.BOLD, 13));
		lblSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSubtotal);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setFont(new Font("Georgia", Font.BOLD, 13));
		lblDescuento.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDescuento);
		
		lblImpuesto = new JLabel("Impuesto 15");
		lblImpuesto.setFont(new Font("Georgia", Font.BOLD, 13));
		lblImpuesto.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblImpuesto);
		
		JLabel lblImpuesto_1 = new JLabel("Impuesto 18");
		lblImpuesto_1.setFont(new Font("Georgia", Font.BOLD, 13));
		lblImpuesto_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblImpuesto_1);
		
		lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Georgia", Font.BOLD, 13));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTotal);
		
		
		//lblImpuesto.setBounds(237, 490, 92, 14);
		
		
		txtSubtotal = new JTextField();
		txtSubtotal.setBackground(color4);
		panel.add(txtSubtotal);
		txtSubtotal.setFont(new Font("Dialog", Font.PLAIN, 35));
		txtSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSubtotal.setText("00");
		txtSubtotal.setEditable(false);
		
		
		txtDescuento = new JTextField();
		txtDescuento.setBackground(color4);
		panel.add(txtDescuento);
		txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDescuento.setEditable(false);
		txtDescuento.setText("00");
		txtDescuento.setFont(new Font("Dialog", Font.PLAIN, 35));
		
		
		
		txtImpuesto = new JTextField();
		txtImpuesto.setBackground(color4);
		panel.add(txtImpuesto);
		txtImpuesto.setHorizontalAlignment(SwingConstants.RIGHT);
		txtImpuesto.setFont(new Font("Dialog", Font.PLAIN, 35));
		txtImpuesto.setText("00");
		txtImpuesto.setEditable(false);
		
		
		
		txtImpuesto18 = new JTextField();
		txtImpuesto18.setBackground(color4);
		panel.add(txtImpuesto18);
		txtImpuesto18.setText("00");
		txtImpuesto18.setHorizontalAlignment(SwingConstants.RIGHT);
		txtImpuesto18.setFont(new Font("Dialog", Font.PLAIN, 35));
		txtImpuesto18.setEditable(false);
		//txtImpuesto18.setBounds(424, 506, 171, 44);
		//txtImpuesto18.setColumns(10);
		//lblDescuento.setBounds(605, 490, 92, 14);
		
		
		
		
		
		
		txtTotal = new JTextField();
		txtTotal.setBackground(color4);
		panel.add(txtTotal);
		txtTotal.setForeground(Color.RED);
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotal.setFont(new Font("Dialog", Font.PLAIN, 35));
		txtTotal.setText("00");
		txtTotal.setEditable(false);
		//txtTotal.setBounds(778, 506, 220, 44);
		txtTotal.setColumns(8);
		
		jpArticulos = new JPanel();
		//jpArticulos.setBackground(PanelPadre.color1);
		jpArticulos.setLayout(new BorderLayout());
		getContentPane().add(jpArticulos, BorderLayout.EAST);
		
		toolBar = new JToolBar();
		toolBar.setPreferredSize(new Dimension(128,50));
		jpArticulos.add(toolBar,BorderLayout.NORTH);
		
		tglbtnComida = new JToggleButton("Comida");
		grupoOpcionesArt.add(tglbtnComida);
		tglbtnComida.setSelected(true);
		tglbtnComida.setPreferredSize(new Dimension(100,70));
		toolBar.add(tglbtnComida);
		
		tglbtnBebida = new JToggleButton("Bebida");
		grupoOpcionesArt.add(tglbtnBebida);
		tglbtnBebida.setPreferredSize(new Dimension(100,70));
		toolBar.add(tglbtnBebida);
		
		jpBtnsArticulos = new JPanel();
		jpBtnsArticulos.setPreferredSize(new Dimension(600,400));
		jpBtnsArticulos.setBackground(PanelPadre.color1);
		jpArticulos.add(jpBtnsArticulos, BorderLayout.CENTER);
		jpBtnsArticulos.setLayout(new GridLayout(0, 4, 6, 0));
		
		
		
		jpBtnNavegacion = new JPanel();
		jpBtnNavegacion.setBackground(PanelPadre.color1);
		jpArticulos.add(jpBtnNavegacion, BorderLayout.SOUTH);
		jpBtnNavegacion.setPreferredSize(new Dimension(140,70));
		jpBtnNavegacion.setLayout(new BorderLayout(0, 0));
		
		btnAtras = new BotonesApp("   Atras   ");
		jpBtnNavegacion.add(btnAtras, BorderLayout.WEST);
		
		btnSiguiente = new BotonesApp("Siguiente");
		jpBtnNavegacion.add(btnSiguiente, BorderLayout.EAST);
		
		
		//setSize(1024, 600);
		setSize(this.getToolkit().getScreenSize());
		//this.setPreferredSize(new Dimension(1024, 600));
		//this.setResizable(false);
		//centrar la ventana en la pantalla
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		//this.pack();
		
			
	
	}
	
	public JPanel getJpBtnsArticulos(){
		return jpBtnsArticulos;
	}
	
	public CbxTmEmpleado getModeloEmpleados(){
		return this.modeloEmpleado;
	}
	
	public JRadioButton getRdbtnContado(){
		return rdbtnContado;
	}
	public  JRadioButton getRdbtnCredito(){
		return  rdbtnCredito;
	}
	public BotonActualizar getBtnActualizar(){
		return btnActualizar;
	}
	public JTextField getTxtRtn(){
		return txtRtn;
	}
	public BotonGuardar getBtnGuardar(){
		return btnGuardar;
	}
	public JButton getBtnBuscar(){
		return btnBuscar;
	}
	public JButton getBtnBuscarCliente(){
		return btnCliente;
	}
	public JButton getBtnCobrar(){
		return btnCobrar;
	}
	public JButton getBtnCerrar(){
		return btnCerrar;
	}
	public JButton getBtnPendientes(){
		return this.btnPendientes;
	}
	public JPanel getPanelAcciones(){
		return panelAcciones;
	}
	public JTextField getTxtDescuento(){
		return txtDescuento;		
	}
	public JTextField getTxtSubtotal(){
		return txtSubtotal;
	}
	public JTextField getTxtImpuesto(){
		return txtImpuesto;
	}
	public JTextField getTxtImpuesto18(){
		return txtImpuesto18;
	}
	public JTextField getTxtTotal(){
		return txtTotal;
	}
	public JTextField getTxtNombrecliente(){
		return txtNombrecliente;
	}
	public JTextField getTxtIdcliente(){
		return txtIdcliente;
	}
	public TmFacturarTouch getModeloTabla(){
		return modeloTabla;
	}
	public JTable getTableDetalle(){
		return tableDetalle;
	}
	public JTextField getTxtFechafactura(){
		return txtFechafactura;
	}
	public JToggleButton getTglbtnComida(){
		return tglbtnComida;
	}
	public JToggleButton getTglbtnBebida(){
		return tglbtnBebida;
	}
	
public void conectarContralador(CtlFacturarTouch c){
		
		txtIdcliente.addActionListener(c);
		txtIdcliente.setActionCommand("BUSCARCLIENTE");
		
		tableDetalle.addKeyListener(c);
		tableDetalle.addMouseListener(c);
		modeloTabla.addTableModelListener(c);
		//tableDetalle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDetalle.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableDetalle.setColumnSelectionAllowed(true);
		tableDetalle.setRowSelectionAllowed(true);
		tableDetalle.setCellSelectionEnabled(true);
		
		txtIdcliente.addKeyListener(c);
		txtNombrecliente.addKeyListener(c);
		txtFechafactura.addKeyListener(c);
		
		btnCierreCaja.addKeyListener(c);
		btnCierreCaja.addActionListener(c);
		btnCierreCaja.setActionCommand("CIERRECAJA");
		
		
		btnPendientes.addKeyListener(c);
		btnPendientes.addActionListener(c);
		btnPendientes.setActionCommand("PENDIENTES");
		
		this.btnBuscar.addKeyListener(c);
		this.btnBuscar.addActionListener(c);
		this.btnBuscar.setActionCommand("BUSCARARTICULO");
		
		
		
		this.btnCerrar.addKeyListener(c);
		this.btnCerrar.addActionListener(c);
		this.btnCerrar.setActionCommand("CERRAR");
		
		this.btnCliente.addKeyListener(c);
		this.btnCliente.addActionListener(c);
		this.btnCliente.setActionCommand("BUSCARCLIENTES");
		
		this.btnCobrar.addKeyListener(c);
		this.btnCobrar.addActionListener(c);
		this.btnCobrar.setActionCommand("COBRAR");
		
		this.btnGuardar.addKeyListener(c);
		this.btnGuardar.addActionListener(c);
		this.btnGuardar.setActionCommand("GUARDAR");
		
		btnActualizar.addKeyListener(c);
		this.btnActualizar.addActionListener(c);
		this.btnActualizar.setActionCommand("ACTUALIZAR");
		
		btnAtras.addActionListener(c);
		btnAtras.setActionCommand("ATRAS");
		
		btnSiguiente.addActionListener(c);
		btnSiguiente.setActionCommand("SIGUIENTE");
		
		tglbtnBebida.addActionListener(c);
		tglbtnBebida.setActionCommand("BEBIDAS");
		
		tglbtnComida.addActionListener(c);
		tglbtnComida.setActionCommand("COMIDAS");
		
		btnAgregar.addActionListener(c);
		btnAgregar.setActionCommand("MAS");
	 
	 	btnMenos.addActionListener(c);
		btnMenos.setActionCommand("MENOS");
		
		btnEliminar.addActionListener(c);
		btnEliminar.setActionCommand("ELIMINAR");
		
		
		
		
		
		this.rdbtnContado.addKeyListener(c);
		this.rdbtnCredito.addKeyListener(c);
		this.txtDescuento.addKeyListener(c);
		this.txtImpuesto.addKeyListener(c);
		this.txtSubtotal.addKeyListener(c);
		txtRtn.addKeyListener(c);
		this.txtTotal.addKeyListener(c);
		
	}

}
