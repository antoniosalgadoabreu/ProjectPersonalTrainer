package view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import control.Aluno;
import control.Cadastro;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TAluno extends JInternalFrame  {
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTipo;
	private Aluno aluno;
	private JFormattedTextField txtCpf;
	private MaskFormatter mascaraCpf;
	private JTable table;
	
	public TAluno(JDesktopPane desktopPane, String caminhologin, String codigoAluno, String caminhoTabelas) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		 Dimension d = tk.getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, d.width, d.height);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		
		aluno = new Aluno();
		
		aluno.localizarCodigo(caminhologin, codigoAluno);
				
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(41, 16, 48, 14);
		panel.add(label);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(110, 13, 349, 20);
		panel.add(txtNome);
		txtNome.setText(aluno.getNome());
		
		JLabel label_1 = new JLabel("Data de Nascimento:");
		label_1.setBounds(39, 41, 122, 14);
		panel.add(label_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(188, 38, 125, 20);
		panel.add(dateChooser);
		//dateChooser.setDate(aluno.getDataNascimento());
		
		JLabel label_2 = new JLabel("CPF:");
		label_2.setBounds(41, 66, 31, 14);
		panel.add(label_2);
		
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setEditable(false);
		txtCpf.setColumns(10);
		txtCpf.setBounds(70, 63, 91, 20);
		panel.add(txtCpf);
		txtCpf.setValue(aluno.getCpf()); 
		
		JLabel label_3 = new JLabel("Email:");
		label_3.setBounds(555, 16, 46, 14);
		panel.add(label_3);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(613, 13, 398, 20);
		panel.add(txtEmail);
		txtEmail.setText(aluno.getEmail());
		
		JLabel label_4 = new JLabel("Tpo de Conta:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(539, 44, 115, 14);
		panel.add(label_4);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setBounds(655, 40, 178, 22);
		panel.add(txtTipo);
		txtTipo.setColumns(10);
		txtTipo.setText(aluno.getTipo());
		
		JButton btnEditarCadastro = new JButton("Editar Cadastro");
		btnEditarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TEditarAluno teditarAluno = new TEditarAluno(desktopPane, caminhologin,aluno);
				desktopPane.add(teditarAluno);
				setVisible(false);
			}
		});
		btnEditarCadastro.setBounds(133, 110, 136, 25);
		panel.add(btnEditarCadastro);
		
		JButton btnNewButton = new JButton("Nova Avaliacao");
		btnNewButton.setBounds(400, 110, 136, 25);
		panel.add(btnNewButton);
		
		JButton btnExcluirCadastro = new JButton("Excluir Cadastro");
		btnExcluirCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(aluno.excluirArquivo(caminhologin, codigoAluno)) {
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
		btnExcluirCadastro.setBounds(673, 110, 151, 25);
		panel.add(btnExcluirCadastro);
		
		JButton btnLogoff = new JButton("LogOff");
		btnLogoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogoff.setBounds(958, 110, 97, 25);
		panel.add(btnLogoff);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 155, 982, 585);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		scrollPane.setViewportView(table);
		
		setVisible(true);
	}

}
