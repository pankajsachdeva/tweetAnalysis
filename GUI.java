
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.*;
import javax.swing.*;
import twitter4j.*;

public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        searchLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        cleanButton = new javax.swing.JButton();
        resultButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        countLabel = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField2.setText("1");
        classifierLabel=new javax.swing.JLabel();
        jTextFieldClassifier=new javax.swing.JTextField();
        
       
        jTextFieldClassifier.setText("");
        classifierLabel.setText("classifier name");
        
        
        list2=new ArrayList<String>();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchLabel.setText("Search Tag");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsubmitButtonActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(1);
        jTextArea1.setRows(20);
        //jTextArea1.setSize(300, 300);
        jScrollPane1.setViewportView(jTextArea1);

        cleanButton.setText("Clean");
        cleanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcleanButtonActionPerformed(evt);
            }
        });

        resultButton.setText("Results");
        resultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jresultButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jstopButtonActionPerformed(evt);
            }
        });

        countLabel.setText("Count");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(cleanButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(resultButton))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(countLabel)
                                        .addGap(70, 70, 70)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(57, 57, 57)
                                .addComponent(stopButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchLabel)
                        .addGap(43, 43, 43)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton)
                        .addGap(21, 21, 21))))
                         .addComponent(classifierLabel)
                        .addGap(15,15,15)
                        .addComponent(jTextFieldClassifier, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countLabel)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cleanButton)
                    .addComponent(resultButton)
                    .addComponent(stopButton))
                     .addComponent(classifierLabel)
                    .addComponent(jTextFieldClassifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    }                                           

    private void jsubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
      
    	list2.clear();
    	jTextArea1.setText(" ");
    	
    	keyword=jTextField1.getText();
    	System.out.println("calling the GetLiveTweetsToTest");
    	int count;
    	count=Integer.parseInt(jTextField2.getText());
    	
    	list1= GetLiveTweetsToTestobj.getTweets(keyword,count);
    	String statusreceived;
    	int i=0;
    	for(Status status: list1)
    	{
    			
    			statusreceived=status.getText();
    			jTextArea1.insert(statusreceived, i);
    			
    			jTextArea1.insert("\n", i+1);
    			i++;
        	
    	
    	}    
    	}                                    

    private void jcleanButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
    	jTextArea1.setText("");
    	
    	String statusreceived;
    	
    	
    	String result1;
    	String result2;
    	String result3;
    	String result4;
    	String result5;
    	
    	
    	 removehttpclass removehttpobj=new removehttpclass();
    	 removestopwordclass removestopwordobj=new removestopwordclass();
    	 removehashtagclass removehashtagobj=new removehashtagclass();
    	 removeAtKeyword removeAtKeywordobj=new removeAtKeyword();
    	removespecialcharacterclass removespecialcharacterobj=new removespecialcharacterclass();
    	
    	int j=0;
    	for(Status status: list1)
    	{
    			
    			statusreceived=status.getText();
    			//cleaning starts
    			
    			result1=removehttpobj.removehttp(statusreceived);
            	//	System.out.println("removed http and result1 is formed");
            		
            		result2=removehashtagobj.removehashtag(result1);
            		result3=removeAtKeywordobj.removeAt(result2);
            		result4=removespecialcharacterobj.remove(result3);
            		result5=removestopwordobj.removestopword(result4);
            		
            		
            		//as result3 is called everywhere, therefiore the below statement
            		result3=result5;
    			
            		list2.add(result3);
    			j++;
    			jTextArea1.append(result3);
    			
    			jTextArea1.append("\n");
    			
        	
    	
    	}
    	
    }                                        

    private void jresultButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
    	String classifierName=jTextFieldClassifier.getText();
    	//if((classifierName.equals("BJP"))||(classifierName.equals("Cong"))||(classifierName.equals("AAP")))
    	SentimentClassifierTestTweet sentClassifier=new SentimentClassifierTestTweet(classifierName); 
    	
    	String sent;
    	int positivecount=0;
    	int negativecount=0;
    	
    	for(String status:list2)
    	{
   	       sent= sentClassifier.classify(status);
   	       System.out.println( sent);
   	       if(sent.startsWith("Pos"))  
				positivecount++;
   	       if(sent.startsWith("Neg"))          	   	  
   	    	   negativecount++;

    	}
    	JFrame resultFrame=new JFrame();
    	JPanel panel1=new JPanel();
    	JLabel label1=new JLabel();
    	JLabel label2=new JLabel();
    	JLabel label3=new JLabel();
    	JLabel label4=new JLabel();
    	label1.setText("Positive Count is");
    	label2.setText(""+positivecount);
    	label3.setText("negative Count is");
    	label4.setText(""+negativecount);
    	
    	panel1.add(label1);
    	
    	
    	panel1.add(label2);
    	panel1.add(label3);
    	panel1.add(label4);
    	resultFrame.getContentPane().add(panel1);
    	resultFrame.setVisible(true);
    	resultFrame.setSize(200, 200);
    }                                        

    private void jstopButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    
    
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton submitButton;
    private javax.swing.JButton cleanButton;
    private javax.swing.JButton resultButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JLabel countLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldClassifier;
    private javax.swing.JLabel classifierLabel;
    // End of variables declaration
    
    List<Status>list1;
    ArrayList<String>list2;
    //List<String>list2;
    GetLiveTweetsToTest GetLiveTweetsToTestobj=new GetLiveTweetsToTest();
    String keyword;
    //String[] cleanedStatus;
   // List list=new List();
}