import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: eveil
 * Date: 1/14/14
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainWindow {
    private JButton bu_launch;
    private JTextField tb_out;
    private JPanel top_pane;
    private JButton bu_simple_launch;

    public MainWindow() {
        bu_launch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // A complex for may be constructed like this:
                // construct the form in a panel. Add as many input controls as you would like.
                JTextField control_field = new JTextField();
                JPanel my_custom_form = new JPanel(new GridLayout(0,1));

                // add form components to the panel
                my_custom_form.add(control_field);

                // launch the modal form. Set the optional (not shown) parameters to dictate the submit button types.
                int result=JOptionPane.showConfirmDialog(null,my_custom_form);

                // handle the result
                if(result==JOptionPane.OK_OPTION){
                    String user_input=control_field.getText();
                    MainWindow.this.tb_out.setText(user_input);
                }
            }
        });

        bu_simple_launch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Alternatively, if you just need one input quickly:

                String user_input = JOptionPane.showInputDialog("Input some data");

                // Handle the submit
                if((user_input != null) && (user_input.length() >0)) {
                    MainWindow.this.tb_out.setText(user_input);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().top_pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
