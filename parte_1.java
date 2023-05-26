package verifica_teba;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class parte_1 extends JFrame implements ActionListener {
	
	private ArrayList<Integer> numeri;
	private JTextArea Output;
	private JTextField Input;

	public parte_1() {
		
		numeri = new ArrayList<>();
		
		setTitle("Verifica_GUI");
		setSize(600,500);
		setLayout(new BorderLayout());
		
		Output = new JTextArea();
		
		JPanel Panel = new JPanel(new FlowLayout());
		JLabel Label = new JLabel("Numeri: ");
		Input = new JTextField(10);
		JButton Aggiungi = new JButton("Aggiungi");
		JButton Rimuovi = new JButton("Rimuovi");
		JButton Visualizza = new JButton("Visualizza");	
		
		Aggiungi.addActionListener(e -> Aggiungi());
		Rimuovi.addActionListener(e -> Rimuovi());
		Visualizza.addActionListener(e -> Visualizza());
	
		Panel.add(Label);
		Panel.add(Input);
		Panel.add(Output);
		Panel.add(Aggiungi);
		Panel.add(Rimuovi);
		Panel.add(Visualizza);
		add(Panel, BorderLayout.NORTH);
	}
	
	public void Aggiungi() {
		String num=Input.getText();
		int n= Integer.parseInt(num);
		numeri.add(n);
		for(int i = 0; i<numeri.size(); i++) {
			for(int j = 1; j<numeri.size(); j++) {
			int h=(int)numeri.get(i);
			if (h>n) {
				int temp=numeri.get(i);
				numeri.set(i, n);
				numeri.set(j, temp);
			}
		}
		System.out.println(numeri);
		}
	}
	
	private void Rimuovi() {
		String num=Input.getText();
		int n= Integer.parseInt(num);
		for (int i=0; i<numeri.size(); i++ ) {
			if (i == n) {
			numeri.remove(i);
			}
		System.out.println(numeri);
		}	
	}
	
	private void Visualizza() {
		Output.setText(numeri.toString());
	}
	
	public static void main(String[] args) {
		parte_1 frame = new parte_1();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals("Aggiungi")) {
			int num = Integer.parseInt(Input.getText());
			Aggiungi();
		}
		
		if(e.getSource().equals("Rimuovi")) {
			int num = Integer.parseInt(Input.getText());
			Rimuovi();
		}
		
		if(e.getSource().equals("Visualizza")) {
			Visualizza();
		}
	}
		
	}
