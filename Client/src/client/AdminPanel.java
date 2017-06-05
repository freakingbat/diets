package client;

import com.alee.laf.WebLookAndFeel;
import diets.objects.Identifable;
import diets.objects.User;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.List;
public abstract class AdminPanel {
    JButton del;
    public void main(AbstractTabulatedPanel inputPanel, User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, MalformedURLException {
        WebLookAndFeel.install();
        JFrame admin = new JFrame("Окно администратора");
        admin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        admin.setSize(400, 500);
        admin.setResizable(false);
        admin.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        admin.add(panel);
        GridBagLayout gbl = new GridBagLayout();
        panel.setLayout(gbl);

        GridBagConstraints a = new GridBagConstraints();

        a.fill = GridBagConstraints.BOTH;
        a.gridheight = 1;
        a.gridwidth = 1;
        a.gridx = 0;
        a.gridy = 0;
        a.insets = new Insets(20, 20, 20, 20);
        a.weightx = 0.5;
        a.weighty = 0.70;

        GridBagConstraints b = new GridBagConstraints();

        b.fill = GridBagConstraints.BOTH;
        b.gridheight = 1;
        b.gridwidth = 1;
        b.gridx = 1;
        b.gridy = 0;
        b.insets = new Insets(20, 20, 20, 20);

        b.weightx = 0.5;
        b.weighty = 0.70;

        GridBagConstraints c = new GridBagConstraints();

        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 70;
        c.weighty = 0.10;

        GridBagConstraints d = new GridBagConstraints();

        d.gridheight = 1;
        d.gridwidth = 1;
        d.gridx = 0;
        d.gridy = 2;
        d.ipadx = 70;
        d.ipady = 10;
        d.weighty = 0.10;

        GridBagConstraints e = new GridBagConstraints();

        e.gridheight = 1;
        e.gridwidth = 1;
        e.gridx = 1;
        e.gridy = 1;
        e.ipadx = 70;
        e.ipady = 10;
        e.weighty = 0.10;

        GridBagConstraints f = new GridBagConstraints();

        f.gridheight = 1;
        f.gridwidth = 1;
        f.gridx = 1;
        f.gridy = 2;
        f.ipadx = 70;
        f.ipady = 10;
        f.weighty = 0.10;

        GridBagConstraints g = new GridBagConstraints();

        g.gridheight = 1;
        g.gridwidth = 2;
        g.gridx = 0;
        g.gridy = 3;
        g.ipadx = 100;
        g.ipady = 20;
        g.weighty = 0.10;

        final DefaultListModel listModel = new DefaultListModel();
        JList list = new JList(listModel);
        JScrollPane scrollableList = new JScrollPane(list);
        
        List<?> content = setInformation(listModel);


        del = new JButton("Удалить");

        gbl.setConstraints(scrollableList, a);
        gbl.setConstraints(del, c);
        setButton((List<Identifable>) content, listModel, list, inputPanel, user);
        panel.add(scrollableList);
        panel.add(del);
        admin.setVisible(true);
    }
    public abstract List<?> setInformation(DefaultListModel listModel);
    public abstract void setButton(List<Identifable> content,DefaultListModel listModel, JList list, AbstractTabulatedPanel inputPanel, User user);
}
