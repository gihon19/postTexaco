package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.SystemColor;

import javax.swing.SwingConstants;

import controlador.CtlFacturar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import view.botones.BotonActualizar;
import view.botones.BotonBuscar1;
import view.botones.BotonBuscarClientes;
import view.botones.BotonCancelar;
import view.botones.BotonCierreCaja;
import view.botones.BotonCobrar;
import view.botones.BotonGuardar;
import view.botones.BotonPendientes;
import view.rendes.RenderizadorTablaFactura;
import view.tablemodel.CbxTmEmpleado;
import view.tablemodel.ComboBoxImpuesto;
import view.tablemodel.TablaModeloFactura;
import view.tablemodel.TmDevoluciones;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.UIManager;

public class ViewFacturar extends JDialog {
	
	protected BorderLayout miEsquema;
	protected JTable tableDetalle;
	protected TablaModeloFactura modeloTabla;
	
	protected JPanel panelAcciones;
	protected JPanel panelBuscar;
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
	
	
	protected JTextField txtBuscar;
	protected JTextField txtArticulo;
	protected JTextField txtPrecio;
	protected JTextField txtImpuesto18;
	protected BotonPendientes btnPendientes;
	
	protected JTextField txtRtn;
	//se crea el modelo de la lista de los impuestos
	protected CbxTmEmpleado modeloEmpleado;//=new ComboBoxImpuesto();
	protected JPanel panel;
	protected JLabel lblBuscar;
	private JPanel panel_2;
	private JLabel lblLogo;
	
	public ViewFacturar(Window view) {
		
		

		
		super(view,"Facturar",Dialog.ModalityType.DOCUMENT_MODAL);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewFacturar.class.getResource("/view/recursos/logo-admin-tool1.png")));
		//getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		grupoOpciones = new ButtonGroup();
		modeloEmpleado=new CbxTmEmpleado();
		modeloTabla=new TablaModeloFactura();
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

		tableDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);     //Tama�o de las columnas de las tablas
		tableDetalle.getColumnModel().getColumn(1).setPreferredWidth(350);	//
		tableDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);	//
		tableDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);	//
		tableDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);	//
		tableDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);	//
		tableDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);	//
		tableDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);	//
		
		tableDetalle.setRowHeight(30);
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
		
		
		
		
		
		
		
		
		panelBuscar= new JPanel();
		panelBuscar.setBackground(color3);
		panel_1.add(panelBuscar, BorderLayout.SOUTH);
		//panelBuscar.setBounds(196, 94, 802, 50);
		//getContentPane().geti
		//panelBuscar.setVisible(false);*/
		
		panelBuscar.setLayout(new GridLayout(2, 3, 7, 1));
		
	
		
		JLabel lblBuscar = new JLabel(" Buscar");
		lblBuscar.setFont(new Font("Georgia", Font.BOLD, 13));
		lblBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscar.setVerticalAlignment(SwingConstants.BOTTOM);
		panelBuscar.add(lblBuscar);
		
		JLabel lblArticulo = new JLabel("Articulo:");
		lblArticulo.setFont(new Font("Georgia", Font.BOLD, 13));
		panelBuscar.add(lblArticulo);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Georgia", Font.BOLD, 13));
		panelBuscar.add(lblPrecio);
		
		txtBuscar = new JTextField();
		txtBuscar.setForeground(Color.WHITE);
		txtBuscar.setBackground(color1);
		panelBuscar.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		txtArticulo = new JTextField();
		txtArticulo.setBackground(color1);
		txtArticulo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtArticulo.setForeground(Color.WHITE);
		txtArticulo.setEditable(false);
		panelBuscar.add(txtArticulo);
		txtArticulo.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBackground(color1);
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPrecio.setForeground(Color.WHITE);
		txtPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrecio.setEditable(false);
		panelBuscar.add(txtPrecio);
		txtPrecio.setColumns(10);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		//panelNorte.add(scrollPane);
		//scrollPane.setBounds(196, 144, 802, 326);
		//panelNorte
		
		//this.setTitle("Facturar");
		getContentPane().add(panelAcciones, BorderLayout.WEST);
		panelAcciones.setLayout(new GridLayout(8, 1, 0, 0));
		
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
		
		
		//setSize(1024, 600);
		setSize(this.getToolkit().getScreenSize());
		//this.setPreferredSize(new Dimension(1024, 600));
		//this.setResizable(false);
		//centrar la ventana en la pantalla
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		//this.pack();
		
			
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
	public TablaModeloFactura getModeloTabla(){
		return modeloTabla;
	}
	public JTable getTableDetalle(){
		return tableDetalle;
	}
	public JTextField getTxtBuscar(){
		return txtBuscar;
	}
	public JTextField getTxtArticulo(){
		return txtArticulo;
	}
	public JTextField getTxtPrecio(){
		return txtPrecio;
	}
	public JTextField getTxtFechafactura(){
		return txtFechafactura;
	}
	public void conectarContralador(CtlFacturar c){
		
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
		
		txtBuscar.addActionListener(c);
		txtBuscar.setActionCommand("BUSCARARTICULO2");
		
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
		
		this.rdbtnContado.addKeyListener(c);
		this.rdbtnCredito.addKeyListener(c);
		this.txtDescuento.addKeyListener(c);
		this.txtImpuesto.addKeyListener(c);
		this.txtSubtotal.addKeyListener(c);
		txtRtn.addKeyListener(c);
		this.txtTotal.addKeyListener(c);
		txtBuscar.addKeyListener(c);
		//txtBuscar.
		txtArticulo.addKeyListener(c);
		txtPrecio.addKeyListener(c);
		
	}
}
