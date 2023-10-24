import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RestaurantUI extends JFrame implements ActionListener {
    // Put these variables outside the functions for no variable scoping
    int cal = 0, rib = 0, bisc = 0, fill = 0, bre = 0, ice = 0;
    JButton appButton;
    JFrame appFrame;
    JPanel appPanel;
    JLabel appLabel, calLabel, ribLabel, biscLabel, fillLabel, breLabel, iceLabel;

    Order orders = new Order();
    double orderTotal = orders.getTotal(), orderTax = orders.getTax(), orderSubtotal = orders.getSubtotal(), orderTotalTax = orders.getTotalTax();

    ItemUI calamari = new ItemUI("Calamari", 5.99, "APPETIZER");
    ItemUI ribs = new ItemUI("Honey Garlic Ribs /w Side Salad", 11.56, "MAIN");
    ItemUI biscuit = new ItemUI("Buttermilk-Biscuit", 6.72, "APPETIZER");
    ItemUI fillet = new ItemUI("Fillet Mignon /w Risotto", 12.67, "MAIN");
    ItemUI bread = new ItemUI("Garlic Truffle Bread", 9.99, "APPETIZER");
    ItemUI icecream = new ItemUI("S'mores Ice Cream Deluxe", 9.54, "DESSERT");

    String[][] items = {
            {calamari.getItemName(), "$" + calamari.getPrice(), calamari.getItemType()},
            {ribs.getItemName(), "$" + ribs.getPrice(), ribs.getItemType()},
            {icecream.getItemName(), "$" + icecream.getPrice(), icecream.getItemType()},
            {biscuit.getItemName(), "$" + biscuit.getPrice(), biscuit.getItemType()},
            {fillet.getItemName(), "$" + fillet.getPrice(), fillet.getItemType()},
            {bread.getItemName(), "$" + bread.getPrice(), bread.getItemType()}
    };

    String[] actions = {"Menu", "Time to Order", "Go to Receipt", "Back to Menu", "Back to Order", "Exit"};

    String[] order = {"Calamari", "Ribs", "Ice Cream", "Biscuits", "Fillet Mignon", "Truffle Bread"};

    public RestaurantUI() {
        displayIntro();
    }

    public void displayIntro() {
        appPanel = new JPanel();
        appButton = new JButton("Menu");
        appButton.setBounds(325, 275, 100, 50);
        appButton.addActionListener(this);
        JLabel appLabel = new JLabel("Welcome to Carlos Restaurant!");
        JLabel appLabel2 = new JLabel("Press Start to Continue");
        appLabel.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 40));
        appLabel.setBounds(60, 50, 750, 50);
        appLabel2.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 40));
        appLabel2.setBounds(145, 90, 750, 50);
        appLabel.setForeground(Color.RED);
        appLabel2.setForeground(Color.RED);
        appPanel.setLayout(null);
        appPanel.add(appLabel);
        appPanel.add(appLabel2);
        appPanel.add(appButton);
        getContentPane().add(appPanel);
        validate();
    }

    public void menu() {
        appPanel = new JPanel();
        appLabel = new JLabel("Dine in/Take-out Menu");
        String[] menuInfo = {"Item Name", "Price", "Item Type"};
        JTable menu = new JTable(items, menuInfo);
        JButton order = new JButton("Time to Order");
        order.setBounds(325, 375, 100, 50);
        appLabel.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 40));
        appLabel.setBounds(130, 30, 750, 50);
        appLabel.setForeground(Color.RED);
        order.addActionListener(this);
        menu.setEnabled(false);
        JScrollPane scrollMenu = new JScrollPane(menu);
        scrollMenu.setBounds(50, 120, 650, 150);
        appPanel.setLayout(null);
        appPanel.add(appLabel);
        appPanel.add(scrollMenu);
        appPanel.add(order, BorderLayout.SOUTH);
        getContentPane().removeAll();
        getContentPane().add(appPanel);
        validate();
    }

    public void order() {
        appPanel = new JPanel();
        appLabel = new JLabel("Ordering Phase");

        JButton calB = new JButton("Calamari");
        JButton ribsB = new JButton("Ribs");
        JButton creamB = new JButton("Ice Cream");
        JButton biscB = new JButton("Biscuits");
        JButton filletB = new JButton("Fillet Mignon");
        JButton breadB = new JButton("Truffle Bread");
        JButton receiptB = new JButton("Go to Receipt");
        JButton menuB = new JButton("Back to Menu");
        calLabel = new JLabel("Calamari Qt: " + cal);
        ribLabel = new JLabel("Honey-Garlic Ribs Qt: " + rib);
        biscLabel = new JLabel("Buttermilk Biscuits Qt: " + bisc);
        fillLabel = new JLabel("Fillet Mignon /w Side Salad Qt: " + fill);
        breLabel = new JLabel("Garlic Truffle Bread Qt: " + bre);
        iceLabel = new JLabel("S'mores Ice Cream Qt: " + ice);

        calLabel.setBounds(400, 70, 200, 100);
        calLabel.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        ribLabel.setBounds(400, 130, 200, 100);
        ribLabel.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        iceLabel.setBounds(400, 190, 200, 100);
        iceLabel.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        biscLabel.setBounds(400, 250, 200, 100);
        biscLabel.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        fillLabel.setBounds(400, 310, 300, 100);
        fillLabel.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        breLabel.setBounds(400, 370, 200, 100);
        breLabel.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        
        appLabel.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 40));
        appLabel.setBounds(210, 30, 750, 50);
        appLabel.setForeground(Color.RED);

        calB.setBounds(130, 100, 100, 50);
        calB.addActionListener(this);
        ribsB.setBounds(130, 160, 100, 50);
        ribsB.addActionListener(this);
        creamB.setBounds(130, 220, 100, 50);
        creamB.addActionListener(this);
        biscB.setBounds(130, 280, 100, 50);
        biscB.addActionListener(this);
        filletB.setBounds(130, 340, 100, 50);
        filletB.addActionListener(this);
        breadB.setBounds(130, 400, 100, 50);
        breadB.addActionListener(this);
        receiptB.setBounds(450, 510, 110, 50);
        receiptB.addActionListener(this);
        menuB.setBounds(130, 510, 110, 50);
        menuB.addActionListener(this);
        
        appPanel.setLayout(null);

        JButton[] buttons = {calB, ribsB, creamB, biscB, filletB, breadB, receiptB, menuB};
        JLabel[] labels = {calLabel, ribLabel, iceLabel, biscLabel, fillLabel, breLabel, appLabel};
        for (int i = 0; i < buttons.length; i++) {
            appPanel.add(buttons[i]);
        }

        for (int i = 0; i < labels.length; i++) {
            appPanel.add(labels[i]);
        }

        getContentPane().removeAll();
        getContentPane().add(appPanel);
        validate();
    }

    public void receipt() {
        appPanel = new JPanel();
        JLabel calTotal = new JLabel("Calamari: $" + (Math.round(cal * calamari.getPrice() * 100)/100.0));
        JLabel ribTotal = new JLabel("Honey-Garlic Ribs: $" + (Math.round(rib * ribs.getPrice() * 100)/100.0));
        JLabel biscTotal = new JLabel("Buttermilk Biscuits: $" + (Math.round(bisc * biscuit.getPrice() * 100)/100.0));
        JLabel fillTotal = new JLabel("Fillet Mignon /w Side Salad: $" + (Math.round(fill* fillet.getPrice() * 100)/100.0));
        JLabel breTotal = new JLabel("Garlic Truffle Bread: $" + (Math.round(bre * bread.getPrice() * 100)/100.0));
        JLabel iceTotal = new JLabel("S'mores Ice Cream: $" + (Math.round(ice * icecream.getPrice() * 100)/100.0));
        JLabel subLabel = new JLabel("Subtotal: $" + (Math.round(orderSubtotal * 100)/100.0));
        JLabel taxLabel = new JLabel("Tax (13%): $" + (Math.round(orderSubtotal * orderTax * 100.0)/100.0));
        JLabel totLabel = new JLabel("Your total is: $" + (Math.round(orderSubtotal * orderTotalTax * 100.0)/100.0));
        JLabel finalQuestion = new JLabel("Order more or exit to send your request?");

        JButton moreOrder = new JButton("Back to Order");
        JButton exit = new JButton("Exit");

        calTotal.setBounds(100, 10, 500, 100);
        calTotal.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        ribTotal.setBounds(100, 70, 500, 100);
        ribTotal.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        iceTotal.setBounds(100, 130, 500, 100);
        iceTotal.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        biscTotal.setBounds(100, 190, 500, 100);
        biscTotal.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        fillTotal.setBounds(100, 250, 500, 100);
        fillTotal.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        breTotal.setBounds(100, 310, 500, 100);
        breTotal.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        subLabel.setBounds(100, 370, 500, 100);
        subLabel.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        taxLabel.setBounds(100, 430, 500, 100);
        taxLabel.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        totLabel.setBounds(100, 490, 500, 100);
        totLabel.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 15));
        finalQuestion.setBounds(400, 190, 500, 100);
        finalQuestion.setFont(new Font("Bitstream Vera Sans Mono",Font.BOLD, 13));
        finalQuestion.setForeground(Color.MAGENTA);
        
        moreOrder.setBounds(460, 270, 150, 50);
        moreOrder.addActionListener(this);
        exit.setBounds(500, 330, 70, 50);
        exit.addActionListener(this);

        appPanel.setLayout(null);

        JLabel[] totalLabels = {calTotal, ribTotal, iceTotal, biscTotal, fillTotal, breTotal, subLabel, taxLabel, totLabel, finalQuestion};
        JButton[] finalButtons = {moreOrder, exit};

        for (int i = 0; i < totalLabels.length; i++) {
            appPanel.add(totalLabels[i]);
        }

        for (int i = 0; i < finalButtons.length; i++) {
            appPanel.add(finalButtons[i]);
        }

        getContentPane().removeAll();
        getContentPane().add(appPanel);
        validate();

    }

    public void doAction(int selection) {
        if (selection == 0 || selection == 3) {
            menu();
        } else if (selection == 1 || selection == 4) {
            order();
        } else if (selection == 2) {
            receipt();
        } else if (selection == 5) {
            System.exit(0);
        }
    }

    public void selectFood(int foodSelection) {
        if (foodSelection == 0) {
            cal++;
            orderSubtotal += calamari.getPrice();
            calLabel.setText("Calamari Qt: " + cal);
        } else if (foodSelection == 1) {
            rib++;
            orderSubtotal += ribs.getPrice();
            ribLabel.setText("Honey-Garlic Ribs Qt: " + rib);
        } else if (foodSelection == 2) {
            ice++;
            orderSubtotal += icecream.getPrice();
            iceLabel.setText("S'mores Ice Cream Qt: " + ice);
        } else if (foodSelection == 3) {
            bisc++;
            orderSubtotal += biscuit.getPrice();
            biscLabel.setText("Buttermilk Biscuits Qt: " + bisc);
        } else if (foodSelection == 4) {
            fill++;
            orderSubtotal += fillet.getPrice();
            fillLabel.setText("Fillet Mignon /w Side Salad Qt: " + fill);
        } else if (foodSelection == 5) {
            bre++;
            orderSubtotal += bread.getPrice();
            breLabel.setText("Garlic Truffle Bread Qt: " + bre);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();

        for (int i = 0; i < actions.length; i++) {
            if (choice.equals(actions[i])) {
                doAction(i);
            }
        }

        for (int i = 0; i < order.length; i++) {
            if (choice.equals(order[i])) {
                selectFood(i);
            }
        }
    }
}