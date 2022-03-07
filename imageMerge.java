import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class imageMerge {
    public static void main(String[] args) {
        String outPath = "G:\\dataset\\mal_merge\\";
        String path1 = "G:\\dataset\\mal_manifest_pic\\";
        File file1 = new File(path1);
        File[] filePathLists1 = file1.listFiles();

        String path2 = "G:\\dataset\\mal_pic\\";
        File file2 = new File(path2);
        File[] filePathLists2 = file2.listFiles();

        for (int i = 0; i < filePathLists1.length; i++) {
            for (int j = 0; j < filePathLists2.length; j++) {
                if (filePathLists1[i].getName().equals(filePathLists2[j].getName())){
                    mergeImage(filePathLists2[j].getAbsolutePath(),filePathLists1[i].getAbsolutePath(),  outPath+i+".jpg");
                }
            }
        }


    }

    public static BufferedImage getBufferedImage(String fileUrl) throws IOException {
        File f = new File(fileUrl);
        return ImageIO.read(f);
    }

    public static void mergeImage(String path1, String path2, String outPath) {
        // 读取待合并的文件
        BufferedImage bi1 = null;
        BufferedImage bi2 = null;
        // 调用mergeImage方法获得合并后的图像
        BufferedImage destImg = null;
        System.out.println("下面是垂直合并的情况：");
//        String saveFilePath = "C:\\Users\\WeiHH\\Desktop\\pic1\\1.jpg";
//        String divingPath = "C:\\Users\\WeiHH\\Desktop\\pic1\\2.jpg";
//        String margeImagePath = "C:\\Users\\WeiHH\\Desktop\\1.jpg";
        try {
            bi1 = getBufferedImage(path1);
            bi2 = getBufferedImage(path2);
            // 调用mergeImage方法获得合并后的图像
            destImg = mergeImage(bi1, bi2, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 保存图像
        generateSaveFile(destImg, outPath);
        System.out.println("垂直合并完毕!");
    }

    public static void generateSaveFile(BufferedImage buffImg, String savePath) {
        int temp = savePath.lastIndexOf(".") + 1;
        try {
            File outFile = new File(savePath);
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            ImageIO.write(buffImg, savePath.substring(temp), outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage mergeImage(BufferedImage img1, BufferedImage img2, boolean isHorizontal) throws IOException {
        int w1 = img1.getWidth();
        int h1 = img1.getHeight();
        int w2 = img2.getWidth();
        int h2 = img2.getHeight();

        // 从图片中读取RGB
        int[] ImageArrayOne = new int[w1 * h1];
        ImageArrayOne = img1.getRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 逐行扫描图像中各个像素的RGB到数组中
        int[] ImageArrayTwo = new int[w2 * h2];
        ImageArrayTwo = img2.getRGB(0, 0, w2, h2, ImageArrayTwo, 0, w2);

        // 生成新图片
        BufferedImage DestImage = null;
        if (isHorizontal) { // 水平方向合并
            DestImage = new BufferedImage(w1 + w2, h1, BufferedImage.TYPE_INT_RGB);
            DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            DestImage.setRGB(w1, 0, w2, h2, ImageArrayTwo, 0, w2);
        } else { // 垂直方向合并
            DestImage = new BufferedImage(w1, h1 + h2, BufferedImage.TYPE_INT_RGB);
            DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            DestImage.setRGB(0, h1, w2, h2, ImageArrayTwo, 0, w2); // 设置下半部分的RGB
        }

        return DestImage;
    }

}
