import javax.swing.*;
import java.awt.event.*;

public class ConcentrationC implements ActionListener
{  
   int x=-1, y=-1;
   ConcentrationV view;
   ConcentrationM model;
   int[] a=ConcentrationM.shuffled();
    
   public ConcentrationC(ConcentrationV view, ConcentrationM model){
   
      this.view=view;
      this.model=model;
   } 
   public void whilee(){
      while(true){
         System.out.print("");
         if(x!=-1 && y!=-1){
            try{
               Thread.sleep(700);
               view.button[x].setIcon(view.card);
               view.button[y].setIcon(view.card);
               x=-1;
               y=-1;
               if (test(view.pci) == false){
                  view.turnP2();
               }
               else  {
                  view.turnP1();
               }
            }
            catch(Exception e){}
         }
      }
   }
   public void end(){
      
      view.init();
      view.initIcons(ConcentrationM.shuffled());
      view.Frame();
   }
      
   public void addButon(){
      
      for(int i=0;i<view.button.length;i++)
      {
         view.button[i].addActionListener(this);
      }
      view.replayBtn.addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent e) {
      if(x==-1 || y==-1){
         if (e.getSource() == view.replayBtn)
         { 
            a=ConcentrationM.shuffled();
            view.replay(a);
         }
         for (int i = 0; i < view.button.length; i++) {
            if (e.getSource() == view.button[i]) { 
               view.button[i].setIcon(view.cards[i]);
               if(x==-1)
               {
                  x=i;
               }    
               else if(y==-1){
                  y=i;
               }
               if(x!=-1 && y!=-1){
                  if(Math.max(a[x],a[y])%2==0 && Math.max(a[x],a[y])-1==Math.min(a[x],a[y])){
                     view.button[x].setEnabled(false);
                     view.button[y].setEnabled(false);
                     
                     if (test(view.pci) == true) {
                        view.player1();
                     } 
                     else if (test(view.pci) == false) {
                        
                        view. player2();
                     }
                  }
                  view.pci++; 
               } 
            
               if(view.score1+view.score2==14)
               {
                  view.won(view.score1,view.score2);
                  if(view.reply==JOptionPane.YES_OPTION)
                  {
                     a=ConcentrationM.shuffled();
                     view.replay(a);
                  }
                  else
                  {
                     System.exit(0);
                  }
               }
            }            
         }       
      }
   }
   
   private boolean test(int a) { 
      if (a % 2 == 0) 
      {	
         return true;
      }
      return false;
   }
 
   public static void main (String[] args)
   {
      ConcentrationV v=new ConcentrationV();
      ConcentrationM m=new ConcentrationM();
      ConcentrationC c=new ConcentrationC(v,m);
      c.end();
      v.comp();
      c.addButon();
      c.whilee(); 
   }  
}