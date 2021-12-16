package view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;
import javax.xml.crypto.Data;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import control.Aluno;
import control.Cadastro;
import control.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.DropMode;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Date;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class TEditarAluno extends JInternalFrame {
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JTextField txtSenha;
	private JTextField txtCfsenha;
	private JTextField txtEmail;
	
	private String tipo = null;
	private JFormattedTextField txtPeso;
	private JTextField txtAltura;
	private JFormattedTextField txtBesquerdo;
	private JFormattedTextField txtBdireto;
	private JFormattedTextField txtPesquerda;
	private JFormattedTextField txtPdireita;
	private JFormattedTextField txtTorax;
	private JFormattedTextField txtQuadril;
	private JFormattedTextField txtAbesquerdo;
	private JFormattedTextField txtAbdireito;
	private JFormattedTextField txtPaesquerda;
	private JFormattedTextField txtPadireita;
	private JFormattedTextField txtCintura;
	private JTextField txtDcTriceps;
	private JTextField txtDcsubescapular;
	private JTextField txtDcabdominal;
	private JTextField txtDccoxamedial;
	private JTextField txtDcpanturrilha;
	private JTextField txtDctorax;
	private JTextField txtDcbiceps;
	private JTextField txtDcaxila;
	private JTextField txtDcsupra;
	private JTextField txtDcsupraespinal;
	private JTextField txtObs;
	private MaskFormatter mascaraCpf;
	private MaskFormatter mascaraCref;
	private MaskFormatter mascaraCm;
	private MaskFormatter mascaraKg;
	
	private boolean aux = true,aux2 = true;
	
	private String anteBracoD, anteBracoE, pernaD, pernaE, torax, quadril, cintura, panturrilhaD, panturrilhaE;
	private String dCTriceps, dCSubescapular, dCAbdominal, dCCoxaMedial, dCPanturrilhaMedial, dCTorax, dCBiceps;
	private String dCAxilaMedial, dCSupraIliaca, dCSupraEspinal,peso, altura, bracoD, bracoE, oBS;
	private String cpf, senha, nome, email;
	private String dataNasc;
	private JTextField txtTipo;
	

	/**
	 * Create the frame.
	 * @param desktopPane 
	 * @param caminho 
	 */
	/**
	 * @param desktopPane
	 * @param caminho
	 * @param aluno 
	 */
	public TEditarAluno(JDesktopPane desktopPane, String caminhoAluno, Aluno aluno) {
		setTitle("Editar Cadastro");
		Toolkit tk = Toolkit.getDefaultToolkit();
		 Dimension d = tk.getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, d.width, d.height);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
				
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(29, 40, 48, 14);
		panel.add(lblNome);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(27, 65, 100, 14);
		panel.add(lblDataDeNascimento);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(29, 90, 31, 14);
		panel.add(lblCpf);
		
		txtNome = new JTextField();
		txtNome.setBounds(98, 37, 349, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		try {
			mascaraKg = new MaskFormatter("###.##");
			mascaraCm = new MaskFormatter("##.##");
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCref = new MaskFormatter("######-U/UU");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setColumns(10);
		txtCpf.setBounds(58, 87, 91, 20);
		panel.add(txtCpf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(594, 40, 46, 14);
		panel.add(lblSenha);
		
		JLabel lblNewLabel = new JLabel("Confirmar Senha:");
		lblNewLabel.setBounds(545, 65, 95, 14);
		panel.add(lblNewLabel);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(650, 37, 145, 20);
		panel.add(txtSenha);
		txtSenha.setColumns(10);
		
		txtCfsenha = new JTextField();
		txtCfsenha.setBounds(650, 62, 145, 20);
		panel.add(txtCfsenha);
		txtCfsenha.setColumns(10);

		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(459, 90, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(515, 87, 398, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setText(aluno.getEmail());
		
		JLabel lblTpoDeConta = new JLabel("Tpo de Conta:");
		lblTpoDeConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTpoDeConta.setBounds(359, 141, 115, 14);
		panel.add(lblTpoDeConta);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(132, 62, 125, 20);
		panel.add(dateChooser);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(29, 215, 56, 16);
		panel.add(lblPeso);
		
		txtPeso = new JFormattedTextField(mascaraKg);
		txtPeso.setToolTipText("");
		txtPeso.setBounds(70, 212, 116, 22);
		panel.add(txtPeso);
		txtPeso.setColumns(10);
		txtPeso.setText(aluno.getPeso());
		
		JLabel lblKg = new JLabel("Kg");
		lblKg.setBounds(198, 215, 56, 16);
		panel.add(lblKg);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(29, 244, 48, 16);
		panel.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbers(e);
			}
		});
		txtAltura.setBounds(80, 241, 116, 22);
		panel.add(txtAltura);
		txtAltura.setText(aluno.getAltura());
		
		JLabel lblCm = new JLabel("cm");
		lblCm.setBounds(208, 244, 56, 16);
		panel.add(lblCm);
		
		JLabel lblBracoEsquerdo = new JLabel("Braco esquerdo:");
		lblBracoEsquerdo.setBounds(41, 368, 108, 16);
		panel.add(lblBracoEsquerdo);
		
		txtBesquerdo = new JFormattedTextField(mascaraCm);
		txtBesquerdo.setBounds(161, 365, 116, 22);
		panel.add(txtBesquerdo);
		txtBesquerdo.setColumns(10);
		txtBesquerdo.setText(aluno.getBracoE());
		
		JLabel lblBracoDireito = new JLabel("Braco direito:");
		lblBracoDireito.setBounds(41, 397, 86, 16);
		panel.add(lblBracoDireito);
		
		txtBdireto = new JFormattedTextField(mascaraCm);
		txtBdireto.setBounds(161, 394, 116, 22);
		panel.add(txtBdireto);
		txtBdireto.setColumns(10);
		txtBdireto.setText(aluno.getBracoD());
		
		JLabel lblPernaEsquerda = new JLabel("Perna esquerda:");
		lblPernaEsquerda.setBounds(374, 368, 100, 16);
		panel.add(lblPernaEsquerda);
		
		JLabel lblCm_1 = new JLabel("cm");
		lblCm_1.setBounds(289, 368, 56, 16);
		panel.add(lblCm_1);
		
		JLabel label = new JLabel("cm");
		label.setBounds(289, 397, 56, 16);
		panel.add(label);
		
		txtPesquerda = new JFormattedTextField(mascaraCm);
		txtPesquerda.setBounds(475, 365, 116, 22);
		panel.add(txtPesquerda);
		txtPesquerda.setColumns(10);
		txtPesquerda.setText(aluno.getPernaE());
		
		JLabel label_1 = new JLabel("cm");
		label_1.setBounds(604, 368, 56, 16);
		panel.add(label_1);
		
		JLabel lblPernaDireita = new JLabel("Perna direita:");
		lblPernaDireita.setBounds(374, 397, 91, 16);
		panel.add(lblPernaDireita);
		
		txtPdireita = new JFormattedTextField(mascaraCm);
		txtPdireita.setBounds(475, 394, 116, 22);
		panel.add(txtPdireita);
		txtPdireita.setColumns(10);
		txtPdireita.setText(aluno.getPernaD());
		
		JLabel label_2 = new JLabel("cm");
		label_2.setBounds(604, 397, 56, 16);
		panel.add(label_2);
		
		JLabel lblTorax = new JLabel("Torax:");
		lblTorax.setBounds(699, 368, 56, 16);
		panel.add(lblTorax);
		
		txtTorax = new JFormattedTextField(mascaraCm);
		txtTorax.setBounds(767, 365, 116, 22);
		panel.add(txtTorax);
		txtTorax.setColumns(10);
		txtTorax.setText(aluno.getTorax());
		
		JLabel lblCm_2 = new JLabel("cm");
		lblCm_2.setBounds(895, 368, 56, 16);
		panel.add(lblCm_2);
		
		JLabel lblQuadril = new JLabel("Quadril:");
		lblQuadril.setBounds(699, 397, 56, 16);
		panel.add(lblQuadril);
		
		txtQuadril = new JFormattedTextField(mascaraCm);
		txtQuadril.setBounds(767, 394, 116, 22);
		panel.add(txtQuadril);
		txtQuadril.setColumns(10);
		txtQuadril.setText(aluno.getQuadril());
		
		JLabel label_3 = new JLabel("cm");
		label_3.setBounds(895, 397, 56, 16);
		panel.add(label_3);
		
		JLabel lblAnteBracoEsquerdo = new JLabel("Ante braco esquerdo:");
		lblAnteBracoEsquerdo.setBounds(41, 432, 130, 16);
		panel.add(lblAnteBracoEsquerdo);
		
		JLabel lblAnteBracoDireito = new JLabel("Ante braco direito:");
		lblAnteBracoDireito.setBounds(41, 461, 130, 16);
		panel.add(lblAnteBracoDireito);
		
		txtAbesquerdo = new JFormattedTextField(mascaraCm);
		txtAbesquerdo.setBounds(171, 429, 116, 22);
		panel.add(txtAbesquerdo);
		txtAbesquerdo.setColumns(10);
		txtAbesquerdo.setText(aluno.getAnteBracoE());
		
		txtAbdireito = new JFormattedTextField(mascaraCm);
		txtAbdireito.setBounds(161, 461, 116, 22);
		panel.add(txtAbdireito);
		txtAbdireito.setColumns(10);
		
		JLabel label_4 = new JLabel("cm");
		label_4.setBounds(299, 432, 56, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("cm");
		label_5.setBounds(289, 461, 56, 16);
		panel.add(label_5);
		
		JLabel lblPanturrilhaEsquerda = new JLabel("Panturrilha esquerda:");
		lblPanturrilhaEsquerda.setBounds(350, 432, 139, 16);
		panel.add(lblPanturrilhaEsquerda);
		
		JLabel lblPanturrilhaDireita = new JLabel("Panturrilha direita:");
		lblPanturrilhaDireita.setBounds(350, 461, 139, 16);
		panel.add(lblPanturrilhaDireita);
		
		txtPaesquerda = new JFormattedTextField(mascaraCm);
		txtPaesquerda.setBounds(485, 429, 116, 22);
		panel.add(txtPaesquerda);
		txtPaesquerda.setColumns(10);
		txtPaesquerda.setText(aluno.getPanturrilhaE());
		
		txtPadireita = new JFormattedTextField(mascaraCm);
		txtPadireita.setBounds(475, 458, 116, 22);
		panel.add(txtPadireita);
		txtPadireita.setColumns(10);
		txtPadireita.setText(aluno.getPanturrilhaD());
		
		JLabel label_6 = new JLabel("cm");
		label_6.setBounds(614, 432, 56, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("cm");
		label_7.setBounds(604, 461, 56, 16);
		panel.add(label_7);
		
		JLabel lblCintura = new JLabel("Cintura:");
		lblCintura.setBounds(699, 432, 56, 16);
		panel.add(lblCintura);
		
		txtCintura = new JFormattedTextField(mascaraCm);
		txtCintura.setBounds(767, 429, 116, 22);
		panel.add(txtCintura);
		txtCintura.setColumns(10);
		txtCintura.setText(aluno.getCintura());
		
		JLabel lblCm_3 = new JLabel("cm");
		lblCm_3.setBounds(895, 432, 56, 16);
		panel.add(lblCm_3);
		
		JLabel lblNewLabel_1 = new JLabel("Tamanhos:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(450, 313, 190, 39);
		panel.add(lblNewLabel_1);
		
		JLabel lblDobrasCutaneas = new JLabel("Dobras cutaneas:");
		lblDobrasCutaneas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDobrasCutaneas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblDobrasCutaneas.setBounds(437, 503, 190, 39);
		panel.add(lblDobrasCutaneas);
		
		JLabel lblTriceps = new JLabel("Triceps:");
		lblTriceps.setBounds(41, 553, 56, 16);
		panel.add(lblTriceps);
		
		txtDcTriceps = new JTextField();
		txtDcTriceps.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbers(e);
			}
		});
		txtDcTriceps.setBounds(109, 550, 116, 22);
		panel.add(txtDcTriceps);
		txtDcTriceps.setColumns(10);
		txtDcTriceps.setText(aluno.getdCTriceps());
		
		JLabel lblMm = new JLabel("mm");
		lblMm.setBounds(237, 553, 56, 16);
		panel.add(lblMm);
		
		JLabel lblNewLabel_2 = new JLabel("Subescapular:");
		lblNewLabel_2.setBounds(29, 582, 98, 16);
		panel.add(lblNewLabel_2);
		
		txtDcsubescapular = new JTextField();
		txtDcsubescapular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbers(e);
			}
		});
		txtDcsubescapular.setBounds(119, 579, 116, 22);
		panel.add(txtDcsubescapular);
		txtDcsubescapular.setColumns(10);
		txtDcsubescapular.setText(aluno.getdCSubescapular());
		
		JLabel label_8 = new JLabel("mm");
		label_8.setBounds(247, 582, 56, 16);
		panel.add(label_8);
		
		JLabel lblNewLabel_3 = new JLabel("Abdominal:");
		lblNewLabel_3.setBounds(29, 611, 78, 16);
		panel.add(lblNewLabel_3);
		
		txtDcabdominal = new JTextField();
		txtDcabdominal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbers(e);
			}
		});
		txtDcabdominal.setBounds(109, 608, 116, 22);
		panel.add(txtDcabdominal);
		txtDcabdominal.setColumns(10);
		txtDcabdominal.setText(aluno.getdCAbdominal());
		
		JLabel label_9 = new JLabel("mm");
		label_9.setBounds(237, 611, 56, 16);
		panel.add(label_9);
		
		JLabel lblNewLabel_4 = new JLabel("Coxa medial:");
		lblNewLabel_4.setBounds(29, 640, 78, 16);
		panel.add(lblNewLabel_4);
		
		txtDccoxamedial = new JTextField();
		txtDccoxamedial.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbers(e);
			}
		});
		txtDccoxamedial.setBounds(109, 637, 116, 22);
		panel.add(txtDccoxamedial);
		txtDccoxamedial.setColumns(10);
		txtDccoxamedial.setText(aluno.getdCCoxaMedial());
		
		JLabel label_10 = new JLabel("mm");
		label_10.setBounds(237, 640, 56, 16);
		panel.add(label_10);
		
		JLabel lblPanturrilhaMedial = new JLabel("Panturrilha medial:");
		lblPanturrilhaMedial.setBounds(350, 553, 115, 16);
		panel.add(lblPanturrilhaMedial);
		
		txtDcpanturrilha = new JTextField();
		txtDcpanturrilha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbers(e);
			}
		});
		txtDcpanturrilha.setBounds(475, 550, 116, 22);
		panel.add(txtDcpanturrilha);
		txtDcpanturrilha.setColumns(10);
		txtDcpanturrilha.setText(aluno.getdCPanturrilhaMedial());
		
		JLabel label_11 = new JLabel("mm");
		label_11.setBounds(604, 553, 56, 16);
		panel.add(label_11);
		
		JLabel lblTorax_1 = new JLabel("Torax:");
		lblTorax_1.setBounds(403, 582, 56, 16);
		panel.add(lblTorax_1);
		
		txtDctorax = new JTextField();
		txtDctorax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbers(e);
			}
		});
		txtDctorax.setBounds(475, 579, 116, 22);
		panel.add(txtDctorax);
		txtDctorax.setColumns(10);
		txtDctorax.setText(aluno.getdCTorax());
		
		JLabel label_12 = new JLabel("mm");
		label_12.setBounds(604, 582, 56, 16);
		panel.add(label_12);
		
		JLabel lblBiceps = new JLabel("Biceps:");
		lblBiceps.setBounds(403, 611, 56, 16);
		panel.add(lblBiceps);
		
		txtDcbiceps = new JTextField();
		txtDcbiceps.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbers(e);
			}
		});
		txtDcbiceps.setBounds(475, 608, 116, 22);
		panel.add(txtDcbiceps);
		txtDcbiceps.setColumns(10);
		txtDcbiceps.setText(aluno.getdCBiceps());
		
		JLabel label_13 = new JLabel("mm");
		label_13.setBounds(604, 611, 56, 16);
		panel.add(label_13);
		
		JLabel lblNewLabel_5 = new JLabel("Axila media:");
		lblNewLabel_5.setBounds(374, 640, 91, 16);
		panel.add(lblNewLabel_5);
		
		txtDcaxila = new JTextField();
		txtDcaxila.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbers(e);
			}
		});
		txtDcaxila.setBounds(475, 637, 116, 22);
		panel.add(txtDcaxila);
		txtDcaxila.setColumns(10);
		txtDcaxila.setText(aluno.getdCAxilaMedial());
		
		JLabel label_14 = new JLabel("mm");
		label_14.setBounds(604, 640, 56, 16);
		panel.add(label_14);
		
		JLabel lblSupra = new JLabel("Supra iliaca:");
		lblSupra.setBounds(699, 553, 86, 16);
		panel.add(lblSupra);
		
		txtDcsupra = new JTextField();
		txtDcsupra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbers(e);
			}
		});
		txtDcsupra.setBounds(797, 550, 116, 22);
		panel.add(txtDcsupra);
		txtDcsupra.setColumns(10);
		txtDcsupra.setText(aluno.getdCSupraIliaca());
		
		JLabel label_15 = new JLabel("mm");
		label_15.setBounds(925, 553, 56, 16);
		panel.add(label_15);
		
		JLabel lblNewLabel_6 = new JLabel("Supra espinal:");
		lblNewLabel_6.setBounds(699, 582, 85, 16);
		panel.add(lblNewLabel_6);
		
		txtDcsupraespinal = new JTextField();
		txtDcsupraespinal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				onlyNumbers(e);
			}
		});
		txtDcsupraespinal.setBounds(797, 579, 116, 22);
		panel.add(txtDcsupraespinal);
		txtDcsupraespinal.setColumns(10);
		txtDcsupraespinal.setText(aluno.getdCSupraEspinal());
		
		JLabel label_16 = new JLabel("mm");
		label_16.setBounds(925, 582, 56, 16);
		panel.add(label_16);
		
		JButton btnCadastrar = new JButton("Editar Cadastro");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date dataNasc = dateChooser.getDate();
				String tipo = aluno.getTipo();
				if(txtSenha.getText().equals(txtCfsenha.getText())) {
					if(tipo.isEmpty()||txtNome.getText().isEmpty()||txtCpf.getText().isEmpty()||txtSenha.getText().isEmpty()||txtEmail.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Necessario preencher minimamente os campos do nome, senha, email, cpf, data de nascimento e selecionar o tipo de conta para prosseguir.");
					}else{
						preencher_variaveis__com_dados_tela();
						String codigo = aluno.getProximo();
						if(aluno.verificarExistenciaUsuario(caminhoAluno, cpf, tipo)) {				
							if(aluno.editarArquivo(caminhoAluno, codigo, cpf, senha, nome, email, tipo,dataNasc, anteBracoD, anteBracoE,pernaD , pernaE, torax, quadril, cintura, panturrilhaD, panturrilhaE, dCTriceps, dCSubescapular, dCAbdominal, dCCoxaMedial, dCPanturrilhaMedial, dCTorax, dCBiceps, dCAxilaMedial, dCSupraIliaca, dCSupraEspinal, peso, altura, bracoD, bracoE, oBS)){
								JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
							}else {
								JOptionPane.showMessageDialog(null, "Cadastro nao pode ser realizado.");
								}
							String caminho = caminhoAluno.substring(0,caminhoAluno.lastIndexOf("\\"));
							TLogin tlogin = new TLogin(desktopPane, caminho);
							desktopPane.add(tlogin);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Tipo de conta e usuario já existente ");
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "As senhas estao diferentes.");
				}
			}
		});
		btnCadastrar.setBounds(299, 704, 145, 25);
		panel.add(btnCadastrar);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String caminho = caminhoAluno.substring(0,caminhoAluno.lastIndexOf("\\"));
				TLogin tlogin = new TLogin(desktopPane, caminho);
				desktopPane.add(tlogin);
				dispose();
			}
		});
		btnCancel.setBounds(658, 704, 127, 25);
		panel.add(btnCancel);
		
		txtObs = new JTextField();
		txtObs.setDragEnabled(true);
		txtObs.setBounds(419, 180, 547, 121);
		panel.add(txtObs);
		txtObs.setColumns(10);
		txtObs.setText(aluno.getoBS());
		
		JLabel lblObservacao = new JLabel("Observacao:");
		lblObservacao.setBounds(321, 182, 86, 16);
		panel.add(lblObservacao);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setBounds(464, 137, 116, 22);
		panel.add(txtTipo);
		txtTipo.setColumns(10);
		txtTipo.setText(aluno.getTipo());
		
		setVisible(true);
		
	}
	public void onlyNumbers(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE) {
			getToolkit().beep();
			e.consume();
		}
	}
	public void preencher_variaveis__com_dados_tela() {
			
			this.anteBracoD = txtAbdireito.getText();
			this.anteBracoE = txtAbesquerdo.getText();
			this.pernaD = txtPdireita.getText();
			this.pernaE = txtPaesquerda.getText();
			this.torax = txtTorax.getText();
			this.quadril = txtQuadril.getText();
			this.cintura = txtCintura.getText();
			this.panturrilhaD = txtPadireita.getText();
			this.panturrilhaE = txtPaesquerda.getText();
			this.dCTriceps = txtDcTriceps.getText();
			this.dCSubescapular = txtDcsubescapular.getText();
			this.dCAbdominal = txtDcabdominal.getText();
			this.dCCoxaMedial = txtDccoxamedial.getText();
			this.dCPanturrilhaMedial = txtDcpanturrilha.getText();
			this.dCTorax = txtDctorax.getText();
			this.dCBiceps = txtDcbiceps.getText();
			this.dCAxilaMedial = txtDcaxila.getText();
			this.dCSupraIliaca = txtDcsupra.getText();
			this.dCSupraEspinal = txtDcsupraespinal.getText();
			this.peso = txtPeso.getText();
			this.altura = txtAltura.getText();
			this.bracoD = txtBdireto.getText();
			this.bracoE = txtBesquerdo.getText();
			this.oBS = txtObs.getText();
			this.cpf = txtCpf.getText();
			this.senha = txtSenha.getText();
			this.nome = txtNome.getText();
			this.email = txtEmail.getText();
	}

}
