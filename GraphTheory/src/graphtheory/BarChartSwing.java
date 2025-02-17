package graphtheory;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public class BarChartSwing extends JPanel {
    private int[] values;
    private String[] categories;

    public BarChartSwing(int[] values, String[] categories) {
        this.values = values;
        this.categories = categories;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Fill background with white before drawing graph
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        drawGraph(g, getWidth(), getHeight());
    }

    private void drawGraph(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        int padding = 50;
        int barWidth = (width - 2 * padding) / values.length;
        int maxBarHeight = height - 2 * padding;
        int maxValue = 10; // Adjust this to 10 as the max value

        // Draw axes
        g2d.setColor(Color.BLACK);
        g2d.drawLine(padding, height - padding, width - padding, height - padding); // X-axis
        g2d.drawLine(padding, padding, padding, height - padding); // Y-axis

        // Label Y-axis (scale from 0 to 10)
        for (int i = 0; i <= maxValue; i++) {
            int yPosition = height - padding - (i * maxBarHeight / maxValue);
            g2d.drawString(String.valueOf(i), padding - 30, yPosition + 5);
        }

        // Draw bars
        for (int i = 0; i < values.length; i++) {
            int barHeight = (values[i] * maxBarHeight) / maxValue;
            int x = padding + i * barWidth;
            int y = height - padding - barHeight;

            g2d.setColor(Color.BLUE);
            g2d.fillRect(x, y, barWidth - 10, barHeight); // Bar with spacing

            g2d.setColor(Color.BLACK);
            g2d.drawString(categories[i], x + (barWidth / 4), height - 30);
        }
    }

    public static void saveChart(String filename, int[] values, String[] categories) {
        int width = 250;
        int height = 200;

        // Create an image to draw on
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Fill background with white
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Draw chart directly on image
        BarChartSwing chart = new BarChartSwing(values, categories);
        chart.drawGraph(g2d, width, height);
        g2d.dispose();

        try {
            String cwd = Path.of("").toAbsolutePath().toString();
            File outputFile = new File(cwd + "\\GraphTheory\\src\\graphtheory\\" + filename); // Save to src folder
            ImageIO.write(image, "png", outputFile);
            System.out.println("Graph saved as: " + outputFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
