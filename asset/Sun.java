package asset;

import java.awt.Color;
import java.awt.Graphics;

import asset.draw.CustomDrawing;
import asset.draw.Dot;
import asset.draw.Fill;

public class Sun {
    public void drawSun(Graphics g, Dot center, int radius, int margin, int count, int rotate, Color color,
            Color fillIn) {
        CustomDrawing customDrawing = new CustomDrawing();
        double angle = 360 / count;
        Dot[] vertexs = new Dot[count];
        int centerX = center.getX();
        int centerY = center.getY();

        g.setColor(color);

        for (int i = 0; i < count; i++) {
            int x = (int) (centerX
                    + ((i % 2 == 0 ? radius : radius - margin) * Math.cos(Math.toRadians(angle + rotate) * i)));
            int y = (int) (centerY
                    + ((i % 2 == 0 ? radius : radius - margin) * Math.sin(Math.toRadians(angle + rotate) * i)));
            vertexs[i] = new Dot(x, y);
        }

        for (int i = 0; i < count; i++) {
            customDrawing.drawCurve(g, new Dot[] {
                    new Dot(vertexs[i].getX(), vertexs[i].getY()),
                    new Dot(centerX, centerY),
                    new Dot(vertexs[i != count - 1 ? i + 1 : 0].getX(), vertexs[i != count - 1 ? i + 1 : 0].getY()),
            });
        }

        fill(g, center, fillIn, color);
    }

    public void fill(Graphics g, Dot center, Color targetColor, Color replacementColor) {
        Picture.bf = Fill.FloodFill(g, center, targetColor, replacementColor);
    }
}
