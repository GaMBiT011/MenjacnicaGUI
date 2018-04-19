package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ObrisiKursGUI extends JFrame {
	private JPanel contentPane;
	private JLabel lblSifra;
	private JTextField txtSifra;
	private JLabel lblNaziv;
	private JTextField txtNaziv;
	private JLabel lblProdajniKurs;
	private JTextField txtProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField txtKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JTextField txtSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField txtSkraceniNaziv;
	private JButton btnObrisi;
	private JButton btnOdustani;
	private JCheckBox chckbxZaistaObrisiKurs;
	private MenjacnicaGUI gp;
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// DodajKursGUI frame = new DodajKursGUI();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public ObrisiKursGUI(MenjacnicaGUI gp) {
		setTitle("Obrisi kurs");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 276);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblSifra());
		contentPane.add(getTxtSifra());
		contentPane.add(getLblNaziv());
		contentPane.add(getTxtNaziv());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getTxtProdajniKurs());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getTxtKupovniKurs());
		contentPane.add(getLblSrednjiKurs());
		contentPane.add(getTxtSrednjiKurs());
		contentPane.add(getLblSkraceniNaziv());
		contentPane.add(getTxtSkraceniNaziv());
		contentPane.add(getBtnObrisi());
		contentPane.add(getBtnOdustani());
		contentPane.add(getChckbxZaistaObrisiKurs());
		this.gp = gp;

	}

	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
			lblSifra.setBounds(33, 11, 46, 14);
		}
		return lblSifra;
	}

	private JTextField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JTextField();
			txtSifra.setBounds(33, 36, 160, 20);
			txtSifra.setColumns(10);
		}
		return txtSifra;
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setBounds(255, 11, 46, 14);
		}
		return lblNaziv;
	}

	private JTextField getTxtNaziv() {
		if (txtNaziv == null) {
			txtNaziv = new JTextField();
			txtNaziv.setBounds(255, 36, 160, 20);
			txtNaziv.setColumns(10);
		}
		return txtNaziv;
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(33, 67, 77, 14);
		}
		return lblProdajniKurs;
	}

	private JTextField getTxtProdajniKurs() {
		if (txtProdajniKurs == null) {
			txtProdajniKurs = new JTextField();
			txtProdajniKurs.setBounds(33, 92, 160, 20);
			txtProdajniKurs.setColumns(10);
		}
		return txtProdajniKurs;
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(255, 67, 77, 14);
		}
		return lblKupovniKurs;
	}

	private JTextField getTxtKupovniKurs() {
		if (txtKupovniKurs == null) {
			txtKupovniKurs = new JTextField();
			txtKupovniKurs.setBounds(255, 92, 160, 20);
			txtKupovniKurs.setColumns(10);
		}
		return txtKupovniKurs;
	}

	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
			lblSrednjiKurs.setBounds(33, 123, 77, 14);
		}
		return lblSrednjiKurs;
	}

	private JTextField getTxtSrednjiKurs() {
		if (txtSrednjiKurs == null) {
			txtSrednjiKurs = new JTextField();
			txtSrednjiKurs.setBounds(33, 148, 160, 20);
			txtSrednjiKurs.setColumns(10);
		}
		return txtSrednjiKurs;
	}

	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
			lblSkraceniNaziv.setBounds(255, 123, 97, 14);
		}
		return lblSkraceniNaziv;
	}

	private JTextField getTxtSkraceniNaziv() {
		if (txtSkraceniNaziv == null) {
			txtSkraceniNaziv = new JTextField();
			txtSkraceniNaziv.setBounds(255, 148, 160, 20);
			txtSkraceniNaziv.setColumns(10);
		}
		return txtSkraceniNaziv;
	}
	private JCheckBox getChckbxZaistaObrisiKurs() {
		if (chckbxZaistaObrisiKurs == null) {
			chckbxZaistaObrisiKurs = new JCheckBox("Zaista obrisi kurs");
			chckbxZaistaObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnObrisi.setEnabled(chckbxZaistaObrisiKurs.isSelected());
				}
			});
			chckbxZaistaObrisiKurs.setBounds(33, 175, 134, 23);
		}
		return chckbxZaistaObrisiKurs;
	}

	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.setEnabled(false);
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String s = "Obrisan kurs:" + " sifra:" + txtSifra.getText() + " naziv:" + txtNaziv.getText()
							+ " prodajni:" + txtProdajniKurs.getText() + " srednji:" + txtSrednjiKurs.getText()
							+ " kupovni:" + txtKupovniKurs.getText() + " skraceniNaziv:" + txtSkraceniNaziv.getText();
				gp.ispisiNaKraj(s);
					dispose();
				}
			});
			btnObrisi.setBounds(33, 199, 160, 23);
		}
		return btnObrisi;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(255, 199, 160, 23);
		}
		return btnOdustani;
	}
}