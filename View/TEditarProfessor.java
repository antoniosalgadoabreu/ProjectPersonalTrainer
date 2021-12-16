package view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import control.Professor;

import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.ActionEvent;

public class TEditarProfessor extends JInternalFrame  {
	private JTextField txtNome;
	private JTextField txtSenha;
	private JTextField txtCfsenha;
	private JTextField txtEmail;
	private JTextField txtTipo;
	private MaskFormatter mascaraCpf;
	private MaskFormatter mascaraCref;
	private JFormattedTextField txtCref;
	private JFormattedTextField txtCpf;

	public TEditarProfessor(JDesktopPane desktopPane, String caminhologin, Professor professor) {
		setTitle("Editar Cadastro");
		Toolkit tk = Toolkit.getDefaultToolkit();
		 Dimension d = tk.getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, d.width, d.height);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(104, 96, 48, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Data de Nascimento:");
		label_1.setBounds(102, 121, 100, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("CPF:");
		label_2.setBounds(104, 146, 31, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("CREF:");
		label_3.setBounds(102, 171, 31, 14);
		panel.add(label_3);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(173, 93, 349, 20);
		panel.add(txtNome);
		txtNome.setText(professor.getNome());
		
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setColumns(10);
		txtCpf.setBounds(147, 143, 91, 20);
		panel.add(txtCpf);
		txtCpf.setText(professor.getCpf());
		
		try {
			mascaraCref = new MaskFormatter("######-U/UU");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 txtCref = new JFormattedTextField(mascaraCref);
		txtCref.setBounds(145, 168, 86, 20);
		panel.add(txtCref);
		txtCref.setColumns(10);
		txtCref.setText(professor.getCref());
		
		JLabel label_4 = new JLabel("Senha:");
		label_4.setBounds(669, 96, 46, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Confirmar Senha:");
		label_5.setBounds(620, 121, 95, 14);
		panel.add(label_5);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(725, 93, 145, 20);
		panel.add(txtSenha);
		
		txtCfsenha = new JTextField();
		txtCfsenha.setColumns(10);
		txtCfsenha.setBounds(725, 118, 145, 20);
		panel.add(txtCfsenha);
		
		JLabel label_6 = new JLabel("Email:");
		label_6.setBounds(534, 146, 46, 14);
		panel.add(label_6);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(590, 143, 398, 20);
		panel.add(txtEmail);
		txtEmail.setText(professor.getEmail());
		
		JLabel label_7 = new JLabel("Tpo de Conta:");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(534, 173, 100, 14);
		panel.add(label_7);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(207, 118, 125, 20);
		panel.add(dateChooser);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setBounds(646, 167, 154, 22);
		panel.add(txtTipo);
		txtTipo.setColumns(10);
		txtTipo.setText(professor.getTipo());
		
		JButton btnEditarCadastro = new JButton("Editar Cadastro");
		btnEditarCadastro.addActionListener(new ActionListener() {
			
			private String cref;
			private String cpf;
			private Object senha;
			private Object nome;
			private Object email;

			public void actionPerformed(ActionEvent arg0) {
				
				this.cref = txtCref.getText();
				this.cpf = txtCpf.getText();
				this.senha = txtSenha.getText();
				this.nome = txtNome.getText();
				this.email = txtEmail.getText();
				String codigo = professor.getProximo();
				String tipo = txtTipo.getText();
				Date dataNasc = dateChooser.getDate();
				
				if(txtSenha.getText().equals(txtCfsenha.getText())) {
					if(tipo.isEmpty()||txtNome.getText().isEmpty()||txtCpf.getText().isEmpty()||txtSenha.getText().isEmpty()||txtEmail.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Necessario preencher minimamente os campos do nome, senha, email, cpf, data de nascimento e selecionar o tipo de conta para prosseguir.");
					}else {
						if(professor.verificarExistenciaUsuario(caminhologin, cpf, tipo)) {					
							if(professor.editarArquivo(caminhologin, codigo, cpf, nome, cref, tipo, dataNasc, senha, email)){
								JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
							}else {
								JOptionPane.showMessageDialog(null, "Cadastro nao pode ser realizado.");
							}
							String caminho = caminhologin.substring(0,caminhologin.lastIndexOf("\\"));
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
		btnEditarCadastro.setBounds(219, 329, 134, 25);
		panel.add(btnEditarCadastro);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnCancelar.setBounds(703, 329, 97, 25);
		panel.add(btnCancelar);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setVisible(true);
	}

}
