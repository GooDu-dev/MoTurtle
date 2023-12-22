import javax.swing.JFrame;

public class App extends JFrame {
    static final int WIDTH = 800, HEIGHT = 600;

    public App(String title) {
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void draw() {
        CustomDrawing cd = new CustomDrawing();
        add(cd);
        Sun s = new Sun();
        add(s);
    }
}
