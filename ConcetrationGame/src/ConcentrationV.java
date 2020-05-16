import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ConcentrationV extends JPanel    {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int   pci=0, score1=0,score2=0, reply;
   JButton replayBtn = new JButton("Restart");
   JButton[] button = new JButton[28];
   ImageIcon card;
   ImageIcon[] cards; 
   Image img;     
   JTextField p1 = new JTextField("Player1: 0 ");
   JTextField p2 = new JTextField("Player2: 0");
   JTextField turn = new JTextField("Turn: Player1");
   JFrame frame = new JFrame("Concentration Game");
      
   public ConcentrationV() {    
   }
   public void init () {    
      int w = 60, h = 80;
      cards = new ImageIcon[28];
      for(int j = 0; j <button.length; j++) {  
         card = new ImageIcon (getClass().getResource("b1fv.png"));
         Image i = card.getImage();     
         card.setImage(i.getScaledInstance(w, h, Image.SCALE_DEFAULT));
         
         button[j] = new JButton (card);        
         button[j].setBackground(new Color(150, 180, 255));
         button[j].setFocusable(false);
         add(button[j]);
      }  
   }
   public void initIcons(int[] shuffled) {
      for (int i = 0; i <button.length; i++) {
      
         int v = shuffled[i];     
      
         img = new ImageIcon(getClass().getResource(v + ".png")).getImage();
         cards[i] = createIcon(img);
      }
   }

   private ImageIcon createIcon(Image img) {
      BufferedImage b = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
      b.createGraphics().drawImage(img, 0, 0, null);
      img = b.getScaledInstance(60, 80, 1);
      return new ImageIcon(img);
   }

   public void comp()
   {
      setLayout(new FlowLayout(FlowLayout.CENTER));
      setBackground(new Color(204, 255, 153));
      JText(p1);
      JText(p2);
      JText(turn);
      turn.setPreferredSize( new Dimension( 684, 30 ) );
      Dimension dim = new Dimension(150,40);
      replayBtn.setPreferredSize(dim);
      replayBtn.setToolTipText("Click for restart");
      replayBtn.setBackground(new Color(153, 0, 153));
      replayBtn.setFont(new Font("Tahoma", 0, 18)); // NOI18N
      replayBtn.setForeground(new Color(153, 153, 255));
      add(turn);
      add(p1);   
      add(p2);   
      add(replayBtn);  
   }
   public void JText(JTextField a)
   {
      a.setPreferredSize( new Dimension( 340, 30 ) );
      a.setEditable(false);
      a.setBorder(null);
      a.setBackground(new Color(153, 153, 255));
      a.setFont(new Font("Tahoma", 20, 20)); // NOI18N
      a.setForeground(new Color(255, 255, 255));
      a.setHorizontalAlignment(JTextField.CENTER);
      a.setSelectionColor(new Color(153, 153, 255));
   }
  
   public void won(int s1, int s2)
   {
      String s;
      if(s1>s2)
      {
         s="Player1 wins!!!";
      }
      else if(s2>s1)
      {
         s="Player2 wins!!! ";
      } 
      else
      {
         s="Tie!!!";
      }
      reply=JOptionPane.showConfirmDialog(null, s+"     Do you want top play again? ", "CONGRATULATIONS!!", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
   }
   public void turnP2() {
   turn.setText("Turn: Player2");
   }
    public void turnP1() {
   turn.setText("Turn: Player1");
   }
   public void player1() {
      pci--;
      score1++;
      p1.setText("Player 1: " + score1);
   }
   public void player2() {
      pci--;
      score2++;
      p2.setText("Player 2: " + score2);
   }
   public void replay(int[] a) { //metoda e restarton lojen
   
      score1=0;
      score2=0;
      pci=0;
      p1.setText("Player 1: 0");
      p2.setText("Player 2: 0");
      turnP1();
      for (int i = 0; i < button.length; i++) {   
         button[i].setIcon(card);
         button[i].setEnabled(true);
      }
      initIcons(a);
      comp();
   }
   public void Frame()
   {
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(this);
      frame.setSize(720, 550);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setVisible(true);
   }
}