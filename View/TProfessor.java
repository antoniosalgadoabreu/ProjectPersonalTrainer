package view;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import control.Cadastro;
import control.Professor;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TProfessor extends JInternalFrame  {
	
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTipo;
	private MaskFormatter mascaraCpf;
	private MaskFormatter mascaraCref;
	private JFormattedTextField txtCref;
	private JFormattedTextField txtCpf;
	Professor professor;
	private JTable table;
	private JTextField txtObs;
	private JTextField txtBracoe;
	private JTextField txtBracod;
	private JTextField txtAbracoe;
	private JTextField txtAbracod;
	private JTextField txtPernae;
	private JTextField txtPernad;
	private JTextField txtPaturrilhae;
	private JTextField txtPanturrilhad;
	private JTextField txtTorax;
	private JTextField txtQuadril;
	private JTextField txtCintura;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtDctriceps;
	private JTextField txtDcsubescapular;
	private JTextField txtDcabdominal;
	private JTextField txtDccoxamedial;
	private JTextField txtDcpanturrilham;
	private JTextField txtDctorax;
	private JTextField txtDcbiceps;
	private JTextField txtDcaxilam;
	private JTextField txtDcsuprailiaca;
	private JTextField txtDcsupraespinal;
	
	public TProfessor(JDesktopPane desktopPane, String caminhologin, String codigoProf, String caminhoTabelas) {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		 Dimension d = tk.getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, d.width, d.height);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		professor = new Professor();
		
		professor.localizarCodigo(caminhologin, codigoProf);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(83, 13, 349, 20);
		panel.add(txtNome);
		txtNome.setText(professor.getNome());
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(14, 16, 48, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Data de Nascimento:");
		label_1.setBounds(12, 41, 122, 14);
		panel.add(label_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(161, 38, 125, 20);
		panel.add(dateChooser);
		
		JLabel label_2 = new JLabel("CPF:");
		label_2.setBounds(14, 66, 31, 14);
		panel.add(label_2);
		
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCref = new MaskFormatter("######-U/UU");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setEditable(false);
		txtCpf.setColumns(10);
		txtCpf.setBounds(43, 63, 91, 20);
		panel.add(txtCpf);
		txtCpf.setText(professor.getCpf());
		
		JLabel label_3 = new JLabel("Email:");
		label_3.setBounds(528, 16, 46, 14);
		panel.add(label_3);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(586, 13, 398, 20);
		panel.add(txtEmail);
		txtEmail.setText(professor.getEmail());
		
		JLabel label_4 = new JLabel("Tpo de Conta:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(512, 44, 115, 14);
		panel.add(label_4);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setColumns(10);
		txtTipo.setBounds(628, 40, 178, 22);
		panel.add(txtTipo);
		txtTipo.setText(professor.getTipo());
		
		JLabel label_5 = new JLabel("CREF:");
		label_5.setBounds(512, 69, 47, 14);
		panel.add(label_5);
		
		txtCref = new JFormattedTextField(mascaraCref);
		txtCref.setEditable(false);
		txtCref.setColumns(10);
		txtCref.setBounds(571, 66, 86, 20);
		panel.add(txtCref);
		txtCref.setText(professor.getCref());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 138, 422, 593);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Cpf", "Nome", "Alerta Aluno"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblTamanhoscm = new JLabel("Tamanhos(cm):");
		lblTamanhoscm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTamanhoscm.setHorizontalAlignment(SwingConstants.CENTER);
		lblTamanhoscm.setBounds(714, 224, 221, 25);
		panel.add(lblTamanhoscm);
		
		txtObs = new JTextField();
		txtObs.setEditable(false);
		txtObs.setBounds(571, 109, 601, 102);
		panel.add(txtObs);
		txtObs.setColumns(10);
		
		JLabel lblObs = new JLabel("OBS:");
		lblObs.setBounds(503, 109, 56, 16);
		panel.add(lblObs);
		
		JLabel lblDobrasCutaneasmm = new JLabel("Dobras cutaneas(mm):");
		lblDobrasCutaneasmm.setHorizontalAlignment(SwingConstants.CENTER);
		lblDobrasCutaneasmm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDobrasCutaneasmm.setBounds(690, 534, 279, 25);
		panel.add(lblDobrasCutaneasmm);
		
		JLabel label_6 = new JLabel("Braco esquerdo:");
		label_6.setBounds(467, 277, 108, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Braco direito:");
		label_7.setBounds(467, 306, 86, 16);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Ante braco esquerdo:");
		label_8.setBounds(446, 343, 130, 16);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Ante braco direito:");
		label_9.setBounds(467, 370, 130, 16);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Panturrilha direita:");
		label_10.setBounds(690, 367, 139, 16);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("Panturrilha esquerda:");
		label_11.setBounds(690, 338, 139, 16);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("Perna direita:");
		label_12.setBounds(714, 303, 91, 16);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("Perna esquerda:");
		label_13.setBounds(714, 274, 100, 16);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("Torax:");
		label_14.setBounds(943, 277, 56, 16);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("Quadril:");
		label_15.setBounds(943, 306, 56, 16);
		panel.add(label_15);
		
		JLabel label_16 = new JLabel("Cintura:");
		label_16.setBounds(943, 341, 56, 16);
		panel.add(label_16);
		
		JLabel label_17 = new JLabel("Peso:");
		label_17.setBounds(700, 435, 56, 16);
		panel.add(label_17);
		
		JLabel label_18 = new JLabel("Kg");
		label_18.setBounds(851, 435, 56, 16);
		panel.add(label_18);
		
		JLabel label_19 = new JLabel("Altura:");
		label_19.setBounds(700, 464, 48, 16);
		panel.add(label_19);
		
		JLabel label_20 = new JLabel("cm");
		label_20.setBounds(851, 464, 56, 16);
		panel.add(label_20);
		
		JLabel label_21 = new JLabel("Triceps:");
		label_21.setBounds(503, 590, 56, 16);
		panel.add(label_21);
		
		JLabel label_22 = new JLabel("Subescapular:");
		label_22.setBounds(467, 619, 86, 16);
		panel.add(label_22);
		
		JLabel label_23 = new JLabel("Abdominal:");
		label_23.setBounds(488, 648, 71, 16);
		panel.add(label_23);
		
		JLabel label_24 = new JLabel("Coxa medial:");
		label_24.setBounds(481, 677, 78, 16);
		panel.add(label_24);
		
		JLabel label_25 = new JLabel("Panturrilha medial:");
		label_25.setBounds(699, 590, 115, 16);
		panel.add(label_25);
		
		JLabel label_26 = new JLabel("Torax:");
		label_26.setBounds(773, 619, 56, 16);
		panel.add(label_26);
		
		JLabel label_27 = new JLabel("Biceps:");
		label_27.setBounds(773, 648, 56, 16);
		panel.add(label_27);
		
		JLabel label_28 = new JLabel("Axila media:");
		label_28.setBounds(741, 677, 71, 16);
		panel.add(label_28);
		
		JLabel label_29 = new JLabel("Supra iliaca:");
		label_29.setBounds(943, 590, 86, 16);
		panel.add(label_29);
		
		JLabel label_30 = new JLabel("Supra espinal:");
		label_30.setBounds(943, 619, 85, 16);
		panel.add(label_30);
		
		JButton btnCriarSerie = new JButton("Criar Serie");
		btnCriarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnCriarSerie.setBounds(488, 706, 139, 25);
		panel.add(btnCriarSerie);
		
		JButton btnLogOff = new JButton("Log off");
		btnLogOff.setBounds(986, 706, 97, 25);
		panel.add(btnLogOff);
		
		txtBracoe = new JTextField();
		txtBracoe.setEditable(false);
		txtBracoe.setBounds(571, 275, 46, 20);
		panel.add(txtBracoe);
		txtBracoe.setColumns(10);
		
		txtBracod = new JTextField();
		txtBracod.setEditable(false);
		txtBracod.setColumns(10);
		txtBracod.setBounds(571, 304, 46, 20);
		panel.add(txtBracod);
		
		txtAbracoe = new JTextField();
		txtAbracoe.setEditable(false);
		txtAbracoe.setColumns(10);
		txtAbracoe.setBounds(571, 339, 46, 20);
		panel.add(txtAbracoe);
		
		txtAbracod = new JTextField();
		txtAbracod.setEditable(false);
		txtAbracod.setColumns(10);
		txtAbracod.setBounds(571, 370, 46, 20);
		panel.add(txtAbracod);
		
		txtPernae = new JTextField();
		txtPernae.setEditable(false);
		txtPernae.setColumns(10);
		txtPernae.setBounds(824, 275, 46, 20);
		panel.add(txtPernae);
		
		txtPernad = new JTextField();
		txtPernad.setEditable(false);
		txtPernad.setColumns(10);
		txtPernad.setBounds(824, 304, 46, 20);
		panel.add(txtPernad);
		
		txtPaturrilhae = new JTextField();
		txtPaturrilhae.setEditable(false);
		txtPaturrilhae.setColumns(10);
		txtPaturrilhae.setBounds(824, 336, 46, 20);
		panel.add(txtPaturrilhae);
		
		txtPanturrilhad = new JTextField();
		txtPanturrilhad.setEditable(false);
		txtPanturrilhad.setColumns(10);
		txtPanturrilhad.setBounds(824, 368, 46, 20);
		panel.add(txtPanturrilhad);
		
		txtTorax = new JTextField();
		txtTorax.setEditable(false);
		txtTorax.setColumns(10);
		txtTorax.setBounds(1009, 275, 46, 20);
		panel.add(txtTorax);
		
		txtQuadril = new JTextField();
		txtQuadril.setEditable(false);
		txtQuadril.setColumns(10);
		txtQuadril.setBounds(1009, 304, 46, 20);
		panel.add(txtQuadril);
		
		txtCintura = new JTextField();
		txtCintura.setEditable(false);
		txtCintura.setColumns(10);
		txtCintura.setBounds(1008, 341, 46, 20);
		panel.add(txtCintura);
		
		txtPeso = new JTextField();
		txtPeso.setEditable(false);
		txtPeso.setColumns(10);
		txtPeso.setBounds(741, 433, 100, 20);
		panel.add(txtPeso);
		
		txtAltura = new JTextField();
		txtAltura.setEditable(false);
		txtAltura.setColumns(10);
		txtAltura.setBounds(741, 462, 100, 20);
		panel.add(txtAltura);
		
		txtDctriceps = new JTextField();
		txtDctriceps.setEditable(false);
		txtDctriceps.setColumns(10);
		txtDctriceps.setBounds(571, 588, 46, 20);
		panel.add(txtDctriceps);
		
		txtDcsubescapular = new JTextField();
		txtDcsubescapular.setEditable(false);
		txtDcsubescapular.setColumns(10);
		txtDcsubescapular.setBounds(571, 617, 46, 20);
		panel.add(txtDcsubescapular);
		
		txtDcabdominal = new JTextField();
		txtDcabdominal.setEditable(false);
		txtDcabdominal.setColumns(10);
		txtDcabdominal.setBounds(571, 646, 46, 20);
		panel.add(txtDcabdominal);
		
		txtDccoxamedial = new JTextField();
		txtDccoxamedial.setEditable(false);
		txtDccoxamedial.setColumns(10);
		txtDccoxamedial.setBounds(571, 675, 46, 20);
		panel.add(txtDccoxamedial);
		
		txtDcpanturrilham = new JTextField();
		txtDcpanturrilham.setEditable(false);
		txtDcpanturrilham.setColumns(10);
		txtDcpanturrilham.setBounds(824, 588, 46, 20);
		panel.add(txtDcpanturrilham);
		
		txtDctorax = new JTextField();
		txtDctorax.setEditable(false);
		txtDctorax.setColumns(10);
		txtDctorax.setBounds(824, 617, 46, 20);
		panel.add(txtDctorax);
		
		txtDcbiceps = new JTextField();
		txtDcbiceps.setEditable(false);
		txtDcbiceps.setColumns(10);
		txtDcbiceps.setBounds(824, 646, 46, 20);
		panel.add(txtDcbiceps);
		
		txtDcaxilam = new JTextField();
		txtDcaxilam.setEditable(false);
		txtDcaxilam.setColumns(10);
		txtDcaxilam.setBounds(824, 675, 46, 20);
		panel.add(txtDcaxilam);
		
		txtDcsuprailiaca = new JTextField();
		txtDcsuprailiaca.setEditable(false);
		txtDcsuprailiaca.setColumns(10);
		txtDcsuprailiaca.setBounds(1037, 588, 46, 20);
		panel.add(txtDcsuprailiaca);
		
		txtDcsupraespinal = new JTextField();
		txtDcsupraespinal.setEditable(false);
		txtDcsupraespinal.setColumns(10);
		txtDcsupraespinal.setBounds(1037, 617, 46, 20);
		panel.add(txtDcsupraespinal);
		
		JButton btnEditarCadastro = new JButton("Editar Proprio Cadastro");
		btnEditarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TEditarProfessor teditarProfessor = new TEditarProfessor(desktopPane,caminhologin,professor);
				desktopPane.add(teditarProfessor);
				dispose();
			}
		});
		btnEditarCadastro.setBounds(741, 706, 150, 25);
		panel.add(btnEditarCadastro);
		
		JButton btnExcluirProprioCadastro = new JButton("Excluir Proprio Cadastro");
		btnExcluirProprioCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(professor.excluirArquivo(caminhologin, codigoProf)) {
					String caminho = caminhologin.substring(0,caminhologin.lastIndexOf("\\"));
					JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso.");
					TLogin tlogin = new TLogin(desktopPane, caminho);
					desktopPane.add(tlogin);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro e não foi possivel excluir seu cadastro.");
				}
			}
		});
		btnExcluirProprioCadastro.setBounds(161, 95, 147, 23);
		panel.add(btnExcluirProprioCadastro);
		
		setVisible(true);
	}

}
