package verifica_teba;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class parte_1 extends JFrame {
	
	private ArrayList<Integer> numeri;
	private JTextArea Output;
	private JTextField Input;

	public parte_1() {
		
		numeri = new ArrayList <>();
		
		setTitle("Verifica_GUI");
		setSize(300,200);
		setLayout(new BorderLayout());
		
		Output = new JTextArea();
		
		JPanel P = new JPanel(new FlowLayout());
		JLabel J = new JLabel("Numeri: ");
		Input = new JTextField(10);
		JButton Aggiungi = new JButton("Aggiungi");
		JButton Rimuovi = new JButton("Rimuovi");
		JButton Visualizza = new JButton("Visualizza");	
		
		Aggiungi.addActionListener(new Listener());
		Rimuovi.addActionListener(new Listener());
		Visualizza.addActionListener(new Listener());
	
		P.add(J);
		P.add(Input);
		P.add(Output);
		P.add(Aggiungi);
		P.add(Rimuovi);
		P.add(Visualizza);
		
	}/* i metodi Aggiungi(), Rimuovi(), e Visualizza() richiedono un parametro di tipo int, ma non viene passato alcun valore quando questi metodi sono chiamati.
	Inolte, non aggiornano la JTextArea in Output. */
		
	public void Aggiungi(int num) {
		numeri.add(num);
		for(int i = 0; i<numeri.size(); i++) {
			if (numeri.get(i)==num) {
				i = num;
			}
		}
		System.out.println(numeri);
	}
	
	private void Rimuovi(int num) {
		for(int i = 0; i<numeri.size(); i++) {
			if (numeri.get(i)==num) {
				num = 0;
			}
		}
		System.out.println(numeri);
	}
	
	private void Visualizza(int num) {
		System.out.println(numeri);
	}
	
	public class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==Aggiungi()) {
				Aggiungi();
			}
			
			if(e.getSource()==Rimuovi()) {
				Rimuovi();
			}
			
			if(e.getSource()==Visualizza()) {
				Visualizza();
			}
		}
	}
}
// il codice non è eseguibile perchè manca la classe main principale
