import javax.swing.*;
public class Restaurant {
    public static void main(String[] args) {
        RestaurantUI app = new RestaurantUI();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(750, 650);
        app.setVisible(true);
        app.setResizable(false);
        app.setTitle("Carlos' Restaurant");
    }
}
