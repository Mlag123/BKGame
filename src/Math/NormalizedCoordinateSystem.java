package Math;

public class NormalizedCoordinateSystem {
    private final double screenWidth;
    private final double screenHeight;
    private final double aspectRatio;
    private final double scale;

    public NormalizedCoordinateSystem(double width, double height) {
        this.screenWidth = width;
        this.screenHeight = height;
        this.aspectRatio = (float)width / height;

        // Масштаб для большей стороны экрана
        this.scale = (width > height) ? width / 2f : height / 2f;
    }

    // Преобразование нормализованных координат в экранные
    public int toScreenX(double normX) {
        return (int)(screenWidth/2f + normX * scale);
    }

    public int toScreenY(double normY) {
        return (int)(screenHeight/2f - normY * scale); // Инвертируем Y
    }

    // Преобразование экранных координат в нормализованные
    public double toNormalizedX(double screenX) {
        return (screenX - screenWidth/2f) / scale;
    }

    public double toNormalizedY(double screenY) {
        return -(screenY - screenHeight/2f) / scale; // Инвертируем Y
    }

    // Коррекция с учетом соотношения сторон
    public double adjustForAspectRatio(double x) {
        return x * aspectRatio;
    }
}